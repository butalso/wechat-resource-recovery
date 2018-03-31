<@override name="content">
<div class="container" id="container">
    <ul class="grid" style="display: block;">
    <#list gifts as gift>
        <li>
        <#--<img src="images/e1.jpg" title="" alt="">-->
            <section class="list-left">
                <h5 class="title">${gift.name}</h5>
                <span class="adprice">${gift.point}积分</span>
                <p class="catpath">Computers &amp; Accessories » Laptops</p>
            </section>
            <section class="list-right">
                <span class="date">库存：${gift.inventory}</span>
                <#if gift.inventory=0>
                    <button class="btn btn-default" disabled="disabled">库存不足</button>
                <#else >
                    <button class="btn btn-default getGift" giftId="${gift.id}">换购</button>
                </#if>
            </section>
            <div class="clearfix"></div>
        </li>
    </#list>
    </ul>
</div></@override>

<@override name="js">
<script src="/web-consumer/static/index/gift.js"></script>
</@override>
<@extends name="layout.ftl"/>
