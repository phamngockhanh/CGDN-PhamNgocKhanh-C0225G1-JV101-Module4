<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>Calculator</legend>
    <form action="/calculator" method="post">
        <input type="number" name="num1">
        <input type="number" name="num2">
        <br>
        <input type="submit" value="Addition(+)" name="cal">
        <input type="submit" value="Subtraction(-)" name="cal">
        <input type="submit" value="Multiplication(X)" name="cal">
        <input type="submit" value="Division(/)" name="cal">
    </form>
</fieldset>
<c:if test="${result!=null||mess!=null}">
    <h1 style="color: red">${result}</h1>
    <h1 style="color: red">${mess}</h1>
</c:if>
</body>
</html>
