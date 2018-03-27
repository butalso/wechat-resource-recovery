$(function () {
    $("button").click(function () {
        var $this = $(this);
        $.ajax({
            type: 'PUT',
            url: LOCALHOST + "/order/" + $this.attr("orderId") + "/receive",
            // dataType: 'json',
            // data: data,
            complete: function (XMLHttpRequest, textStatus) {
            },
            success: function (data) {
                console.log(data);
                if (data == "接单成功") {
                    $this.attr('disabled', "true").text(data);
                }
            },
            error: function (err) {
                console.log(err);
            }
        });
    });
});