package se.servlet;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.Variable;
import se.model.User;

/**
 * url - /signin
 *
 * @author Ben
 */
public class SignInServlet extends HttpServlet {

    private static final String TAG = "SignInServlet";
    private static final String PAGE_JSP = "welcome_page.jsp";

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
        if (request.getSession().getAttribute(Variable.SES_CURRENT_USER) != null) {
            response.sendRedirect(Variable.PAGE_HOME);
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
        if (request.getSession().getAttribute(Variable.SES_CURRENT_USER) != null) {
            response.sendRedirect(Variable.PAGE_HOME);
            return;
        }

        // Get parameter from request
        String username = request.getParameter(Variable.WEB_USERNAME);
        String password = request.getParameter(Variable.WEB_PASSWORD);

        //Check if input is empty
        if (username == null || password == null || username.isEmpty() && password.isEmpty()) {
            request.setAttribute(Variable.MESSAGE, "Please enter your username and password.");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (username == null || username.isEmpty()) {
            request.setAttribute(Variable.MESSAGE, "Please enter your username.");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (password == null || password.isEmpty()) {
            request.setAttribute(Variable.MESSAGE, "Please enter your password.");
            request.setAttribute(Variable.WEB_USERNAME, username);
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute(Variable.APP_DB_NAME);
            // Create a reference for fecthing matched data
            DocumentReference docRef = db.collection(Variable.DB_COL_USER).document(username);
            DocumentSnapshot doc = docRef.get().get();

            // Check if user exists in database
            if (doc.exists()) {
                // Check password
                if (password.equals(doc.getString(Variable.DB_DOC_USER_PASSWORD))) {
                    User user = new User(username);
                    // Get user data from database and store in session
                    user.setDisplayname(doc.getString(Variable.DB_DOC_USER_DISPLAYNAME));
                    user.setFirstname(doc.getString(Variable.DB_DOC_USER_FIRSTNAME));
                    user.setLastname(doc.getString(Variable.DB_DOC_USER_LASTNAME));
                    user.setEmail(doc.getString(Variable.DB_DOC_USER_EMAIL));
                    user.setPhone(doc.getString(Variable.DB_DOC_USER_PHONE));
                    user.setImage(doc.getString(Variable.DB_DOC_USER_IMAGE));
                    user.setPrivilege(doc.getString(Variable.DB_DOC_USER_PRIVILEGE));
                    user.setInfo(doc.getString(Variable.DB_DOC_USER_INFO));
                    user.setTag(doc.getString(Variable.DB_DOC_USER_TAG));
                    request.getSession().setAttribute(Variable.SES_CURRENT_USER, user);
                    response.sendRedirect(Variable.PAGE_HOME);
                } else {
                    request.setAttribute(Variable.MESSAGE, "Wrong password.");
                    request.setAttribute(Variable.WEB_USERNAME, username);
                    request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                }
            } else {
                // No username in database
                request.setAttribute(Variable.MESSAGE, "Unknown user.");
                request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            }
        } catch (InterruptedException | ExecutionException ex) {
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
        return "A servlet for handle user first step authentication. "
                + "Store credential in session scope.";
    }

}
