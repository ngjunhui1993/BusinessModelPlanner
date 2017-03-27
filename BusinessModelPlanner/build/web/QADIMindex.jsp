<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--CSS FOR TOOLTIPS-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimTooltip.css" />
        <!--CSS FOR CURRENT PAGE-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimForm.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimformComponent.css" />
        <!--CSS FOR LOADING PROJECT-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadim-cs-select.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadim-cs-skin-elastic.css" />
        <!--CSS FOR NEW PROJECT BUTTON-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimButton.css" />
        <script src="resources/js/qadim/qadimmodernizr.custom.js"></script>
    </head>
    <body>
    <CENTER>
        <!--EXPLANATION-->
        <div id="maincontent">
            <div class="tooltipcontent">
                <div class="dummy dummy-text">
                    <br><br><br>
                    <span class="tooltip tooltip-effect-3">
                        <span class="tooltip-item" style="font-size:1.8em">QaDIM</span>
                        <span class="tooltip-content clearfix">
                            <span class="tooltip-text" style="padding-left:15px">
                                An innovation framework, also known as the THE QUICK AND DIRTY INNOVATION MODEL.<br>
                            </span></span></span> enable 
                    users to <b><u>identify incremental innovation opportunities</u></b> for 
                    existing or new products or services. You can start by either <b>creating a new project</b> or <b>load your existing project</b>
                    below
                </div>
            </div>
            <br><br>
            <!--END OF EXPLANATION-->          
            <table>
                <tr>
                    <td>
                        <!--LOAD NEW PROJECT//NAV TO QADIMnewProjectForm-->
                <center>
                    <button class="btn btn-2 btn-2a"  onclick="window.location.href='QADIMnewProject.jsp'">CREATE NEW PROJECT</button>
                </center>
                </td>
                </tr>
                <tr><td><center><h1>OR</h1></center></td></tr>
                <tr>
                    <td>
                        <!--LOAD EXISTING PROJECT-->
                <center>
                        <select class="cs-select cs-skin-elastic">
                            <option value="" disabled selected>Load Existing Project</option>
                            <option value="france" >France</option>
                        </select>
                </center>

                    </td>
                </tr>
            </table>
    </CENTER>
    <!--SCRIPT FOR DROPDOWN-->
    <script src="resources/js/qadim/qadimClassie.js"></script>
    <script src="resources/js/qadim/qadimFormSelectFx.js"></script>
    <script>
        (function () {
            [].slice.call(document.querySelectorAll('select.cs-select')).forEach(function (el) {
                new SelectFx(el);
            });
        })();
    </script>
</body>
</html>
