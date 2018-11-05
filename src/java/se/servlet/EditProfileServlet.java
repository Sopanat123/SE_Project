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

import se.Variable;
import se.crypto.Sha2;
import se.model.User;

/**
 * url - /editprofile
 *
 * @author Ben
 */
public class EditProfileServlet extends HttpServlet {

    private static final String TAG = "EditProfileServlet";
    private static final String PAGE_JSP = "WEB-INF/edit_profile.jsp";

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
        // User 'MUST' signed in
        if (request.getSession().getAttribute(Variable.SES_CURRENT_USER) == null) {
            response.sendRedirect(Variable.PAGE_SIGN_IN);
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
        User user = (User) request.getSession().getAttribute(Variable.SES_CURRENT_USER);

        // User 'MUST' signed in
        if (user == null) {
            response.sendRedirect(Variable.PAGE_SIGN_IN);
            return;
        }

        // Get parameter from request
        String displayname = request.getParameter(Variable.WEB_DISPLAYNAME);
        String username = request.getParameter(Variable.WEB_USERNAME);
        String password = request.getParameter(Variable.WEB_PASSWORD);
        String firstname = request.getParameter(Variable.WEB_FIRSTNAME);
        String lastname = request.getParameter(Variable.WEB_LASTNAME);
        String email = request.getParameter(Variable.WEB_EMAIL);
        String phone = request.getParameter(Variable.WEB_PHONE);
        // TODO - get more field (info, image, tag, idc, ids)

        // Check user input
        if (displayname.isEmpty() || displayname.length() < 8) {
            request.setAttribute(Variable.MESSAGE, "Invalid displayname");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (username.isEmpty() || username.length() < 8) {
            request.setAttribute(Variable.MESSAGE, "Invalid username");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (!password.isEmpty() && password.length() < 8) { // if user want to change password
            request.setAttribute(Variable.MESSAGE, "Invalid password");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (email.isEmpty()) {
            request.setAttribute(Variable.MESSAGE, "Invalid email");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (phone.isEmpty()) {
            request.setAttribute(Variable.MESSAGE, "Invalid phone number");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }
        // TODO - add more field

        // Flag for change in important field
        boolean usernameFlag = !user.getUsername().equals(username);
        boolean emailFlag = !user.getEmail().equals(email);
        boolean passwordFlag = !password.isEmpty();

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute(Variable.APP_DB_NAME);

            // Check if user want to change username and/or email
            if (usernameFlag && emailFlag) {
                // Duplicate username check
                if (db.collection(Variable.DB_COL_USER).document(username).get().get().exists()) {
                    request.setAttribute(Variable.MESSAGE, "This username is not available.");
                    request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                    return;
                }

                // Duplicate email check
                CollectionReference users = db.collection(Variable.DB_COL_USER);
                Query query = users.whereEqualTo(Variable.DB_DOC_USER_EMAIL, email);
                ApiFuture<QuerySnapshot> qs = query.get();

                // INVALID email - email is already taken
                if (qs.get().size() > 0) {
                    request.setAttribute(Variable.MESSAGE, "This email is already taken.");
                    request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                    return;
                }

                // Store pre-db data in Map
                Map<String, Object> map = new HashMap<>();
                map.put(Variable.DB_DOC_USER_DISPLAYNAME, displayname);
                map.put(Variable.DB_DOC_USER_FIRSTNAME, firstname);
                map.put(Variable.DB_DOC_USER_LASTNAME, lastname);
                map.put(Variable.DB_DOC_USER_EMAIL, email);
                map.put(Variable.DB_DOC_USER_PHONE, phone);
                map.put(Variable.DB_DOC_USER_CREATE_TIME, FieldValue.serverTimestamp());
                if (passwordFlag) {
                    // New password
                    map.put(Variable.DB_DOC_USER_PASSWORD, Sha2.sha256(password));
                } else {
                    // Old password
                    map.put(Variable.DB_DOC_USER_PASSWORD, db.collection(Variable.DB_COL_USER)
                            .document(user.getUsername())
                            .get().get()
                            .getString(Variable.DB_DOC_USER_PASSWORD));
                }
                // TODO - add more field

                // Add map into users collection, using username as key value
                db.collection(Variable.DB_COL_USER).document(username).set(map);

                // Delete old document
                db.collection(Variable.DB_COL_USER).document(user.getUsername()).delete();

                // Reset user property
                user.setDisplayname(displayname);
                user.setUsername(username);
                user.setEmail(email);
                user.setPhone(phone);
                // TODO - add more field

                // Redirect to homepage
                response.sendRedirect(Variable.PAGE_HOME);
            } else if (usernameFlag) {
                // Duplicate username check
                if (db.collection(Variable.DB_COL_USER).document(username).get().get().exists()) {
                    request.setAttribute(Variable.MESSAGE, "This username is not available.");
                    request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                    return;
                }

                // Store pre-db data in Map
                Map<String, Object> map = new HashMap<>();
                map.put(Variable.DB_DOC_USER_DISPLAYNAME, displayname);
                map.put(Variable.DB_DOC_USER_FIRSTNAME, firstname);
                map.put(Variable.DB_DOC_USER_LASTNAME, lastname);
                map.put(Variable.DB_DOC_USER_EMAIL, email);
                map.put(Variable.DB_DOC_USER_PHONE, phone);
                map.put(Variable.DB_DOC_USER_CREATE_TIME, FieldValue.serverTimestamp());
                if (passwordFlag) {
                    map.put(Variable.DB_DOC_USER_PASSWORD, Sha2.sha256(password));
                } else {
                    map.put(Variable.DB_DOC_USER_PASSWORD, db.collection(Variable.DB_COL_USER)
                            .document(user.getUsername())
                            .get().get()
                            .getString(Variable.DB_DOC_USER_PASSWORD));
                }
                // TODO - add more field

                // Add map into users collection, using username as key value
                db.collection(Variable.DB_COL_USER).document(username).set(map);

                // Delete old document
                db.collection(Variable.DB_COL_USER).document(user.getUsername()).delete();

                // Reset user property
                user.setDisplayname(displayname);
                user.setUsername(username);
                user.setPhone(phone);
                // TODO - add more field

                // Redirect to homepage
                response.sendRedirect(Variable.PAGE_HOME);
            } else if (emailFlag) {
                // Duplicate email check
                CollectionReference users = db.collection(Variable.DB_COL_USER);
                Query query = users.whereEqualTo(Variable.DB_DOC_USER_EMAIL, email);
                ApiFuture<QuerySnapshot> qs = query.get();

                // INVALID email - email is already taken
                if (qs.get().size() > 0) {
                    request.setAttribute(Variable.MESSAGE, "This email is already taken.");
                    request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                    return;
                }

                // Update data in database
                DocumentReference dr = db.collection(Variable.DB_COL_USER).document(username);
                dr.update(Variable.DB_DOC_USER_DISPLAYNAME, displayname);
                dr.update(Variable.DB_DOC_USER_EMAIL, email);
                dr.update(Variable.DB_DOC_USER_PHONE, phone);
                if (passwordFlag) {
                    dr.update(Variable.DB_DOC_USER_PASSWORD, Sha2.sha256(password));
                }
                // TODO - add more field

                // Update data in session
                user.setDisplayname(displayname);
                user.setEmail(email);
                user.setPhone(phone);
                // TODO - add more field

                // Redirect to homepage
                response.sendRedirect(Variable.PAGE_HOME);
            } else {
                // Update data in database
                DocumentReference dr = db.collection(Variable.DB_COL_USER).document(username);
                dr.update(Variable.DB_DOC_USER_DISPLAYNAME, displayname);
                dr.update(Variable.DB_DOC_USER_EMAIL, email);
                dr.update(Variable.DB_DOC_USER_PHONE, phone);
                if (passwordFlag) {
                    dr.update(Variable.DB_DOC_USER_PASSWORD, Sha2.sha256(password));
                }
                // TODO - add more field

                // Update data in session
                user.setDisplayname(displayname);
                user.setEmail(email);
                user.setPhone(phone);
                // TODO - add more field

                // Redirect to homepage
                response.sendRedirect(Variable.PAGE_HOME);
            }
        } catch (InterruptedException | ExecutionException | NoSuchAlgorithmException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            request.setAttribute(Variable.MESSAGE, "Can't connect to database.");
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
