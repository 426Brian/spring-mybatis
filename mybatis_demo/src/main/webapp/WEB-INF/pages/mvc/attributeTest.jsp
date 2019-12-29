<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 2018/4/5
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
attribute test<br>

<form name="myform" action="../hello/attributeTest2" method="post">
    <input type="text" name="hidden" value="test"/>
    <br>

    id:<input name="id" value="55"/>
    name:<input type="text" name="name" value="Tom">
    address:<input type="text" name="address.city" value="Seattle2">

    <input type="submit" value="submit"/>
</form>
    <br>
    <form name="form2 ">
    <input type="hidden" name="_method" value="DELETE"/>
    </form>

<script>
    var hideT = document.getElementsByName("hidden")[0].value;
    console.log(hideT);
</script>
</body>
</html>
