
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">发送Ajax请求</button>
    <script>
        (function(){
            function creatXmlHttp(){
                var xmlHttp=null;
                if(window.ActiveXObject){
                    xmlHttp=new ActiveXObject("MicroSoft.xmlHttp");
                }else{
                    xmlHttp=new XMLHttpRequest();
                }
               return xmlHttp;
            }
            document.querySelector("#btn").onclick=function(){
                var xmlHttp = creatXmlHttp();
                xmlHttp.open("get","/ajax");
                xmlHttp.send();
            }

        })();
    </script>
</body>
</html>
