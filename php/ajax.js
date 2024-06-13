function obj2str(obj) {
    var res = [];
    for (var key in obj) {
        res.push(key + "=" + obj[key]);
    }
    return res.join("&");
}

function ajax(type, url, obj, timeout, success, error) {
    var xmlHttpRequest = new XMLHttpRequest();
    var timer;
    var str = obj2str(obj);
    
    if(type==="GET"){
        xmlHttpRequest.open(type, url + "?" + str);
        xmlHttpRequest.send();
    }
    else{
        xmlHttpRequest.open(type, url);
        xmlHttpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttpRequest.send(str);
    }

    xmlHttpRequest.onreadystatechange = function () {
        clearInterval(timer);
        if (xmlHttpRequest.readyState === 4) {
            if (xmlHttpRequest.status >= 200 && xmlHttpRequest.status < 300 || xmlHttpRequest.status === 304) {
                success(xmlHttpRequest);
            }
            else {
                error(xmlHttpRequest);
            }
        }
    }
    if (timeout) { timer = setInterval(() => { xmlHttpRequest.abort(); clearInterval(timer); }, timeout); }
}