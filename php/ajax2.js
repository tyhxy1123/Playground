function obj2str(obj){
    var l = [];
    for(var key in obj){
        l.push(key+"="+obj[key]);
    }
    return l.join("&");
}

function ajax(){
    
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "05-ajax-get.php");
    xmlHttp.send();
    xmlHttp.onreadystatechange=function (){
        if(xmlHttp.readyState === 4){
            // if(xmlHttp.status >= 200 && xmlHttp.status < 300 || xmlHttp.status === 304){
            //     // success(xmlHttp);
            //     alert(xmlHttp.responseText);
            // }
            // else{
            //     // error(xmlHttp);
            //     alert("error");
            // }
            alert(xmlHttp.responseText);

        }
        
    }

}