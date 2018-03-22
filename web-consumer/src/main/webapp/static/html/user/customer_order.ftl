<@override name="content">
<div class="container orderList">
    <a href="/web-consumer/user/info" class="btn">
        <
        <返回
    </a>
    <#list orders as order>
        <div class="region-block">
            <div class="media" orderId="${order.orderItem.id}">
                <div class="media-left">
                    <a href="#">
                        <i class="fa fa-user" aria-hidden="true" style="font-size: 50px;"></i>
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">
                        订单编号:${order.orderItem.id}
                        <span class="more" orderId="${order.orderItem.id}">>></span>
                    </h4>
                    <div>${order.orderItem.state}</div>
                    <div>订单时间:${(order.orderItem.createTime?string("yyyy-MM-dd  hh:mm:ss"))!}</div>
                </div>
            </div>
        </div>
    </#list>
</div>
</@override>

<@override name="js">
<script src="/web-consumer/static/index/customer_order.js"></script>
</@override>
<@extends name="layout.ftl"/>
