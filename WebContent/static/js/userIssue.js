
$(function(){
    $(".push").click(function () {
        var loginUserId = $(".push").attr("data-id");
        var txtDynamic = $("#divEdit").html();
        if (!txtDynamic) {
            $(".main .errorMeg").html("发表内容不能为空哦！");
            $(".main .errorMeg").css("display","block");
            setTimeout(() => {
                $(".main .errorMeg").css("display","none");
            }, 3000);
        } else {
            $.post(
                "pushDynamic.do",
                {
                    "txtWords": txtDynamic,
                    "issueUser.id": loginUserId
                 },
                function (data) {
                    if (data) {
                        $(".main .errorMeg").html("发表成功！");
                        $("#divEdit").html("");
                        $(".main .errorMeg").css('color', '#00BFFF');
                        $(".main .errorMeg").css("display","block");
                        setTimeout(() => {
                            $(".main .errorMeg").css("display","none");
                        }, 3000);
                    } else {
                        $(".main .errorMeg").html("errro[520520]错误！");
                        $(".main .errorMeg").css("display","block");
                        setTimeout(() => {
                            $(".main .errorMeg").css("display","none");
                        }, 3000);
                    }
                }
            );
        }
    });

});