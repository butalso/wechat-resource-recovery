<@override name="content">
<div class="container" id="container">
    <ul class="grid" style="display: block;">
        <#list gifts as gift>
            <li>
                <#switch gift.id>
                    <#case 1>
                        <img src="static/images/gift/rag.png" title="" alt="">
                        <#break>
                    <#case 2>
                        <img src="static/images/gift/cleaningBall.jpg" title="" alt="">
                        <#break>
                    <#case 3>
                        <img src="static/images/gift/brush.jpg" title="" alt="">
                        <#break>
                    <#case 4>
                        <img src="static/images/gift/soap.png" title="" alt="">
                        <#break>
                    <#case 5>
                        <img src="static/images/gift/thimerosal.jpg" title="" alt="">
                        <#break>
                    <#case 6>
                        <img src="static/images/gift/detergent.png" title="" alt="">
                        <#break>
                    <#case 7>
                        <img src="static/images/gift/liquidDetergent.png" title="" alt="">
                        <#break>
                    <#case 8>
                        <img src="static/images/gift/toothpaste.jpg" title="" alt="">
                        <#break>
                    <#case 9>
                        <img src="static/images/gift/toilet.jpg" title="" alt="">
                        <#break>
                    <#case 10>
                        <img src="static/images/gift/gloves.jpg" title="" alt="">
                        <#break>
                    <#default>
                </#switch>
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
