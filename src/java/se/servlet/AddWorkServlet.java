package se.servlet;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import se.Variable;
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
        String hidden = request.getParameterValues(Variable.WEB_WORK_HIDDEN)[0]; // 1 checkbox
        Part image = request.getPart(Variable.WEB_WORK_IMAGE);
        Part file = request.getPart(Variable.WEB_WORK_FILE);
        String imageName = Paths.get(image.getSubmittedFileName()).getFileName().toString();
        String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
        
        // Check parameter
        
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
