<@override name="content">
<div class="container">
    <ol class="breadcrumb">
        <li><a href="#">主页</a></li>
        <li><a href="/web-consumer/user/customer/message">话题榜</a></li>
        <li class="active">话题评论</li>
    </ol>
    <h3>旧手机只能扔了吗？<span class="label label-default">加入讨论</span></h3>
    <a href="/web-consumer/user/customer/message" class="btn">
        <span><<返回</span>
    </a>
    <div class="media">
        <div class="media-left" style="width: 20%;">
            <a href="#">
                <img class="media-object" src="/web-consumer/static/images/avatars/avatar5.png" alt=""
                     style="width: 80px;">
            </a>
        </div>
        <div class="media-body">
            <h4 class="media-heading">李先生</h4>
            旧手机可以改造成行车记录仪的
            <br>
            发布于2018.03.02
        </div>
    </div>
    <div class="media">
        <div class="media-left" style="width: 20%;">
            <a href="#">
                <img class="media-object" src="/web-consumer/static/images/avatars/avatar4.png" alt=""
                     style="width: 80px;">
            </a>
        </div>
        <div class="media-body">
            <h4 class="media-heading">欧学长</h4>
            改造成闹钟也不是不可以
            <br>
            发布于2017.12.22
        </div>
    </div>
    <div class="row addMessage">
        <button class="btn btn-default btn-block" type="button" data-toggle="modal"
                data-target="#messageModal">加入讨论
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
