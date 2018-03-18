<div>
    <p>添加${userDetails}</p>
</div>

<@override name="content">
    <div class="regions main-grid-border">
        <div class="container">
            <div class="media">
                <div class="media-left media-middle">
                    <a href="#">
                        <i class="fa fa-user" aria-hidden="true" style="font-size: 70px;"></i>
                    <#--<img class="media-object" src="/web-consumer/static/images/b1.jpg" alt="...">-->
                    </a>
                </div>
                <div class="media-body">
                    <h2 class="head media-heading">您好 许先生<a href="/web-consumer/logout" class="logout">登出</a></h2>
                    经验值: 12/100
                </div>
            </div>
        </div>
        <hr>
        <div class="region-block">
            <div class="state">
                <a href="/web-consumer/user/order"><h3>废品订单<span class="more">>></span></h3></a>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <h3>我的钱包<span class="more">>></span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <h3>交易记录<span class="more">>></span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</@override>

<@override name="js">
<script src="/web-consumer/static/index/customer.js"></script>
</@override>
<@extends name="layout.ftl"/>
