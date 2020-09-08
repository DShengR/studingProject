<%--
  Created by IntelliJ IDEA.
  User: dShengR
  Date: 2020/9/1
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
  pageContext.setAttribute("ctp", request.getContextPath());
%>
<body>
<form action="${ctp}/converter">
<%--source:name-age-gender--%>
    <input type="text" name="user"/>
    <input type="submit" value="login"/>
</form>
</body>
</html>
