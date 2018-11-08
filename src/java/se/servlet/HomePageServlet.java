package se.servlet;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.Variable;

import se.model.User;
import se.model.WorkList;

/**
 * url - /home
 *
 * @author Ben
 */
public class HomePageServlet extends HttpServlet {

    private static final String TAG = "HomePageServlet";
    private static final String PAGE_JSP = "WEB-INF/homepage.jsp";

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
        // Get user from session
        User user = (User) request.getSession().getAttribute(Variable.SES_CURRENT_USER);

        // User 'MUST' logged in
        if (user == null) {
            response.sendRedirect(Variable.PAGE_SIGN_IN);
            return;
        }

        // Get database
        Firestore db = (Firestore) request.getServletContext().getAttribute("db");
        WorkList wl = new WorkList(db);
        request.setAttribute(Variable.WORKLIST, wl.getList());
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
        // TODO
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "A servlet for homepage";
    }

}
