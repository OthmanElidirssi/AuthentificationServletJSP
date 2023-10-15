<%@ page import="com.example.entities.Client" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Client c = (Client) session.getAttribute("client");

    if (c == null) {
        response.sendRedirect("Auth.jsp");
    } else {
%>
<h1>Welcome: <%= c.getNom() %></h1>
<%
    }
%>
<form action="Logout" method="post">
    <input type="submit" value="Log out">
</form>
</body>
</html>

