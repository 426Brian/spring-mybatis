<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 2018/4/6
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%String ctx = application.getContextPath();
    pageContext.setAttribute("ctx", ctx);%>


<body>
<form  method="post" name="myform">
    id: <input name="id" value="26"/><br>
    name: <input name="name" value="William"/><br>

    city: <input name="address.city" value="linfen"/><br>
    street: <input name="address.street" value="prosperity"/><br>
    <input type="submit" value="submit"/>
    <br>
    测试cookie<br>

    <a href="${pageContext.getAttribute("ctx")}/hello/testCookie">cookie</a>
</form>

<br>
ModelAndView 中的值
<br>
${requestScope.get("name")}
<br>
<a href="${pageContext.getAttribute("ctx")}/hello/testMap"></a>
testMap 中的值
<br>
${requestScope.get("testMap")}
<br>
testModel 中的值
<br>
${requestScope.get("modelTest")}
<br>
testModelMap 中的值
<br>
${requestScope.get("modelmap")}
<br>
<a href="${pageContext.getAttribute("ctx")}/hello/result">result</a>
<br>
${user.name}
<script>
    var root = '${pageContext.getAttribute("ctx")}';
    function toResult(){
        myform.action= root+"/hello/poToResult";
        myform.submit();
    }
    // toResult();
</script>
</body>

</html>
