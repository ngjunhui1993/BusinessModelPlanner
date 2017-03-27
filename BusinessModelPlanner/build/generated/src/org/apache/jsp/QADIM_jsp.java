package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class QADIM_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html ng-app=\"drag-and-drop\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <!--CSS FOR DRAGGABLE ELEMENTS-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/qadim/qadimDraggable.css\" />\n");
      out.write("        <!--CSS FOR TOOLTIPS-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/qadim/qadimTooltip.css\" />\n");
      out.write("        <!--CSS FOR BUTTONS-->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"../favicon.ico\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/qadim/qadimButton.css\" />\n");
      out.write("        <script src=\"resources/js/qadim/qadimmodernizr.custom.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--\n");
      out.write("        CONTENT\n");
      out.write("        1. EXPLANATION (TOOLTIPS)\n");
      out.write("        2. QADIM MODEL\n");
      out.write("        3. SIDE PANEL (PROJECT NAME AND BUTTONS)\n");
      out.write("        -->\n");
      out.write("\n");
      out.write("        <!--EXPLANATION-->\n");
      out.write("        <div id=\"maincontent\">\n");
      out.write("            <div class=\"tooltipcontent\">\n");
      out.write("                <div class=\"dummy dummy-text\">\n");
      out.write("                    <br><br><br>\n");
      out.write("                    <span class=\"tooltip tooltip-effect-3\">\n");
      out.write("                        <span class=\"tooltip-item\" style=\"font-size:1.8em\">QaDIM</span>\n");
      out.write("                        <span class=\"tooltip-content clearfix\">\n");
      out.write("                            <span class=\"tooltip-text\" style=\"padding-left:15px\">\n");
      out.write("                                An innovation framework, also known as the THE QUICK AND DIRTY INNOVATION MODEL.<br>\n");
      out.write("                            </span></span></span> enable \n");
      out.write("                    users to <b><u>identify incremental innovation opportunities</u></b> for \n");
      out.write("                    existing or new products or services. The model works on a 3 by 3 framework that allows users to enter desired\n");
      out.write("                    <span class=\"tooltip tooltip-effect-3\"><span class=\"tooltip-item\">Operators</span> \n");
      out.write("                        <span class=\"tooltip-content clearfix\"><span class=\"tooltip-text\" style=\"padding-left:15px\">\n");
      out.write("                                <strong>Operators</strong> are meaningful verbs or phrases that indicate the incremental innovation opportunities. <br>\n");
      out.write("                                Drag the operators around and change the operators to any values you desire.<br>\n");
      out.write("\n");
      out.write("                            </span></span></span> around the product/service. Look out for the \n");
      out.write("                    <span class=\"tooltip tooltip-effect-3\">\n");
      out.write("                        <span class=\"tooltip-item\">Tools</span> \n");
      out.write("                        <span class=\"tooltip-content clearfix\">\n");
      out.write("                            <span class=\"tooltip-text\" style=\"padding-left:15px\">\n");
      out.write("                                The <strong>Tools</strong> are developed to help you in the following:<br><br>\n");
      out.write("                                1. <strong>Save</strong> your current project.<br>\n");
      out.write("                                2. <Strong>Create</strong> a new project or <Strong>load</Strong> previous projects.<br>\n");
      out.write("                                3. <Strong>Download</Strong> your project in excel format.<br>\n");
      out.write("                            </span></span></span> on the right to perform more functions. If you are unsure of what to do, you can always <b>click here</b> for help.\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!--END OF EXPLANATION-->\n");
      out.write("\n");
      out.write("            <!--QADIM MODEL-->\n");
      out.write("            <table>\n");
      out.write("                <tr><td>\n");
      out.write("                        <!--PROJECT CONTENT-->\n");
      out.write("                        <div id=\"qadimcontent\">\n");
      out.write("                            <div ng-controller=\"oneCtrl as loki\">\n");
      out.write("                                <div class='contentWrapper ng-cloak'>\n");
      out.write("                                    <ul class=\"thumbnails\">\n");
      out.write("                                        <li ng-repeat=\"item in list1\" data-drop=\"true\" ng-model='list1' jqyoui-droppable=\"{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}\">\n");
      out.write("\n");
      out.write("                                            <div class=\"thumbnail\" data-drag=\"{{item.drag}}\" data-jqyoui-options=\"{revert: 'invalid'}\" ng-model=\"list1\" jqyoui-draggable=\"{index: {{$index}},animate:true}\">\n");
      out.write("                                                <h1>{{item.title}}</h1>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div ng-controller=\"oneCtrl as loki\">\n");
      out.write("                                <div class='contentWrapper ng-cloak'>\n");
      out.write("                                    <ul class=\"thumbnails\">\n");
      out.write("                                        <li ng-repeat=\"item in list2A\" data-drop=\"true\" ng-model='list2A' jqyoui-droppable=\"{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}\">\n");
      out.write("                                            <div class=\"thumbnail\" data-drag=\"{{item.drag}}\" data-jqyoui-options=\"{revert: 'invalid'}\" ng-model=\"list2A\" jqyoui-draggable=\"{index: {{$index}},animate:true}\">\n");
      out.write("                                                <h1>\n");
      out.write("                                                    {{item.title}}   \n");
      out.write("                                                </h1>\n");
      out.write("                                            </div>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <div class=\"thumbnail\" contenteditable=\"true\" id=\"projectName\"  >\n");
      out.write("                                                <h1>\n");
      out.write("                                                    Product / Service\n");
      out.write("                                                </h1>\n");
      out.write("                                            </div>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li ng-repeat=\"item in list2B\" data-drop=\"true\" ng-model='list2B' jqyoui-droppable=\"{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}\">\n");
      out.write("                                            <div class=\"thumbnail\" data-drag=\"{{item.drag}}\" data-jqyoui-options=\"{revert: 'invalid'}\" ng-model=\"list2B\" jqyoui-draggable=\"{index: {{$index}},animate:true}\">\n");
      out.write("                                                <h1>\n");
      out.write("                                                    {{item.title}}   \n");
      out.write("                                                </h1>\n");
      out.write("                                            </div>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div ng-controller=\"oneCtrl as loki\">\n");
      out.write("                                <div class='contentWrapper ng-cloak'>\n");
      out.write("                                    <ul class=\"thumbnails\">\n");
      out.write("                                        <li ng-repeat=\"item in list3\" data-drop=\"true\" ng-model='list3' jqyoui-droppable=\"{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}\">\n");
      out.write("                                            <div class=\"thumbnail\" data-drag=\"{{item.drag}}\" data-jqyoui-options=\"{revert: 'invalid'}\" ng-model=\"list3\" jqyoui-draggable=\"{index: {{$index}},animate:true}\">\n");
      out.write("                                                <h1>\n");
      out.write("                                                    {{item.title}}\n");
      out.write("                                                </h1>\n");
      out.write("                                            </div>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!--END OF QADIM MODEL-->\n");
      out.write("                    </td>\n");
      out.write("                    <!--QADIM TOOLS-->\n");
      out.write("                    <td>\n");
      out.write("                        <p style=\"font-size:20px; color:#fff; margin-bottom:-2.2em\">\n");
      out.write("                            YOU ARE MODIFYING PROJECT<br></p>\n");
      out.write("                        <p style=\"font-size:40px; color:#fff;margin-bottom:-.02em\">\n");
      out.write("                            <b>PROJECT NAME</b>\n");
      out.write("                        </p>\n");
      out.write("\n");
      out.write("                        <button class=\"progress-button\" data-style=\"flip-open\" data-perspective data-horizontal>New/Load</button><br><br>\n");
      out.write("                        <button class=\"progress-button\" data-style=\"fill\" data-horizontal id=\"QaDIMSave\">Save</button><br><br>\n");
      out.write("                        <button class=\"progress-button\" data-style=\"shrink\" data-horizontal>Download</button>\n");
      out.write("                    </td>\n");
      out.write("                    <!--END OF QADIM TOOLS-->\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <br><br>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--SCRIPTS FOR QADIM DRAGGABLE-->\n");
      out.write("\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular.min.js\"></script>\n");
      out.write("        <script src=\"resources/js/qadim/qadimDragDrop.js\"></script>\n");
      out.write("        <script src=\"resources/js/qadim/qadimApp.js\"></script>\n");
      out.write("\n");
      out.write("        <!--SCRIPT FOR TEXT FUNCTION-->\n");
      out.write("        <script>\n");
      out.write("                                                                changetext = function (e) {\n");
      out.write("                                                                src = (e.parentNode);\n");
      out.write("                                                                        src.outerHTML = \"<div><input +\" + \"name=input\" + \"></div>\";\n");
      out.write("                                                                }\n");
      out.write("        </script>\n");
      out.write("        <!--SCRIPTS FOR BUTTON-->\n");
      out.write("        <script src=\"resources/js/qadim/qadimClassie.js\"></script>\n");
      out.write("        <script src=\"resources/js/qadim/qadimProgressButton.js\"></script>\n");
      out.write("        <script>\n");
      out.write("                                                                [].slice.call(document.querySelectorAll('button.progress-button')).forEach(function (bttn) {\n");
      out.write("                                                        new ProgressButton(bttn, {\n");
      out.write("                                                        callback: function (instance) {\n");
      out.write("                                                        var progress = 0,\n");
      out.write("                                                                interval = setInterval(function () {\n");
      out.write("                                                                progress = Math.min(progress + Math.random() * 0.1, 1);\n");
      out.write("                                                                        instance._setProgress(progress);\n");
      out.write("                                                                        if (progress === 1) {\n");
      out.write("                                                                instance._stop(1);\n");
      out.write("                                                                        clearInterval(interval);\n");
      out.write("                                                                }\n");
      out.write("                                                                }, 200);\n");
      out.write("                                                        }\n");
      out.write("                                                        });\n");
      out.write("                                                        });\n");
      out.write("        </script>\n");
      out.write("        <!--This is the script for save functionality, i use ajax. getElementByID(the element ID), and get its inner html-->\n");
      out.write("        <!--after which, the data should be parsed to a servlet. The servlet handles changes the json into normal objects-->\n");
      out.write("        <!--The parser servlet will then pass the data to the qadimdao. validations required. -->\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("           $('#QaDIMSave').click( function parse() {\n");
      out.write("                var saveQADIMProjectName = document.getElementById(\"projectName\").innerHTML;\n");
      out.write("                console.log(saveQADIMProjectName);\n");
      out.write("                \n");
      out.write("                $.ajax\n");
      out.write("                   (\n");
      out.write("                   {\n");
      out.write("                    //testing   \n");
      out.write("                    //console.log(saveQADIMProjectName);\n");
      out.write("                       url:'QADIMParser',\n");
      out.write("                       data:{ \n");
      out.write("                           saveQADIMProjectName : saveQADIMProjectName\n");
      out.write("\n");
      out.write("                       },\n");
      out.write("\n");
      out.write("                       type:'GET',\n");
      out.write("                       cache:false,\n");
      out.write("                       success:function(){alert(saveQADIMProjectName);},\n");
      out.write("                       error:function(){alert('You have an existing project with the same title! Use a different project title');}\n");
      out.write("                   }\n");
      out.write("                   );  \n");
      out.write("        \n");
      out.write("            }) ; \n");
      out.write("        </script>\n");
      out.write("\n");
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
