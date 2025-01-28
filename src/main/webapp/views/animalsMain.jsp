<%@ page import="java.util.List" %>
<%@ page import="com.ggjiuw.animals.Animal"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Animals</title>
</head>
<body>
    <%
        Object animalsObject = request.getAttribute("animals");
        int index = 0;
        if (animalsObject instanceof List) {
            List<Animal> animals = (List<Animal>) animalsObject;
            for (Animal a : animals) {
                out.println("<div> <h2>" + a.getName() + "</h2>");
                out.println("<h4>" + a.getType() + "</h4>");
                out.println("<form action=\"http://localhost:8080/animals?remove=" + index + "\" method=\"post\">");
                out.println("    <p><input type=\"submit\" value=\"❌Delete\"></p>");
                out.println("</form> </div>");
                index++;
            }
        }
    %>


    <form action="http://localhost:8080/animals" method="post">
        <p> Name: <input rows="20" cols="40" name="name"></textarea></p>
        <p> type: <input rows="20" cols="40" name="type"></textarea></p>
        <p><input type="submit" value="Add"></p>
    </form>

</body>
</html>