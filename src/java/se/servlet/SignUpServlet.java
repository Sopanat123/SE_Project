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
import se.model.User;
import se.UserService;

/**
 * url - /signup
 *
 * @author Ben
 */
public class SignUpServlet extends HttpServlet {

    private static final String TAG = "SignUpServlet";
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
        String username = request.getParameter(Variable.WEB_USER_USERNAME);
        String password = request.getParameter(Variable.WEB_USER_PASSWORD);
        String firstname = request.getParameter(Variable.WEB_USER_FIRSTNAME);
        String lastname = request.getParameter(Variable.WEB_USER_LASTNAME);
        String email = request.getParameter(Variable.WEB_USER_EMAIL);
        String phone = request.getParameter(Variable.WEB_USER_PHONE);

        // Check user input
        if (!UserService.validateUsername(username)) {
            request.setAttribute(Variable.MESSAGE, UserService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (!UserService.validatePassword(password)) {
            request.setAttribute(Variable.MESSAGE, UserService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (!UserService.validateEmail(email)) {
            request.setAttribute(Variable.MESSAGE, UserService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (!UserService.validateFirstname(firstname)) {
            request.setAttribute(Variable.MESSAGE, UserService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (!UserService.validateLastname(lastname)) {
            request.setAttribute(Variable.MESSAGE, UserService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        } else if (!UserService.validatePhone(phone)) {
            request.setAttribute(Variable.MESSAGE, UserService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute(Variable.APP_DB_NAME);
            DocumentReference docRef = db.collection(Variable.DB_COL_USER).document(username);
            DocumentSnapshot document = docRef.get().get();

            // INVALID username - username is already taken
            if (document.exists()) {
                request.setAttribute(Variable.MESSAGE, "This username is not available.");
                request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                return;
            }

            // VALID username - performing email check
            CollectionReference users = db.collection(Variable.DB_COL_USER);
            Query query = users.whereEqualTo(Variable.DB_DOC_USER_EMAIL, email);
            ApiFuture<QuerySnapshot> qs = query.get();

            // INVALID email - email is already taken
            if (qs.get().size() > 0) {
                request.setAttribute(Variable.MESSAGE, "This email is already taken.");
                request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                return;
            }

            // VALID email - create map to store into database
            Map<String, Object> map = new HashMap<>();
            map.put(Variable.DB_DOC_USER_DISPLAYNAME, username); // for new user
            map.put(Variable.DB_DOC_USER_PASSWORD, password);
            map.put(Variable.DB_DOC_USER_FIRSTNAME, firstname);
            map.put(Variable.DB_DOC_USER_LASTNAME, lastname);
            map.put(Variable.DB_DOC_USER_EMAIL, email);
            map.put(Variable.DB_DOC_USER_PHONE, phone);
            map.put(Variable.DB_DOC_USER_IMAGE, Variable.DEF_PRO_IMG);
            map.put(Variable.DB_DOC_USER_CREATE_TIME, FieldValue.serverTimestamp());
            map.put(Variable.DB_DOC_USER_PRIVILEGE, Variable.PRIVILEGE_MEMBER);
            map.put(Variable.DB_DOC_USER_VERIFY, Variable.VERIFY_NONE);

            // Add map into users collection, using username as key value
            // Username already set to be the document id
            docRef.set(map);

            // Create user and store data in session
            User user = new User(username);
            user.setDisplayname(username);
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setPhone(phone);
            user.setImage(Variable.DEF_PRO_IMG);
            user.setPrivilege(Variable.PRIVILEGE_MEMBER);
            request.getSession().setAttribute(Variable.SES_CURRENT_USER, user);

            // Redirect to homepage when sign up process is done
            response.sendRedirect(Variable.PAGE_HOME);
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
        return "A servlet for handle the user account creation";
    }

}
