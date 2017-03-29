<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Project Form</title>
        <!--CSS FOR NEW FORM-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimForm.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimformComponent.css" />
        <script src="resources/js/qadim/qadimmodernizr.custom.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="fs-form-wrap" id="fs-form-wrap">
                <div class="fs-title">
                    <h1>Create New Project</h1>
                </div>
                <!--START OF FORM-->
                <form id="myform" class="fs-form fs-form-full" autocomplete="off" action="QADIMPageUpdate">
                    <ol class="fs-fields">
                        <!--PROJECT NAME FIELD-->
                        <li>
                            <label class="fs-field-label fs-anim-upper" for="q1" data-info="Tell us about your project">What's your project name?</label>
                            <input class="fs-anim-lower" id="q1" name="projectName" type="text" placeholder="e.g. HAPPY PROJECT" required/>
                        </li>
                        <!--PRODUCT NAME FIELD-->
                        <li>
                            <label class="fs-field-label fs-anim-upper" for="q2" data-info="What is your product?">What's your product name?</label>
                            <input class="fs-anim-lower" id="q2" name="productName" type="text" placeholder="COOLERBOX" required/>
                        </li>
                        <!--PRODUCT DESCRIPTION FIELD-->
                        <li>
                            <label class="fs-field-label fs-anim-upper" for="q4">Describe your product</label>
                            <textarea class="fs-anim-lower" id="q4" name="productDescription" placeholder="Describe here"></textarea>
                        </li>

                    </ol>
                    
                    <!--POPULATE TO QADIM PAGE: PROJECT NAME AND PRODUCT NAME-->
                    <button class="fs-submit" type="submit">DONE!</button>
                </form>
            </div>
        </div>
        <!--SCRIPTS FOR NEW FORM -->
        <script src="resources/js/qadim/qadimClassie.js"></script>
        <script src="resources/js/qadim/qadimFormSelectFx.js"></script>
        <script src="resources/js/qadim/qadimFullScreenForm.js"></script>
        <script src="resources/js/qadim/qadimLoadNewForm.js"></script>
    </body>
</html>
