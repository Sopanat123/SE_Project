package se.servlet;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.storage.Acl;
//import com.google.cloud.storage.Acl.User;
//import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;

import java.io.IOException;
import java.io.InputStream;
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

import se.UserService;
import se.Variable;
//import se.model.User;

/**
 * url - /editprofile
 *
 * @author Ben
 */
@MultipartConfig
public class EditProfileServlet extends HttpServlet {

    private static final String TAG = "EditProfileServlet";
    private static final String PAGE_JSP = "WEB-INF/edit_profile.jsp";
    private static final String CLEAR = "CLEAR";

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
        se.model.User user = (se.model.User) request.getSession().getAttribute(Variable.SES_CURRENT_USER);

        // User 'MUST' signed in
        if (user == null) {
            response.sendRedirect(Variable.PAGE_SIGN_IN);
            return;
        }

        // Get parameter from request
        String displayname = request.getParameter(Variable.WEB_USER_DISPLAYNAME);
        String password = request.getParameter(Variable.WEB_USER_PASSWORD);
        String email = request.getParameter(Variable.WEB_USER_EMAIL);
        String phone = request.getParameter(Variable.WEB_USER_PHONE);
        String info = request.getParameter(Variable.WEB_USER_INFO);
        Part image = request.getPart(Variable.WEB_USER_IMAGE);
        String imgName = Paths.get(image.getSubmittedFileName()).getFileName().toString();
        String tag = request.getParameter(Variable.WEB_USER_TAG);

        // Web parameter flags
        boolean displaynameFlag = displayname != null && !displayname.isEmpty();
        boolean passwordFlag = password != null && !password.isEmpty();
        boolean emailFlag = email != null && !email.isEmpty();
        boolean phoneFlag = phone != null && !phone.isEmpty();
        boolean infoFlag = info != null && !info.isEmpty();
        boolean imageFlag = imgName != null && !imgName.isEmpty();
        boolean tagFlag = tag != null && !tag.isEmpty();

        // Check user input
        if (displaynameFlag && !UserService.validateDisplayname(displayname)) {
            request.setAttribute(Variable.MESSAGE, UserService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }
        if (passwordFlag && !UserService.validatePassword(password)) {
            request.setAttribute(Variable.MESSAGE, UserService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }
        if (emailFlag && !UserService.validateEmail(email)) {
            request.setAttribute(Variable.MESSAGE, UserService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }
        if (phoneFlag && !UserService.validatePhone(phone)) {
            request.setAttribute(Variable.MESSAGE, UserService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }
        if (info != null && info.equals(CLEAR)) { // If input == "CLEAR", data field will set to null
            info = "";
        } else if (infoFlag && !UserService.validateInfo(info)) {
            request.setAttribute(Variable.MESSAGE, UserService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }
        if (tag != null && tag.equals(CLEAR)) { // If input == "CLEAR", data field will set to null
            tag = "";
        } else if (tagFlag && !UserService.validateTag(tag)) {
            request.setAttribute(Variable.MESSAGE, UserService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute(Variable.APP_DB_NAME);
            DocumentReference dr = db.collection(Variable.DB_COL_USER).document(user.getUsername());

            // Create map to store new data
            Map<String, Object> map = new HashMap<>();

            // Changes check
            if (displaynameFlag) {
                // Duplicate displayname check
                CollectionReference users = db.collection(Variable.DB_COL_USER);
                Query queryDn = users.whereEqualTo(Variable.DB_DOC_USER_DISPLAYNAME, displayname);
                ApiFuture<QuerySnapshot> qsDn = queryDn.get();

                // INVALID displayname - displayname is already taken
                if (qsDn.get().size() > 0) {
                    request.setAttribute(Variable.MESSAGE, "This displayname is already taken.");
                    request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                    return;
                }

                map.put(Variable.DB_DOC_USER_DISPLAYNAME, displayname);
            }
            if (passwordFlag) {
                map.put(Variable.DB_DOC_USER_PASSWORD, password);
            }
            if (emailFlag) {
                // Duplicate email check
                CollectionReference users = db.collection(Variable.DB_COL_USER);
                Query queryEm = users.whereEqualTo(Variable.DB_DOC_USER_EMAIL, email);
                ApiFuture<QuerySnapshot> qsEm = queryEm.get();

                // INVALID email - email is already taken
                if (qsEm.get().size() > 0) {
                    request.setAttribute(Variable.MESSAGE, "This email is already taken.");
                    request.getRequestDispatcher(PAGE_JSP).forward(request, response);
                    return;
                }

                map.put(Variable.DB_DOC_USER_EMAIL, email);
            }
            if (phoneFlag) {
                map.put(Variable.DB_DOC_USER_PHONE, phone);
            }
            if (infoFlag) {
                map.put(Variable.DB_DOC_USER_INFO, info);
            }
            if (imageFlag) {
                Bucket bk = (Bucket) request.getServletContext().getAttribute(Variable.APP_DB_BUCKET);
                String imgLink = Variable.LINK_APPEND_PROFILE_IMAGE + user.getUsername() + "-" + imgName;

                bk.getStorage().create(BlobInfo.newBuilder(bk.getName(), imgLink)
                        .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                        .build(), image.getInputStream());

                map.put(Variable.DB_DOC_USER_IMAGE, Variable.LINK_GCS + imgLink);
            }
            if (tagFlag) {
                map.put(Variable.DB_DOC_USER_TAG, tag);
            }

            // Put map to database if change is occured
            if (!map.isEmpty()) {
                dr.update(map);

                // Update current user
                DocumentSnapshot doc = dr.get().get();
                user.setDisplayname(doc.getString(Variable.DB_DOC_USER_DISPLAYNAME));
                user.setEmail(doc.getString(Variable.DB_DOC_USER_EMAIL));
                user.setPhone(doc.getString(Variable.DB_DOC_USER_PHONE));
                user.setInfo(doc.getString(Variable.DB_DOC_USER_INFO));
                user.setImage(doc.getString(Variable.DB_DOC_USER_IMAGE));
                user.setTag(doc.getString(Variable.DB_DOC_USER_TAG));
            }

            // Redirect to homepage
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
        return "A servlet that handle profile update operation";
    }

}
