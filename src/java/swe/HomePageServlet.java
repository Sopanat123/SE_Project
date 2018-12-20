package swe;

import com.google.cloud.firestore.Firestore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swe.model.WorkList;
import swe.referenceinfo.MainDatabaseReferenceInfo;
import swe.referenceinfo.ServletReferenceInfo;
import swe.referenceinfo.SessionReferenceInfo;
import swe.referenceinfo.WebPageReferenceInfo;

/**
 *
 * @author Ben
 */
public class HomePageServlet extends HttpServlet {

    private final String REQ_WORKLIST = "works";

    private final MainDatabaseReferenceInfo dbRef = MainDatabaseReferenceInfo.getMainDatabaseReferenceInfo();
    private final ServletReferenceInfo svlRef = ServletReferenceInfo.getServletReferenceInfo();
    private final SessionReferenceInfo sesRef = SessionReferenceInfo.getSessionReferenceInfo();
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

        if (request.getSession().getAttribute(sesRef.getUser()) == null) {
            response.sendRedirect(svlRef.getSignIn());
            return;
        }

        // Get database
        Firestore db = (Firestore) request.getServletContext().getAttribute(dbRef.getDatabase());
        WorkList wl = new WorkList(db);
        request.setAttribute(REQ_WORKLIST, wl.getList());
        request.getRequestDispatcher(pageRef.getHome()).forward(request, response);
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
