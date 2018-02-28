$(function () {
    init();
    $(".btn").click(function () {
        addShopoingCart();
    });
});

function init() {
    var categories = getQueryString("categories");
    var name = getQueryString("name");
    $(".secDirect").text(categories);
    $(".itemtype h4").text(name);
    $(".rate").text(getPrice(name) + "yuan/kg");

}

function getPrice(str) {
    var price = 100;
    $.ajax({
        type: 'post',
        url: "http://localhost:8080/web-consumer/XXXXXX",
        dataType: 'json',
        data: str,
        complete: function (XMLHttpRequest, textStatus) {
        },
        success: function (data) {
            console.log(data);
        },
        error: function (err) {
            console.log(err);
        }
    });
    return price;
}

function addShopoingCart() {
    var name = getQueryString("name");
    var weight = $(".condition input").val();
    var price = getPrice(name);
    if (sessionStorage.getItem("shoppingCar")) {
        var shoppingCar = JSON.parse(sessionStorage.getItem("shoppingCar"));
        var data = {
            name: name,
            price: price,
            weight: weight
        }
        shoppingCar.push(data);
        sessionStorage.setItem("shoppingCar", JSON.stringify(shoppingCar));
    } else {
        var data = [{
            name: name,
            price: price,
            weight: weight
        }]
        sessionStorage.setItem("shoppingCar", JSON.stringify(data));
    }
    Toast("废品已添加~", 2000);
}
