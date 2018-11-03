package se.servlet;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
 * url - /signin
 *
 * @author Ben
 */
public class SignInServlet extends HttpServlet {

    private static final String TAG = "SignInServlet";
    private static final String MESSAGE = "msg";
    private static final String PAGE_JSP = "welcome_page.jsp";
    private static final String PAGE_HOME = "home";
    private static final String SESS_USER = "user";
    private static final String PARAM_USERNAME = "username";
    private static final String PARAM_PASSWORD = "password";

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

        //Check if input is empty
        if (username.isEmpty() && password.isEmpty()) {
            request.setAttribute(MESSAGE, "Please enter your username and password.");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (username.isEmpty()) {
            request.setAttribute(MESSAGE, "Please enter your username.");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (password.isEmpty()) {
            request.setAttribute(MESSAGE, "Please enter your password.");
            request.setAttribute(PARAM_USERNAME, username);
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute("db");
            // Create a reference for fecthing matched data
            DocumentReference docRef = db.collection("users").document(username);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot doc = future.get();

            // Check if user exists in database
            if (doc.exists()) {
                // Check password
                if (Sha2.sha256(password).equals(doc.getString("password"))) {
                    User user = new User(username);
                    user.setDisplayname(doc.getString("displayname"));
                    user.setEmail(doc.getString("email"));
                    user.setFirstname(doc.getString("firstname"));
                    user.setImageUrl(doc.getString("imageurl"));
                    user.setLastname(doc.getString("lastname"));
                    user.setPhone(doc.getString("phone"));
                    user.setPrivilege(doc.getString("privilege"));
                    request.getSession().setAttribute(SESS_USER, user);
                    response.sendRedirect(PAGE_HOME);
                } else {
                    request.setAttribute(MESSAGE, "Wrong password.");
                    request.setAttribute(PARAM_USERNAME, username);
                    request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                }
            } else {
                // No username in database
                request.setAttribute(MESSAGE, "Unknown user.");
                request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            }
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
        return "A servlet for handle user first step authentication. "
                + "Store credential in session scope.";
    }

}
