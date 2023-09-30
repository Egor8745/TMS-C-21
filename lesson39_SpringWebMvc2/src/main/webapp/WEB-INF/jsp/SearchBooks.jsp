<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 20.09.2023
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Hello, enter the book title to search
<form action="/books" method="post">
    Name: <input type="text" name="name"><br>
    <input type="submit" value="search">
</form>

</body>
</html>
