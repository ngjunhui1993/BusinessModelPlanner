<%-- 
    Document   : QADIM
    Created on : Oct 22, 2016, 1:44:59 PM
    Author     : jiaohui.lee.2014
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainValidation">
                <label for="product">Product</label>
                <input type="text" name="product" id="product" /> <br>
            <% 
                int productId =1; //need to increase based on number of projects
                int operatorId =0; //need to increase based on number of operator below
                int numberOfBoxes = Integer.parseInt(request.getParameter("numberOfBoxes"));
                for(int j = 1; j<=numberOfBoxes ;j++){ 
                    operatorId++;
            %>
                <label for="operator">Operator Name</label>
                <input type="text" name="operatorName<%=j%>" id="operator" /> <br>
                <label for="verb">Verb</label>
                <input type="text" name="verb<%=j%>" id="verb"/> <br>
                <label for="generalPhrase">General Phase</label>
                <input type="text" name="generalPhrase<%=j%>" id="generalPhrase"/> <br> <!--Assuming it is 1 line text now -->
                <label for="specificPhrase">Specific Phase</label>
                <input type="text" name="specificPhrase<%=j%>" id="specificPhrase" /> <br> <!--Assuming user key all phases -->
                <label for="dimension">Dimension</label>
                <input type="text" name="dimension<%=j%>" id="dimension" /> <br>

                <input type="hidden" name="productId" value="<%=productId%>"/>
                <input type="hidden" name="operatorId<%=j%>" value="<%=operatorId%>"/>
            <%
                }
            %>
                <input type="hidden" name="numberOfBoxes" value="<%=numberOfBoxes%>"/>
                <input type="submit" value="submit"/>
        </form>
    </body>
</html>
