$(function () {
    $(".records").click(function () {
        $(this).nextAll().slideToggle();
    });

    $(".withdrawBtn").click(function () {
        $(".walletVal").slideDown();
        $(".walletVal input").attr("placeholder", "请输入提现金额");
        $("#walletBtn").attr("value", -1);

    });

    $(".rechargeBtn").click(function () {
        $(".walletVal").slideDown();
        $(".walletVal input").attr("placeholder", "请输入充值金额");
        $("#walletBtn").attr("value", 1);
    })

    $("#walletBtn").click(function () {
        var data = {
            walletId: getQueryString("walletId"),
            value: $("#sum").val() * ($("#walletBtn").attr("value")),
            payPass: $("#payPass").val()
        }
        console.log(data);

        $.ajax({
            type: 'POST',
            url: LOCALHOST + "/wallet/" + getQueryString("walletId"),
            // dataType: 'json',
            data: {
                walletId: getQueryString("walletId"),
                value: $("#sum").val() * ($("#walletBtn").attr("value")),
                payPass: $("#payPass").val()
            },
            complete: function (XMLHttpRequest, textStatus) {
            },
            success: function (data) {
                console.log(data);
                if (data == "充值提现成功") {
                    Toast("操作成功", 2000);
                    setTimeout(function () {
                        location.reload();
                    }, 3000);
                }
            },
            error: function (err) {
                console.log(err);
                Toast(err.responseText, 2000);
            }
        });
    });

    $("#sum").on("input porporpertychange", function () {
        console.log();
        if ($(this).val() > 0 && $(this).val() > 0 != "") {
            $("#nextBtn").removeAttr("disabled");
        } else {
            $("#nextBtn").attr("disabled", "disabled");
        }
    });
});

