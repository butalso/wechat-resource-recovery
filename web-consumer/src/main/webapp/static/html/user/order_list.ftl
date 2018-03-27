<#if (userKind>0)>
    <@override name="nav"></@override>
</#if>
<@override name="content">
<div class="container orderList">
    <a href="/web-consumer/user" class="btn">
        <span><<返回</span>
    </a>
    <#list orders as order>
        <div class="region-block">
            <div class="media" orderId="${order.orderItem.id}">
                <div class="media-left">
                    <a href="#">
                        <i class="fa fa-user" aria-hidden="true" style="font-size: 50px;"></i>
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">
                        订单编号:${order.orderItem.id}
                        <#if (userKind=1)>
                            <#if (order.orderItem.state='已上门回收'||order.orderItem.state='订单完成')>
                                <#if (order.orderItem.collectorGrade!=0)>
                                    <button type="button" class="btn btn-default more collector" disabled="true"
                                            state="已回收" orderId="${order.orderItem.id}">
                                        已评分
                                    </button>
                                <#else>
                                    <button type="button" class="btn btn-default more collector"
                                            state="已回收" orderId="${order.orderItem.id}">
                                        评分
                                    </button>
                                </#if>
                            <#else>
                                <button type="button" class="btn btn-default more collector"
                                        state="未回收" orderId="${order.orderItem.id}">
                                    确认回收
                                </button>
                            </#if>
                        <#elseif (userKind=2)>
                            <#if (order.orderItem.state='已上门回收')>
                                <button type="button" class="btn btn-default more company"
                                        orderId="${order.orderItem.id}">
                                    确认完成
                                </button>
                            <#elseif (order.orderItem.state='订单完成')>
                                <button type="button" class="btn btn-default more collector" disabled="true"
                                        orderId="${order.orderItem.id}">
                                    已完成
                                </button>
                            </#if>
                        <#else>
                            <a href="/web-consumer/order/details?orderId=${order.orderItem.id}"><span
                                    class="more">>></span></a>
                        </#if>
                    </h4>
                    <div>${order.orderItem.state}</div>
                    <div>订单时间:${(order.orderItem.createTime?string("yyyy-MM-dd  hh:mm:ss"))!}</div>
                </div>
            </div>
        </div>
    </#list>
</div>
<!-- Modal -->
<div class="modal fade" id="companyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">请输入交易密码</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <input type="number" name="payPassword" class="form-control">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default companyPay" data-dismiss="modal">确认支付</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="collectGradeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">请为此次交易评分</h4>
            </div>
            <div class="modal-body">
                <form class="form-inline gradeForm row">
                    <div class="form-group col-xs-2 col-xs-offset-1">
                        <label for="exampleInputName2">1分</label>
                        <input type="radio" class="form-control" name="grade" value="1">
                    </div>
                    <div class="form-group col-xs-2">
                        <label for="exampleInputName2">2分</label>
                        <input type="radio" class="form-control" name="grade" value="2">
                    </div>
                    <div class="form-group col-xs-2">
                        <label for="exampleInputName2">3分</label>
                        <input type="radio" class="form-control" name="grade" value="3">
                    </div>
                    <div class="form-group col-xs-2">
                        <label for="exampleInputName2">4分</label>
                        <input type="radio" class="form-control" name="grade" value="4">
                    </div>
                    <div class="form-group col-xs-2">
                        <label for="exampleInputName2">5分</label>
                        <input type="radio" class="form-control" name="grade" value="5" checked="true">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default collectGradeBtn" data-dismiss="modal">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
</div>
</@override>

<@override name="js">
<script src="/web-consumer/static/index/order_list.js"></script>
</@override>
<@extends name="layout.ftl"/>
