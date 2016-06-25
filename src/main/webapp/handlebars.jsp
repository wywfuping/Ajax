<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>Handlerbars</h3>
    </div>
    <button id="btn">Load temp</button>
    <div id="message"></div>

</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/handlebars-v4.0.5.js"></script>
<script type="yawei" id="msgTemp">
    <div class="panel panel-default">
        <div class="panel-heading">
            {{author}}
            {{#if isVip}}
            <span class="text-danger">VIP</span>
            {{else}}
            <span class="text-danger">❤</span>
            {{/if}}
        </div>
        <div class="panel-body">
            <ul>
               {{#each message}}
               <li>{{this}}</li>
               {{/each}}
            </ul>
        </div>
    </div>




</script>
<script>
    $("#btn").click(function () {
        $("#message").html("");
        var json = {"author": "tom", "message": ["come on baby","加油 宝贝"], "isVip": false};
        var source = $("#msgTemp").html();
        var template = Handlebars.compile(source);
        var html = template(json);

        $("#message").prepend(html);
    });

</script>
</body>
</html>
