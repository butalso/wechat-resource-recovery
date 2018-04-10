var sessionStorage = sessionStorage;
var LOCALHOST = "http://localhost:8080/web-consumer";

$(function () {
    forMobileApps();
});

// <!-- for-mobile-apps -->
function forMobileApps() {
    addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    }
}

// 获取url中的参数
function getQueryString(key) {
    var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
    var result = window.location.search.substr(1).match(reg);
    return result ? decodeURIComponent(result[2]) : null;
}

function Toast(msg, duration) {
    duration = isNaN(duration) ? 3000 : duration;
    var m = document.createElement('div');
    m.innerHTML = msg;
    m.style.cssText = "width: 60%;min-width: 150px;opacity: 0.7;height: 30px;color: rgb(255, 255, 255);line-height: 30px;text-align: center;border-radius: 5px;position: fixed;top: 40%;left: 20%;z-index: 999999;background: rgb(0, 0, 0);font-size: 12px;";
    document.body.appendChild(m);
    setTimeout(function () {
        var d = 0.5;
        m.style.webkitTransition = '-webkit-transform ' + d + 's ease-in, opacity ' + d + 's ease-in';
        m.style.opacity = '0';
        setTimeout(function () {
            document.body.removeChild(m)
        }, d * 1000);
    }, duration);
}

function addressLinkage() {
    $.ajax({
        type: 'GET',
        url: LOCALHOST + "/address/linkage",
        dataType: 'json',
        // data: data,
        complete: function (XMLHttpRequest, textStatus) {
        },
        success: function (data) {
            var $list = $("select[name='province']");
            var node = '';
            $list.append('<option>请选择</option>');
            $.each(data, function (index, element) {
                node = '<option value="' + this + '">' + this + '</option>';
                $list.append(node);
            });
        },
        error: function (err) {
            console.log(err);
        }
    }).done(function () {
        $("select[name='province']").change(function () {
            $.ajax({
                type: 'GET',
                url: LOCALHOST + "/address/linkage",
                dataType: 'json',
                data: {
                    province: $(this).val()
                },
                complete: function (XMLHttpRequest, textStatus) {
                },
                success: function (data) {
                    console.log(data);
                    var $list = $("select[name='city']");
                    $list.empty().append('<option>请选择</option>');
                    var node = '';
                    $.each(data, function (index, element) {
                        node = '<option value="' + this + '">' + this + '</option>';
                        $list.append(node);
                    });
                },
                error: function (err) {
                    console.log(err);
                }
            });
        });
        $("select[name='city']").change(function () {
            $.ajax({
                type: 'GET',
                url: LOCALHOST + "/address/linkage",
                dataType: 'json',
                data: {
                    city: $(this).val()
                },
                complete: function (XMLHttpRequest, textStatus) {
                },
                success: function (data) {
                    console.log(data);
                    var $list = $("select[name='area']");
                    $list.empty().append('<option>请选择</option>');
                    var node = '';
                    $.each(data, function (index, element) {
                        node = '<option value="' + this + '">' + this + '</option>';
                        $list.append(node);
                    });
                },
                error: function (err) {
                    console.log(err);
                }
            });
        });
        $("select[name='area']").change(function () {
            $.ajax({
                type: 'GET',
                url: LOCALHOST + "/address/linkage",
                dataType: 'json',
                data: {
                    area: $(this).val()
                },
                complete: function (XMLHttpRequest, textStatus) {
                },
                success: function (data) {
                    console.log(data);
                    var $list = $("select[name='detail']");
                    $list.empty().append('<option>请选择</option>');
                    var node = '';
                    $.each(data, function (index, element) {
                        node = '<option value="' + this + '">' + this + '</option>';
                        $list.append(node);
                    });
                },
                error: function (err) {
                    console.log(err);
                }
            });
        });
    });
}