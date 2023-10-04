<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 20.09.2023
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<hr>
<a href="/?lang=en">en</a>
<a href="/?lang=ru">ru</a>
<hr>
<p>
    <spring:message code="label.name"></spring:message>
    <spring:message code="label.search"></spring:message>
</p>

Hello, enter the book title to search
<form action="/books" method="post">
    Name: <input type="text" name="name"><br>
    <input type="submit" value="search">
</form>

</body>
</html>
