$(function () {
    $(".media").click(function (e) {
        var $this = $(this);
        if ($this.attr("orderID")) {
            if ($this.siblings().size()) {
                $this.next().toggle();
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

    $("button.collector").click(function (e) {
        e.stopPropagation();
        var $this = $(this);
        if ($this.attr("state") == "已回收") {
            $("#collectGradeModal").modal('toggle');
            $(".collectGradeBtn").click(function () {
                var t = $(".gradeForm").serializeArray();
                $.ajax({
                    type: 'POST',
                    url: LOCALHOST + "/order/" + $this.attr("orderId") + "/grade",
                    // dataType: 'json',
                    data: {
                        orderItemId: $this.attr("orderId"),
                        grade: parseInt(t[0].value)
                    },
                    headers: {
                        "Accept": "text/plain; charset=utf-8",
                        "Content-Type": "application/x-www-form-urlencoded"
                    },
                    complete: function (XMLHttpRequest, textStatus) {
                    },
                    success: function (data) {
                        console.log(data);
                        if (data == "评分成功") {
                            $this.attr("disabled", true).text("已评分");
                            $("#collectGradeModal").hide();
                        }
                    },
                    error: function (err) {
                        console.log(err);
                    }
                });
            });
        }
        else if ($this.attr("state") == "未回收") {
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
        }

    });

    $("button.company").click(function (e) {
        e.stopPropagation();
        var $this = $(this);
        $("form").append('<input type="hidden" name="orderItemIds" value="' + $this.attr("orderId") + '" class="form-control">');
        $("#companyModal").modal('toggle');
        $(".companyPay").click(function () {
            var t = $("form").serializeArray();
            var data = {};
            $.each(t, function (index, element) {
                data[this.name] = this.value;
            });
            console.log(data);
            $.ajax({
                type: 'POST',
                url: LOCALHOST + "/order/confirm_finish",
                // dataType: 'json',
                data: data,
                headers: {
                    "Accept": "text/plain; charset=utf-8",
                    "Content-Type": "application/x-www-form-urlencoded; charset=utf-8"
                },
                complete: function (XMLHttpRequest, textStatus) {
                },
                success: function (data) {
                    if (data == "确认成功") {
                        $this.attr("disabled", true).text("已完成")
                    }
                    console.log(data);
                },
                error: function (err) {
                    console.log(err);
                }
            });
        });
    });

});