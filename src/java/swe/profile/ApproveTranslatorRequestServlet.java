package swe.profile;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swe.model.TranslatorVerifyList;
import swe.model.User;
import swe.referenceinfo.MainDatabaseReferenceInfo;
import swe.referenceinfo.ServletReferenceInfo;
import swe.referenceinfo.SessionReferenceInfo;
import swe.referenceinfo.UserDatabaseReferenceInfo;
import swe.referenceinfo.WebPageReferenceInfo;

/**
 *
 * @author Ben
 */
public class ApproveTranslatorRequestServlet extends HttpServlet {

    private final String vTranslator = "trans";
    private final String btnRej = "rej";
    private final String btnSuc = "suc";

    private final MainDatabaseReferenceInfo dbRef = MainDatabaseReferenceInfo.getMainDatabaseReferenceInfo();
    private final ServletReferenceInfo svlRef = ServletReferenceInfo.getServletReferenceInfo();
    private final SessionReferenceInfo sesRef = SessionReferenceInfo.getSessionReferenceInfo();
    private final UserDatabaseReferenceInfo uDbRef = UserDatabaseReferenceInfo.getUserDatabaseReferenceInfo();
    private final WebPageReferenceInfo pageRef = WebPageReferenceInfo.getWebPageReferenceInfo();

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

        // Get current user from session
        User user = (User) request.getSession().getAttribute(sesRef.getUser());

        // Check if user has a right to access the page
        if (user == null) {
            response.sendRedirect(svlRef.getSignIn());
            return;
        } else if (!user.getPrivilege().equals(uDbRef.getAttPrivilegeAdmin())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        // Get database
        Firestore db = (Firestore) request.getServletContext().getAttribute(dbRef.getDatabase());
        TranslatorVerifyList tl = new TranslatorVerifyList(db);

        // Forward to verify page
        request.setAttribute(vTranslator, tl.getList());
        request.getRequestDispatcher(pageRef.getApprovetranslator()).forward(request, response);
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

        // Get current user from session
        User admin = (User) request.getSession().getAttribute(sesRef.getUser());

        // Check if user has a right to access the page
        if (admin == null) {
            response.sendRedirect(svlRef.getSignIn());
        } else if (!admin.getPrivilege().equals(uDbRef.getAttPrivilegeAdmin())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }

        // Get database
        Firestore db = (Firestore) request.getServletContext().getAttribute(dbRef.getDatabase());

        // Check what button admin does pressed
        if (request.getParameter(btnRej) != null) {
            DocumentReference dr = db.collection(uDbRef.getColUser())
                    .document(request.getParameter(btnRej));

            dr.update(uDbRef.getDocVerify(), uDbRef.getAttVerifyReject());
        } else if (request.getParameter(btnSuc) != null) {
            DocumentReference dr = db.collection(uDbRef.getColUser())
                    .document(request.getParameter(btnSuc));

            dr.update(uDbRef.getDocVerify(), uDbRef.getAttVerifySuccess());
        }

        // Forward to back to same page
        request.getRequestDispatcher(svlRef.getApprovetranslator()).forward(request, response);
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
