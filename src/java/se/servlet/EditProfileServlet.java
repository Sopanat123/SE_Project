package se.servlet;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.crypto.Sha2;

import se.model.User;

/**
 * url - /editprofile
 *
 * @author Ben
 */
public class EditProfileServlet extends HttpServlet {

    private static final String TAG = "EditProfileServlet";
    private static final String MESSAGE = "msg";
    private static final String PAGE_JSP = "WEB-INF/edit_profile.jsp";
    private static final String PAGE_SIGNIN = "signin";
    private static final String PAGE_HOME = "home";
    private static final String SESS_USER = "user";

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // User 'MUST' logged in
        if (request.getSession().getAttribute(SESS_USER) == null) {
            response.sendRedirect(PAGE_SIGNIN);
            return;
        }
        request.getRequestDispatcher(PAGE_JSP).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get user from session
        User user = (User) request.getSession().getAttribute(SESS_USER);

        // User 'MUST' logged in
        if (user == null) {
            response.sendRedirect(PAGE_SIGNIN);
            return;
        }

        // Get parameter from request
        String displayname = request.getParameter("displayname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Check user input
        if (displayname.isEmpty() || displayname.length() < 8) {
            request.setAttribute(MESSAGE, "Invalid displayname");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (username.isEmpty() || username.length() < 8) {
            request.setAttribute(MESSAGE, "Invalid username");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (!password.isEmpty() && password.length() < 8) { // if user want to change password
            request.setAttribute(MESSAGE, "Invalid password");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (email.isEmpty()) {
            request.setAttribute(MESSAGE, "Invalid email");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (phone.isEmpty()) {
            request.setAttribute(MESSAGE, "Invalid phone number");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }

        boolean usernameFlag = !user.getUsername().equals(username);
        boolean emailFlag = !user.getEmail().equals(email);
        boolean passwordFlag = !password.isEmpty();

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute("db");

            // Check if user want to change username and/or email
            if (usernameFlag && emailFlag) {
                // Duplicate username check
                if (db.collection("users").document(username).get().get().exists()) {
                    request.setAttribute(MESSAGE, "This username is not available.");
                    request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                    return;
                }

                // Duplicate email check
                CollectionReference users = db.collection("users");
                Query query = users.whereEqualTo("email", email);
                ApiFuture<QuerySnapshot> qs = query.get();

                // INVALID email - email is already taken
                if (qs.get().size() > 0) {
                    request.setAttribute(MESSAGE, "This email is already taken.");
                    request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                    return;
                }

                // Store pre-db data in Map
                Map<String, Object> map = new HashMap<>();
                map.put("displayname", displayname);
                map.put("firstname", firstname);
                map.put("lastname", lastname);
                map.put("email", email);
                map.put("phone", phone);
                map.put("created", FieldValue.serverTimestamp());
                if (passwordFlag) {
                    map.put("password", Sha2.sha256(password));
                } else {
                    map.put("password", db.collection("users")
                            .document(user.getUsername())
                            .get().get().getString("password"));
                }

                // Add map into users collection, using username as key value
                db.collection("users").document(username).set(map);

                // Delete old document
                db.collection("users").document(user.getUsername()).delete();

                // Reset user property
                user.setDisplayname(displayname);
                user.setUsername(username);
                user.setEmail(email);
                user.setPhone(phone);

                // Redirect to homepage
                response.sendRedirect(PAGE_HOME);
            } else if (usernameFlag) {
                // Duplicate username check
                if (db.collection("users").document(username).get().get().exists()) {
                    request.setAttribute(MESSAGE, "This username is not available.");
                    request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                    return;
                }

                // Store pre-db data in Map
                Map<String, Object> map = new HashMap<>();
                map.put("displayname", displayname);
                map.put("firstname", firstname);
                map.put("lastname", lastname);
                map.put("email", email);
                map.put("phone", phone);
                map.put("created", FieldValue.serverTimestamp());
                if (passwordFlag) {
                    map.put("password", Sha2.sha256(password));
                } else {
                    map.put("password", db.collection("users")
                            .document(user.getUsername())
                            .get().get().getString("password"));
                }

                // Add map into users collection, using username as key value
                db.collection("users").document(username).set(map);

                // Delete old document
                db.collection("users").document(user.getUsername()).delete();

                // Reset user property
                user.setDisplayname(displayname);
                user.setUsername(username);
                user.setPhone(phone);

                // Redirect to homepage
                response.sendRedirect(PAGE_HOME);
            } else if (emailFlag) {
                // Duplicate email check
                CollectionReference users = db.collection("users");
                Query query = users.whereEqualTo("email", email);
                ApiFuture<QuerySnapshot> qs = query.get();

                // INVALID email - email is already taken
                if (qs.get().size() > 0) {
                    request.setAttribute(MESSAGE, "This email is already taken.");
                    request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                    return;
                }

                // Update data in database
                DocumentReference dr = db.collection("users").document(username);
                dr.update("displayname", displayname);
                dr.update("email", email);
                dr.update("phone", phone);
                if (passwordFlag) {
                    dr.update("password", Sha2.sha256(password));
                }

                // Update data in session
                user.setDisplayname(displayname);
                user.setEmail(email);
                user.setPhone(phone);

                // Redirect to homepage
                response.sendRedirect(PAGE_HOME);
            } else {
                // Update data in database
                DocumentReference dr = db.collection("users").document(username);
                dr.update("displayname", displayname);
                dr.update("email", email);
                dr.update("phone", phone);
                if (passwordFlag) {
                    dr.update("password", Sha2.sha256(password));
                }

                // Update data in session
                user.setDisplayname(displayname);
                user.setEmail(email);
                user.setPhone(phone);

                // Redirect to homepage
                response.sendRedirect(PAGE_HOME);
            }
        } catch (InterruptedException | ExecutionException | NoSuchAlgorithmException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            request.setAttribute(MESSAGE, "Can't connect to database.");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "A servlet that handle profile update operation";
    }

}
