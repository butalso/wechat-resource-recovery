<#if (userKind=1)>
    <@override name="nav"></@override>
</#if>
<@override name="content">
<div class="container orderList">
    <a href="/web-consumer/user/info" class="btn">
        <
        <返回
    </a>
    <#list orders as order>
        <div class="region-block">
        <#if (userKind>0)>
            <div class="media">
        <#else>
            <div class="media" orderId="${order.orderItem.id}">
        </#if>
                <div class="media-left">
                    <a href="#">
                        <i class="fa fa-user" aria-hidden="true" style="font-size: 50px;"></i>
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">
                        订单编号:${order.orderItem.id}
                        <#if (userKind>0&&order.orderItem.state='已上门回收')>
                            <button type="button" class="btn btn-default more collector" disabled="true"
                                    orderId="${order.orderItem.id}">
                                已回收
                            </button>
                        <#elseif (userKind>0&&order.orderItem.state!='已上门回收')>
                            <button type="button" class="btn btn-default more collector" orderId="${order.orderItem.id}">
                                确认回收
                            </button>
                        <#else>
                            <a href="/web-consumer/order/details?orderId=${order.orderItem.id}"><span class="more">>></span></a>
                        </#if>
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
<script src="/web-consumer/static/index/order_list.js"></script>
</@override>
<@extends name="layout.ftl"/>
