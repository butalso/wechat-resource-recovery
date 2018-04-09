<@override name="content">
<div class="container">
    <a href="/web-consumer/user" class="btn">
        <span><<返回</span>
    </a>
    <div>
        <ul class="media-list">
            <li class="media">
                <div class="media-left">
                    <a href="#">
                        <i class="fa fa-user" aria-hidden="true" style="font-size: 70px;"></i>
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">不愿透露姓名的许先生</h4>
                    <p>我觉得这个页面完成的非常不OK</p>
                    <p>我觉得这个页面完成的非常不OK</p>
                    <p>我觉得这个页面完成的非常不OK</p>
                    <!-- Nested media object -->
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <i class="fa fa-user" aria-hidden="true" style="font-size: 70px;"></i>
                            </a>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">不愿透露姓名的欧学长</h4>
                            我也觉得
                            我也觉得
                            我也觉得
                            <!-- Nested media object -->
                            <div class="media">
                                <div class="media-left">
                                    <a href="#">
                                        <i class="fa fa-user" aria-hidden="true" style="font-size: 70px;"></i>
                                    </a>
                                </div>
                                <div class="media-body">
                                    <h4 class="media-heading">不愿透露姓名的李女士</h4>
                                    顶楼上
                                    顶楼上
                                    顶楼上
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Nested media object -->
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <i class="fa fa-user" aria-hidden="true" style="font-size: 70px;"></i>
                            </a>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">不愿透露姓名的赵同学</h4>
                            啥时候开饭？
                            啥时候开饭？
                            啥时候开饭？
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
    <div class="row addMessage">
        <button class="btn btn-default btn-block" type="button" data-toggle="modal"
                data-target="#messageModal">添加评论
        </button>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="messageModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">添加评论</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <textarea class="form-control"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-default">确认添加</button>
            </div>
        </div>
    </div>
</div>
</@override>

<@override name="js">
<#--<script src="/web-consumer/static/index/customer_message_board.js"></script>-->
</@override>
<@extends name="layout.ftl"/>
