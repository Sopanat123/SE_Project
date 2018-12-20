package swe.work;

import com.google.cloud.firestore.Firestore;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swe.model.User;
import swe.model.Work;

import swe.model.WorkList;
import swe.referenceinfo.MainDatabaseReferenceInfo;
import swe.referenceinfo.ServletReferenceInfo;
import swe.referenceinfo.SessionReferenceInfo;
import swe.referenceinfo.WebPageReferenceInfo;

/**
 *
 * @author Ben
 */
public class MyWorkServlet extends HttpServlet {

    private final String reqWork = "rwork";
    private final String tskWork = "twork";

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

        User user = (User) request.getSession().getAttribute(sesRef.getUser());

        if (user == null) {
            response.sendRedirect(svlRef.getSignIn());
            return;
        }

        // Get database
        Firestore db = (Firestore) request.getServletContext().getAttribute(dbRef.getDatabase());
        WorkList wl = new WorkList(db);

        ArrayList<Work> mywork = new ArrayList<>();
        for (Work w : wl.getList()) {
            if (w.getOwner().equals(user.getUsername())) {
                mywork.add(w);
            }
        }

        ArrayList<Work> myTask = new ArrayList<>();
        for (Work w : wl.getList()) {
            if (w.getTranslator() == null) {
                continue;
            }
            if (w.getTranslator().equals(user.getUsername())) {
                myTask.add(w);
            }
        }

        request.setAttribute(reqWork, mywork);
        request.setAttribute(tskWork, myTask);

        request.getRequestDispatcher(pageRef.getMywork()).forward(request, response);
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
