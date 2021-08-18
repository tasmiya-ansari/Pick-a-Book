package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import pickabook.dao.CategoryDAO;
import pickabook.helper.Helper;
import java.util.ArrayList;
import pickabook.dto.BookDetailsDTO;
import pickabook.dao.BookDAO;

public final class explore_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"\n");
      out.write("              integrity=\"sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==\"\n");
      out.write("              crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/styles.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/explore.css\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"./images/favicon.ico\">\n");
      out.write("        <title>Pick-a-Book | Explore Books</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body onload=\"getAllBooks()\">\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div class=\"navbar\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"index.html\"><img src=\"./images/logo.png\" alt=\"\"></a>\n");
      out.write("                </div>\n");
      out.write("                <nav>\n");
      out.write("                    <ul class=\"menu-items\">\n");
      out.write("                        <li><a href=\"index.html\">Home</a></li>\n");
      out.write("                        <li><a href=\"explore.html\">Explore</a></li>\n");
      out.write("                        <li><a href=\"about.html\">About</a></li>\n");
      out.write("                        <li><a href=\"register.html\">Account</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("                <a href=\"cart.html\"><i class=\"fa fa-shopping-cart\" aria-hidden=\"true\"></i></a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Explore page main section -->\n");
      out.write("        <section class=\"menu\">\n");
      out.write("            <!-- title -->\n");
      out.write("            <div class=\"title\">\n");
      out.write("                <h2>Explore Books</h2>\n");
      out.write("                <div class=\"underline\"></div>\n");
      out.write("            </div>\n");
      out.write("            <!-- filter buttons -->\n");
      out.write("            <div class=\"btn-container\">\n");
      out.write("                <button class=\"filter-btn\" type=\"button\" data-id=\"All\" onclick=\"getBooks(this)\" id=\"All\">All</button>\n");
      out.write("                 ");

                    ArrayList<String> categoryList = CategoryDAO.getCategory();
                    for (String c : categoryList) {
                
      out.write("\n");
      out.write("                <button class=\"filter-btn\" type=\"button\" data-id=\"");
      out.print(c );
      out.write("\" id=\"");
      out.print(c );
      out.write("\" onclick=\"getBooks(this)\">");
      out.print(c );
      out.write("</button>\n");
      out.write("                ");
                 }
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- books -->\n");
      out.write("            <div class=\"section-center\" id=\"showbooks\">\n");
      out.write("                <!-- Single item -->\n");
      out.write("                \n");
      out.write("                <!-- End of Single item -->\n");
      out.write("            </div>  \n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("<!--         Page navigation buttons \n");
      out.write("        <div class=\"page-btn-container\">\n");
      out.write("            <a href=\"explore.html\" class=\"pg-btn\"><span>1</span></a>\n");
      out.write("            <a href=\"explore-pg2.html\" class=\"pg-btn\"><span>2</span></a>\n");
      out.write("            <a href=\"explore-pg3.html\" class=\"pg-btn\"><span>3</span></a>\n");
      out.write("            <a href=\"explore-pg4.html\" class=\"pg-btn\"><span>4</span></a>\n");
      out.write("            <a href=\"#\" class=\"pg-btn\" id=\"next-btn\"><span><i class=\"fa fa-arrow-right\"></i></span></a>\n");
      out.write("        </div>-->\n");
      out.write("\n");
      out.write("        <!-- footer -->\n");
      out.write("        <footer class=\"footer bg-dark\">\n");
      out.write("            <div class=\"f-container grid grid-3\">\n");
      out.write("                <div>\n");
      out.write("                    <h1>Pick-a-Book</h1>\n");
      out.write("                    <p>Copyright &copy; 2021</p>\n");
      out.write("                </div>\n");
      out.write("                <nav>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"index.html\">Home</a></li>\n");
      out.write("                        <li><a href=\"explore.html\">Explore</a></li>\n");
      out.write("                        <li><a href=\"about.html\">About</a></li>\n");
      out.write("                        <li><a href=\"register.html\">Account</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("                <div class=\"social\">\n");
      out.write("                    <a href=\"#\"><i class=\"fab fa-github fa-2x\"></i></a>\n");
      out.write("                    <a href=\"#\"><i class=\"fab fa-facebook fa-2x\"></i></a>\n");
      out.write("                    <a href=\"#\"><i class=\"fab fa-instagram fa-2x\"></i></a>\n");
      out.write("                    <a href=\"#\"><i class=\"fab fa-twitter fa-2x\"></i></a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("        <!-- script/s -->\n");
      out.write("<!--        <script src=\"./js/main.js\"></script>-->\n");
      out.write("<script src=\"js/jquery.js\"></script>\n");
      out.write("            <script src=\"./js/explore1.js\"></script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
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
