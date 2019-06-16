$(function () {
    var parCommentId;
    var replyToUserName;
    $(".sub-reply").click(function() {
        parCommentId = $(this).attr("data-commentId");
        replyToUserName = $(this).attr("data-toUserName");
        var dynamicId = $(this).attr("data-dynamicId");
        $(".s_comments a").attr("data-type", "sub-comment-reply");
        $("#comment"+dynamicId).focus();
    });
    
    $(".s_comments a").click(function() {
        var dynamicId = $(this).attr("data-dynamicId");
        var txtComment = $("#comment"+dynamicId).val();
        var commentUserId = $(this).attr("data-userId");
        var dataType = $(this).attr("data-type");
        
        //父评论
        if (dataType === "par-comment-reply") {
            $.post(
                "pushParComment.do",
                {
                    "txtComment": txtComment,
                    "commentUser.id": commentUserId,
                    "dynamicId": dynamicId
                },
                function (data) {
                    if (data) {
                        location.reload();
                    } else {
                        $(".comment_message").html("errro[520520]错误！");
                        $(".comment_message").css("display","block");
                        setTimeout(() => {
                            $(".comment_message").css("display","none");
                        }, 3000);
                    }
                }
            );
        }

        //子评论
        if (dataType === "sub-comment-reply") {
            $.post(
                "pushSubComment.do",
                {
                    "txtComment": txtComment,
                    "commentUser.id": commentUserId,
                    "parCommentId": parCommentId,
                    "replyToUserName": replyToUserName
                },
                function (data) {
                    if (data) {
                        location.reload();
                    } else {
                        $(".comment_message").html("errro[520520]错误！");
                        $(".comment_message").css("display","block");
                        setTimeout(() => {
                            $(".comment_message").css("display","none");
                        }, 3000);
                    }
                }
            );
        }
    });

    $(".delete_dynamic").click(function() {
        var dynamicId = $(this).attr("data-dynamic-id");
        $.post(
            "deleteDynamic.do",
            {
                "dynamicId": dynamicId
            },
            function (data) {
                if (data) {
                    location.reload();
                }
            }
       );
    });
});