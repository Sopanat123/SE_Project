package swe;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import swe.referenceinfo.MainDatabaseReferenceInfo;
import swe.referenceinfo.MainStorageReferenceInfo;

import swe.referenceinfo.ServletReferenceInfo;
import swe.referenceinfo.SessionReferenceInfo;
import swe.referenceinfo.WebPageReferenceInfo;
import swe.referenceinfo.WorkDatabaseReferenceInfo;
import swe.requirement.GeneralRequirement;
import swe.requirement.WorkRequirement;

/**
 *
 * @author Ben
 */
public class AddWorkServlet extends HttpServlet {

    private final InputService isv = InputService.getService();

    private final MainDatabaseReferenceInfo dbRef = MainDatabaseReferenceInfo.getMainDatabaseReferenceInfo();
    private final MainStorageReferenceInfo strRef = MainStorageReferenceInfo.getMainStorageReferenceInfo();
    private final ServletReferenceInfo svlRef = ServletReferenceInfo.getsServletReferenceInfo();
    private final SessionReferenceInfo sesRef = SessionReferenceInfo.getSessionReferenceInfo();
    private final WebPageReferenceInfo pageRef = WebPageReferenceInfo.getWebPageReferenceInfo();
    private final WorkDatabaseReferenceInfo wDbRef = WorkDatabaseReferenceInfo.getWorkDatabaseReferenceInfo();

    private final GeneralRequirement gReq = GeneralRequirement.getGeneralRequirement();
    private final WorkRequirement wReq = WorkRequirement.getWorkRequirement();

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

        // User must signed in
        if (request.getSession().getAttribute(sesRef.getUser()) == null) {
            response.sendRedirect(svlRef.getSignIn());
            return;
        }
        request.getRequestDispatcher(pageRef.getAddwork()).forward(request, response);
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

        // Get user from the session
        swe.model.User user = (swe.model.User) request.getSession().getAttribute(sesRef.getUser());

        // User MUST signed in
        if (user == null) {
            response.sendRedirect(svlRef.getSignIn());
            return;
        }

        // Get parameter adn part from request
        String title = request.getParameter(wDbRef.getDocTitle());
        String desc = request.getParameter(wDbRef.getDocDesc());
        String origLang = request.getParameter(wDbRef.getDocOrigLang());
        String targLang = request.getParameter(wDbRef.getDocTargLang());
        String tag = request.getParameter(wDbRef.getDocTag());
        String deadline = request.getParameter(wDbRef.getDocDeadline());
        String price = request.getParameter(wDbRef.getDocPrice());
        String hidden = request.getParameterValues(wDbRef.getDocHidden())
                == null ? "" : request.getParameterValues(wDbRef.getDocHidden())[0];
        Part image = request.getPart(wDbRef.getDocImage());
        Part sample = request.getPart(wDbRef.getDocSample());

        String imageName = Paths.get(image.getSubmittedFileName()).getFileName().toString();
        String sampleName = Paths.get(sample.getSubmittedFileName()).getFileName().toString();

        // Check null for all optional parameter
        boolean descFlag = desc != null;
        boolean tagFlag = tag != null;
        boolean deadlineFlag = deadline != null;
        boolean priceFlag = !isv.checkVoidString(price);
        boolean hiddenFlag = !isv.checkVoidString(hidden);
        boolean imageFlag = !isv.checkVoidString(imageName);
        boolean sampleFlag = !isv.checkVoidString(sampleName);

