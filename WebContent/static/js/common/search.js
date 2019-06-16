$(function () {
    $(".cancel_focus").click(function() {
        var userId = $(this).attr("data-user-id");
        var friendId = $(this).attr("data-friend-id");
        $.post(
            "cancelFocusFriend.do",
            {
                "userId": userId,
                "friendId": friendId
            },
            function (data) {
                if (data) {
                    location.reload();
                }
            }
        );
    });
    
    $(".add_focus").click(function() {
        var userId = $(this).attr("data-user-id");
        var friendId = $(this).attr("data-friend-id");
        $.post(
            "addFocusFriend.do",
            {
                "userId": userId,
                "friendId": friendId
            },
            function (data) {
                if (data) {
                    location.reload();
                }
            }
        );
    });

});