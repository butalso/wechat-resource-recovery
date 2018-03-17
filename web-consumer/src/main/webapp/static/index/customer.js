$(function () {
    // init();
    $(".moreOrder").click(function () {
        getMoreOrder();
    });
});
window.onbeforeunload=function (ev) {
    alert("?")
}
function init() {
    $.ajax({
        type: 'GET',
        url: LOCALHOST + "/user/info/detail",
        dataType: 'json',
        // data: data,
        complete: function (XMLHttpRequest, textStatus) {
        },
        success: function (data) {
            $(".head").html('您好 ' + data.nickName + '<a href="/web-consumer/logout" class="logout">登出</a>');
            $(".address").text(data.address.province + data.address.city + data.address.area + data.address.housingEstate);
            console.log(data);
        },
        error: function (err) {
            console.log(err);
        }
    });
}

function getMoreOrder() {
    $(".bs-example").show();
    $.ajax({
        type: 'GET',
        url: LOCALHOST + "/order/info",
        dataType: 'json',
        // data: data,
        complete: function (XMLHttpRequest, textStatus) {
        },
        success: function (data) {
            $orderList = $(".orderList");
            $orderList.empty();
            var node = '';
            var garbageNode = '';
            $.each(data, function (index, element) {
                garbageNode = '';
                $.each(element.orderDetails, function (index, element) {
                    garbageNode += '<td>' + element.name + ':' + element.weight + '千克</td>';
                });
                node = '<tr>\
                            <td>' + element.id + '</td>\
                            <td>' + element.stateInfo + '</td>\
                            ' + garbageNode + '\
                        </tr>';
                $orderList.append(node);
            });
            console.log(data);
        },
        error: function (err) {
            console.log(err);
        }
    });
}
