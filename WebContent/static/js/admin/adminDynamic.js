$(function(){
    $(".searchLogo_body").click(function() {
        var dynamicKey = $(".userKey").val();
        location.href = "dynamicManage.do?dynamicKey=" + dynamicKey;
    });
});