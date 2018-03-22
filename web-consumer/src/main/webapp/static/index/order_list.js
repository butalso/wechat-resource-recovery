$(function () {
    $(".media").click(function () {
        var $this = $(this);
        if ($this.attr("orderID")) {
            if ($this.siblings().size()) {
                $this.next().toggle();
                console.log("yes")
            } else {
                $.ajax({
                    type: 'GET',
                    url: LOCALHOST + "/order/" + $this.attr("orderID"),
                    dataType: 'json',
                    // data: data,
                    complete: function (XMLHttpRequest, textStatus) {
                    },
                    success: function (data) {
                        console.log(data);
                        var subNode = "";
                        var node = "";
                        $.each(data.orderDetails, function (index, element) {
                            subNode += '<li class="list-group-item">' + element.name + '：' + element.weight + 'KG</li>\n'
                            console.log(element);
                        });
                        var node = '<ul class="list-group">' + subNode + '</ul>';
                        $this.after(node);
                    },
                    error: function (err) {
                        console.log(err);
                    }
                });
            }
        }
    });

    $("button.collector").click(function () {
        var $this = $(this);
        $.ajax({
            type: 'POST',
            url: LOCALHOST + "/order/" + $this.attr("orderId") + "/confirm_receive",
            // dataType: 'json',
            // data: data,
            complete: function (XMLHttpRequest, textStatus) {
            },
            success: function (data) {
                console.log(data);
                if (data == "确认成功") {
                    $this.attr("disabled", true).text("已确认回收");
                }
            },
            error: function (err) {
                console.log(err);
            }
        });
    });
});