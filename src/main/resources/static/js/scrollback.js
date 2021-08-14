function showInfo(type,code){
    window.location.href = "__URL__/show"+type+"/id/"+code;
}
function  Trim(strValue) {
    return   strValue.replace(/^s*|s*$/g,"");
}
function SetCookie(sName,sValue) {
    document.cookie = sName + "=" + escape(sValue);
}
function GetCookie(sName) {
    var aCookie = document.cookie.split(";");
    for(var　i=0;　i　< aCookie.length;　i++) {
        var aCrumb = aCookie[i].split("=");
        if(sName　== Trim(aCrumb[0])) {
            return unescape(aCrumb[1]);
        }
    }
    return null;
}
function scrollback() {
    if(GetCookie("scroll")!=null){document.body.scrollTop=GetCookie("scroll")}
}