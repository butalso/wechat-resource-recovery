<@override name="nav"></@override>
<@override name="content">
<div class="container">
    <a href="/web-consumer/user/company/staff" class="btn">
        <span><<返回</span>
    </a>

    <div class="panel panel-default">
        <div class="panel-heading">员工信息</div>
        <div class="panel-body">
            <ul class="list-group col-xs-6">
                <li class="list-group-item">编号：${collector.id}</li>
                <li class="list-group-item">姓名：${collector.name}</li>
                <li class="list-group-item">地址：${collector.address.detail}</li>
                <li class="list-group-item">电话：${collector.phone}</li>
            </ul>
            <ul class="list-group col-xs-6">
                <li class="list-group-item">评分：4.5</li>
                <li class="list-group-item">积分值：${collector.point}</li>
                <li class="list-group-item">诚信值：${collector.credit}</li>
                <li class="list-group-item">经验值：${collector.experience}</li>
            </ul>
        </div>
        <div class="panel-heading">订单列表</div>
        <div class="panel-body">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>订单编号</th>
                    <th>订单状态</th>
                    <th>订单时间</th>
                    <th>回收住户</th>
                    <th>交易金额</th>
                </tr>
                </thead>
                <tbody>
                    <#list orders as order>
                    <tr>
                        <td>${order.orderItem.id}</td>
                        <td>${order.orderItem.state}</td>
                        <td>${(order.orderItem.finishTime?string("yyyy-MM-dd  hh:mm:ss"))!}</td>
                        <td>${order.orderItem.customerName}</td>
                        <#assign totalAmount = 0>
                        <#list order.orderDetails as detail>
                            <#assign totalAmount = totalAmount + detail.weight * detail.price>
                        </#list>
                        <td>${totalAmount}</td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</@override>

<@override name="js">
<#--<script src="/web-consumer/static/index/company_staff_orders.js"></script>-->
</@override>
<@extends name="layout.ftl"/>

