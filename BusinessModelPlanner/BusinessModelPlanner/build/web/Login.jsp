
<%
    if (session.getAttribute("user") == "admin") {
        response.sendRedirect("admin.jsp");
        return;
    }else if(session.getAttribute("user") != null){
        response.sendRedirect("mainMenu.jsp");
        return;

    }
    
%>
<html>
    <head>
        <title>FYP</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="resources/css/style.css">
    </head>

    <body>
        <div class="login-page">
            <div class="form">
              <form class="register-form" method="post" action="Register">
                <input type="text" placeholder="name" name="name"/>
                <input type="password" placeholder="password" name="password"/>
                <input type="text" placeholder="email address" name="email"/>
                <input class="btn" type="submit" id="register" value="Register »" name="submit">
                <p class="message">Already registered? <a href="#">Sign In</a></p>
              </form>
              <form class="login-form" method="post" action="Login">
                <input type="text" placeholder="username" name="username"/>
                <input type="password" placeholder="password" name="password"/>
                <input class="btn" type="submit" id="login" value="Login »" name="submit">
                <p class="message">
                <%
    
                    String error = (String) request.getAttribute("errorMsg");

                    if (error != null) {
                        out.println("<font color='red'>" + error + "</br><br> </font>");
                    }

    
                    String success = (String) request.getAttribute("successMsg");

                    if (success != null) {
                        out.println("<font color='green'>" + success + "</br><br> </font>");
                    }

                %>
                <br/>
                    Not registered? <a href="#">Create an account</a></p>
              </form>
            </div>
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="resources/js/index.js"></script>
        
    </body>
