package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class BMC_005fResults_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html ng-app=\"BusinessModelCanvas\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>RESULT PAGE</h1>\n");
      out.write("        <H2>COMPANY NAME; </H2>\n");
      out.write("    <body ng-controller=\"RootController\">\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-4 title\">The Business Model Canvas</div>\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <table class=\"table table-bordered canvas-table\">\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr ng-repeat=\"row in tableLayout\">\n");
      out.write("                                <td ng-repeat=\"cell in row\"\n");
      out.write("                                    ng-controller=\"SectionController\"\n");
      out.write("                                    class=\"canvas-cell\"\n");
      out.write("                                    ng-class=\"{'tall-cell':  cell.rowspan == 2,\n");
      out.write("                               'short-cell': cell.rowspan == 1}\"\n");
      out.write("                                    rowspan=\"{{cell.rowspan}}\"\n");
      out.write("                                    colspan=\"{{cell.colspan}}\">\n");
      out.write("                                    <div class=\"table-cell\">\n");
      out.write("                                        <span>{{cell.title}}</span>\n");
      out.write("                                        <ul>\n");
      out.write("                                            <li ng-repeat=\"item in doc.sections[one.keyPartners]\">\n");
      out.write("                                            Hello\n");
      out.write("                                            </li>\n");
      out.write("\n");
      out.write("                                        </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <script src=\"js/angular.js\" type=\"text/javascript\"></script>\n");
      out.write("            <script src=\"js/ui-utils.js\" type=\"text/javascript\"></script>\n");
      out.write("            <script src=\"js/code.js\" type=\"text/javascript\"></script>\n");
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
