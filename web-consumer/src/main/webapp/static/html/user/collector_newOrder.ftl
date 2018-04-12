<@override name="nav"></@override>
<@override name="content">
<div class="container orderList">
    <a href="/web-consumer/user" class="btn">
        <span><<返回</span>
    </a>
    <#list orders as order>
        <div class="region-block">
            <div class="media">
                <div class="media-left media-middle" style="width: 20%;">
                    <a href="/web-consumer/user/details">
                        <img class="media-object" src="" alt=""
                             style="width: 80px;">
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">
                        编号:${order.orderItem.id}
                    </h4>
                    <div>业主：${order.orderItem.customerName}</div>
                    <button type="button" class="btn btn-default more" orderId="${order.orderItem.id}">接单</button>
                    <div>
                        地址：${order.orderItem.address.province}${order.orderItem.address.city}${order.orderItem.address.area}${order.orderItem.address.detail}</div>
                    <div>创建时间:${(order.orderItem.createTime?string("yyyy-MM-dd  hh:mm:ss"))!}</div>
                </div>
            </div>
        </div>
    </#list>
</div>
</@override>

<@override name="js">
<script src="/web-consumer/static/index/collector_newOrder.js"></script>
</@override>
<@extends name="layout.ftl"/>
