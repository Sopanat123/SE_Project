package se.servlet;

import java.io.IOException;

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

        // Check if user (translator) is already interested in this work
        boolean interested = false;
        if (work.getTranslator().contains(user.getUsername())) {
            interested = true;
        }

        // Forward to coresponse page
        request.setAttribute(Variable.REQ_INTERESTED, interested);
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
        String wid = work.getId();
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
