
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="getBtn">发送get请求</button>
<button id="postBtn">发送post请求</button>
<script src="/static/js/ajax.js"></script>
<script>
    (function(){
        function sayHello(arg1,arg2) {
            alert(arguments.length);
        }
        document.querySelector("#getBtn").onclick = function(){
            Ajax.getText("/ajax",function(result){
                alert("Hi," + result);
            });
        };
        document.querySelector("#postBtn").onclick = function(){
            Ajax.postText("/ajax",{name:"java",address:"USA"},function(result){
                alert("Post:" + result);
            })
        };

    })();
</script>
</body>
</html>
