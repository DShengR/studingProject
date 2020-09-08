<%--
  Created by IntelliJ IDEA.
  User: dShengR
  Date: 2020/9/5
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("ctp", request.getContextPath());%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  Hello I am SpringMvcTest3
  <form action="${ctp}/httpEntity" method="post" >
    姓名：<input name="name" type="text"/>${err.name}<br/>
    年龄：<input name="age" type="text"/>${err.age}<br/>
    性别：<input name="gender" type="text"/>${err.gender}<br/>
    <input type="submit" value="提交"/>
  </form>
  <hr>
  <form action="testUpload" method="post" enctype="multipart/form-data">
    文件: <input type="file" name="file"/><br><br>
    描述: <input type="text" name="desc"/><br><br>
    <input type="submit" value="提交"/>
  </form>
  </body>
</html>
