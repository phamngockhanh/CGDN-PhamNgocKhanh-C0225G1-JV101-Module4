<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>Gia vị</legend>
    <form action="/save" method="post">
        <label>Name:</label>
        <input type="text" name="name" value="${name}">
        <input type="checkbox" value="lettuce" name="condiment"> <span>Súp lơ</span>
        <input type="checkbox" value="tomato" name="condiment"> <span>Cà chua</span>
        <input type="checkbox" value="mustard" name="condiment"> <span>Mù tạt</span>
        <input type="checkbox" value="sprouts" name="condiment"> <span>Dưa muối</span>
        <button>Save</button>
    </form>
</fieldset>
<table>
    <tr>
        <th>STT</th>
        <th>Tên bánh kẹp</th>
        <th>Đồ kèm theo</th>
    </tr>
    <c:forEach items="${sandwichList}" var="sandwich" varStatus="idx">
        <tr>
            <td>${idx.count}</td>
            <td>${sandwich.name}</td>
            <td>${sandwich.condiment}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
