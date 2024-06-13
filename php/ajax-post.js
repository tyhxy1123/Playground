function obj2str(obj){
    var l = [];
    for(var key in obj){
        l.push(key+"="+obj[key]);
    }
    return l.join("&");
}

function ajax(url, obj, timeout, success, error){
    var str = obj2str(obj);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("POST", url);
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlHttp.send(str);
    xmlHttp.onreadystatechange=function (){
        if(xmlHttp.readyState === 4){
            if(xmlHttp.status >= 200 && xmlHttp.status < 300 || xmlHttp.status === 304){
                success(xmlHttp);
            }
            else{
                error(xmlHttp);
            }
            

        }
        
    }

}