<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 25.09.2023
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<H1>Result of search</H1>

<table>
    <tr>
        <th>Book</th>
        <th>Author</th>
    </tr>

    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.name}</td>
            <td>${book.author}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
