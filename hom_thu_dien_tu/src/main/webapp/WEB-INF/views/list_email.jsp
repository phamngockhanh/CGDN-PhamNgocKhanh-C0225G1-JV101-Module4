<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <fieldset>
        <legend>List Email</legend>
        <table border="1px">
            <tr>
                <th>STT</th>
                <th>Ngôn ngữ</th>
                <th>Số trang</th>
                <th>Lọc spam</th>
                <th>Chữ ký</th>
                <th>Chỉnh sửa</th>
            </tr>
        <c:forEach items="${emailList}" var="email" varStatus="idx">
            <tr>
                <td>${idx.count}</td>
                <td>${email.language}</td>
                <td>${email.pageSize}</td>
                <td>${email.spamFilter}</td>
                <td>${email.signature}</td>
                <td><a href="/email/${email.id}">Chỉnh sửa</a></td>
            </tr>
        </c:forEach>
        </table>
    </fieldset>
</body>
</html>
