<%-- 
    Document   : index
    Created on : Mar 5, 2021, 10:06:25 AM
    Author     : ThienKim
--%>

<%@page import="fpt.aptech.entities.Country"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Countries List</h1>
        <form method="GET">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Country Name</th>
                    <th>Country Population</th>
                    <th>Action</th>
                </tr>
                <%
                    List<Country> clist = (List<Country>) request.getAttribute("list");
                    for (Country c : clist) {
                %>
                <tr>
                <td><%=c.getId()%></td>
                <td><%=c.getCountryname()%></td>
                <td><%=c.getPopulation()%></td>
                <td><a href="CountriesServlet?action=delete&id=<%=c.getId()%>">Remove</a></td>
                </tr>
                <%
                    }
                %>
            </table>
        </form>
            <h3><a href="create.jsp">Create New</a></h3>
    </body>
</html>
