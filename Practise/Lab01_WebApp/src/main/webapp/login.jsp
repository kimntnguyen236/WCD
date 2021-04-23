<%-- 
    Document   : login
    Created on : Jan 22, 2021, 10:12:08 AM
    Author     : ThienKim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="HomeServlet" method="POST">
            <div>
                <input type="text" name="txtName" placeholder="Enter your name..."/>
                <input type="password" name="txtPass" placeholder="Enter your password..."/>
                <input type="submit" value="Sign in"/>
            </div>
        </form>
    </body>
</html>
