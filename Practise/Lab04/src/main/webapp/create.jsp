<%-- 
    Document   : create
    Created on : Mar 5, 2021, 10:06:35 AM
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
        <h1>Create Country</h1>
        <form action="CountriesServlet" method="POST">
            <div>
                <div>
                    <input type="text" name="txtName" placeholder="Enter Country Name..."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtPop" placeholder="Enter Country Population..."/>
                </div><br/><br/>
                <div>
                    <input type="submit" name="action" value="Create"/>
                </div>
            </div>
        </form>
    </body>
</html>
