<%--
  Created by IntelliJ IDEA.
  User: othma
  Date: 14/10/2023
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
  <legend>Mot de passe oblié </legend>
  <form action="forgotPassword" method="post">
    <h3>Entrez votre E-mail pour envoyer un code sur votre e-mail</h3>
    <table>
      <tr>
        <td>E-mail</td>
        <td><input type="email" name="email"></td>
        <td><input type="submit" value="Envoyer"></td>

      <% if( request.getAttribute("message")!=null){%>
        <tr><td><h4><%= request.getAttribute("message")%></h4></td></tr>
      <%}%>



      </tr>
    </table>
  </form>
</fieldset>

</body>
</html>
