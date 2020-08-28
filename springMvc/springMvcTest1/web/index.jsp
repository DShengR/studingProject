<%--
  Created by IntelliJ IDEA.
  User: dShengR
  Date: 2020/8/26
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <%
    pageContext.setAttribute("ctp",request.getContextPath());
  %>
  <body>
    <form action="${ctp}/helloRest" method="post" >
      <input name="id" type="text"/>
      <input type="submit" value="新增"/>
    </form>
    <form action="${ctp}/helloRest" method="post" >
      <input name="id" type="text"/>
      <input type="hidden" name="_method" value="delete"/>
      <input type="submit" value="删除"/>
    </form>
    <form action="${ctp}/helloRest" method="post" >
      <input name="id" type="text"/>
      <input type="hidden" name="_method" value="put"/>
      <input type="submit" value="更新"/>
    </form>
    <form action="${ctp}/helloRest" method="get" >
      <input name="id" type="text"/>
      <input type="submit" value="查询"/>
    </form>
  </body>
</html>
