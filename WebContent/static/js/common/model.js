function displayModel () {
    $(".model").css("display", "block");
    $("body").css("overflow", "hidden");
}
function hiddenModel () {
    $(".model").css("display", "none");
    $("body").css("overflow","visible");
}
$(function () {
    $(".modelExit").click(hiddenModel);
});