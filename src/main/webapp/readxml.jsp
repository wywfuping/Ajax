
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>Ajax读取XML文件</h3>
    </div>
    <button id="readBtn">读取</button>
    <div id="bookBox">


    </div>

</div>
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
    function creatBookDiv(id,bookname,author,price,publishing){
        var div = document.createElement("div");
        var h3 = document.createElement("h3");
        var small = document.createElement("small");
        var p = document.createElement("p");

        var idText=document.createTextNode(id);
        var bookNameText=document.createTextNode(bookname);
        var authorText=document.createTextNode(author);
        var priceText=document.createTextNode(price);
        var publishingText=document.createTextNode(publishing);

        p.appendChild(authorText);
        p.appendChild(priceText);
        p.appendChild(publishingText);
        small.appendChild(idText);
        h3.appendChild(bookNameText);
        h3.appendChild(small);

        div.appendChild(h3);
        div.appendChild(p);
        document.getElementById("bookBox").appendChild(div);
    }

    document.getElementById("readBtn").onclick=function(){
        var xmlHttp=creatXmlHttp();
        xmlHttp.open("get","/book.xml",true);
        xmlHttp.onreadystatechange=function (){
            var xmlState=xmlHttp.readyState;
            if(xmlState==4){
                var httpState=xmlHttp.status;
                if (httpState==200){
                    document.getElementById("bookBox").innerHTML="";
                    var book = xmlHttp.responseXML;
                    var bookArray = book.getElementsByTagName("book");
                    for(var i=0;i<bookArray.length;i++){
                        var book= bookArray[i];
                        var id = book.getAttribute("id");
                        var bookname=book.getElementsByTagName("bookname")[0].childNodes[0].nodeValue;
                        var author=book.getElementsByTagName("author")[0].childNodes[0].nodeValue;
                        var price=book.getElementsByTagName("price")[0].childNodes[0].nodeValue;
                        var publishing=book.getElementsByTagName("publishing")[0].childNodes[0].nodeValue;
                        //console.log(id+":"+bookname+":"+author+":"+price+":"+publishing);
                        creatBookDiv(id,bookname,"作者："+author+";","出版社："+publishing+";","价格："+price+"元");
                    }
                }else{
                    alert("请求服务器异常"+httpState);
                }
            }
        };
        xmlHttp.send();
    }

    })();

</script>
</body>
</html>
