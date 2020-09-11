<%--
  Created by IntelliJ IDEA.
  User: dShengR
  Date: 2020/9/5
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%pageContext.setAttribute("ctp", request.getContextPath());%>
<script src="scripts/jquery-1.9.1.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${ctp}/json">发送ajax请求</a>
<div>
</div>
<script type="text/javascript">
    $("a:first").click(function () {
        $.ajax({
            url:"${ctp}/json",
            type:"GET",
            success:function(data){
                console.log(data);
                $.each(data,function(){
                    $("div:first").append(this.name+"--"+this.age+"--"+this.gender+"--"+this.email+"--"+this.birth+'<br>')
                })
            }
        });
        return false;
    })
</script>
</body>
</html>
