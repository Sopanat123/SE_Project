package swe.work;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swe.model.User;
import swe.model.Work;
import swe.referenceinfo.MainDatabaseReferenceInfo;
import swe.referenceinfo.ServletReferenceInfo;
import swe.referenceinfo.SessionReferenceInfo;
import swe.referenceinfo.WorkDatabaseReferenceInfo;

/**
 *
 * @author Ben
 */
public class WorkDetailServlet extends HttpServlet {

    private final String reqWork = "rwork";
    private final String reqUser = "ruser";
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    private final MainDatabaseReferenceInfo dbRef = MainDatabaseReferenceInfo.getMainDatabaseReferenceInfo();
    private final ServletReferenceInfo svlRef = ServletReferenceInfo.getServletReferenceInfo();
    private final SessionReferenceInfo sesRef = SessionReferenceInfo.getSessionReferenceInfo();
    private final WorkDatabaseReferenceInfo wDbRef = WorkDatabaseReferenceInfo.getWorkDatabaseReferenceInfo();

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

        User user = (User) request.getSession().getAttribute(sesRef.getUser());
        if (user == null) {
            response.sendRedirect(svlRef.getSignIn());
            return;
        }

        String workID = request.getParameter(reqWork);
        if (workID == null) {
            response.sendRedirect(svlRef.getHome());
            return;
        }

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute(dbRef.getDatabase());
            // Create a reference for fecthing matched data
            DocumentReference docRef = db.collection(wDbRef.getColWork()).document(workID);
            DocumentSnapshot doc;

            doc = docRef.get().get();

            Work work = new Work();

            work.setId(doc.getId());
            work.setOwner(doc.getString(wDbRef.getDocOwner()));
            work.setTitle(doc.getString(wDbRef.getDocTitle()));
            work.setOrigLang(doc.getString(wDbRef.getDocOrigLang()));
            work.setTargLang(doc.getString(wDbRef.getDocTargLang()));
            work.setDesc(doc.getString(wDbRef.getDocDesc()));
            work.setTag(doc.getString(wDbRef.getDocTag()));
            work.setImgUrl(doc.getString(wDbRef.getDocImage()));
            work.setSampleUrl(doc.getString(wDbRef.getDocSample()));
            work.setFileUrl(doc.getString(wDbRef.getDocFile()));
            work.setCmpFileUrl(doc.getString(wDbRef.getDocCmpFile()));
            work.setTranslator(doc.getString(wDbRef.getDocTranslator()));
            work.setStatus(doc.getString(wDbRef.getDocStatus()));

            Date dDate = doc.getDate(wDbRef.getDocDeadline());
            work.setDeadline(df.format(dDate));
            Date cDate = doc.getDate(wDbRef.getDocCreateTime());
            work.setCreated(df.format(cDate));
            Date aDate = doc.getDate(wDbRef.getDocAcceptTime());
            work.setAccepted(df.format(aDate));
            Date fDate = doc.getDate(wDbRef.getDocFinishTime());
            work.setFinished(df.format(fDate));

            double dPrice = doc.getDouble(wDbRef.getDocPrice());
            work.setPrice(String.valueOf(dPrice));
            work.setHidden(doc.getString(wDbRef.getDocHidden()));

            request.setAttribute(reqWork, work);
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(WorkDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
