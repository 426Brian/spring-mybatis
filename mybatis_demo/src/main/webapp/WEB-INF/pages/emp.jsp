<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 2018/4/5
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表</title>

</head>
<body>
<form>
${name}
    <table>
        <c:forEach items="${emps}" var="emp">
            <tr>
                <td>
                        ${emp.empno}
                </td>
                <td>
                        ${emp.ename}
                </td>
                <td>
                        ${emp.sal}
                </td>
                <td>
                        ${emp.gender}
                </td>
                <td>
                        ${emp.deptno}
                </td>

            </tr>
        </c:forEach>

    </table>
    <input id = "emp" value="${emp.ename}"/>
</form>

<script>
    var empname = document.getElementById("emp").value;

    // alert(empname);
    function getLocation(){
        if(navigator.geolocation){
            navigator.geolocation.getCurrentPosition(showPosition)
        }
    }

    function showPosition(position){
        var latlon = position.coords.latitude+position.coords.longitude;
       var img_url = "http://maps.googleapis.com/maps/api/staticmap?center="
           +latlon+"&zoom=14&size=400x300&sensor=false";
    }
    getLocation();

</script>
</body>
</html>
