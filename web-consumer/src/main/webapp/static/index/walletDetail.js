$(function () {
    $(".records").click(function () {
        console.log("?");
        $(this).nextAll().slideToggle();
    });
});