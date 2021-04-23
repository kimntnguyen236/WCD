<%-- 
    Document   : index
    Created on : Mar 8, 2021, 10:03:49 AM
    Author     : ThienKim
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include file="header.html" %>
    <body>
    <center>
        <a href="create.jsp" >Create New</a>
        <h3>Courses List</h3>
        <form action="ThienKimServlet">
            <table border="1">
                <tr>
                    <th>Course ID</th>
                    <th>Course Name</th>
                    <th>Course Duration</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td> <c:out value="${item.getCourseid()}"/></td>
                        <td><c:out value="${item.getCoursename()}"/></td>
                        <td><c:out value="${item.getDuration()}"/></td>
                        <td>
                            <a href="CourseServlet?action=delete&id=${item.getId()}">Delete</a>
                            <a href="CourseServlet?action=details&id=${item.getName()}">Details</a>
                            <a href="CourseServlet?action=update&id=${item.getSalary()}">Update</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </center>
</body>
<%@include file="footer.html" %>
</html>
