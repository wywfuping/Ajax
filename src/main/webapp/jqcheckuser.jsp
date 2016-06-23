
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" id="username">
<span id="helpSpan"></span>

<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    $(function(){
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
