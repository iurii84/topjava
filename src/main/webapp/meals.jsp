<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: iurii
  Date: 09-Jun-2019
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Meals page</title>
</head>
<body>


<table border="1">
    <h1>List of meals</h1>
    <tr>
        <th>Description</th>
        <th>Date</th>
        <th>Time</th>
        <th>Calories</th>
        <th>Is exceeded?</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${mealList}" var="meal">
        <tr>
            <td>
                <c:out value="${meal.description}"/>
            </td>
            <td>
                <c:out value="${meal.dateTime.toLocalDate()}"/>
            </td>
            <td>
                <c:out value="${meal.dateTime.toLocalTime()}"/>
            </td>
            <td>
                <c:out value="${meal.calories}"/>
            </td>
            <td bgcolor="${meal.exceed ? "red" : "green"}">
                <c:out value="${meal.exceed}"/>
            </td>
            <td>
                <form action="<c:url value="/update"/>" method="post">
                    <input type="hidden" name="id" value="${meal.id}">
                    <input type="submit" value="update">
                </form>
            </td>
            <td>
                <form action="<c:url value="/delete"/>" method="post">
                    <input type="hidden" name="id" value="${meal.id}">
                    <input type="submit" value="delete">
                </form>
            </td>
        </tr>

    </c:forEach>
</table>
<br>

<form method="get" action="newMeal">
    <button type="submit">Add new meal...</button>
</form>

</body>
</html>
