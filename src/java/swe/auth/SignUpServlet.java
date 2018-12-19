package swe.auth;

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

import swe.InputService;
import swe.model.User;
import swe.referenceinfo.MainDatabaseReferenceInfo;
import swe.referenceinfo.MainSessionReferenceInfo;
import swe.referenceinfo.ServletReferenceInfo;
import swe.referenceinfo.UserDatabaseReferenceInfo;
import swe.referenceinfo.UserWebReferenceInfo;
import swe.referenceinfo.WebPageReferenceInfo;
import swe.requirement.GeneralRequirement;
import swe.requirement.UserRequirement;

/**
 *
 * @author Ben
 */
public class SignUpServlet extends HttpServlet {

    private final InputService isv = InputService.getService();
    private final MainDatabaseReferenceInfo dbRef = MainDatabaseReferenceInfo.getMainDatabaseReferenceInfo();
    private final ServletReferenceInfo svlRef = ServletReferenceInfo.getsServletReferenceInfo();
    private final MainSessionReferenceInfo sesRef = MainSessionReferenceInfo.getMainSessionReferenceInfo();
    private final UserDatabaseReferenceInfo uDbRef = UserDatabaseReferenceInfo.getUserDatabaseReferenceInfo();
    private final UserWebReferenceInfo uWebRef = UserWebReferenceInfo.getUserWebReferenceInfo();
    private final WebPageReferenceInfo pageRef = WebPageReferenceInfo.getWebPageReferenceInfo();

    private final GeneralRequirement gReq = GeneralRequirement.getGeneralRequirement();
    private final UserRequirement uReq = UserRequirement.getUserRequirement();

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
        String firstname = request.getParameter(uWebRef.getFirstname());
        String lastname = request.getParameter(uWebRef.getLastname());
        String email = request.getParameter(uWebRef.getEmail());
        String phone = request.getParameter(uWebRef.getPhone());

        // Check user input
        if (isv.verifyString(username, uReq.getUsernameMinLength(), uReq.getUsernameMaxLength())
                || isv.verifyString(password, uReq.getPasswordMinLength(), uReq.getPasswordMaxLength())
                || isv.verifyString(firstname, uReq.getFirstnameMinLength(), uReq.getFirstnameMaxLength())
                || isv.verifyString(lastname, uReq.getLastnameMinLength(), uReq.getLastnameMaxLength())
                || isv.verifyString(email, uReq.getEmailMinLength(), uReq.getEmailMaxLength())
                || isv.verifyString(phone, uReq.getPhoneMinLength(), uReq.getPhoneMaxLength())) {
            return;
        }

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute(dbRef.getDatabase());
            DocumentReference docRef = db.collection(uDbRef.getColUser()).document(username);
            DocumentSnapshot document = docRef.get().get();

            // INVALID username - username is already taken
            if (document.exists()) {
                request.getRequestDispatcher(pageRef.getWelcome()).forward(request, response);
                return;
            }

            // VALID username - performing email check
            CollectionReference users = db.collection(uDbRef.getColUser());
            Query query = users.whereEqualTo(uDbRef.getDocEmail(), email);
            ApiFuture<QuerySnapshot> qs = query.get();

            // INVALID email - email is already taken
            if (qs.get().size() > 0) {
                request.getRequestDispatcher(pageRef.getWelcome()).forward(request, response);
                return;
            }

            // VALID email - create map to store into database
            Map<String, Object> map = new HashMap<>();
            map.put(uDbRef.getDocUsername(), username); // for new user
            map.put(uDbRef.getDocPassowrd(), password);
            map.put(uDbRef.getDocFirstname(), firstname);
            map.put(uDbRef.getDocLastname(), lastname);
            map.put(uDbRef.getDocEmail(), email);
            map.put(uDbRef.getDocPhone(), phone);
            map.put(uDbRef.getDocImage(), uDbRef.getAttDefProImage());
            map.put(uDbRef.getDocCreateTime(), FieldValue.serverTimestamp());
            map.put(uDbRef.getDocPrivilege(), uDbRef.getAttPrivilegeMember());

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
            user.setImage(uDbRef.getAttDefProImage());
            user.setPrivilege(uDbRef.getAttPrivilegeMember());
            request.getSession().setAttribute(sesRef.getUser(), user);

            // Redirect to homepage when sign up process is done
            response.sendRedirect(svlRef.getHome());
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
