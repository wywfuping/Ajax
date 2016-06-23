
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" id="username">
<span id="helpSpan"></span>
<hr>
<button id="postBtn">Post To Ajax</button>
<hr>
<button id="jsonBtn">get To JSON</button>
<ul id="jsonList"></ul>
<hr>
<button id="xmlBtn">get xml</button>
<div id="bookbox">

</div>


<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    $(function(){
        $("#xmlBtn").click(function(){
            var $bookbox=$("#bookbox");
            $bookbox.html("");
            $.get("/book.xml",function(data){
                $(data).find("book").each(function(){
                    var id=$(this).attr("id");
                    var bookname= $(this).find("bookname").text();
                    var author= $(this).find("author").text();
                    var price= $(this).find("price").text();
                    var publishing= $(this).find("publishing").text();
                    $bookbox.append("<div><h3>"+bookname+"<small>"+id+"</small></h3><p>"+
                            author+"</p><p>"+price+"</p><p>"+publishing+"</p></div>");
                });

            });
        });

        $("#jsonBtn").click(function(){
            var $jsonList=$("#jsonList");
            $jsonList.html("");
            $.get("/user.json",function(data){
                for(var i=0;i<data.length;i++){
                    var user = data[i];
                    $jsonList.append("<li>"+user.username+"</li>");
                }
            });
        });

        $("#postBtn").click(function(){
            $.post("/ajax",{"username":"wang","address":"chaina"},function(result){
                console.log(result);
            });
        });

        $("#username").change(function(){
            var $username= $(this).val();

            $.get("/checkusername",{"username":$username}, function (result) {
                if(result=="yes"){
                    $("#helpSpan").text("√");
                }else {
                    $("#helpSpan").text("账号已被占用");
                }
            });
        });
    });

</script>

</body>
</html>
