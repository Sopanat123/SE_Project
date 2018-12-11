package se.servlet;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.Variable;
import se.model.TranslatorVerifyList;
import se.model.User;

/**
 * /verifytranslator
 *
 * @author Ben
 */
public class VerifyTranslatorServlet extends HttpServlet {

    private static final String TAG = "VerifyTranslatorServlet";
    private static final String PAGE_JSP = ""; // TODO ////////////////////////////////////////////////////////
    private static final String WEB_BUTTON_REJECT = ""; // TODO ///////////////////////////////////////////////
    private static final String WEB_BUTTON_APPROVE = ""; // TODO //////////////////////////////////////////////

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
        User user = (User) request.getSession().getAttribute(Variable.SES_CURRENT_USER);

        // Check if user has a right to access the page
        if (user == null) {
            response.sendRedirect(Variable.PAGE_SIGN_IN);
            return;
        } else if (!user.getPrivilege().equals(Variable.PRIVILEGE_ADMIN)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        // Get database
        Firestore db = (Firestore) request.getServletContext().getAttribute(Variable.APP_DB_NAME);
        TranslatorVerifyList tl = new TranslatorVerifyList(db);

        // Forward to verify page
        request.setAttribute(Variable.PAGE_VERIFY_TRANSLATOR, tl.getList());
        request.getRequestDispatcher(Variable.PAGE_VERIFY_TRANSLATOR).forward(request, response);
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
        User admin = (User) request.getSession().getAttribute(Variable.SES_CURRENT_USER);

        // Check if user has a right to access the page
        if (admin == null) {
            response.sendRedirect(Variable.PAGE_SIGN_IN);
        } else if (admin.getPrivilege().equals(Variable.PRIVILEGE_ADMIN)) {
            request.getRequestDispatcher(Variable.PAGE_VERIFY_TRANSLATOR).forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }

        // Get database
        Firestore db = (Firestore) request.getServletContext().getAttribute(Variable.APP_DB_NAME);

        // Check what button admin does pressed
        if (request.getParameter(WEB_BUTTON_REJECT) != null) {
            DocumentReference dr = db.collection(Variable.DB_COL_USER)
                    .document(request.getParameter(WEB_BUTTON_REJECT));
            dr.update(Variable.DB_DOC_USER_VERIFY, Variable.VERIFY_REJECT);
        } else if (request.getParameter(WEB_BUTTON_APPROVE) != null) {
            DocumentReference dr = db.collection(Variable.DB_COL_USER)
                    .document(request.getParameter(WEB_BUTTON_APPROVE));
            dr.update(Variable.DB_DOC_USER_VERIFY, Variable.VERIFY_SUCCESS);
        }

        // Forward to back to same page
        request.getRequestDispatcher(PAGE_JSP).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "A servlet for admin to verify and approve user request to become a translator";
    }

}
