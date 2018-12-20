package swe.work;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.Bucket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swe.InputService;
import swe.model.User;
import swe.referenceinfo.MainDatabaseReferenceInfo;
import swe.referenceinfo.MainStorageReferenceInfo;
import swe.referenceinfo.ServletReferenceInfo;
import swe.referenceinfo.SessionReferenceInfo;
import swe.referenceinfo.WorkDatabaseReferenceInfo;
import swe.referenceinfo.WorkWebReferenceInfo;

/**
 *
 * @author Ben
 */
public class AddNewWorkServlet extends HttpServlet {

    private final InputService isv = InputService.getService();
    private final MainDatabaseReferenceInfo dbRef = MainDatabaseReferenceInfo.getMainDatabaseReferenceInfo();
    private final MainStorageReferenceInfo strRef = MainStorageReferenceInfo.getMainStorageReferenceInfo();
    private final ServletReferenceInfo svlRef = ServletReferenceInfo.getServletReferenceInfo();
    private final SessionReferenceInfo sesRef = SessionReferenceInfo.getSessionReferenceInfo();
    private final WorkDatabaseReferenceInfo wDbRef = WorkDatabaseReferenceInfo.getWorkDatabaseReferenceInfo();
    private final WorkWebReferenceInfo wWebRef = WorkWebReferenceInfo.getWorkWebReferenceInfo();

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

        User user = (User) request.getSession().getAttribute(sesRef.getUser());

        if (user == null) {
            response.sendRedirect(svlRef.getSignIn());
        }

        String title = request.getParameter(wWebRef.getTitle());
        String desc = request.getParameter(wWebRef.getDesc());

        if (isv.checkVoidString(title)) {
            request.getRequestDispatcher(svlRef.getHome()).forward(request, response);
            return;
        }

        // Get database
        Firestore db = (Firestore) request.getServletContext().getAttribute(dbRef.getDatabase());
        DocumentReference dr = db.collection(wDbRef.getColWork()).document();
        Bucket bk = (Bucket) request.getServletContext().getAttribute(strRef.getStorage());

        // Create map to store new data
        Map<String, Object> map = new HashMap<>();

        // Process mandaoty stuff
        map.put(wDbRef.getDocOwner(), user.getUsername());
        map.put(wDbRef.getDocTitle(), title);
        map.put(wDbRef.getDocDesc(), desc);
        map.put(wDbRef.getDocOwnerImage(), user.getImage());
        map.put(wDbRef.getDocStatus(), wDbRef.getAttStatusNew());
        map.put(wDbRef.getDocCreateTime(), FieldValue.serverTimestamp());

        // Add data to database with auto generate id
        String id = dr.getId();
        map.put(wDbRef.getDocId(), id);
        dr.set(map);

        // Send user back after operation is done
        response.sendRedirect(svlRef.getHome());
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
