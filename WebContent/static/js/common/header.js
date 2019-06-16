$(function () {
    var titles = $(".logoTitle .title");
    var i = 0, len = titles.length;
    for (; i < len; i++) {
        titles[i].className = "title";
    }
    var active = window.location.hash;
    $(active).addClass("active");
    
    $(".searchLogo").click(function() {
        var searchKey = $(".selfInfo input").val();
        location.href = "searchUserByKey.do?searchKey=" + searchKey;
    });
    
    $(".userLogo").click(function() {
        $(".user-logo").click();
    });
    
    $(".user-logo").change(function() {
        var formdata = new FormData();
        formdata.append("userNewLogo", $(this)[0].files[0]);

/*        $.ajax({
            type: "POST",
            url: "changeLogo.do",
            data: formdata,
            contentType: false, // 不设置内容类型
            processData: false, // 不处理数据
            dataType: "json",
            success: function(data) {
                console.log("success!");
            },
            error: function(data) {
                console.log(data);
                console.log("fail!");
            }
        });*/
        
        
        var self = this;  // 在each中this指向没个v  所以先将this保留

        var xhr = new XMLHttpRequest();
        // 完成
        xhr.addEventListener("load", function(e){

        }, false);  
        // 错误
        xhr.addEventListener("error", function(e){

        }, false);  
        
        xhr.open("POST", "changeLogo.do", true);
        xhr.setRequestHeader("X_FILENAME", "newLogo");
        xhr.setRequestHeader("Cache-Control","no-cache");
        xhr.setRequestHeader("If-Modified-Since","0");
        xhr.send(formdata);
    });
});