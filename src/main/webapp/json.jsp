<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">Gte Json</button>
<ul id="userList">

</ul>

<script>
    (function () {
        function creatXmlHttp() {
            var xmlHttp = null;
            if (window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }

        document.querySelector("#btn").onclick = function () {
            var xmlHttp = creatXmlHttp();
            xmlHttp.open("get", "/user.json", true);
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4) {
                    if (xmlHttp.status == 200) {
                        var result = xmlHttp.responseText;
                        var json = JSON.parse(result);
                        for (var i = 0; i < json.length; i++) {
                            var user = json[i];
                            var id = user.id;
                            var username = user.username;
                            var address = user.address;
                            var age = user.age;

                            var li = document.createElement("li");
                            var text = document.createTextNode(id + "->" + username);
                            li.appendChild(text);
                            document.getElementById("userList").appendChild(li);
                        }
                    }
                }
            };
            xmlHttp.send();
        }
    })();
</script>
</body>
</html>
