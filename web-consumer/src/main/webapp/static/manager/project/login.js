/**
 * Created by Administrator on 2018/3/4.
 */
var LOCALHOST = "http://localhost:8080/web-consumer";
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
                window.location = LOCALHOST + "/manager/index";
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function show_box(id) {
    $('.widget-box.visible').removeClass('visible');
    $('#'+id).addClass('visible');
}

