
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <input type="text" id="keyword">
    <button id="btn">翻译</button>
    <p id="result"></p>
</head>
<body>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    $(function () {
        $("#btn").click(function () {
            var url="http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=jsonp&callback=?&version=1.1";
            var keyword= $("#keyword").val();
            $.getJSON(url,{"q":keyword}, function (json) {
                var array = json.basic.explains;
                var str="";
                for(var i=0;i<array.length;i++){
                    str+=array[i]+"<br>";
                }
                $("#result").html(str);
            });
        });
    });
    
</script>

</body>
</html>
