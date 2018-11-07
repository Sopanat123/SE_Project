package se.servlet;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
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

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import se.Variable;
import se.WorkService;
//import se.model.User;

/**
 *
 * @author Ben
 */
@MultipartConfig
public class AddWorkServlet extends HttpServlet {

    private static final String PAGE_JSP = "WEB-INF/addwork.jsp";

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
        // Get user from the session
        se.model.User user = (se.model.User) request.getSession().getAttribute(Variable.SES_CURRENT_USER);

        // User MUST signed in
        if (user == null) {
            response.sendRedirect(Variable.PAGE_SIGN_IN);
            return;
        }

        // Get parameter adn part from request
        String title = request.getParameter(Variable.WEB_WORK_TITLE);
        String desc = request.getParameter(Variable.WEB_WORK_DESC);
        String tag = request.getParameter(Variable.WEB_WORK_TAG);
        String deadline = request.getParameter(Variable.WEB_WORK_DEADLINE);
        String price = request.getParameter(Variable.WEB_WORK_PRICE);
        String onlysample = request.getParameterValues(Variable.WEB_WORK_ONLYSAMPLE)[0]; // 1 checkbox
        String hidden = request.getParameterValues(Variable.WEB_WORK_HIDDEN)[0]; // 1 checkbox
        Part image = request.getPart(Variable.WEB_WORK_IMAGE);
        Part sample = request.getPart(Variable.WEB_WORK_SAMPLE);
        Part file = request.getPart(Variable.WEB_WORK_FILE);
        String imageName = Paths.get(image.getSubmittedFileName()).getFileName().toString();
        String sampleName = Paths.get(sample.getSubmittedFileName()).getFileName().toString();
        String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString();

        // Check null for all optional parameter
        boolean descFlag = desc != null;
        boolean tagFlag = tag != null;
        boolean deadlineFlag = deadline != null;
        boolean priceFlag = price != null && !price.isEmpty();
        boolean onlysampleFlag = onlysample != null && !onlysample.isEmpty();
        boolean hiddenFlag = hidden != null && !hidden.isEmpty();
        boolean imageFlag = imageName != null && !imageName.isEmpty();
        boolean sampleFlag = sampleName != null && !sampleName.isEmpty();

        // Check parameter
        if (!WorkService.validateTitle(title)) {
            request.setAttribute(Variable.MESSAGE, WorkService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }
        if (descFlag && !WorkService.validateDescription(desc)) {
            request.setAttribute(Variable.MESSAGE, WorkService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }
        if (tagFlag && !WorkService.validateTag(tag)) {
            request.setAttribute(Variable.MESSAGE, WorkService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }
        if (deadlineFlag && !WorkService.validateTime(deadline)) {
            request.setAttribute(Variable.MESSAGE, WorkService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }
        if (priceFlag && !WorkService.validatePrice(price)) {
            request.setAttribute(Variable.MESSAGE, WorkService.getMessage());
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
            return;
        }

        // Get database
        Firestore db = (Firestore) request.getServletContext().getAttribute(Variable.APP_DB_NAME);
        DocumentReference dr = db.collection(Variable.DB_COL_USER).document(user.getUsername());
        Bucket bk = (Bucket) request.getServletContext().getAttribute(Variable.APP_DB_BUCKET);
        Storage st = bk.getStorage();

        // Create map to store new data
        Map<String, Object> map = new HashMap<>();

        // Process stuff
        map.put(Variable.DB_DOC_WORK_OWNER, user.getUsername());
        map.put(Variable.DB_DOC_WORK_TITLE, title);
        map.put(Variable.DB_DOC_WORK_STATUS, Variable.WORK_STATUS_NEW);
        map.put(Variable.DB_DOC_WORK_CREATED, FieldValue.serverTimestamp());
        if (imageFlag) {
            InputStream imgFile = image.getInputStream();

            st.create(BlobInfo.newBuilder(bk.getName(),
                    Variable.LINK_APPEND_WORK_IMAGE
                    + user.getUsername()
                    + "-"
                    + imageName)
                    .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                    .build(), imgFile);

            map.put(Variable.DB_DOC_USER_IMAGE, Variable.LINK_GCS
                    + Variable.LINK_APPEND_WORK_IMAGE
                    + user.getUsername()
                    + "-"
                    + imageName);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "A servlet for handle work creation";
    }

}
