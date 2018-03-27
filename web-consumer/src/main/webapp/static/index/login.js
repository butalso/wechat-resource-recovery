$(function () {
    $("#loginBtn").click(function () {
        login();
    });

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
        url: LOCALHOST + "/login",
        // dataType: 'json',
        data: loginData,
        complete: function (XMLHttpRequest, textStatus) {
        },
        success: function (data) {
            if (data == "登录成功") {
                window.location = LOCALHOST + "/user";
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}
