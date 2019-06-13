<%--
  Created by IntelliJ IDEA.
  User: iurii
  Date: 12-Jun-2019
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update meal...</title>
</head>
<body>

<form action="update" method="post">
    <input type="hidden" name="id" value="${actualMeal.id}">
    <input type="text" name="description" value="${actualMeal.description}" placeholder=${actualMeal.description}>
    <br>
    <input type="date" name="date" value="${actualMeal.date}" placeholder=${actualMeal.date}>
    <br>
    <input type="time" name="time" value="${actualMeal.time}" placeholder=${actualMeal.time}>
    <br>
    <input type="number" name="calories" value="${actualMeal.calories}" placeholder=${actualMeal.calories}>
    <br>
    <input type="submit" value="Update">
</form>
</body>
</html>
