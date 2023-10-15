<%--
  Created by IntelliJ IDEA.
  User: othma
  Date: 14/10/2023
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>Authentification</legend>
    <form action="Authentication" method="POST">
        <table>
            <tr>
                <td>Login :</td>

                <td><input type="email" name="email"></td>

                <td>Mot de passe :</td>
                <td> <input type="password" name="password"></td>
                <td><input type="submit" value="Connexion"></td>
            </tr>
            <tr>
                <td><a href="Mpob.jsp">Mot de passe oblier</a></td>
                <td><a href="Inscription.jsp">Creé un nouveau compt</a></td>
            </tr>
        </table>
    </form>
</fieldset>

</body>
</html>
