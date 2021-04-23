<%-- 
    Document   : index
    Created on : Mar 10, 2021, 9:44:05 AM
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
        <br/>
        <%
            String uid = request.getSession().getAttribute("uid").toString();
        %>
        <h2 style="color: red">Welcome to <%=uid%></h2>
        <hr/>
        <h1>List of Users</h1>
        <form action="UserServlet" method="GET">
            <div>
                <input  type="text" name="uname" placeholder="Search by user name..."/>
                <input type="submit" name="action" value="Search"/>
            </div>
            <table border="1">
                <tr>
                    <th>User Id</th>
                    <th>User Name</th>
                    <th>User Address</th>
                </tr>
               <c:forEach  items="${list}" var="lst"> 
                    <!-- setAttribute ten list nen items lay list-->
                    <tr>
                        <td><c:out  value="${lst.getUserid()}"></c:out></td>
                        <td><c:out  value="${lst.getFullname()}"></c:out></td>
                        <td><c:out  value="${lst.getAddress()}"></c:out></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
