package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_mangeusers_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"\n");
      out.write("        integrity=\"sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==\"\n");
      out.write("        crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/admin.css\">\n");
      out.write("    <title>Admin | Manage Users</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"header\">\n");
      out.write("        <div class=\"navbar\">\n");
      out.write("            <div class=\"logo\">\n");
      out.write("                <a href=\"index.html\"><img src=\"./images/logo.png\" alt=\"\"></a>\n");
      out.write("            </div>\n");
      out.write("            <nav>\n");
      out.write("                <a href=\"#\" class=\"btn\">Logout</a>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Admin wrapper -->\n");
      out.write("    <div class=\"admin-wrapper\">\n");
      out.write("        <!-- Left side -->\n");
      out.write("        <div class=\"left-sidebar\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"../books/b-index.html\">Manage Books</a></li>\n");
      out.write("                <li><a href=\"admin.manageusers.html\">Manage Users</a></li>\n");
      out.write("                <li><a href=\"../categories/c-index.html\">Manage Categories</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <!-- Admin Content -->\n");
      out.write("        <div class=\"admin-content\">\n");
      out.write("            <div class=\"button-group\">\n");
      out.write("                <a href=\"c-create.html\" class=\"btn\">Add Users</a>\n");
      out.write("                <a href=\"c-index.html\" class=\"btn\">Manage Users</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <h2 class=\"section-title\">Manage Users</h2>\n");
      out.write("                <table>\n");
      out.write("                    <thead>\n");
      out.write("                        <th>S.NO</th>\n");
      out.write("                        <th>Username</th>\n");
      out.write("                        <th>Role</th>\n");
      out.write("                        <th colspan=\"2\">Action</th>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>1</td>\n");
      out.write("                            <td>@tasmiya_ansari</td>\n");
      out.write("                            <td>Admin</td>\n");
      out.write("                            <td><a href=\"#\" class=\"edit\">Edit</a></td>\n");
      out.write("                            <td><a href=\"#\" class=\"delete\">Delete</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>1</td>\n");
      out.write("                            <td>i_tushar.kataria</td>\n");
      out.write("                            <td>Admin</td>\n");
      out.write("                            <td><a href=\"#\" class=\"edit\">Edit</a></td>\n");
      out.write("                            <td><a href=\"#\" class=\"delete\">Delete</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <!-- footer\n");
      out.write("    <footer class=\"footer bg-dark\">\n");
      out.write("        <div class=\"f-container grid grid-3\">\n");
      out.write("            <div>\n");
      out.write("                <h1>Pick-a-Book | Admin Panel</h1>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer> -->\n");
      out.write("\n");
      out.write("    <!-- script/s -->\n");
      out.write("</body>\n");
      out.write("\n");
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
