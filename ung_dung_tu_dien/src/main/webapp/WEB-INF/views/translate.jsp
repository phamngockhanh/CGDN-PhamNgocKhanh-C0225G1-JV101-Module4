<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <label>Vietnamese:</label>
    <input type="text" name="vietnamese" value="${vietnamese}">
    <label>English:</label>
    <input type="text" name="english" value="${english}" readonly>
    <button>Translate</button>
</form>
<h5 name="wrong" style="color: red">${wrong}</h5>
</body>
</html>
