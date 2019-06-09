<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: iurii
  Date: 09-Jun-2019
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meals page</title>
</head>
<body>

<table>
    <h1>List of meals</h1>
    <tr>
        <th>Description</th>
        <th>Date and Time</th>
        <th>Calories</th>
        <th>Is exceeded?</th>
    </tr>
    <c:forEach items="${mealList}" var="meal">
        <tr>
            <td>
                <b>
                    <c:out value="${meal.getDescription()}"/>
                </b>
            </td>
            <td>
                <c:out value="${meal.getDateTime()}"/>
            </td>
            <td>
                <c:out value="${meal.getCalories()}"/>
            </td>
            <td>
                <c:out value="${meal.isExcess()}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
