<@override name="nav"></@override>
<@override name="content">
    <div class="regions main-grid-border">
        <div class="container">
            <div class="media">
                <div class="media-left media-middle" style="width: 20%;">
                    <a href="#">
                        <img class="media-object" src="/web-consumer/static/images/avatars/avatar.png" alt=""
                             style="width: 80px;">
                    </a>
                </div>
                <div class="media-body">
                    <h2 class="head media-heading">您好 ${userDetails.name}<a href="/web-consumer/logout" class="logout">登出</a>
                    </h2>
                    经验值: ${userDetails.experience}
                </div>
            </div>
        </div>
        <hr>
        <div class="region-block">
            <div class="state">
                <a href="/web-consumer/order/new"><h3>待抢单<span class="more">>></span></h3></a>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <a href="/web-consumer/order"><h3>待回收<span class="more">>></span></h3></a>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <a href="/web-consumer/wallet/${userDetails.wallet.id}"><h3>查看钱包<span class="more">>></span></h3></a>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</@override>

<@override name="js">
<script src="/web-consumer/static/index/collector.js"></script>
</@override>
<@extends name="layout.ftl"/>
