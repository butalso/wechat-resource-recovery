var $list;

$(function () {
    initList();
    $(".btn").click(function () {
        getPay();
    });
});

function initList() {
    var node;
    $list = $(".list");
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
    } else {
        cleanList();
    }
}

function getPay() {
    var data = sessionStorage.getItem("shoppingCar");
    console.log(data);
    $.ajax({
        type: 'post',
        url: LOCALHOST + "/order/create",
        // dataType: 'json',
        headers: {
            "Accept": "text/plain; charset=utf-8",
            "Content-Type": "application/json; charset=utf-8"
        },
        data: data,
        complete: function (XMLHttpRequest, textStatus) {
        },
        success: function (data) {
            console.log(data);
            if (data == "创建成功") {
                sessionStorage.removeItem("shoppingCar");
                Toast("订单已提交", 2000);
                cleanList();
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function cleanList() {
    var node = '<span>你还没有添加任何废品哦～</span>';
    $list.empty().append(node);
    $(".btn").hide();
}