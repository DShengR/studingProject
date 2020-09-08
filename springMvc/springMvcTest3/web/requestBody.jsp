<%--
  Created by IntelliJ IDEA.
  User: dShengR
  Date: 2020/9/5
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("ctp", request.getContextPath());%>
<script src="scripts/jquery-1.9.1.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctp}/requestBody" method="post">
    用户名：<input type="text" name="name"/></br>
    年龄：<input type="text" name="age"/></br>
    性别：<input type="text" name="gender"/></br>
    <input type="submit" value="提交"/>
</form>

<a href="${ctp}/requestBody.jsp">发送ajax数据</a>
<script type="application/javascript">
    $("a:first").click(function () {
        console.log("a clicked");
        var user={name:"dsr",age:"25",gender:"男",email:"ddd@163.com"};
        var userJson=JSON.stringify(user);
        $.ajax({
           url:"${ctp}/requestBody",
            type:"POST",
            contentType:"application/json",
           data:userJson,
            success:function(data){
               console.log(data);
            }
        });
        return false;
    })
</script>

</body>
</html>