        // Check parameter
        if (!isv.verifyString(title, wReq.getTitleMinLength(), wReq.getTitleMaxLength())) {
            request.getRequestDispatcher(pageRef.getAddwork()).forward(request, response);
            return;
        }
        if (!isv.verifyString(origLang, wReq.getLanguageMinLength(), wReq.getLanguageMaxLength())) {
            request.getRequestDispatcher(pageRef.getAddwork()).forward(request, response);
            return;
        }
//        if (descFlag && !WorkService.validateDescription(desc)) {
//            request.setAttribute(Variable.REQ_MESSAGE, WorkService.getMessage());
//            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
//            return;
//        }
//        if (tagFlag && !WorkService.validateTag(tag)) {
//            request.setAttribute(Variable.REQ_MESSAGE, WorkService.getMessage());
//            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
//            return;
//        }
//        if (deadlineFlag && !WorkService.validateTime(deadline)) {
//            request.setAttribute(Variable.REQ_MESSAGE, WorkService.getMessage());
//            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
//            return;
//        }
//        if (priceFlag && !WorkService.validatePrice(price)) {
//            request.setAttribute(Variable.REQ_MESSAGE, WorkService.getMessage());
//            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
//            return;
//        }

        // Get database
        Firestore db = (Firestore) request.getServletContext().getAttribute(dbRef.getDatabase());
        DocumentReference dr = db.collection(wDbRef.getColWork()).document();
        String id = dr.getId();
        Bucket bk = (Bucket) request.getServletContext().getAttribute(strRef.getStorage());

        // Create map to store new data
        Map<String, Object> map = new HashMap<>();
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(Calendar.getInstance().getTime());

//        // Process mandaoty stuff
//        map.put(wDbRef.getDocOwner(), user.getUsername());
//        map.put(wDbRef.getDocTitle(), title);
//        map.put(Variable.DB_DOC_WORK_LANG_ORI, oriLang);
//        map.put(Variable.DB_DOC_WORK_LANG_DEST, destLang);
//        map.put(Variable.DB_DOC_WORK_STATUS, Variable.WORK_STATUS_NEW);
//        map.put(Variable.DB_DOC_WORK_CREATED, FieldValue.serverTimestamp());
//        // Upload work file to database
//        String fileUrl = Variable.LINK_APPEND_WORK_FILE + timestamp + "-f-" + user.getUsername() + fileName;
//        bk.getStorage().create(BlobInfo.newBuilder(bk.getName(), fileUrl)
//                .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
//                .build(), file.getInputStream());
//        map.put(Variable.DB_DOC_WORK_FILE, Variable.LINK_GCS + fileUrl);
//
//        // Process optional stuff
//        if (descFlag) {
//            map.put(Variable.DB_DOC_WORK_DESC, desc);
//        }
//        if (tagFlag) {
//            map.put(Variable.DB_DOC_WORK_TAG, tag);
//        }
//        if (deadlineFlag) {
//            map.put(Variable.DB_DOC_WORK_DEADLINE, deadline);
//        }
//        if (priceFlag) {
//            map.put(Variable.DB_DOC_WORK_PRICE, price);
//        }
//        if (onlysampleFlag) {
//            map.put(Variable.DB_DOC_WORK_ONLYSAMPLE, onlysample);
//        }
//        if (hiddenFlag) {
//            map.put(Variable.DB_DOC_WORK_HIDDEN, hidden);
//        }
//        if (imageFlag) {
//            String imageUrl = Variable.LINK_APPEND_WORK_IMAGE + timestamp + "-i-" + user.getUsername() + imageName;
//
//            bk.getStorage().create(BlobInfo.newBuilder(bk.getName(), imageUrl)
//                    .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
//                    .build(), image.getInputStream());
//
//            map.put(Variable.DB_DOC_WORK_IMAGE, Variable.LINK_GCS + imageUrl);
//        }
//        if (sampleFlag) {
//            String sampleUrl = Variable.LINK_APPEND_WORK_SAMPLE + timestamp + "-s-" + user.getUsername() + sampleName;
//
//            bk.getStorage().create(BlobInfo.newBuilder(bk.getName(), sampleUrl)
//                    .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
//                    .build(), sample.getInputStream());
//
//            map.put(Variable.DB_DOC_WORK_SAMPLE, Variable.LINK_GCS + sampleUrl);
//        }
//
//        // Add data to database with auto generate id
//        map.put(Variable.DB_DOC_WORK_ID, id);
//        dr.set(map);
//
//        response.sendRedirect(Variable.PAGE_HOME);
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
