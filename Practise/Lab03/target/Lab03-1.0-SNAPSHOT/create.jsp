<%-- 
    Document   : create
    Created on : Mar 3, 2021, 11:09:47 AM
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
        <h1>Create Countries</h1>
        <form action="CreateServlet">
            <div>
                <div>
                    <input type="text" name="txtName" placeholder="Enter country name ..."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtPop" placeholder="Enter population ..."/>
                </div> <br/>
                <div>
                    <input type="submit" value="Create"/>
                </div>
            </div>
        </form>
    </body>
</html>
