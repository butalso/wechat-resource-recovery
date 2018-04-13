<@override name="content">
    <!-- Services -->
    <div class="total-ads main-grid-border">
        <div class="container">
            <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
                <div id="myTabContent" class="tab-content">
                    <div role="tabpanel" class="tab-pane fade in active" id="home" aria-labelledby="home-tab">
                        <div id="container">
                            <div class="clearfix"></div>
                            <ul class="list">

                            </ul>
                            <div>
                                <!-- Button trigger modal -->
                                <button type="button" class="btn btn-default btn-lg btn-block" name="button"
                                        data-toggle="modal" data-target="#myModal">
                                    下单
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <!-- // Services -->

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" style="width: 80%;" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">回收详情</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group checkbox">
                            <label>
                                <input type="checkbox" value="1" name="useOldAddress" checked>
                                使用默认地址：
                                <span class="oldAddress">${address.province+address.city+address.area+address.detail}</span>
                            </label>
                        </div>
                        <hr>
                        <div class="form-group addressInput" style="display: none">
                            <label for="province" class="col-sm-2 control-label">新的地址：</label>
                            <div class="col-sm-8">
                                省<select name="province" class="form-control"> </select>
                                市<select name="city" class="form-control"> </select>
                                区<select name="area" class="form-control"> </select>
                                小区<select name="detail" class="form-control"> </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="province" class="col-sm-2 control-label">上门时间</label>
                            <div class="col-sm-8">
                                从<input type="datetime-local" class="form-control" name="collectFromTime">
                                至<input type="datetime-local" class="form-control" name="collectEndTime">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" id="payBtn" class="btn btn-default">下单</button>
                </div>
            </div>

            </div>
    </div>

</@override>

<@override name="js">
<script>
    // 获取业主地址信息
    var oldAddress = {
        province: '${address.province}',
        city: '${address.city}',
        area: '${address.area}',
        detail: '${address.detail}'
    };
</script>
<script src="/web-consumer/static/index/shoppingCar.js"></script>
</@override>
<@extends name="layout.ftl"/>
