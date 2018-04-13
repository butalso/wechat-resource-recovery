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

    <div class="media hidden">
        <div class="media-left" style="width: 20%;">
            <a href="#">
                <img class="media-object" src="/web-consumer/static/images/avatars/avatar4.png" alt=""
                     style="width: 80px;">
            </a>
        </div>
        <div class="media-body">
            <h4 class="media-heading">业主甲</h4>
            <span class="comment">改造成闹钟也不是不可以</span>
            <br>
            发布于<span class="comment-date">2017.12.22</span>
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
    <div class="modal-dialog" role="document" style="width: 80%;">
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
                <button type="button" class="btn btn-default add">确认添加</button>
            </div>
        </div>
    </div>
</div>
</@override>

<@override name="js">
<#--<script src="/web-consumer/static/index/customer_message_board.js"></script>-->
</@override>
<@extends name="layout.ftl"/>

<script type="text/javascript">
    $('.modal-footer .add').on('click', function () {
        var s = $('.modal-body textarea').val();
        $('.media.hidden .comment').text(s);
        $('.media.hidden .comment-date').text(new Date().format('yyyy-MM-dd'));
        $('.media.hidden').removeClass('hidden');
        $('.modal').modal('hide');
    });

    // 对Date的扩展，将 Date 转化为指定格式的String
    // 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
    // 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
    // 例子：
    // (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
    // (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
    Date.prototype.format = function(fmt)
    { //author: meizz
        var o = {
            "M+" : this.getMonth()+1,                 //月份
            "d+" : this.getDate(),                    //日
            "h+" : this.getHours(),                   //小时
            "m+" : this.getMinutes(),                 //分
            "s+" : this.getSeconds(),                 //秒
            "q+" : Math.floor((this.getMonth()+3)/3), //季度
            "S"  : this.getMilliseconds()             //毫秒
        };
        if(/(y+)/.test(fmt))
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)
            if(new RegExp("("+ k +")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        return fmt;
    }
</script>
