$(function () {
    init();
    $(".moreOrder").click(function () {
        getMoreOrder();
    });
});

function init() {
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/web-consumer/user/info/detail",
        dataType: 'json',
        // data: data,
        complete: function (XMLHttpRequest, textStatus) {
        },
        success: function (data) {
            $(".head").html('您好 ' + data.nickName + '<a href="/web-consumer/logout" class="logout">登出</a>');
            console.log(data);
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function getMoreOrder() {
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/web-consumer/order/info",
        dataType: 'json',
        // data: data,
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