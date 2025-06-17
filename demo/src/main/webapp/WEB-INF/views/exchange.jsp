<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/exchange">
    <label>USD</label>
    <input type="number" name="usd" value="${usd}">
    <label>VND</label>
    <input type="number" name="vnd" value="${vnd}" readonly>
    <button>Chuyển</button>
</form>
</body>
</html>
