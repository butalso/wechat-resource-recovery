$(function () {
    // $(".media").click(function () {
    //     var $this = $(this);
    //     $.ajax({
    //         type: 'GET',
    //         url: LOCALHOST + "/order/" + $this.attr("orderID"),
    //         dataType: 'json',
    //         // data: data,
    //         complete: function (XMLHttpRequest, textStatus) {
    //         },
    //         success: function (data) {
    //             console.log(data);
    //             if ($this.siblings().size()) {
    //                 $this.next().toggle();
    //             } else {
    //                 var subNode = "";
    //                 var node = "";
    //                 $.each(data.orderDetails, function (index, element) {
    //                     subNode += '<li class="list-group-item">' + element.name + '：' + element.weight + 'KG</li>\n'
    //                     console.log(element);
    //                 });
    //                 var node = '<ul class="list-group">' + subNode + '</ul>';
    //                 $this.after(node);
    //             }
    //         },
    //         error: function (err) {
    //             console.log(err);
    //         }
    //     });
    // });
    $(".media").click(function () {
        var $this = $(this)
        window.location = "/web-consumer/order/details?orderId=" + $this.attr("orderId");
        console.log($this.attr("orderID"));
    });
});