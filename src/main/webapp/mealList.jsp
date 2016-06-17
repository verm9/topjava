<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>
<table>
    <tr>
        <td>datetime</td><td>description</td><td>calories</td>
    </tr>
<c:forEach var="meal" items="${meals}">
    <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.UserMealWithExceed"/>
    <tr style="background-color: ${meal.exceed ? 'lightpink' : 'aquamarine'}">
        <td>
            <%= TimeUtil.formatLocalDateTime(meal.getDateTime(), "yyyy.MM.dd HH:mm")%>
        </td><td>${meal.description}</td><td>${meal.calories}</td>
    </tr>

</c:forEach>
</table>
</body>
</html>
