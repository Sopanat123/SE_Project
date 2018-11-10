package se.servlet;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.Variable;
import se.model.User;
import se.model.Work;

/**
 * /workinterested
 *
 * @author Ben
 */
public class WorkInterestedServlet extends HttpServlet {

    private static final String TAG = "WorkInterestedServlet";
    private static final String PAGE_JSP = ""; // TODO ////////////////////////////////////////////////////////
    private static final String INTERESTED = "interboo";
    private static final String INTERESTER = "interstr";
    private static final String INTERESTER_NUMBER = "interint";

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
        // Get current user
        User user = (User) request.getAttribute(Variable.SES_CURRENT_USER);

        // Check current user
        if (user == null) {
            response.sendRedirect(Variable.PAGE_SIGN_IN);
            return;
        } else if (user.getPrivilege().equals(Variable.PRIVILEGE_MEMBER)) {
            response.sendRedirect(Variable.PAGE_HOME);
            return;
        }

        // Get current work from session
        Work work = (Work) request.getSession().getAttribute(Variable.SES_CURRENT_WORK);

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute(Variable.APP_DB_NAME);
            DocumentReference dr = db.collection(Variable.DB_COL_WORK).document(work.getId());

            // Update translator (prevent outdate data)
            work.setTranslator(dr.get().get().getString(Variable.DB_DOC_WORK_TRANSLATOR));

            // Check if user (translator) is already interested in this work
            boolean interested = false;
            if (work.getTranslator().contains(user.getUsername())) {
                interested = true;
            }

            // Define instant of work's interested translator
            String[] interesters = {"None"};
            int interestNumber = 0;

            // Check if work has any interester
            if (work.getTranslator() != null) {
                interesters = work.getTranslator().split(",");
                interestNumber = interesters.length;
            }

            // Forward to coresponse page
            request.setAttribute(INTERESTED, interested);
            request.setAttribute(INTERESTER, interesters);
            request.setAttribute(INTERESTER_NUMBER, interestNumber);
            request.getRequestDispatcher(PAGE_JSP).forward(request, response);
        } catch (ExecutionException | InterruptedException ex) {
            Logger.getLogger(WorkInterestedServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        // Get current user (translator) from the session
        User user = (User) request.getAttribute(Variable.SES_CURRENT_USER);

        // Check current user
        if (user == null) {
            response.sendRedirect(Variable.PAGE_SIGN_IN);
            return;
        } else if (user.getPrivilege().equals(Variable.PRIVILEGE_MEMBER)) {
            response.sendRedirect(Variable.PAGE_HOME);
            return;
        }

        // Get current work from session
        Work work = (Work) request.getSession().getAttribute(Variable.SES_CURRENT_WORK);

        try {
            // Get database
            Firestore db = (Firestore) request.getServletContext().getAttribute(Variable.APP_DB_NAME);
            DocumentReference dr = db.collection(Variable.DB_COL_WORK).document(work.getId());

            // Update translator (prevent outdate data)
            work.setTranslator(dr.get().get().getString(Variable.DB_DOC_WORK_TRANSLATOR));

            // Check what user (translator) press the button
            // TODO
        } catch (ExecutionException | InterruptedException ex) {
            Logger.getLogger(WorkInterestedServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "A servlet for processing translator interest to the work";
    }

}
