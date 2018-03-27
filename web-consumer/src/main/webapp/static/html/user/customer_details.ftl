<@override name="content">
<div class="container">
    <a href="/web-consumer/user/info" class="btn">
        <
        <返回
    </a>
    <div class="regions main-grid-border">
        <div class="region-block">
            <div class="state">
                <h3>个人主页<span class="more"><i class="fa fa-user" aria-hidden="true"></i></span></h3>
            <#--<img src="${userDetails.imageUrl}">-->
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <h3>姓名<span class="more">${userDetails.name}</span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <h3>性别<span class="more">${userDetails.gender}</span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <h3>联系电话<span class="more">${userDetails.phone}</span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <h3>诚信度<span class="more">${userDetails.credit}</span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <h3>积分值<span class="more">${userDetails.point}</span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <h3>经验值<span class="more">${userDetails.experience}</span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
        <hr>
        <div class="region-block">
            <div class="state">
                <h3>省<span class="more">${userDetails.address.province}</span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <h3>市<span class="more">${userDetails.address.city}</span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <h3>区<span class="more">${userDetails.address.area}</span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="region-block">
            <div class="state">
                <h3>窝<span class="more">${userDetails.address.detail}</span></h3>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">地址修改</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-xs-2 control-label">省</label>
                            <div class="col-xs-10">
                                <select name="province" class="form-control"> </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-xs-2 control-label">市</label>
                            <div class="col-xs-10">
                                <select name="city" class="form-control"> </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-xs-2 control-label">区</label>
                            <div class="col-xs-10">
                                <select name="area" class="form-control"> </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-xs-2 control-label">窝</label>
                            <div class="col-xs-10">
                                <select name="detail" class="form-control"> </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" id="editBtn" class="btn btn-default">保存修改</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <button class="btn btn-default col-xs-3 col-xs-offset-2" type="button" data-toggle="modal"
                data-target="#myModal">修改地址
        </button>
        <a href="/web-consumer/user" class="btn btn-default col-xs-3 col-xs-offset-2">返回</a>
    </div>
</div>
</@override>

<@override name="js">
<script type="text/javascript">
    // 获取业主头像，性别，电话，地址信息
    var user = {
        imageUrl: '${userDetails.imageUrl}',
        gender: '${userDetails.gender}',
        phone: '${userDetails.phone}',
        address: {
            province: '${userDetails.address.province}',
            city: '${userDetails.address.city}',
            area: '${userDetails.address.area}',
            detail: '${userDetails.address.detail}'
        }
    };
</script>
<script src="/web-consumer/static/index/customer_details.js"></script>
</@override>
<@extends name="layout.ftl"/>
