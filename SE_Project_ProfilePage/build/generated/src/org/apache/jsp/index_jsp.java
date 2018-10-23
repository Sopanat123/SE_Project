package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!doctype html>\n");
      out.write("<!--[if lt IE 7]>      <html class=\"no-js lt-ie9 lt-ie8 lt-ie7\" lang=\"\"> <![endif]-->\n");
      out.write("<!--[if IE 7]>         <html class=\"no-js lt-ie9 lt-ie8\" lang=\"\"> <![endif]-->\n");
      out.write("<!--[if IE 8]>         <html class=\"no-js lt-ie9\" lang=\"\"> <![endif]-->\n");
      out.write("<!--[if gt IE 8]><!--> <html class=\"no-js\" lang=\"\"> <!--<![endif]-->\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("        <title></title>\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"apple-touch-icon.png\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"assests/css/bootstrap.min.css\">\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                padding-top: 50px;\n");
      out.write("                padding-bottom: 20px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <link rel=\"stylesheet\" href=\"assests/css/bootstrap-theme.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assests/css/main.css\">\n");
      out.write("\n");
      out.write("        <script src=\"js/vendor/modernizr-2.8.3-respond-1.4.2.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        \n");
      out.write("\t<div class=\"row\">\n");
      out.write("            \n");
      out.write("            <div class=\"col-sm-3\"><!--left col-->\n");
      out.write("              \n");
      out.write("\n");
      out.write("      <div class=\"text-center\">\n");
      out.write("        <img src=\"http://ssl.gstatic.com/accounts/ui/avatar_2x.png\" class=\"avatar img-circle img-thumbnail\" alt=\"avatar\">\n");
      out.write("        <h6>Upload a different photo...</h6>\n");
      out.write("        <input type=\"file\" class=\"text-center center-block file-upload\">\n");
      out.write("      </div></hr><br>\n");
      out.write("        </div><!--/col-3-->\n");
      out.write("\t\t<div class=\"col-md-3 \">\n");
      out.write("                    \n");
      out.write("\t\t     <!--<div class=\"list-group \">\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action active\">Dashboard</a>\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action\">User Management</a>\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action\">Used</a>\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action\">Enquiry</a>\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action\">Dealer</a>\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action\">Media</a>\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action\">Post</a>\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action\">Category</a>\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action\">New</a>\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action\">Comments</a>\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action\">Appearance</a>\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action\">Reports</a>\n");
      out.write("              <a href=\"#\" class=\"list-group-item list-group-item-action\">Settings</a>\n");
      out.write("              \n");
      out.write("              \n");
      out.write("            </div> -->\n");
      out.write("\t\t</div> \n");
      out.write("\t\t<div class=\"col-md-9\">\n");
      out.write("\t\t    <div class=\"card\">\n");
      out.write("\t\t        <div class=\"card-body\">\n");
      out.write("\t\t            <div class=\"row\">\n");
      out.write("\t\t                <div class=\"col-md-12\">\n");
      out.write("\t\t                    <h4>Your Profile</h4>\n");
      out.write("\t\t                    <hr>\n");
      out.write("\t\t                </div>\n");
      out.write("\t\t            </div>\n");
      out.write("                            \n");
      out.write("\t\t            <div class=\"row\">\n");
      out.write("\t\t                <div class=\"col-md-12\">\n");
      out.write("\t\t                    <form>\n");
      out.write("                              <div class=\"form-group row\">\n");
      out.write("                                <label for=\"username\" class=\"col-4 col-form-label\">Alias</label> \n");
      out.write("                                <div class=\"col-8\">\n");
      out.write("                                  <input id=\"username\" name=\"username\" placeholder=\"Username\" class=\"form-control here\" type=\"text\">\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"form-group row\">\n");
      out.write("                                <label for=\"name\" class=\"col-4 col-form-label\">First Name*</label> \n");
      out.write("                                <div class=\"col-8\">\n");
      out.write("                                  <input id=\"name\" name=\"name\" placeholder=\"First Name\" class=\"form-control here\" required=\"required\" type=\"text\">\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"form-group row\">\n");
      out.write("                                <label for=\"lastname\" class=\"col-4 col-form-label\">Last Name*</label> \n");
      out.write("                                <div class=\"col-8\">\n");
      out.write("                                  <input id=\"lastname\" name=\"lastname\" placeholder=\"Last Name\" class=\"form-control here\" required=\"required\" type=\"text\">\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"form-group row\">\n");
      out.write("                                <label for=\"text\" class=\"col-4 col-form-label\">Nick Name</label> \n");
      out.write("                                <div class=\"col-8\">\n");
      out.write("                                  <input id=\"text\" name=\"text\" placeholder=\"Nick Name\" class=\"form-control here\" type=\"text\">\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"form-group row\">\n");
      out.write("                                <label for=\"email\" class=\"col-4 col-form-label\">Email*</label> \n");
      out.write("                                <div class=\"col-8\">\n");
      out.write("                                  <input id=\"email\" name=\"email\" placeholder=\"Email\" class=\"form-control here\" required=\"required\" type=\"text\">\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"form-group row\">\n");
      out.write("                                <label for=\"publicinfo\" class=\"col-4 col-form-label\">Public Info</label> \n");
      out.write("                                <div class=\"col-8\">\n");
      out.write("                                  <textarea id=\"publicinfo\" name=\"publicinfo\" cols=\"40\" rows=\"4\" class=\"form-control\"></textarea>\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"form-group row\">\n");
      out.write("                                <label for=\"tags\" class=\"col-4 col-form-label\">Tags</label>                               \n");
      out.write("                              </div>\n");
      out.write("                              <!--<div class=\"form-group row\">\n");
      out.write("                                <label for=\"newpass\" class=\"col-4 col-form-label\">New Password</label> \n");
      out.write("                                <div class=\"col-8\">\n");
      out.write("                                  <input id=\"newpass\" name=\"newpass\" placeholder=\"New Password\" class=\"form-control here\" type=\"text\">\n");
      out.write("                                </div>\n");
      out.write("                              </div>  -->\n");
      out.write("                              <div class=\"form-group row\">\n");
      out.write("                                <div class=\"offset-4 col-8\">\n");
      out.write("                                  <button name=\"submit\" type=\"submit\" class=\"btn btn-primary\">Update My Profile</button>\n");
      out.write("                                </div>\n");
      out.write("                              </div>\n");
      out.write("                            </form>\n");
      out.write("\t\t                </div>\n");
      out.write("\t\t            </div>\n");
      out.write("\t\t            \n");
      out.write("\t\t        </div>\n");
      out.write("\t\t    </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>       <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("        <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.2.min.js\"><\\/script>')</script>\n");
      out.write("\n");
      out.write("        <script src=\"js/vendor/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->\n");
      out.write("        <script>\n");
      out.write("            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=\n");
      out.write("            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;\n");
      out.write("            e=o.createElement(i);r=o.getElementsByTagName(i)[0];\n");
      out.write("            e.src='//www.google-analytics.com/analytics.js';\n");
      out.write("            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));\n");
      out.write("            ga('create','UA-XXXXX-X','auto');ga('send','pageview');\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
