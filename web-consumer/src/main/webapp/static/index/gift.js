$(function () {
    $(".getGift").click(function () {
        console.log($(this).attr("giftId"));
        $.ajax({
            type: 'POST',
            url: LOCALHOST + "/gift/" + $(this).attr("giftId"),
            // dataType: 'json',
            // data: data,
            complete: function (XMLHttpRequest, textStatus) {
            },
            success: function (data) {
                Toast("礼品将于7个工作日为您发出，请注意查收");
                console.log(data);
            },
            error: function (err) {
                Toast(err.responseText, 2000);
                console.log(err);
            }
        });
    });
});