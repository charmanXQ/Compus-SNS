$(function(){
    $(".searchLogo_body").click(function() {
        var userKey = $(".userKey").val();
        location.href = "adminMain.do?userKey=" + userKey;
    });
    
    $(".func-operate").click(function() {
        $(".func-action").css("display", "block");
        var userId = $(this).attr("data-userId");
        $(".func-action .cancel").attr("data-userId", userId);
    });

    $(".func-action .cancel").click(function() {
        $(".func-action").css("display", "none");
    });

    $(".func-action .comfirm").click(function() {
        var userId = $(".func-action .cancel").attr("data-userId");
        var funcIdsArr = new Array();
        var count = 0;
        $("input[type=checkbox]:checked").each(function(i) {
            var funcId = $(this).val(); 
            funcIdsArr[count++] = funcId;
        });
        
        var funcIds = funcIdsArr.join(",");
        $.post(
            "resetFunc.do",
            {
                "funcIds" : funcIds,
                "userId" : userId
            },
            function(flag) {
                if (flag) {
                    $(".func-action").css("display", "none");
                    $(".message").text("重置权限成功！");
                    $(".message").css("display", "block");
                    setTimeout(function() {
                        $(".message").css("display", "none");
                        $(".message").text("");
                    }, 2000)
                    
                } else {
                    $(".message").text("重置权限失败！");
                    $(".message").css("display", "block");
                    $(".message").css("background-color", "red");
                    setTimeout(function() {
                        $(".message").css("display", "none");
                        $(".message").text("");
                    }, 2000)
                }
            }
        );
    });
});