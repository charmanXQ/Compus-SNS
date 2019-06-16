$(function(){
    $(".searchLogo_body").click(function() {
        var noticeKey = $(".userKey").val();
        location.href = "noticeManage.do?noticeKey=" + noticeKey;
    });
    
    $(".delete_notice").click(function() {
        var noticeId = $(this).attr("data-notice-id");
        $.post(
            "deleteNotice.do",
            {
                "noticeId": noticeId
            },
            function (data) {
                if (data) {
                    location.reload();
                }
            }
       );
    });
});