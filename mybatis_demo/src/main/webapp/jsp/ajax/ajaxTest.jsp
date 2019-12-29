<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 2018/10/17
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%-- 网络链接引入jquery 资源 --%>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript">
        // 获取XHR 即 XMLHttpRequest 对象的函数
        function getXMLHttpRequest(){
            var xhr = false;
            if(window.XMLHttpRequest){
                xhr = new XMLHttpRequest();
            }else if(window.ActiveXObject){
                xhr = new ActiveXObject();
            }
            return xhr;
        };


        window.onload = function(){
            var toAjax = document.getElementById("toAjax");

            // url 加时间戳保证每次请求的唯一性（处理因缓存导致的未及时更新）
            var url = toAjax.href +"?date = "+ new Date();
            // ajaxOragin(toAjax, url);
            // jqueryAjax(toAjax, url);
        };

        // javaScript 原生ajax
        function ajaxOragin(toAjax, url){
            toAjax.onclick = function (){
                var xhr = getXMLHttpRequest();

                // 利用 XHR 对象打开与服务器的连接
                xhr.open("get", url);
                // 发送客户端连接到服务器
                xhr.send();

                // XHR 对象的状态改变函数其状态又服务器端改变
                xhr.onreadystatechange = function(){
                    if(xhr.readyState == 4){
                        // 服务器已经处理 XHR 请求
                        if(xhr.status == 200){
                            // 服务器正确做出HTTP 响应
                            var content = document.getElementById("content");
                            var receiveData = xhr.responseText;

                            // 解析JSON
                            receiveData = eval("("+receiveData+")");
                            var newData = "name:"+ receiveData.name+"\n"+ "age:"+ receiveData.age;
                            console.log(newData);

                            newData = "name:"+ receiveData.name +"<br>"+  "age:"+ receiveData.age;
                            content.innerHTML = newData;
                        }
                    }
                };
                // 取消href 的跳转功能
                return false;
            };
        };

        // Jquery ajax
        function jqueryAjax(toAjax, url){
            toAjax.onclick = function() {
                $.ajax({
                    cache: false,
                    url: url,
                    type: "get",
                    data: "json",
                    success: function(data){
                        // 解析JSON
                        data = eval("("+data+")");
                        var newData = "name:"+ data.name+ "<br>" +"age:"+ data.age;
                        console.log(newData);
                        $("#content").html(newData);
                    }
                });

                return false;
            };

        };

        $(function(){
            $("#toAjax").click(function(){
                $("#content").load("ajax.txt");
                return false;
            });
        });

    </script>
</head>
<body>

<a href="ajax.txt" id="toAjax">TextToAjax</a>
<div id="content"></div>
</body>

</html>
