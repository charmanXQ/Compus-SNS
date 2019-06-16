$(function () {
    $("#userMain").addClass("active");
    var barItems = $(".barItem");
    var i = 0, len = barItems.length;
    for (; i < len; i++) {
        barItems[i].className = "barItem";
    }
    var current = window.location.hash;
    $(current+"_func").addClass("active");
});