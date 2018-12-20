package swe.profile;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import swe.model.User;
import swe.referenceinfo.MainDatabaseReferenceInfo;
import swe.referenceinfo.MainStorageReferenceInfo;
import swe.referenceinfo.ServletReferenceInfo;
import swe.referenceinfo.SessionReferenceInfo;
import swe.referenceinfo.UserDatabaseReferenceInfo;
import swe.referenceinfo.UserWebReferenceInfo;
import swe.referenceinfo.WebPageReferenceInfo;

/**
 *
 * @author Ben
 */
@MultipartConfig
public class BeTranslatorServlet extends HttpServlet {

    private final MainDatabaseReferenceInfo dbRef = MainDatabaseReferenceInfo.getMainDatabaseReferenceInfo();
    private final MainStorageReferenceInfo strRef = MainStorageReferenceInfo.getMainStorageReferenceInfo();
    private final ServletReferenceInfo svlRef = ServletReferenceInfo.getServletReferenceInfo();
    private final SessionReferenceInfo sesRef = SessionReferenceInfo.getSessionReferenceInfo();
    private final UserDatabaseReferenceInfo uDbRef = UserDatabaseReferenceInfo.getUserDatabaseReferenceInfo();
    private final UserWebReferenceInfo uWebRef = UserWebReferenceInfo.getUserWebReferenceInfo();
    private final WebPageReferenceInfo pageRef = WebPageReferenceInfo.getWebPageReferenceInfo();

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
        User user = (User) request.getSession().getAttribute(sesRef.getUser());

        // Check if no user in session
        if (user == null) {
            response.sendRedirect(svlRef.getSignIn());
            return;
        }
        // Check if user is already translator
        if (user.getPrivilege().equals(uDbRef.getAttPrivilegeTranslator())) {
            response.sendRedirect(svlRef.getEditprofile());
            return;
        }

        // Get file from web
        Part idCard = request.getPart(uWebRef.getIdCardImage());
        Part idSelfie = request.getPart(uWebRef.getIdSelfieImage());

        // Check null
        if (idCard == null) {
            request.getRequestDispatcher(pageRef.getEditprofile()).forward(request, response);
            return;
        }
        if (idSelfie == null) {
            request.getRequestDispatcher(pageRef.getEditprofile()).forward(request, response);
            return;
        }

        // Get database
        Firestore db = (Firestore) request.getServletContext().getAttribute(dbRef.getDatabase());
        DocumentReference dr = db.collection(uDbRef.getColUser()).document(user.getUsername());
        Bucket bk = (Bucket) request.getServletContext().getAttribute(strRef.getStorage());

        // Create HashMap to hold url of each file to update user reference data in database
        HashMap<String, Object> map = new HashMap<>();
        map.put(uDbRef.getDocVerify(), uDbRef.getAttVerifyWait());

        // Get file name
        String idCardName = Paths.get(idCard.getSubmittedFileName()).getFileName().toString();
        String idSelfieName = Paths.get(idSelfie.getSubmittedFileName()).getFileName().toString();
        // Create url
        String idCardUrl = strRef.getUrlExtIdCard() + user.getUsername() + "." + idCardName;
        String idSelfieUrl = strRef.getUrlExtIdSelfie() + user.getUsername() + "." + idSelfieName;

        // Upload id card image to GCS
        bk.getStorage().create(BlobInfo.newBuilder(bk.getName(), idCardUrl)
                .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                .build(), idCard.getInputStream());
        // Add url to map
        map.put(uDbRef.getDocIdCard(), strRef.getUrlGCS() + idCardUrl);

        // Upload id card selfie to GCS
        bk.getStorage().create(BlobInfo.newBuilder(bk.getName(), idSelfieUrl)
                .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                .build(), idSelfie.getInputStream());
        // Add url to map
        map.put(uDbRef.getDocIdSelfie(), strRef.getUrlGCS() + idSelfieUrl);

        // Update (Add) both file url to user document in database
        dr.update(map);

        // Redirect user to homepage
        response.sendRedirect(svlRef.getHome());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "A servlet that handle user privilege change to translator";
    }

}
