$(function () {
    $("#editSelf").click(function () {
        $(".edit_user_message").css("display","block");
    });

    $(".edit_cancel").click(function() {
        $(".edit_user_message").css("display","none");
    });
});