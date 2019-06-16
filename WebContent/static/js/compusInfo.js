$(function(){
    $(".tab_nav li a").click(function() {
    	var dataId = $(this).attr("data-id");
        $(".tab_nav li a").each(function() {
            $(this).removeClass("active");
        });
        
        $(".tab").each(function() {
            $(this).css("display", "none");
        });
        $(this).addClass("active");
        $("."+dataId).css("display", "block");
    });
});