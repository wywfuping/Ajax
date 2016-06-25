<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>轮询演示</h3>
    </div>
    <a href="javascript:;" id="loadMsg">
        <div class="alert alert-info" style="display:none"></div>
    </a>
    <div id="message">
        <c:forEach items="${messageList}" var="msg">
            <div class="panel panel-default">
                <div class="panel-heading">
                    作者：${msg.author}
                </div>
                <div class="panel-body">
                    消息：${msg.message}
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script type="yawei" id="msgTemp">
    <div class="panel panel-default">
        <div class="panel-heading">
            {{author}}
        </div>
        <div class="panel-body">
            {{message}}
        </div>
    </div>
</script>
<script>
    $(function () {
        var maxId =${maxId};
        var newData = null;

        $("#loadMsg").click(function () {
            var $message = $("#message");
            if (newData) {
                for (var i = newData.length - 1; i >= 0; i--) {
                    var msg = newData[i];
                    var temp = $("#msgTemp").html();
                    temp = temp.replace("{{author}}", msg.author);
                    temp = temp.replace("{{message}}", msg.message);
                    $message.prepend(temp);
                }
                maxId = newData[0].id;
                newData = null;
                $(".alert").fadeOut();
            }
        });

        setInterval(function () {
            $.post("/message", {"maxId": maxId}, function (data) {
                if (data.length > 0) {
                    newData = data;
                    $(".alert").text("目前有" + data.length + "条新数据，请点击查看！").fadeIn();
                }
            });
        }, 5000);
    });

</script>
</body>
</html>
