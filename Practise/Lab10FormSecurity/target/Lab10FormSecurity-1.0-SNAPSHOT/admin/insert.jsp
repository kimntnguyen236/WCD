<%-- 
    Document   : insert
    Created on : Mar 19, 2021, 12:09:16 PM
    Author     : ThienKim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create New Contact</h1>
        <form action="ContactServlet" method="POST">
            <input type="text" name="txtFN" placeholder="Enter First Name ..."/>
            <input type="text" name="txtLN" placeholder="Enter Last Name ..."/>
            <input type="text" name="txtPhone" placeholder="Enter Phone ..."/>
            <input type="submit" value="Create" name="action"/>
        </form>
    </body>
</html>
