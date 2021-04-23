<%-- 
    Document   : details
    Created on : Mar 8, 2021, 11:35:11 AM
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
        <h1>Course Details</h1>
        <form action="CourseServlet" method="POST">
            <div>
                <div>
                    <label>Course ID: </label>
                    <input type="text" name="txtID" value="${c.getCourseid()}" readonly="true"/>
                </div> <br/><!-- comment -->
                <div>
                    <label>Course Name: </label>
                    <input type="text" name="txtNAME" value="${c.getCoursename()}" placeholder="Enter the course name..."/>
                </div> <br/>
                <div>
                    <label>Course Duration: </label>
                    <input type="text" name="txtDURATION" value="${c.getDuration()}" placeholder="Enter duration..."/>
                </div> <br/>
                <div>
                    <label>Course Fee:  </label>
                    <input type="text" name="txtFEE" value="${c.getFee()}" placeholder="Enter fee..."/>
                </div> <br/>
                <div>
                    <input type="submit" name="action" value="UpdateCourse"/>
                </div> <br/>
            </div>
        </form>
        <a href="CourseServlet">Back</a>
    </body>
</html>
