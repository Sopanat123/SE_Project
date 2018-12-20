package swe.profile;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import swe.InputService;
import swe.referenceinfo.MainDatabaseReferenceInfo;
import swe.referenceinfo.SessionReferenceInfo;
import swe.referenceinfo.MainStorageReferenceInfo;
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
@MultipartConfig
public class EditProfileServlet extends HttpServlet {

    private final String CLEAR = "CLEAR";

    private final InputService isv = InputService.getService();
    private final MainDatabaseReferenceInfo dbRef = MainDatabaseReferenceInfo.getMainDatabaseReferenceInfo();
    private final MainStorageReferenceInfo strRef = MainStorageReferenceInfo.getMainStorageReferenceInfo();
    private final ServletReferenceInfo svlRef = ServletReferenceInfo.getServletReferenceInfo();
    private final SessionReferenceInfo sesRef = SessionReferenceInfo.getSessionReferenceInfo();
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

        // User 'MUST' signed in
        if (request.getSession().getAttribute(sesRef.getUser()) == null) {
            response.sendRedirect(svlRef.getSignIn());
            return;
        }
        request.getRequestDispatcher(pageRef.getEditprofile()).forward(request, response);
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
        swe.model.User user = (swe.model.User) request.getSession().getAttribute(sesRef.getUser());

        // User 'MUST' signed in
        if (user == null) {
            response.sendRedirect(svlRef.getSignIn());
            return;
        }

        // Get parameter from request
        String displayname = request.getParameter(uWebRef.getDisplayname());
        String password = request.getParameter(uWebRef.getPassword());
        String email = request.getParameter(uWebRef.getEmail());
        String phone = request.getParameter(uWebRef.getPhone());
        String info = request.getParameter(uWebRef.getInfo());
        Part image = request.getPart(uWebRef.getImage());
        String tag = request.getParameter(uWebRef.getTag());

        String imgName = "";
        if (image != null) {
            imgName = Paths.get(image.getSubmittedFileName()).getFileName().toString();
        }

        // Web parameter flags
        boolean displaynameFlag = !isv.checkVoidString(displayname);
        boolean passwordFlag = !isv.checkVoidString(password);
        boolean emailFlag = !isv.checkVoidString(email);
        boolean phoneFlag = !isv.checkVoidString(phone);
        boolean infoFlag = !isv.checkVoidString(info);
        boolean imageFlag = !isv.checkVoidString(imgName);
        boolean tagFlag = !isv.checkVoidString(tag);

        // Check user input
        if (displaynameFlag && !isv.verifyString(displayname, uReq.getDisplaynameMinLength(), uReq.getDisplaynameMaxLength())) {
            request.getRequestDispatcher(pageRef.getEditprofile()).forward(request, response);
            return;
        }
        if (passwordFlag && !isv.verifyString(password, uReq.getPasswordMinLength(), uReq.getPasswordMaxLength())) {
            request.getRequestDispatcher(pageRef.getEditprofile()).forward(request, response);
            return;
        }
        if (emailFlag && !isv.verifyString(email, uReq.getEmailMinLength(), uReq.getEmailMaxLength())) {
            request.getRequestDispatcher(pageRef.getEditprofile()).forward(request, response);
            return;
        }
        if (phoneFlag && !isv.verifyString(phone, uReq.getPhoneMinLength(), uReq.getPhoneMaxLength())) {
            request.getRequestDispatcher(pageRef.getEditprofile()).forward(request, response);
            return;
        }
        if (infoFlag && info.equals(CLEAR)) { // If input == "CLEAR", data field will set to null
            info = "";
        } else if (infoFlag && !isv.verifyString(info, uReq.getInfoMinLength(), uReq.getInfoMaxLength())) {
            request.getRequestDispatcher(pageRef.getEditprofile()).forward(request, response);
            return;
        }
        if (tagFlag && tag.equals(CLEAR)) { // If input == "CLEAR", data field will set to null
            tag = "";
        } else if (tagFlag && !isv.verifyString(tag, gReq.getTagMinLength(), gReq.getTagMaxLength())) {
            request.getRequestDispatcher(pageRef.getEditprofile()).forward(request, response);
            return;
        }

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute(dbRef.getDatabase());
            DocumentReference dr = db.collection(uDbRef.getColUser()).document(user.getUsername());

            // Create map to store new data
            Map<String, Object> map = new HashMap<>();

            // Changes check
            if (displaynameFlag) {
                // Duplicate displayname check
                CollectionReference users = db.collection(uDbRef.getColUser());
                Query queryDn = users.whereEqualTo(uDbRef.getDocDisplayname(), displayname);
                ApiFuture<QuerySnapshot> qsDn = queryDn.get();

                // INVALID displayname - displayname is already taken
                if (qsDn.get().size() > 0) {
                    request.getRequestDispatcher(pageRef.getEditprofile()).forward(request, response);
                    return;
                }

                map.put(uDbRef.getDocDisplayname(), displayname);
            }
            if (passwordFlag) {
                map.put(uDbRef.getDocPassowrd(), password);
            }
            if (emailFlag) {
                // Duplicate email check
                CollectionReference users = db.collection(uDbRef.getColUser());
                Query queryEm = users.whereEqualTo(uDbRef.getDocEmail(), email);
                ApiFuture<QuerySnapshot> qsEm = queryEm.get();

                // INVALID email - email is already taken
                if (qsEm.get().size() > 0) {
                    request.getRequestDispatcher(pageRef.getEditprofile()).forward(request, response);
                    return;
                }

                map.put(uDbRef.getDocEmail(), email);
            }
            if (phoneFlag) {
                map.put(uDbRef.getDocPhone(), phone);
            }
            if (infoFlag) {
                map.put(uDbRef.getDocInfo(), info);
            }
            if (imageFlag) {
                Bucket bk = (Bucket) request.getServletContext().getAttribute(strRef.getStorage());
                String imgLink = strRef.getUrlExtProfileImage() + user.getUsername() + "-" + imgName;

                bk.getStorage().create(BlobInfo.newBuilder(bk.getName(), imgLink)
                        .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                        .build(), image.getInputStream());

                map.put(uDbRef.getDocImage(), strRef.getUrlGCS() + imgLink);
            }
            if (tagFlag) {
                map.put(uDbRef.getDocTag(), tag);
            }

            // Put map to database if change is occured
            if (!map.isEmpty()) {
                dr.update(map);

                // Update current user
                DocumentSnapshot doc = dr.get().get();
                user.setDisplayname(doc.getString(uDbRef.getDocDisplayname()));
                user.setEmail(doc.getString(uDbRef.getDocEmail()));
                user.setPhone(doc.getString(uDbRef.getDocPhone()));
                user.setInfo(doc.getString(uDbRef.getDocInfo()));
                user.setImage(doc.getString(uDbRef.getDocImage()));
                user.setTag(doc.getString(uDbRef.getDocTag()));
            }

            // Redirect to homepage
            response.sendRedirect(svlRef.getHome());
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
//            request.getRequestDispatcher(pageRef.getEditprofile()).forward(request, response);
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
