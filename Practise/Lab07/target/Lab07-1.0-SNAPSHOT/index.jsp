<%-- 
    Document   : index
    Created on : Mar 12, 2021, 9:29:50 AM
    Author     : ThienKim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="calc" class="fpt.aptech.JavaBean.Calculator" scope="request" />
    <!--Lấy tất cả thuộc tính-->
    <jsp:setProperty name="calc" property="*"/> 
    <body>
        <h1>Calculator</h1>
        <form action="index.jsp">
            <input type="text" name="num1" placeholder="Enter number 1..."/> <br/><br/>
            <input type="text" name="num2" placeholder="Enter number 2..."/> <br/><br/>
            Operator selected:
            <select name="opt" id="opt"> <!-- lấy từ bên switch java -->
                <option value="+">Addition</option>
                <option value="-">Subtraction</option>
                <option value="*">Multiplication</option>
                <option value="/">Division</option>
            </select> <br/><br/>
            <input type="submit" value="Submit"/><br/><br/>
            <h2 style="color: red">Result: ${calc.result()}</h2><br/><br/>
        </form>
    </body>
</html>
