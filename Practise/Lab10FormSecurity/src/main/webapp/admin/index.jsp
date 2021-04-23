<%-- 
    Document   : index
    Created on : Mar 19, 2021, 12:01:56 PM
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
        <h1>List of Contacts</h1>
        <a href="insert.jsp">Create New</a>
        <form action="ContactServlet" method="GET">
            <table border="1">
                <tr>
                    <th>Last Name</th>
                    <th>Phone</th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td><c:out value="${item.getLastname()}" /></td>
                        <td><c:out value="${item.getPhone()}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
