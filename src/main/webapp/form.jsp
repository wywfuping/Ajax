<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-4">
            <form id="regForm">
                <legend>表单注册</legend>
                <div class="form-group">
                    <lable>账号</lable>
                    <input type="text" class="form-control" name="username">
                </div>
                <div class="form-group">
                    <lable>密码</lable>
                    <input type="text" class="form-control" name="password">
                </div>

                <div class="form-group">
                    <button class="btn btn-primary" type="button" id="subBtn">注册</button>
                </div>
            </form>
        </div>
    </div>

</div>

<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>
<script>
    $(function () {
        $("#regForm").validate({
            errorElement: "span",
            errorClass: "text-danger",
            rules: {
                username: {
                    required: true,
                    minlength: 5,
                    remote: "/checkusername"
                },
                password: {
                    required: true,
                    rangelength: [6, 18]
                }
            },
            messages: {
                username: {
                    required: "请输入账号",
                    minlength: "最少长度为5个字符",
                    remote: "该账号已被占用"
                },
                password: {
                    required: "请输入密码",
                    rangelength: "密码长度为6—18位"
                }
            },
            submitHandler: function (form) {
                var $subBtn = $("#subBtn");
                $.ajax({
                    url: "/reg",
                    type: "post",
                    data: $(form).serialize(),
                    beforeSend: function () {
                        $subBtn.text("提交中……").attr("disabled", "disabled");
                    },
                    success: function () {
                        alert("注册成功");
                    },
                    error: function () {
                        alert("服务器忙，稍后再试");
                    },
                    complete: function () {
                        $subBtn.text("注册").removeAttr("disabled");
                    }
                });
            }
        });
        $("#subBtn").click(function () {
            $("#regForm").submit();
        });
    });

</script>
</body>
</html>
