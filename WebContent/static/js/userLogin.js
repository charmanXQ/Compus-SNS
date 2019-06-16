
$(function(){
    $("#register").click(function () {
        displayModel();
        $(".registerForm").css("display", "block");
        $(".registerForm input")[0].focus();
        return false;
    });
    
    $(".cancel").click(function () {
        hiddenModel();
        $(".registerForm").css("display", "none");
        $("input")[0].focus();
        return false;
    });
    $(".link").mouseenter(function () {
        this.children[0].src = "/Compus-SNS/static/images/insert_images/hover_cancel.png";
    });
    $(".link").mouseleave(function () {
        this.children[0].src = "/Compus-SNS/static/images/insert_images/link_cancel.png";
    });
    $(".link").click(function () {
        this.previousElementSibling.value = "";
        this.previousElementSibling.focus();
        return false;
    });
    
    // 登录验证
    var emailFlag = false;
    var pwdFlag = false;
    $("#email").blur(function () {
        var email = $("#email").val();
        if (!email) {
            $(".errorInfo").html( "邮箱不能为空哦! ");
            $(".errorInfo").css("display", "block");
            setTimeout(() => {
                $(".errorInfo").css("display", "none");
            }, 2000);
        } else {
            emailFlag = true;
        }
    });
    
    $("#password").blur(function () {
        var password = $("#password").val();
        if (!password) {
            $(".errorInfo").html("  密码不能为空哦! ");
            $(".errorInfo").css("display", "block");
            setTimeout(() => {
                $(".errorInfo").css("display", "none");
            }, 2000);
        } else {
            pwdFlag = true;
        }
    });
    $(".submit").click(function () {
        if (emailFlag && pwdFlag) {
            $("#login").submit();
        } else {
            $(".errorInfo").css("display", "none");
            alert(" 请输入邮箱和密码！ ");
        }
    });
    //请求验证码
    $("#codeImg").click(function () {
        var newsrc = 'getVerifyCode.do?'+(new Date()).getTime();
        $("#codeImg").attr('src',newsrc); 
    });
    // 注册验证
    var r_nickNameFlag = false;
    var r_emailFlag = false;
    var r_collegeFlag = false;
    var r_pwdFlag = false;
    var r_pwd2Flag = false;
    var r_codeFlag = false;
    $("#r_nickName").blur(function () {
        var nickName = $("#r_nickName").val();
        if (!nickName) {
            $("#nickError").css('color', '#DC143C');
            $("#nickError").html("昵称不能为空！");
        } else {
            if (nickName.length < 4 || nickName.length > 20) {
                $("#nickError").css('color', '#DC143C');
                $("#nickError").html("昵称长度为4-20位！");
            } else {
                $.post(
                    "checkNickName.do",
                    {"inputNickName":nickName},
                    function (data) {
                        if (data) {
                            $("#nickError").css('color', '#00FF7F');
                            $("#nickError").html("输入有效！");
                            r_nickNameFlag = true;
                        } else {
                            $("#nickError").css('color', '#DC143C');
                            $("#nickError").html("该昵称已经被注册！");
                        }
                    }
                );
            }
        }
    });
    $("#r_email").blur(function () {
        var email = $("#r_email").val();
        if (!email) {
            $("#emailError").css('color', '#DC143C');
            $("#emailError").html("邮箱不能为空！");
        }  else {
            var reg=/^([a-zA-Z0-9]+)@([a-zA-Z0-9_]+)(.[a-zA-Z0-9])+/;
            if (!reg.test(email)) {
                $("#emailError").css('color', '#DC143C');
                $("#emailError").html("格式不对！");
            } else {
                $.post(
                    "checkEmail.do",
                    {"inputEmail": email},
                    function (data) {
                        if (data) {
                            $("#emailError").css('color', '#00FF7F');
                            $("#emailError").html("输入有效！");
                            r_emailFlag = true;
                        } else {
                            $("#emailError").css('color', '#DC143C');
                            $("#emailError").html("该邮箱已经被注册！");
                        }
                    }
                );
            }
        }
    });
    $("#r_college").blur(function () {
        var college = $("#r_college").val();
        if (!college) {
            $("#collegeError").css('color', '#DC143C');
            $("#collegeError").html("学院不能为空！");
        } else {
            if (college.length < 3 || college.length > 10) {
                $("#collegeError").css('color', '#DC143C');
                $("#collegeError").html("学院长度为3-10位！");
            } else {
                $("#collegeError").css('color', '#00FF7F');
                $("#collegeError").html("输入有效！");
                r_collegeFlag = true;
            }
        }
    })
    $("#r_pwd").blur(function () {
        var pwd = $("#r_pwd").val();
        if (!pwd) {
            $("#pwdError").css('color', '#DC143C');
            $("#pwdError").html("密码不能为空！");
        } else {
            if (pwd.length < 6 || pwd.length > 20) {
                $("#pwdError").css('color', '#DC143C');
                $("#pwdError").html("密码长度为6-20位！");
            } else {
                $("#pwdError").css('color', '#00FF7F');
                $("#pwdError").html("输入有效！");
                r_pwdFlag = true;
            }
        }
    });
    $("#r_pwd2").blur(function () {
        var pwd2 = $("#r_pwd2").val();
        var pwd = $("#r_pwd").val();
        if (!pwd2 || pwd != pwd2) {
            $("#pwd2Error").css('color', '#DC143C');
            $("#pwd2Error").html("两次密码输入不一样！");
        } else {
            $("#pwd2Error").css('color', '#00FF7F');
            $("#pwd2Error").html("输入有效！");
            r_pwd2Flag = true;
        }
    });
    $("#r_code").blur(function () {
        var code = $("#r_code").val();
        if (!code) {
        	$("#codeError").css('color', '#DC143C');
            $("#codeError").html("验证码不能为空！");
        } else {
            if (code.length != 4) {
            	$("#codeError").css('color', '#DC143C');
                $("#codeError").html("验证码的长度是4位！");
            } else {
                $.post(
                    "checkCode.do",
                    {"inputCode": code},
                    function (data) {
                        if (data) {
                            $("#codeError").css('color', '#00FF7F');
                            $("#codeError").html("验证码匹配成功！");
                            r_codeFlag = true;
                        } else {
                            $("#codeError").css('color', '#DC143C');
                            $("#codeError").html("验证码错误！");
                        }
                    }
                );
            }
            
        }
    });

    $(".r_submit").click(function () {
        if (r_nickNameFlag && r_emailFlag && r_collegeFlag &&
            r_pwdFlag && r_pwd2Flag && r_codeFlag) {
            $("#register2").submit();
        } else {
            alert("您还有数据没有填写完整！");
        }
    });
});