$(document).onclick("a", function () {
    var json = {
        time : new Date().getTime()
    };
    window.history.replaceState(json, "", location.href + "?gonativeIndex");
});


var i_top = document.getElementsByClassName("i_top")[0],
    i_bottom = document.getElementsByClassName("i_bottom")[0];
    i_top.onclick = function () {
        window.scrollTo(0, 0)
    }