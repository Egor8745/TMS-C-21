<%--
  Created by IntelliJ IDEA.
  User: Егор
  Date: 06.08.2023
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>For search a book, enter the title and author</h1>

<form method="post" action="/">
    Name: <input type="text" name="title"
                 value=<%=request.getParameter("title")==null?"": request.getParameter("title")%>> <br>
    Author: <input type="text" name="author"
                   value=<%=request.getParameter("author") ==null?"":request.getParameter("author")%>> <br>
    <input type="submit" value="Submit an application">
</form>
</body>
</html>
