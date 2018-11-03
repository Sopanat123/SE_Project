package se.servlet;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
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
 * url - /signup
 *
 * @author Ben
 */
public class SignUpServlet extends HttpServlet {

    private static final String TAG = "SignUpServlet";
    private static final String MESSAGE = "msg";
    private static final String PAGE_JSP = "welcome_page.jsp";
    private static final String PAGE_HOME = "home";
    private static final String SESS_USER = "user";
    private static final String PARAM_USERNAME = "username";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_EMAIL = "email";
    private static final String PARAM_FNAME = "firstname";
    private static final String PARAM_LNAME = "lastname";
    private static final String PARAM_PHONE = "phone";

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
        // Check if already signed in
        if (request.getSession().getAttribute(SESS_USER) != null) {
            response.sendRedirect(PAGE_HOME);
        } else {
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
        }
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
        // Must has 'NO' user in session to continue
        if (request.getSession().getAttribute(SESS_USER) != null) {
            request.getRequestDispatcher(PAGE_HOME).forward(request, response);
            return;
        }

        // Get parameter from request
        String username = request.getParameter(PARAM_USERNAME);
        String password = request.getParameter(PARAM_PASSWORD);
        String email = request.getParameter(PARAM_EMAIL);
        String firstname = request.getParameter(PARAM_FNAME);
        String lastname = request.getParameter(PARAM_LNAME);
        String phone = request.getParameter(PARAM_PHONE);

        // Check user input
        if (username.isEmpty() || username.length() < 6) {
            request.setAttribute(MESSAGE, "Invalid username");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (password.isEmpty() || password.length() < 6) {
            request.setAttribute(MESSAGE, "Invalid password");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (email.isEmpty()) {
            request.setAttribute(MESSAGE, "Invalid email");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (firstname.isEmpty()) {
            request.setAttribute(MESSAGE, "Invalid name");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (lastname.isEmpty()) {
            request.setAttribute(MESSAGE, "Invalid name");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (phone.isEmpty()) {
            request.setAttribute(MESSAGE, "Invalid phone number");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute("db");
            // Create DocRef for later operation
            DocumentReference docRef = db.collection("users").document(username);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();

            // INVALID username - username is already taken
            if (document.exists()) {
                request.setAttribute(MESSAGE, "This username is not available.");
                request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                return;
            }

            // VALID username - performing email check
            CollectionReference users = db.collection("users");
            Query query = users.whereEqualTo("email", email);
            ApiFuture<QuerySnapshot> qs = query.get();

            // INVALID email - email is already taken
            if (qs.get().size() > 0) {
                request.setAttribute(MESSAGE, "This email is already taken.");
                request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                return;
            }

            // VALID email - create map to store into database
            Map<String, Object> map = new HashMap<>();
            map.put("password", Sha2.sha256(password));
            map.put("email", email);
            map.put("firstname", firstname);
            map.put("lastname", lastname);
            map.put("phone", phone);
            map.put("created", FieldValue.serverTimestamp());
            // Add map into users collection, using username as key value
            docRef.set(map);

            // Create user and store data in session
            User user = new User(username);
            user.setDisplayname(firstname);
            user.setEmail(email);
            user.setFirstname(firstname);
            user.setImageUrl("assets/def_pro_img.png");
            user.setLastname(lastname);
            user.setPhone(phone);
            user.setPrivilege("member");
            request.getSession().setAttribute(SESS_USER, user);
            response.sendRedirect(PAGE_HOME);
        } catch (NoSuchAlgorithmException | InterruptedException | ExecutionException ex) {
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
        return "A servlet for handle the user account creation";
    }

}
