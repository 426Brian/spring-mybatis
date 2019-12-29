<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 2018/1/1
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homeJsp</title>
    <%-- 网络链接引入jquery 资源 --%>
    <script src="http://code.jquery.com/jquery-latest.js"></script>


    <script type="text/javascript">
        $(function () {
            $("#toAjax").click(function () {
                $.ajax({
                    url: 'http://localhost:8088/mybatisWeb/hello/ajax',
                    type: 'post',
                    contentType: 'application/json; charset=UTF-8',
                    data: '[{"name":"tom", "age":12}, {"name":"Thon", "age":26}]',
                    success: function () {

                    }
                });
                return false;
            });
        });
    </script>
</head>
<body>
spring mvc successful from test<br>
<a href="../home.jsp" id="toAjax">toAJax</a>
</body>
</html>
