<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <%
        if (request.getAttribute("LoginMessage") != null) {
            if ("LoginFailed".equals(request.getAttribute("LoginMessage"))) {
                out.println("<h1>Incorrect login or password</h1>");
            } else if ("LoginSuccess".equals(request.getAttribute("LoginMessage"))) {
                out.println("<h1>You are successfully logged in!</h1>");
            }
        } else {
            Object isLoggedIn = request.getSession().getAttribute("loggined");
            if (isLoggedIn != null && isLoggedIn instanceof Boolean && (Boolean) isLoggedIn) {
    %>
                <h1>You're already logged in</h1>
    <%
            } else {
    %>
                <form action="http://localhost:8080/login" method="post">
                    <p> Login: <input rows="20" cols="40" name="login"></textarea></p>
                    <p> Password: <input rows="20" cols="40" name="password"></textarea></p>
                    <p><input type="submit" value="Login"></p>
                </form>
    <%
            }
        }
    %>
    <button onclick="location.href='/'">Main page</button>
</body>
</html>
