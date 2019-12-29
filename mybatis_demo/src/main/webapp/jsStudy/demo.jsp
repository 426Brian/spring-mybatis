<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 2018/10/18
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%-- 网络链接引入jquery 资源 --%>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <style>
        #div1 {
            width: 200px;
            height: 200px;
            background: red;
            display: none;
        }
    </style>

</head>
<body>
<input type="button" value="登录" onmouseout="div1.style.display='none'" onmouseover="div1.style.display='block'"/>
<div id="div1">

</div>
</body>
</html>
