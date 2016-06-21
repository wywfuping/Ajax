var Ajax = (function () {
    function creatXmlHttp() {
        var xmlHttp = null;
        if (window.ActiveXObject) {
            xmlHttp = new ActiveXObject("MicroSoft.xmlHttp");
        } else {
            xmlHttp = new XMLHttpRequest();
        }
        return xmlHttp;
    }

    function queryParam(isPost, objectParam) {
        var param = "";
        if (!isPost) {
            param = "?";
        }
        for (var index in objectParam) {
            var key = index;
            var value = objectParam[index];
            param += (key + "=" + value + "&");
        }
        if (!isPost) {
            param += "_=" + new Date().getTime();
        }else{
            if(param.lastIndexOf("&")==param.length-1){
            param=param.substring(0,param.length-1);
            }
        }
        return param;
    }


    function sendGet(url,param,callback){
        var args=arguments;
        var xmlHttp = creatXmlHttp();
        xmlHttp.open("get", url + queryParam(false,param),true);
        xmlHttp.onreadystatechange = function () {
            var readystate = xmlHttp.readyState;
            if (readystate == 4) {
                var httpState = xmlHttp.status;
                if (httpState == 200) {
                    var result = xmlHttp.responseText;
                    if (args.length==2) {
                        args[1](relust);
                    } else if(args.length==3){
                        args[2](relust);
                    }
                } else {
                    alert("服务器请求异常:" + httpState);
                }
            }
        };
        xmlHttp.send();
    }

    function sendPost(url,param,callback){
        var args=arguments;

        var xmlHttp = creatXmlHttp();
        xmlHttp.open("post", url,true);
        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        xmlHttp.onreadystatechange = function () {
            var readystate = xmlHttp.readyState;
            if (readystate == 4) {
                var httpState = xmlHttp.status;
                if (httpState == 200) {
                    var result = xmlHttp.responseText;
                    if (args.length==2) {
                        args[1](relust);
                    } else if(args.length==3){
                        args[2](relust);
                    }
                } else {
                    alert("服务器请求异常:" + httpState);
                }
            }
        };
        xmlHttp.send(queryParam(true,param));
    }

    return {
        getText:sendGet,
        postText:sendPost
    }
})();

