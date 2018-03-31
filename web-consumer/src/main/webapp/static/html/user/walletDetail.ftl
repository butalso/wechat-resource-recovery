<#if (wallet.userKind>0)>
    <@override name="nav"></@override>
</#if>
<@override name="content">
<div class="container">
    <a href="/web-consumer/user" class="btn">
        <span><<返回</span>
    </a>
    <div class="regions main-grid-border">
        <div class="region-block">
            <div class="state">
                <h3>余额<span class="more">${wallet.balance}元</span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
        <hr>
        <div class="region-block records">
            <div class="state">
                <h3>交易记录<span class="more">>></span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
        <#list walletRecords as walletRecord>
            <div class="region-block">
                <div class="media">
                    <div class="media-left">
                        <a href="#">
                            <i class="fa fa-user" aria-hidden="true" style="font-size: 50px;"></i>
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">
                            订单编号:${walletRecord.id}
                            <span class="more">
                                交易金额：${walletRecord.value}元
                            </span>
                        </h4>
                        <div>付款方：
                            <#if walletRecord.transfer?contains("company")=true>
                                ${'${walletRecord.transfer}'?substring(8)}（公司）
                            <#elseif walletRecord.transfer?contains("collector")=true>
                                ${'${walletRecord.transfer}'?substring(10)}（回收员）
                            <#else>
                                ${'${walletRecord.transfer}'?substring(9)}（住户）
                            </#if>
                        </div>
                        <div>收款方：
                            <#if walletRecord.receiver?contains("company")=true>
                                ${'${walletRecord.receiver}'?substring(8)}（公司）
                            <#elseif walletRecord.receiver?contains("collector")=true>
                                ${'${walletRecord.receiver}'?substring(10)}（回收员）
                            <#else>
                                ${'${walletRecord.receiver}'?substring(9)}（住户）
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
</@override>

<@override name="js">
<script src="/web-consumer/static/index/walletDetail.js"></script>
</@override>
<@extends name="layout.ftl"/>
