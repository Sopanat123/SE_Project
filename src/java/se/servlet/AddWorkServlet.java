package se.servlet;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.Acl;
//import com.google.cloud.storage.Acl.User;
//import com.google.cloud.storage.Acl.Role;
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

import se.Variable;
import se.WorkService;
//import se.model.User;

/**
 *
 * @author Ben
 */
@MultipartConfig
public class AddWorkServlet extends HttpServlet {

    private static final String TAG = "AddWorkServlet";
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
        String oriLang = request.getParameter(Variable.WEB_WORK_LANG_ORI);
        String destLang = request.getParameter(Variable.WEB_WORK_LANG_DEST);
        String tag = request.getParameter(Variable.WEB_WORK_TAG);
        String deadline = request.getParameter(Variable.WEB_WORK_DEADLINE);
        String price = request.getParameter(Variable.WEB_WORK_PRICE);
        String onlysample = request.getParameterValues(Variable.WEB_WORK_ONLYSAMPLE)
                == null ? "" : request.getParameterValues(Variable.WEB_WORK_ONLYSAMPLE)[0];
        String hidden = request.getParameterValues(Variable.WEB_WORK_HIDDEN)
                == null ? "" : request.getParameterValues(Variable.WEB_WORK_HIDDEN)[0];
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
        if (!WorkService.validateLanguage(oriLang) || !WorkService.validateLanguage(destLang)) {
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

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute(Variable.APP_DB_NAME);
            DocumentReference dr = db.collection(Variable.DB_COL_WORK).document();
            String id = dr.getId();
            Bucket bk = (Bucket) request.getServletContext().getAttribute(Variable.APP_DB_BUCKET);

            // Create map to store new data
            Map<String, Object> map = new HashMap<>();
            String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(Calendar.getInstance().getTime());

            // Process mandaoty stuff
            map.put(Variable.DB_DOC_WORK_OWNER, user.getUsername());
            map.put(Variable.DB_DOC_WORK_TITLE, title);
            map.put(Variable.DB_DOC_WORK_LANG_ORI, oriLang);
            map.put(Variable.DB_DOC_WORK_LANG_DEST, destLang);
            map.put(Variable.DB_DOC_WORK_STATUS, Variable.WORK_STATUS_NEW);
            map.put(Variable.DB_DOC_WORK_CREATED, FieldValue.serverTimestamp());
            // Upload work file to database
            String dbFileName = Variable.LINK_APPEND_WORK_FILE + timestamp + "-f-" + user.getUsername() + fileName;
            bk.getStorage().create(BlobInfo.newBuilder(bk.getName(), dbFileName)
                    .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                    .build(), file.getInputStream());
            map.put(Variable.DB_DOC_WORK_FILE, Variable.LINK_GCS + dbFileName);

            // Process optional stuff
            if (descFlag) {
                map.put(Variable.DB_DOC_WORK_DESC, desc);
            }
            if (tagFlag) {
                map.put(Variable.DB_DOC_WORK_TAG, tag);
            }
            if (deadlineFlag) {
                map.put(Variable.DB_DOC_WORK_DEADLINE, deadline);
            }
            if (priceFlag) {
                map.put(Variable.DB_DOC_WORK_PRICE, price);
            }
            if (onlysampleFlag) {
                map.put(Variable.DB_DOC_WORK_ONLYSAMPLE, onlysample);
            }
            if (hiddenFlag) {
                map.put(Variable.DB_DOC_WORK_HIDDEN, hidden);
            }
            if (imageFlag) {
                String dbImageName = Variable.LINK_APPEND_WORK_IMAGE + timestamp + "-i-" + user.getUsername() + imageName;

                bk.getStorage().create(BlobInfo.newBuilder(bk.getName(), dbImageName)
                        .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                        .build(), image.getInputStream());

                map.put(Variable.DB_DOC_WORK_IMAGE, Variable.LINK_GCS + dbImageName);
            }
            if (sampleFlag) {
                String dbSampleName = Variable.LINK_APPEND_WORK_SAMPLE + timestamp + "-s-" + user.getUsername() + sampleName;

                bk.getStorage().create(BlobInfo.newBuilder(bk.getName(), dbSampleName)
                        .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                        .build(), sample.getInputStream());

                map.put(Variable.DB_DOC_WORK_SAMPLE, Variable.LINK_GCS + dbSampleName);
            }

            // Add data to database with auto generate id
            map.put(Variable.DB_DOC_WORK_ID, id);
            dr.set(map);

            response.sendRedirect(Variable.PAGE_HOME);
        } catch (IOException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            request.setAttribute(Variable.MESSAGE, "Can't upload to database.");
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
        return "A servlet for handle work creation";
    }

}
