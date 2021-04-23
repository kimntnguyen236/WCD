<%-- 
    Document   : create
    Created on : Mar 8, 2021, 10:53:39 AM
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
        <h1>Create New Course</h1>
        <form action="ThienKimServlet" method="POST">
            <div>
                <div>
                    <input type="text" name="txtID" placeholder="Enter id ...."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtName" placeholder="Enter name ...."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtDuration" placeholder="Enter duration ...."/>
                </div> <br/>
                <div>
                    <input type="text" name="txtFee" placeholder="Enter fee ...."/>
                </div> <br/>
                <div>
                    <input type="submit" name="action" value="Create"/>
                </div> <br/>
            </div>
        </form>
    </body>
</html>
