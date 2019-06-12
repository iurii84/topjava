<%--
  Created by IntelliJ IDEA.
  User: iurii
  Date: 11-Jun-2019
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<style type="text/css">
    .field {
        clear: both;
        text-align: right;
        line-height: 25px;
    }

    label {
        float: left;
        padding-right: 10px;
    }

    .main {
        float: left
    }
</style>

<html>
<head>
    <title>Add your new meal...</title>
</head>
<body>
<div class="main">
    <form method="POST">
        <div class="field">
            <label for="desc">Имя</label>
            <input type="text" name="description" id="desc">
        </div>
        <div class="field">
            <label for="da">Date</label>
            <input type="date" name="date" id="da">
        </div>
        <div class="field">
            <label for="ti">Time</label>
            <input type="time" name="time" id="ti">
        </div>
        <div class="field">
            <label for="ca">Calories</label>
            <input type="number" name="calories" id="ca">
        </div>

        <div class="field">
            <label for="sub"></label>
            <input type="submit" value="Submit" id="sub">
        </div>
    </form>
</div>


</body>
</html>
