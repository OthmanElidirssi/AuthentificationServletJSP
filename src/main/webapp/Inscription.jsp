<%--
  Created by IntelliJ IDEA.
  User: othma
  Date: 14/10/2023
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="Register" method="POST">
    <fieldset>
        <legend>
            Inscription
        </legend>
        <table>
            <tr>
                <td>Nom</td>
                <td><input type="text" name="nom" value=""/></td>
            </tr>
            <tr>
                <td>Prenom</td>
                <td><input type="text" name="prenom" value=""/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value=""/></td>
            </tr>
            <tr>
                <td>Mot de passe</td>
                <td><input type="password" name="password" value=""/></td>
            </tr>
            <tr>
                <td>Date de naissance</td>
                <td><input type="date" name="date" value=""/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Valider"/>
                    <input type="reset" value="Annuler"/></td>
            </tr>

        </table>

    </fieldset>


</form>
</body>
</html>
