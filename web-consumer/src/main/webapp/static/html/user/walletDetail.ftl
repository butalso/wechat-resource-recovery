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
        <form class="walletVal" style="display: none">
            <div class="input-group" style="width: 80%;
        margin-left: 10%;
        margin-top: 20px;">
                <input type="text" class="form-control input-lg" id="sum" placeholder="请输入金额">
                <div class="input-group-btn">
                    <button type="button" class="btn btn-default" id="nextBtn" style="height: 46px" disabled="disabled"
                            data-toggle="modal"
                            data-target="#myModal">
                        下一步
                    </button>
                </div>
            </div>
        </form>
        <div class="row" style="margin-top: 20px">
            <button class="btn btn-default col-xs-3 col-xs-offset-2 withdrawBtn" type="button">提现</button>
            <button class="btn btn-default col-xs-3 col-xs-offset-2 rechargeBtn" type="button">充值</button>
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
                            <i class="fa fa-check-square" aria-hidden="true" style="font-size: 50px;"></i>
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
 <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document" style="width: 80%">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">请输入密码</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <input class="form-control input-lg" id="payPass" type="password">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" id="walletBtn" class="btn btn-default">确定</button>
                </div>
            </div>
        </div>
    </div>

</@override>

<@override name="js">
<script src="/web-consumer/static/index/walletDetail.js"></script>
</@override>
<@extends name="layout.ftl"/>
