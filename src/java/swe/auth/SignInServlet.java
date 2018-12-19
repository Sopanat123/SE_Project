package swe.auth;

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

import swe.InputService;
import swe.model.User;
import swe.referenceinfo.MainDatabaseReferenceInfo;
import swe.referenceinfo.ServletReferenceInfo;
import swe.referenceinfo.MainSessionReferenceInfo;
import swe.referenceinfo.WebPageReferenceInfo;
import swe.referenceinfo.UserDatabaseReferenceInfo;
import swe.referenceinfo.UserWebReferenceInfo;

/**
 *
 * @author Ben
 */
public class SignInServlet extends HttpServlet {

    private final InputService isv = InputService.getService();
    private final MainDatabaseReferenceInfo dbRef = MainDatabaseReferenceInfo.getMainDatabaseReferenceInfo();
    private final ServletReferenceInfo svlRef = ServletReferenceInfo.getsServletReferenceInfo();
    private final MainSessionReferenceInfo sesRef = MainSessionReferenceInfo.getMainSessionReferenceInfo();
    private final UserDatabaseReferenceInfo uDbRef = UserDatabaseReferenceInfo.getUserDatabaseReferenceInfo();
    private final UserWebReferenceInfo uWebRef = UserWebReferenceInfo.getUserWebReferenceInfo();
    private final WebPageReferenceInfo pageRef = WebPageReferenceInfo.getWebPageReferenceInfo();

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

        // If user is logged in, send to homepage
        if (request.getSession().getAttribute(sesRef.getUser()) != null) {
            response.sendRedirect(svlRef.getHome());
        } else {
            request.getRequestDispatcher(pageRef.getWelcome()).forward(request, response);
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
        if (request.getSession().getAttribute(sesRef.getUser()) != null) {
            response.sendRedirect(svlRef.getHome());
            return;
        }

        // Get parameter from request
        String username = request.getParameter(uWebRef.getUsername());
        String password = request.getParameter(uWebRef.getPassword());

        // Check empty input
        if (isv.checkVoidString(username) || isv.checkVoidString(password)) {
            request.getRequestDispatcher(pageRef.getWelcome()).forward(request, response);
            return;
        }

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute(dbRef.getDatabase());
            // Create a reference for fecthing matched data
            DocumentReference docRef = db.collection(uDbRef.getColUser()).document(username);
            DocumentSnapshot doc = docRef.get().get();

            // Check if user exists in database
            if (doc.exists()) {
                // Check password
                if (password.equals(doc.getString(uDbRef.getDocPassowrd()))) {
                    User user = new User(username);
                    // Get user data from database and store in session
                    user.setDisplayname(doc.getString(uDbRef.getDocDisplayname()));
                    user.setFirstname(doc.getString(uDbRef.getDocFirstname()));
                    user.setLastname(doc.getString(uDbRef.getDocLastname()));
                    user.setEmail(doc.getString(uDbRef.getDocEmail()));
                    user.setPhone(doc.getString(uDbRef.getDocPhone()));
                    user.setImage(doc.getString(uDbRef.getDocImage()));
                    user.setPrivilege(doc.getString(uDbRef.getDocPrivilege()));
                    user.setInfo(doc.getString(uDbRef.getDocInfo()));
                    user.setTag(doc.getString(uDbRef.getDocTag()));
                    request.getSession().setAttribute(sesRef.getUser(), user);
                    response.sendRedirect(svlRef.getHome());
                } else {
                    request.getRequestDispatcher(pageRef.getWelcome()).forward(request, response);
                }
            } else {
                // No username in database
                request.getRequestDispatcher(pageRef.getWelcome()).forward(request, response);
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
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
