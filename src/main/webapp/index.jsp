<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <% Object s = request.getSession().getAttribute("login"); %>
    <%
        if (s != null)
            out.println("<h1>Hello, " + s + "</h1>");
        else
            out.println("<button onclick=\"location.href='/login'\">Login page</button>");
    %>

    <h1>Welcome to My Web App!</h1>
    <p>This is the index page.</p>

</body>
</html>