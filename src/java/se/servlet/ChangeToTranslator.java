package se.servlet;

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

import se.Variable;
import se.model.User;

/**
 * /changetotranslator
 *
 * @author Ben
 */
@MultipartConfig
public class ChangeToTranslator extends HttpServlet {

    private static final String TAG = "ChangeToTranslator";
    private static final String PAGE_JSP = ""; // TODO ////////////////////////////////////////////////////////

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
        // Get user in session
        User user = (User) request.getSession().getAttribute(Variable.SES_CURRENT_USER);

        // User must signed in and is not a translator
        if (user == null) {
            response.sendRedirect(Variable.PAGE_SIGN_IN);
        } else if (user.getPrivilege().equals(Variable.PRIVILEGE_TRANSLATOR)) {
            response.sendRedirect(Variable.PAGE_HOME);
        } else {
            request.getRequestDispatcher(Variable.PAGE_TO_TRANSLATOR).forward(request, response);
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
        // Get user from session
        User user = (User) request.getSession().getAttribute(Variable.SES_CURRENT_USER);

        // Check if no user in session
        if (user == null) {
            response.sendRedirect(Variable.PAGE_SIGN_IN);
            return;
        }
        // Check if user is already translator
        if (user.getPrivilege().equals(Variable.PRIVILEGE_TRANSLATOR)) {
            response.sendRedirect(Variable.PAGE_HOME);
            return;
        }

        // Get file from web
        Part idCard = request.getPart(Variable.WEB_USER_ID_CARD);
        Part idSelfie = request.getPart(Variable.WEB_USER_ID_SELFIE);

        // Check null
        if (idCard == null) {
            request.setAttribute(Variable.MESSAGE, "No id card image");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }
        if (idSelfie == null) {
            request.setAttribute(Variable.MESSAGE, "No id card selfie image");
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }

        // Get database
        Firestore db = (Firestore) request.getServletContext().getAttribute(Variable.APP_DB_NAME);
        DocumentReference dr = db.collection(Variable.DB_COL_USER).document(user.getUsername());
        Bucket bk = (Bucket) request.getServletContext().getAttribute(Variable.APP_DB_BUCKET);

        // Create HashMap to hold url of each file to update user reference data in database
        HashMap<String, Object> map = new HashMap<>();
        map.put(Variable.DB_DOC_USER_VERIFY, Variable.VERIFY_WAIT);

        // Get file name
        String idCardName = Paths.get(idCard.getSubmittedFileName()).getFileName().toString();
        String idSelfieName = Paths.get(idSelfie.getSubmittedFileName()).getFileName().toString();

        // Create url
        String idCardUrl = Variable.LINK_APPEND_USER_ID_CARD + user.getUsername() + "." + idCardName;
        String idSelfieUrl = Variable.LINK_APPEND_USER_ID_SELFIE + user.getUsername() + "." + idSelfieName;

        // Upload id card image to GCS
        bk.getStorage().create(BlobInfo.newBuilder(bk.getName(), idCardUrl)
                .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                .build(), idCard.getInputStream());
        // Add url to map
        map.put(Variable.DB_DOC_USER_ID_IMAGE, Variable.LINK_GCS + idCardUrl);

        // Upload id card selfie to GCS
        bk.getStorage().create(BlobInfo.newBuilder(bk.getName(), idSelfieUrl)
                .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                .build(), idSelfie.getInputStream());
        // Add url to map
        map.put(Variable.DB_DOC_USER_ID_SELFIE, Variable.LINK_GCS + idSelfieUrl);

        // Update (Add) both file url to user document in database
        dr.update(map);

        // Redirect user to homepage
        response.sendRedirect(Variable.PAGE_HOME);
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
