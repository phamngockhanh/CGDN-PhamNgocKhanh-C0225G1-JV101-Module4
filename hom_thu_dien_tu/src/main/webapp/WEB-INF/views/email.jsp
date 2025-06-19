<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend><h1>Settings</h1></legend>
    <form:form action="/email" method="post" modelAttribute="email">
        <label>Languages</label>
        <form:select path="language">
            <form:option value="English">English</form:option>
            <form:option value="Vietnamese">Vietnamese</form:option>
            <form:option value="Japanese">Japanese</form:option>
            <form:option value="Chinese">Chinese</form:option>
        </form:select>
        <br>
        <label>Page Size:</label>
        <span>Show
        <form:select path="pageSize">
            <form:option value="5" label="5"/>
            <form:option value="10" label="10"/>
            <form:option value="15" label="15"/>
            <form:option value="25" label="25"/>
            <form:option value="50" label="50"/>
            <form:option value="100" label="100"/>
        </form:select> emails per page
    </span>
        <br>
        <label>Spams filter:</label>
        <form:checkbox path="spamFilter"/> <span>Enables spams filter</span>
        <br>
        <label for="signature">Signature:</label>
        <form:textarea path="signature" rows="5" cols="30" />
        <br>
        <div style="margin-left: 100px">
            <button style="background-color: aqua">Update</button>
            <a href="/list-email"><button type="button">Cancel</button></a>
        </div>
        <form:hidden path="id"/>
    </form:form>
</fieldset>
</body>
</html>
