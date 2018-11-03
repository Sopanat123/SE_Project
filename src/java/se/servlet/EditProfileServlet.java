package se.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.model.User;

/**
 * url - /editprofile
 *
 * @author Ben
 */
public class EditProfileServlet extends HttpServlet {

    private static final String TAG = "EditProfileServlet";
    private static final String MESSAGE = "msg";
    private static final String PAGE_JSP = "WEB-INF/edit_profile.jsp";
    private static final String PAGE_SIGNIN = "signin";
    private static final String PAGE_HOME = "home";
    private static final String SESS_USER = "user";

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
        // User 'MUST' logged in
        if (request.getSession().getAttribute(SESS_USER) == null) {
            response.sendRedirect(PAGE_SIGNIN);
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
        // Get user from session
        User user = (User) request.getSession().getAttribute(SESS_USER);

        // User 'MUST' logged in
        if (user == null) {
            response.sendRedirect(PAGE_SIGNIN);
            return;
        }

        // TODO - Set Data
        response.sendRedirect(PAGE_HOME);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "A servlet that handle profile update operation";
    }

}
