<div>
    <p>添加${user}</p>
</div>

<@override name="content">
    <div class="regions main-grid-border">
        <div class="container">
            <h2 class="head">您好 许先生<a href="/web-consumer/logout" class="logout">登出</a></h2>
        </div>
        <div class="region-block">
            <div class="container">
                <div class="state col-md-3">
                    <h3>废品订单<span class="more moreOrder">展示>></span></h3>
                </div>
                <div class="sun-regions col-md-9">
                    <ul>
                        <li><a href="#">已提交</a></li>
                        <li><a href="#">已抢单</a></li>
                        <li><a href="#">已回收</a></li>
                    </ul>
                </div>
                <div class="bs-example" style="display:none">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>订单状态</th>
                            <th>订单内容</th>
                        </tr>
                        </thead>
                        <tbody class="orderList">
                        </tbody>
                    </table>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="region-block">
            <div class="container">
                <div class="state col-md-3">
                    <h3>我的钱包<span class="more">更多>></span></h3>
                </div>
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
<script src="/web-consumer/static/index/customer.js"></script>
</@override>
<@extends name="layout.ftl"/>
