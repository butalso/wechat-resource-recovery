<div>
    <p>添加${userDetails}</p>
</div>

<@override name="header"></@override>
<@override name="content">
    <div class="regions main-grid-border">
        <div class="container">
            <h2 class="head">您好 许先生<a href="/web-consumer/logout" class="logout">登出</a></h2>
        </div>
        <div class="region-block">
            <div class="container">
                <div class="state col-md-3">
                    <h3>待抢单<span class="more moreUserOrder">展示>></span></h3>
                </div>
                <div class="sun-regions col-md-9">
                    <ul>
                        <li><a href="#">待接收</a></li>
                        <li><a href="#">待回收</a></li>
                        <li><a href="#">已回收</a></li>
                    </ul>
                </div>
                <table class="table userOrderTab" style="display: none">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>创建时间</th>
                        <th>创建人</th>
                        <th>创建地址</th>
                        <th>订单内容</th>
                    </tr>
                    </thead>
                    <tbody class="userOrderList">
                    </tbody>
                </table>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="region-block">
            <div class="container">
                <div class="state col-md-3">
                    <h3>我的订单<span class="more moreMyOrder">展示>></span></h3>
                </div>
                <div class="sun-regions col-md-9">
                    <ul>
                        <li><a href="#">待接收</a></li>
                        <li><a href="#">待回收</a></li>
                        <li><a href="#">已回收</a></li>
                    </ul>
                </div>
                <table class="table myOrderTab" style="display: none;">
                    <thead>
                    <tr>
                        <th>订单编号</th>
                        <th>创建时间</th>
                        <th>创建人</th>
                        <th>订单内容</th>
                    </tr>
                    </thead>
                    <tbody class="myOrderList">
                    </tbody>
                </table>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="region-block">
            <div class="container">
                <div class="state col-md-3">
                    <h3>地址管理<span class="more">更多>></span></h3>
                </div>
                <div class="sun-regions col-md-9">
                    <p class="address"></p>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</@override>

<@override name="js">
<script src="/web-consumer/static/index/collector.js"></script>
</@override>
<@extends name="layout.ftl"/>
