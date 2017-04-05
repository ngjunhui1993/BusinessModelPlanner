<%@include file="Protect.jsp"%>
<%@page import="com.app.model.entity.QadimProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.QaDIMDAO"%>
<%@page import="com.app.model.entity.Demographics"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIMHA INNOVATION MODEL</title>
        <!--CSS FOR NEW FORM-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimForm.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimformComponent.css" />
        <script src="resources/js/qadim/qadimmodernizr.custom.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="fs-form-wrap" id="fs-form-wrap">
                <div class="fs-title">
                    <h1>Manage Projects</h1>
                    <a class="codrops-icon codrops-icon-prev" href="QADIMindex.jsp"> BACK</a><br>
                    Select Project to Delete<br>
                    Hold shift to select multiple projects to delete <br>
                    Project Name || Product Name<br>
                </div>
                <div style='margin-top: 100px;'>
                    <form class="me-select" action="QADIMParser">
                        <div style='padding:150px; margin-bottom: -120px;'>
                            <%String userid = user.getUserid();
                                ArrayList<QadimProduct> loadedProjects = QaDIMDAO.retrieveAllProjects(userid);
                                if (loadedProjects.size() != 0) {%>
                            <select name="projectsToDelete" style="width:200px; height: auto; margin:10px 10px 10px;" multiple>
                                <option disabled>Choose Project to Delete</option>
                                <%
                                    for (QadimProduct project : loadedProjects) {
                                        String projectName = project.getProjectName();
                                        String productName = project.getProductName();
                                        int productid = project.getProductID();
                                %>
                                <option value="<%=productid%>,<%=projectName%>"><%=projectName%></option>
                                <%
                                    };%>
                            </select>
                            <%
                                };
                            %></div>
                        <input type="hidden" value="deleteProject" name="deleteCheck"/>
                        <div style='margin-left:20px;'>
                            <button class="fs-submit" type="submit">Delete</button>
                        </div>
                    </form><!-- /fs-form -->
                    <div style='margin:20px 30px;'>
                        <%
                            String[] projectsDeleted = (String[]) request.getAttribute("projectsDeleted");
                            if (projectsDeleted != null) {
                        %>
                        You have successfully deleted the following project(s):
                        <%
                            for (String project : projectsDeleted) {
                                String projectNameDeleted = project.substring(project.indexOf(",") + 1, project.length());
                                projectNameDeleted.trim();
                        %>
                        <ul><li><%=projectNameDeleted%></li></ul>
                                <%
                                        }
                                    }
                                %>
                    </div>
                </div>
            </div><!-- /fs-form-wrap -->
        </div>
        <!--SCRIPTS FOR NEW FORM -->
        <script src="resources/js/qadim/qadimClassie.js"></script>
        <script src="resources/js/qadim/qadimFormSelectFx.js"></script>
        <script src="resources/js/qadim/qadimFullScreenForm.js"></script>
        <script src="resources/js/qadim/qadimLoadNewForm.js"></script>
        <!--SCRIPT FOR SELECT-->
        <script src="resources/js/qadim/qadimMagicselection.js"></script>
        <script>
            (function () {

                var selList = document.getElementById('me-select-list'),
                        items = selList.querySelectorAll('li');

                // fill the initial checked elements (mozilla)
                [].slice.call(items).forEach(function (el) {
                    el.className = el.querySelector('input[type="checkbox"]').checked ? 'selected' : '';
                });

                function checkUncheck(el) {
                    var elCheckbox = el.querySelector('input[type="checkbox"]');
                    el.className = elCheckbox.checked ? '' : 'selected';
                    elCheckbox.checked = !elCheckbox.checked;
                }

                new magicSelection(selList.querySelectorAll('li'), {
                    onSelection: function (el) {
                        checkUncheck(el);
                    },
                    onClick: function (el) {
                        el.className = el.querySelector('input[type="checkbox"]').checked ? 'selected' : '';
                    }
                });

            })();
        </script>
    </body>
</html>
