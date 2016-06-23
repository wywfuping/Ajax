
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <div class="container">
        <div class="page-header">
            RSS演示
        </div>
        <input type="text" id="url" class="col-lg-4">
        <button id="loadBtn">下载</button>
        <ul class="list-unstyled" id="list">

        </ul>
    </div>
</head>
<body>
<script>
    (function(){
        function creatXmlHttp(){
            var xmlHttp = null;
            if(window.ActiveXObject){
                xmlHttp=new ActiveXObject("Microsoft.XMLHTT");
            }else {
                xmlHttp=new XMLHttpRequest();
            }
            return xmlHttp;
        }

        function creatLi(link,title){
            var li=document.createElement("li");
            var a=document.createElement("a");
            var text=document.createTextNode(title);

            a.setAttribute("href",link);
            a.setAttribute("target","_blank");
            a.appendChild(text);
            li.appendChild(a);

            document.querySelector("#list").appendChild(li);
        }

        document.querySelector("#loadBtn").onclick = function () {
           document.querySelector("#list").innerHTML="";
            var url = document.querySelector("#url").value;
            var xmlHttp = creatXmlHttp();
            xmlHttp.open("get", "/load?url=" + url,true);
            xmlHttp.onreadystatechange = function () {
                var readystate = xmlHttp.readyState;
                if (readystate == 4) {
                    var httpState = xmlHttp.status;
                    if (httpState == 200) {
                        var result = xmlHttp.responseXML;
                        var itemArray=result.getElementsByTagName("item");
                       for(var i=0;i<itemArray.length;i++){
                           var item= itemArray[i];
                           var title = item.getElementsByTagName("title")[0].childNodes[0].nodeValue;
                           var link = item.getElementsByTagName("link")[0].childNodes[0].nodeValue;
                           creatLi(link,title);
                       }
                    } else {
                        alert("服务器请求异常:" + httpState);
                    }
                }
            };
            xmlHttp.send();
        }
    })();

</script>
</body>
</html>
