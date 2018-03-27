<@override name="content">
<div class="container">
    <a href="/web-consumer/order" class="btn">
        <span><<返回</span>
    </a>
</div>
<!-- Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">修改订单内容</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal editForm">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default getNewOrder">修改订单</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="gradeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
                <button type="button" class="btn btn-default getGrade">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
</@override>

<@override name="js">
<script src="/web-consumer/static/index/customer_order_details.js"></script>
</@override>
<@extends name="layout.ftl"/>
