$(function () {
    initList();
    $(".btn").click(function () {
        getPay();
    });
});

function initList() {
    var node;
    var $list = $(".list");
    $list.empty();
    if (sessionStorage.getItem("shoppingCar")) {
        var shoppingCar = JSON.parse(sessionStorage.getItem("shoppingCar"));
        $.each(shoppingCar, function (index, element) {
            node = '<li>\
                    <section class="list-left">\
                        <h5 class="title">' + element.name + '</h5>\
                        <p class="catpath">单价：' + element.price + '元/kg</p>\
                    </section>\
                    <section class="list-right">\
                        <span class="date">重量:' + element.weight + 'KG</span>\
                        <span class="cityname">删除</span>\
                    </section>\
                    <div class="clearfix"></div>\
                </li>';
            $list.append(node);
        })
    }
}

function getPay() {
    var data = sessionStorage.getItem("shoppingCar");
    console.log(data);
    $.ajax({
        type: 'post',
        url: "http://localhost:8080/web-consumer/order/create",
        dataType: 'json',
        headers: {
            "Accept" : "text/plain; charset=utf-8",
            "Content-Type": "application/json; charset=utf-8"
        },
        data: data,
        complete: function (XMLHttpRequest, textStatus) {
        },
        success: function (data) {
            sessionStorage.removeItem("shoppingCar");
            console.log(data);
        },
        error: function (err) {
            console.log(err);
        }
    });
}
