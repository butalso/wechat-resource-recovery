<@override name="content">
    <div class="regions main-grid-border">
        <div class="container">
            <div class="media">
                <div class="media-left media-middle">
                    <a href="/web-consumer/user/details">
                        <i class="fa fa-user" aria-hidden="true" style="font-size: 70px;"></i>
                    <#--<img class="media-object" src="${userDetails.imageUrl}" alt="...">-->
                    </a>
                </div>
                <div class="media-body">
                    <h2 class="head media-heading">
                        <a href="/web-consumer/user/details">您好 ${userDetails.name}
                        </a>
                        <a href="/web-consumer/logout" class="logout">登出</a>
                    </h2>
                    经验值: ${userDetails.experience}
                </div>
            </div>
        </div>
        <hr>
        <div class="region-block">
            <div class="state">
                <a href="/web-consumer/order/info"><h3>废品订单<span class="more">>></span></h3></a>
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
                <h3>礼品兑换记录<span class="more">>></span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</@override>

<@override name="js">
<script src="/web-consumer/static/index/customer.js"></script>
</@override>
<@extends name="layout.ftl"/>
