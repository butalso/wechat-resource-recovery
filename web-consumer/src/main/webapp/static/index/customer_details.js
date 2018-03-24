$(function () {
    addressLinkage();

    // 业主修改头像，性别，电话，地址信息
    $("button#editBtn").click(function () {
        var formObj = {};
        var form = $("form").serializeArray();
        $.each(form, function () {
            formObj[this.name] = this.value;
        });
        user.address = formObj;
        console.log(user);
        $.ajax({
            type: 'POST',
            url: LOCALHOST + "/user/info",
            // dataType: 'json',
            data: JSON.stringify(user),
            contentType: 'application/json',
            complete: function (XMLHttpRequest, textStatus) {
            },
            success: function (data) {
                console.log(data);
            },
            error: function (err) {
                console.log(err);
            }
        });
    });
});