<@override name="nav"></@override>
<@override name="content">
    <div class="regions main-grid-border">
        <div class="container">
            <div class="media">
                <div class="media-left media-middle">
                    <a href="#">
                        <i class="fa fa-user" aria-hidden="true" style="font-size: 70px;"></i>
                    <#--<img class="media-object" src="${userDetails.imageUrl}" alt="...">-->
                    </a>
                </div>
                <div class="media-body">
                    <h2 class="head media-heading">您好 ${userDetails.name}<a href="/web-consumer/logout" class="logout">登出</a>
                    </h2>
                </div>
                地址：${userDetails.address.province+userDetails.address.city+userDetails.address.area+userDetails.address.detail}
            </div>
        </div>
        <hr>
        <div class="region-block">
            <div class="state">
                <a href="/web-consumer/order"><h3>查看相关订单<span class="more">>></span></h3></a>
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
<#--<script src="/web-consumer/static/index/company.js"></script>-->
</@override>
<@extends name="layout.ftl"/>
