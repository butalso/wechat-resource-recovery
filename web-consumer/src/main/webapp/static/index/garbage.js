var categories;
var name;
var price;

$(function () {
    init();
    $(".btn").click(function () {
        $(this).attr("disabled", true);
        addShopoingCart();
    });
});

function init() {
    categories = getQueryString("categories");
    name = getQueryString("name");
    console.log(categories, name);
    getPrice({name: name});
    $(".secDirect").text(categories);
    $(".itemtype h4").text(name);
}

function getPrice(data) {
    $.ajax({
        type: 'GET',
        url: LOCALHOST + "/garbage/",
        dataType: 'json',
        data: data,
        complete: function (XMLHttpRequest, textStatus) {
        },
        success: function (data) {
            console.log(data);
            price = data.price;
        },
        error: function (err) {
            console.log(err);
        }
    }).done(function () {
        $(".rate").text(price + "元/千克");
    });
}

function addShopoingCart() {
    var weight = $(".condition input").val();
    console.log(name, price, weight);
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
