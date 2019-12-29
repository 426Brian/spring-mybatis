<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 2018/4/7
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
result jsp<br>
city: ${requestScope.modelmap}<br>

<form name="myform"></form>

<%String ctx = application.getContextPath();
    pageContext.setAttribute("ctx", ctx);%>
<script>
    var root = '${pageContext.getAttribute("ctx")}';
    function toPo(){
        myform.action= root+"/hello/resultToPo";
        myform.submit();
    }
    // toPo();
</script>
</body>
</html>
