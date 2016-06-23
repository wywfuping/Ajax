
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <button id="jsonBtn">get Json</button>
    <button id="ajaxBtn">get ajax</button>
    <img src="/static/img/ajax-loader.gif" id="load" style="display: none">

</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    $(function(){
        $("#ajaxBtn").click(function(){
            var $this = $(this);
            $.ajax({
                url:"/user.json",
                type:"get",
                data:{"username":"tom"},
                timeout:8000,
                success:function(data){
                    console.log("success....");
                    alert("come on");
                },
                error:function(){
                    console.log("error....");
                },
                complete:function(){
                    console.log("complete...");
                    $this.text("get ajax").removeAttr("disabled");
                    $("#load").hide();
                },
                beforeSend:function(){
                    console.log("beforeSend....");
                    $this.text("loading").attr("disabled","disabled");
                    $("#load").show();
                }
            });
        });

        });

    $(function(){
        $("#jsonBtn").click(function(){
            $.getJSON("/user.json", function (data) {
                console.log(data);
            }).done(function(data){
                console.log(data);
            }).fail(function(){
                console.log("fail……");
            }).always(function(){
                console.log("always");
            })
        });
    });

</script>

</body>
</html>
