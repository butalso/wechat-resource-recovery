/**
 * Created by Administrator on 2018/3/4.
 */
var LOCALHOST = "http://120.79.94.32:8080/web-consumer";
$(function () {
    $("#loginBtn").click(function () {
        login();
    });

    $(".forgot-password-link").on("click",function () {
        show_box("forgot-box");
        return false;
    })

    $(".user-signup-link").on("click",function () {
        show_box("signup-box");
        return false;
    })

    $(".back-to-login-link").on("click",function () {
        show_box("login-box");
        return false;
    })

});

function login() {
    var loginData = {};
    var t = $("#loginForm").serializeArray();
    $.each(t, function () {
        loginData[this.name] = this.value;
    });

    console.log(loginData);

    $.ajax({
        type: 'post',
        url: LOCALHOST+"/manager/login",
        // dataType: 'json',
        data: loginData,
        complete: function (XMLHttpRequest, textStatus) {
        },
        success: function (data) {
            if (data == "登录成功") {
                var seconds=3;
                for(var i=seconds;i>=0;i--) {
                    window.setTimeout('doUpdate(' + i + ')', (seconds-i) * 1000);
                }
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function doUpdate(num) {
    $("#title").html("<div class='widget-main'> <h4 class='header blue lighter bigger'>\
        登录成功，将在'+num+'秒后自动跳转到主页</h4><div class='space-6 '></div> </div>");
    if(num == 0) {
        window.location = LOCALHOST + "/manager/index";
    }
}

function show_box(id) {
    $('.widget-box.visible').removeClass('visible');
    $('#'+id).addClass('visible');
}

