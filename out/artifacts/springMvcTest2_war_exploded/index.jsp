<%--
  Created by IntelliJ IDEA.
  User: dShengR
  Date: 2020/8/28
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title11$</title>
  </head>
  <%
    pageContext.setAttribute("ctp", request.getContextPath());
  %>
  <body>
  Hello I am SpringMvcTest2
  <form action="${ctp}/dataValidate" method="post" >
    姓名：<input name="name" type="text"/>${err.name}<br/>
    年龄：<input name="age" type="text"/>${err.age}<br/>
    性别：<input name="gender" type="text"/>${err.gender}<br/>
    <input type="submit" value="提交"/>
  </form>
  </body>
</html>
