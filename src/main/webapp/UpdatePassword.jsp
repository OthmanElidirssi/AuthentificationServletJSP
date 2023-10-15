<%--
  Created by IntelliJ IDEA.
  User: othma
  Date: 14/10/2023
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>nouveau mot de passe</legend>
    <form action="updatePassword" method="post">
        <table>
            <tr>
                <td>passworde:</td>
                <td><input type="password" name="password"></td>
                <td>confirmer password :</td>
                <td><input type="password" name="passwordcnf"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Modifier"></td>
            </tr>
            <% if (request.getAttribute("message")!=null){%>
            <tr>
                <td><h4><%= request.getAttribute("message")%>
                </h4></td>
            </tr>
            <%}%>
        </table>
    </form>
</fieldset>

</body>
</html>
