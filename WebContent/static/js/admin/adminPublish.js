
$(function(){
    $(".push").click(function () {
        var issueName = $(".issueName").val();
        var issueType = $("input[name='issueType']:checked").val();
        var txtNotice = $("#divEdit").html();
        if (!txtNotice) {
            $(".content-wrapper .errorMeg").html("发布内容不能为空哦！");
            $(".content-wrapper .errorMeg").css("display","block");
            setTimeout(() => {
                $(".content-wrapper .errorMeg").css("display","none");
            }, 3000);
        } else if (!issueName) {
            $(".content-wrapper .errorMeg").html("请填写单位名称！");
            $(".content-wrapper .errorMeg").css("display","block");
            setTimeout(() => {
                $(".content-wrapper .errorMeg").css("display","none");
            }, 3000);
        }else {
            $.post(
                "pushNotice.do",
                {
                    "text": txtNotice,
                    "issueName": issueName,
                    "issueType": issueType
                 },
                function (data) {
                    if (data) {
                        $(".content-wrapper .errorMeg").html("发布成功！");
                        $(".issueName").val("");
                        $("#divEdit").html("");
                        $(".content-wrapper .errorMeg").css('color', '#00BFFF');
                        $(".content-wrapper .errorMeg").css("display","block");
                        setTimeout(() => {
                            $(".content-wrapper .errorMeg").css("display","none");
                        }, 3000);
                    } else {
                        $(".content-wrapper .errorMeg").html("errro[520520]错误！");
                        $(".content-wrapper .errorMeg").css("display","block");
                        setTimeout(() => {
                            $(".content-wrapper .errorMeg").css("display","none");
                        }, 3000);
                    }
                }
            );
        }
    });

});