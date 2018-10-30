/* 写cookie */
function setCookie(name, value){
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/";
}

/* 读cookie */
function getCookie(name){
    var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
    if(arr != null){
        return unescape(arr[2]);
    }
    return null;
}
/* 获取URL参数 */
function getUrlParams(name){
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if(r != null){
        return unescape(r[2])
    }
    return null;
}

function getImgInfoByUrl(imgUrl) {
    var map = new HashMap();
    var url = new java.net.URL(imgUrl);
    var bi = javax.imageio.ImageIO.read(url);
    var y = bi.getHeight();
    var x = bi.getWeight();

    map.put("width", x);
    map.put("height", y);

    return map;
}









var preVisualHeight = 0;

// 自媒体数据数组
var wemediaArts = [];

// 自媒体文章曝光统计
(function($b){
    function monitorScroll() {
        var scrollHeight = 0;
        var visualHeight = 0;

        if (document.documentElement && document.documentElement.scrollTop){
            scrollHeight = document.documentElement.scrollTop;
        } else if (document.body){
            scrollHeight = document.body.scrollTop;
        }
    }
})


var http = require("http");

var server = http.createServer(function(req, res){
    res.writeHead(200, {'Content-Type':'text/html;charset=UTF-8'});
    res.end('Hello nodejs');
});





















