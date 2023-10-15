<%--
  Created by IntelliJ IDEA.
  User: othma
  Date: 14/10/2023
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<legend>Verification</legend>

<fieldset>
    <legend>Verification  </legend>
    <form action="Verify">
        <table>

            <tr>
                <td>Code de validation:</td>
                <td><input type="number" name="code"></td>
            </tr>
            <tr>
                <td><input type="submit" value="valider"></td>
            </tr>
            <tr><td><h4><%= request.getAttribute("message")%></h4></td></tr>
        </table>
    </form>
</fieldset>
</body>
</html>
