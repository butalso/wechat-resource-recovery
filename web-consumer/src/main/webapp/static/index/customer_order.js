$(function () {
    $(".media").click(function () {
    console.log($(this).attr("orderID"));
        if ($(this).siblings().size()) {
            $(this).next().toggle();
        } else {
            var node = '<ul class="list-group">\n' +
                '    <li class="list-group-item">item ：A</li>\n' +
                '    <li class="list-group-item">item ：A</li>\n' +
                '    <li class="list-group-item">item ：A</li>\n' +
                '    </ul>';
            $(this).after(node);
        }
    });
});