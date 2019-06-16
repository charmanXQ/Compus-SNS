
$(function () {
/*    $(".photos a").click(function () {
        displayModel();
    });*/

    $("#finish").click(function() {
        var inputs = $(".select");
        for (var i = 0; i<inputs.length; i++) {
            inputs[i].style.display = "none";
        }
        this.style.display = "none";
        $("#delete").css("display", "none");
    });

    $("#manage").click(function() {
        var inputs = $(".select");
        for (var i = 0; i<inputs.length; i++) {
            inputs[i].style.display = "block";
        }
        $("#finish").css("display", "block");
        $("#delete").css("display", "block");
    });

    $(".delete_picture").click(function() {
        var pictureId = $(this).attr("data-picture-id");
        $.post(
            "deleteOnePicture.do",
            {
                "pictureId": pictureId
            },
            function (data) {
                if (data) {
                    location.reload();
                }
            }
       );
    });
    
    $("#delete").click(function() {
        $(".model").css("display", "block");
        $(".alert-close").css("display", "block");
    });

    $(".bt-yes").click(function() {
        var deleteIdsArr = new Array();
        var count = 0;
        $("input[type=checkbox]:checked").each(function(i) {
            var pictureId = $(this).val(); 
            deleteIdsArr[count++] = pictureId;
        });
        
        if (deleteIdsArr.length === 0) {
            $(".message").text("还没有选项被选择！");
            $(".message").css("display", "block");
            setTimeout(function() {
                $(".message").css("display", "none");
                $(".message").text("");
                return;
            }, 2000)
            return;
        }
        
        var deleteIds = deleteIdsArr.join(",");
        $.post(
            "deletePictures.do",
            {"deleteIds" : deleteIds},
            function(flag) {
                if (flag) {
                    $(".message").text("删除成功！");
                    $(".message").css("display", "block");
                    setTimeout(function() {
                        $(".message").css("display", "none");
                        $(".message").text("");
                        location.reload();
                    }, 1000)
                    
                } else {
                    $(".message").text("删除失败！");
                    $(".message").css("display", "block");
                    setTimeout(function() {
                        $(".message").css("display", "none");
                        $(".message").text("");
                    }, 2000)
                }
            }
        );
    });
    
    $(".btn-upload").click(function() {
        $(".main .model").css("display", "block");
        $(".upload_pic").css("display", "block");
    });
    
    $(".cancel_upload").click(function() {
        location.reload();
    });
});