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
        url: "http://localhost:8080/web-consumer/login",
        dataType: 'json',
        data: loginData,
        complete: function (XMLHttpRequest, textStatus) {
        },
        success: function (data) {
            console.log(data);
        },
        error: function (err) {
            console.log(err);
        }
    });
}