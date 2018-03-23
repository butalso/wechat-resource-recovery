// $(function () {
//     init();
//     $(".moreUserOrder").click(function () {
//         getUserOrder();
//     });
//     $(".moreMyOrder").click(function () {
//         getMyOrder();
//     });
// });
//
// function init() {
//     $.ajax({
//         type: 'GET',
//         url: LOCALHOST + "/user/info/detail",
//         dataType: 'json',
//         // data: data,
//         complete: function (XMLHttpRequest, textStatus) {
//         },
//         success: function (data) {
//             $(".head").html('您好 ' + data.nickName + '<a href="/web-consumer/logout" class="logout">登出</a>');
//             $(".address").text(data.address.province + data.address.city + data.address.area + data.address.housingEstate);
//             console.log(data);
//         },
//         error: function (err) {
//             console.log(err);
//         }
//     });
// }
//
// function getUserOrder() {
//     $(".userOrderTab").fadeToggle();
//     $.ajax({
//         type: 'GET',
//         url: LOCALHOST + "/order/new",
//         dataType: 'json',
//         // data: data,
//         complete: function (XMLHttpRequest, textStatus) {
//         },
//         success: function (data) {
//             console.log(data);
//             $orderList = $(".userOrderList");
//             $orderList.empty();
//             var node = '';
//             var garbageNode = '';
//             $.each(data, function (index, element) {
//                 garbageNode = '';
//                 $.each(element.orderDetails, function (index, element) {
//                     garbageNode += '<td>' + element.name + ':' + element.weight + '千克</td>';
//                 });
//                 node = '<tr>\
//                             <td><button class="btn btn-default getOrder" value=' + element.id + '>抢单</button></td>\
//                             <td>' + element.createTime + '</td>\
//                             <td>' + element.customerName + '</td>\
//                             <td>' + element.address.province + element.address.city + element.address.area + element.address.housingEstate + '</td>\
//                             ' + garbageNode + '\
//                         </tr>';
//                 $orderList.append(node);
//             });
//         },
//         error: function (err) {
//             console.log(err);
//         }
//     }).done(function () {
//         $(".getOrder").click(function () {
//             var $this = $(this);
//             $.ajax({
//                 type: 'POST',
//                 url: LOCALHOST + "/order/receive",
//                 // dataType: 'json',
//                 data: {
//                     orderId: $this.val()
//                 },
//                 complete: function (XMLHttpRequest, textStatus) {
//                 },
//                 success: function (data) {
//                     console.log(data);
//                     if (data == "接单成功") {
//                         $this.attr('disabled', "true").text("已抢单");
//                     }
//                 },
//                 error: function (err) {
//                     console.log(err);
//                 }
//             });
//             console.log($(this).val());
//         })
//     });
// }
//
// function getMyOrder() {
//     $(".myOrderTab").fadeToggle();
//     $.ajax({
//         type: 'GET',
//         url: LOCALHOST + "/order/info",
//         dataType: 'json',
//         // data: data,
//         complete: function (XMLHttpRequest, textStatus) {
//         },
//         success: function (data) {
//             console.log(data);
//             $orderList = $(".myOrderList");
//             $orderList.empty();
//             var node = '';
//             var garbageNode = '';
//             $.each(data, function (index, element) {
//                 garbageNode = '';
//                 $.each(element.orderDetails, function (index, element) {
//                     garbageNode += '<td>' + element.name + ':' + element.weight + '千克</td>';
//                 });
//                 node = '<tr>\
//                             <td>' + element.id + '</td>\
//                             <td>' + element.createTime + '</td>\
//                             <td>' + element.customerName + '</td>\
//                             <td>' + element.address.province + element.address.city + element.address.area + element.address.housingEstate + '</td>\
//                             ' + garbageNode + '\
//                         </tr>';
//                 $orderList.append(node);
//             });
//         },
//         error: function (err) {
//             console.log(err);
//         }
//     });
// }
