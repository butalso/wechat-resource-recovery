var order;

$(function () {
    getDetails(getQueryString("orderId"));
});

function getDetails(orderId) {
    $.ajax({
        type: 'GET',
        url: LOCALHOST + "/order/" + orderId,
        dataType: 'json',
        // data: data,
        complete: function (XMLHttpRequest, textStatus) {
        },
        success: function (data) {
            console.log(data);
            order = data;
            var subNode = '';
            $.each(data.orderDetails, function (index, element) {
                subNode += '<tr>\n' +
                    '                    <th scope="row">' + (index + 1) + '</th>\n' +
                    '                    <td>' + element.name + '</td>\n' +
                    '                    <td>' + element.weight + '</td>\n' +
                    '                    <td>' + element.weight * element.price + '</td>\n' +
                    '                </tr>'
            });
            var node = '<div class="panel panel-default">\n' +
                '        <ul class="list-group">\n' +
                '            <li class="list-group-item">订单编号：' + data.orderItem.id + '</li>\n' +
                '            <li class="list-group-item">当前状态：' + data.orderItem.state + '</li>\n' +
                '            <li class="list-group-item">收获地址：' + data.orderItem.address.province + data.orderItem.address.city + data.orderItem.address.area + data.orderItem.address.detail + '</li>\n' +
                '            <li class="list-group-item">上门时间：' + data.orderItem.collectFromTime + '</li>\n' +
                '        </ul>\n' +
                '\n' +
                '        <div class="panel-heading">废品清单</div>\n' +
                '        <div class="panel-body">\n' +
                '            <table class="table table-bordered">\n' +
                '                <thead>\n' +
                '                <tr>\n' +
                '                    <th>#</th>\n' +
                '                    <th>废品名称</th>\n' +
                '                    <th>废品重量</th>\n' +
                '                    <th>价值</th>\n' +
                '                </tr>\n' +
                '                </thead>\n' +
                '                <tbody>\n' +
                subNode +
                '                </tbody>\n' +
                '            </table>\n' +
                '        </div>\n' +
                '    </div>\n' +
                '    <div class="row">\n' +
                '        <button class="btn btn-default editBtn col-xs-3 col-xs-offset-2" type="button" data-toggle="modal" data-target="#editModal">修改细则</button>\n' +
                '        <button class="btn btn-default col-xs-3 col-xs-offset-2" type="button">取消订单</button>\n' +
                '    </div>';

            $(".content .container").append(node);
        },
        error: function (err) {
            console.log(err);
        }
    }).done(function () {
        if (order.orderItem.state != "回收员已接单" && order.orderItem.state != "订单创建成功") {
            $(".editBtn").attr("disabled", true)
        }
        $(".editBtn").click(function () {
            var subNode = '';
            $.each(order.orderDetails, function (index, element) {
                subNode += '<div class="form-group">\n' +
                    '           <label for="' + element.name + '" class="col-xs-4 control-label">' + element.name + '</label>\n' +
                    '           <div class="col-xs-8">\n' +
                    '               <input type="number" class="form-control" name="' + element.name + '" value = "' + element.weight + '"placeholder="(单位：KG)">\n' +
                    '           </div>\n' +
                    '       </div>';
            });
            $("form").empty().append(subNode);
        });
        $(".getNewOrder").click(function () {
            var t = $("form").serializeArray();
            var orderDetails = [];
            $.each(t, function (index, element) {
                orderDetails.push({
                    "name": this.name,
                    "weight": parseInt(this.value)
                })
            });
            order.orderDetails = orderDetails;
            console.log(order);
            $.ajax({
                type: 'POST',
                url: LOCALHOST + "/order/order_details",
                // dataType: 'json',
                data: JSON.stringify(order),
                headers: {
                    "Accept": "text/plain; charset=utf-8",
                    "Content-Type": "application/json; charset=utf-8"
                },
                complete: function (XMLHttpRequest, textStatus) {
                },
                success: function (data) {
                    if (data == "修改成功") {
                        Toast("修改成功", 1000);
                        setTimeout("location.reload()", 1000);
                    }
                    console.log(data);
                },
                error: function (err) {
                    console.log(err);
                }
            });
        });
    });
}