<%-- 
    Document   : show
    Created on : Mar 15, 2021, 11:13:25 AM
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
    <body>
        <h1>Employees List</h1>
        <form action="EmployeeServlet" method="GET">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Salary</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td><c:out value="${item.getId()}"/></td>
                        <td><c:out value="${item.getName()}"/></td>
                        <td><c:out value="${item.getSalary()}"/></td>
                        <td>
                            <a href="EmployeeServlet?action=SetPass&id=${item.getId()}">Reset Password</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
