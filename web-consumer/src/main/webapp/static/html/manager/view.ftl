<@override name="breadcrumb">
<ul class="breadcrumb">
    <li>
        <i class="icon-home home-icon"></i>
        <a href="/web-consumer/manager/index">首页</a>
    </li>

    <li>
        <a href="#">用户信息管理</a>
    </li>
    <li class="active">业主用户信息</li>
</ul><!-- .breadcrumb -->
</@override>
<@override name="page-header">
<!-- .page-header -->
<div class="page-header">
    <h1>
        用户信息
        <small>
            <i class="icon-double-angle-right"></i>
             筛选用户
        </small>
    </h1>
</div>
<!-- /.page-header -->
</@override>
<@override name="content">
    <div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <div>
            <div id="user-profile-2" class="user-profile">
                <div id="searchBox">
                    <div class="clearfix">
                        <div class="alert alert-info no-margin">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="icon-remove"></i>
                            </button>

                            <div class="row">
                                <div class="col-xs-12 col-sm-2">
                                    <div class="widget-box transparent">
                                        <div class="widget-header widget-header-small">
                                            <h4 class="smaller">
                                                <i class="icon-undo bigger-110"></i>
                                                搜索导航
                                            </h4>
                                        </div>

                                        <div class="widget-body">
                                            <div class="widget-main pull-left">
                                                <ul class="nav nav-stacked nav-pills" id="selected">
                                                    <li  class="active">
                                                        <a data-toggle="pill" href="#exact">精确筛选</a>
                                                    </li>
                                                    <li>
                                                        <a data-toggle="pill" href="#addressSelect">地址筛选</a>
                                                    </li>
                                                    <li>
                                                        <a data-toggle="pill" href="#credit">信用值筛选</a>
                                                    </li>
                                                    <li>
                                                        <a data-toggle="pill" href="#comprehensive">综合筛选</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-xs-12 col-sm-10">
                                    <div class="widget-box transparent">
                                        <div class="widget-body">
                                            <div class="widget-main">
                                                <div class="tab-content">
                                                    <div id="exact" class="tab-pane in active">
                                                        <div class="row">
                                                            <form id="createTF">
                                                                <label for="id-date-range-picker-1" class="center">订单创建时间范围</label>
                                                                <div class="col-sm-11">
                                                                    <div class="row">
                                                                        <div class="col-xs-8 col-sm-11">
                                                                            <div class="input-group">
                                                                                <span class="input-group-addon">
                                                                                    <i class="icon-calendar bigger-110"></i>
                                                                                </span>

                                                                                <input class="form-control" type="text" name="date-range-picker" id="id-date-range-picker-1" />
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-sm-1 pull-right">
                                                                    <button class="btn btn-app btn-purple btn-xs padding-2" id="cTButton" >搜索</button>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div><!-- #exact -->

                                                    <div id="addressSelect" class="tab-pane">
                                                        <div class="row">
                                                            <form id="addressF">
                                                                <div class="col-sm-11" id="departmentSpecialty">
                                                                    <!--省份下拉框-->
                                                                    <div class="col-sm-3" style="padding-right:0px">
                                                                        <select class="form-control selectChoice" name="province">
                                                                            <option value="0" class="label">选择省份</option>
                                                                        </select>
                                                                    </div>
                                                                    <!--城市下拉框-->
                                                                    <div class="col-sm-3" style="padding-right:0px">
                                                                        <select class="form-control selectChoice" name="city">
                                                                            <option value="0">选择城市</option>
                                                                        </select>
                                                                    </div>
                                                                    <!--区域下拉框-->
                                                                    <div class="col-sm-3" style="padding-right:0px">
                                                                        <select class="form-control selectChoice" name="area">
                                                                            <option value="0" class="label">选择区域</option>
                                                                        </select>
                                                                    </div>
                                                                    <!--地址下拉框-->
                                                                    <div class="col-sm-2" style="padding-right:0px">
                                                                        <select class="form-control selectChoice" name="community">
                                                                            <option value="0" class="label">选择小区</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div class="col-sm-1 pull-right">
                                                                    <button class="btn btn-app btn-purple btn-xs" type="submit" id="addressButton" >搜索</button>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div><!-- /#addressSelect -->

                                                    <div id="credit" class="tab-pane">
                                                        <label  class="center">信息值范围</label>
                                                        <div class="row">
                                                            <form id="valueF">
                                                                <div class="col-sm-11">
                                                                   <input type="text" class="input-mini" name="from" id="spinner1" />
                                                                   <input type="text" class="input-mini" name="end" id="spinner2" />
                                                                </div>
                                                                <div class="col-sm-1 pull-right">
                                                                    <button class="btn btn-app btn-purple btn-xs padding-2" id="cTButton" >搜索</button>
                                                                </div>
                                                            </form>
                                                        </div>

                                                        <label  class="center">积分值范围</label>
                                                        <div class="row">
                                                                <div class="col-sm-11">
                                                                    <input type="text" class="input-mini" name="from" id="spinner3" />
                                                                    <input type="text" class="input-mini" name="end" id="spinner4" />
                                                                </div>
                                                        </div>


                                                    </div><!-- /#addressSelect -->

                                                    <div id="comprehensive" class="tab-pane">

                                                    </div><!-- /#addressSelect -->

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
                <div class="hr hr-8"></div>
                <div id="resultBox">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-header">
                                查询结果
                            </div>

                            <div class="table-responsive">
                                <table id="userInfo-table" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th class="center">
                                            <label>
                                                <input type="checkbox" class="ace" />
                                                <span class="lbl"></span>
                                            </label>
                                        </th>
                                        <th>姓名</th>
                                        <th>信用值</th>
                                        <th class="hidden-480">积分值</th>

                                        <th class="hidden-480">
                                            <i class="icon-time bigger-110 hidden-480"></i>
                                            创建时间
                                        </th>
                                        <th>小区</th>

                                        <th>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody id="selectContent">

                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div>
</@override>
<@override name="js">
<!-- page specific plugin scripts -->
<script src="/web-consumer/static/manager/jquery.dataTables.min.js"></script>
<script src="/web-consumer/static/manager/jquery.dataTables.bootstrap.js"></script>
<script src="/web-consumer/static/manager/datepicker/bootstrap-datepicker.min.js"></script>
<script src="/web-consumer/static/manager/datepicker/bootstrap-timepicker.min.js"></script>
<script src="/web-consumer/static/manager/datepicker/moment.min.js"></script>
<script src="/web-consumer/static/manager/fuelux/fuelux.spinner.min.js"></script>
<script src="/web-consumer/static/manager/datepicker/daterangepicker.min.js"></script>
<script type="text/javascript" src="/web-consumer/static/manager/project/logicalDeal.js"></script>
<script type="text/javascript" src="/web-consumer/static/manager/project/memberManagement.js"></script>
<script type="text/javascript">
    jQuery(function($) {
        //存放用户详细信息
        var usersDetail=[];
        //存放用户基本信息
        var basicInfo=[];
        //按创建时间筛选的用户信息
        var createTimeInfo=[];
        /////////////获取用户数据
        function loading_data() {
            <#if users??>
                <#list users as user>
                    var people=new Object();
                    people.nickname="${user.name}";
                    people.credit="${user.credit}";
                    people.point="${user.point}";
                    people.imageUrl="${user.imageUrl}";
                    people.address="${user.address!'未填写'}";
                    people.createTime="${user.createTime?string('yyyy/MM/dd HH:mm:ss')}";
                    people.gender="${user.gender}";
                    people.experience="${user.experience}";
                    people.phone="${user.phone}";
                    people.wallet="${user.wallet!'0'}";
                    people.password="${user.password}";
                    people.userKind="${user.userKind}";
                    usersDetail.push(people);
                </#list>
            </#if>

            <#if users??>
                <#list users as user>
                    var User=new Object();
                    User.first=" ";
                    User.nickName="${user.name}";
                    User.credit="${user.credit}";
                    User.point="${user.point}";
                    User.createTime="${user.createTime?string('yyyy/MM/dd HH:mm:ss')}";
                    User.address="${user.address!'未填写'}";
                    var params={"userKind":"${user.userKind!'未填写'}","userName":"${user.name!'未填写'}"};
                    User.hrefParam=$.param(params);
                    basicInfo.push(User);
                </#list>
            </#if>
        }

        function deleteSelect() {
                var nTrs = table.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr
                for(var i = 0; i < nTrs.length; i++){
                if($(nTrs[i]).hasClass('selected')){//相当于$(tr)
                    var t = table.fnGetData(nTrs[i]);
                    console.log("aaaaaa:" + t[2]);//获取一行第3列数据
                    }
                }
            }

        $('table th input:checkbox').on('click' , function(){
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                    .each(function(){
                        this.checked = that.checked;
                        $(this).closest('tr').toggleClass('selected');
            });

        });

        var index;

        $("#selectContent").on("click","tr",function (e) {
            e.preventDefault();
            index=$(this).context._DT_RowIndex;
        })

        $("#selectContent").on("click","tr td a[name='id-btn-dialog']",function (e) {
            e.preventDefault();
            var param=$(this).attr("href").substr(1);
            var userKind=$.getUrlParam("userKind",param);
            var userName=$.getUrlParam("userName",param);

            $( "#dialog-confirm" ).removeClass('hide').dialog({
                    dialogClass: "no-close",
                    resizable: false,
                    modal: true,
                    title: "<div class='widget-header'><h4 class='smaller'><i class='icon-warning-sign red'></i>删除用户信息？</h4></div>",
                    title_html: true,
                    buttons: [
                        {
                            html: "<i class='icon-trash bigger-110'></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;确定&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;",
                            "class" : "btn btn-danger btn-xs",
                            click: function() {
                                $.ajax({
                                    type:"DELETE",
                                    url:LOCALHOST+"/user/"+userKind+"/"+userName,
                                    complete: function(XMLHttpRequest,textStatus){

                                    } ,
                                    success: function(data){
                                        if(data=="删除成功"){
                                            $( "#dialog-success" ).removeClass('hide').dialog({
                                                dialogClass: "no-close",
                                                resizable: false,
                                                modal: true,
                                                title: "<div class='widget-header'><h4 class='smaller'><i class='icon-ok-sign red'></i>提示框</h4></div>",
                                                title_html: true,
                                                buttons: [
                                                    {
                                                        html: "<i class='icon-trash bigger-110'></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;确定&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;",
                                                        "class" : "btn btn-danger btn-xs",
                                                        click: function() {
                                                            $("#userInfo-table").dataTable().fnDeleteRow(index, null, true);
//
                                                            $( this ).dialog( "close" );
                                                        }
                                                    },
                                                    {
                                                        html: "<i class='icon-remove bigger-110'></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;",
                                                        "class" : "btn  btn-info btn-xs",
                                                        click: function() {
                                                            $( this ).dialog( "close" );
                                                        }
                                                    }
                                                ]
                                            });
                                        }
                                    },
                                    error: function(error){
                                        console.log(error);
                                    }

                                })
                                $( this ).dialog( "close" );
                            }
                        },
                        {
                            html: "<i class='icon-remove bigger-110'></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;",
                            "class" : "btn  btn-info btn-xs",
                            click: function() {
                                $( this ).dialog( "close" );
                            }
                        }
                    ]
                });

        })

        //Jump to view detail user information
        $("#selectContent").on("click","tr td a[name='viewDetail']",2,function () {
            var param=$(this).attr("href").substr(1);
            var userKind=$.getUrlParam("userKind",param);
            var userName=$.getUrlParam("userName",param);
            $.ajax({
                type:"GET",
                url:LOCALHOST+"/user/"+userKind+"/"+userName,
                dataType:"html",
                complete: function(XMLHttpRequest,textStatus){

                } ,
                success: function(data){
                    $(".main-content").html(data);
                },
                error: function(error){
                    console.log(error);
                }
            })
        })

        $("#selectContent").on("click","tr td a[name='edit']",1,function (even) {
            alert(even.data)
            var param=$(this).attr("href").substr(1);
            var userKind=$.getUrlParam("userKind",param)
            var userName=$.getUrlParam("userName",param)
            $.ajax({
                    type:"GET",
                    url:LOCALHOST+"/user/"+userKind+"/"+userName,
                    dataType:"html",
                    complete: function(XMLHttpRequest,textStatus){

                    } ,
                    success: function(data){
                        $(".main-content").html(data);
                    },
                    error: function(error){
                        console.log(error);
                    }
                })
        })




        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('table')
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            var w2 = $source.width();

            if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
            return 'left';
        }

        function initTableDatas(info) {
            loading_data();
            var userTable = $("#userInfo-table").dataTable( {
                "bProcessing": true,
                "bStateSave": true,
                "aaData": info,
                "aoColumns": [
                    { "bSortable": false,"mDataProp":"first","sClass":"center"},
                    { "bSortable":true, "mDataProp":"nickName"},
                    { "bSortable":true, "mDataProp":"credit"},
                    { "bSortable":true, "mDataProp":"point","sClass":" hidden-480"},
                    { "bSortable":true, "mDataProp":"createTime"},
                    { "bSortable":true, "mDataProp":"address","sClass":" hidden-480"},
                    { "bSortable":false, "mDataProp":"hrefParam"},

                ],
                "aoColumnDefs": [
                    {
                        "aTargets": [0], // 目标列位置，下标从0开始
                        "data": "nickName", // 数据列名
                        "mRender": function(data,type,full){
                            return "<label> <input type='checkbox' class='ace' /> <span class='lbl'></span> </label>"
                        }
                    },
                    {
                        "aTargets": [1], // 目标列位置，下标从0开始
                        "data": "name", // 数据列名
                        "mRender": function(data,type,full){
                            if(data!=null && data!="") {
                                return  "<a href='#'>"+data+"</a>";
                            }else {
                                return "<font color='font-red-mint'>尚未填写</font>";
                            }
                        }
                    },
                    {
                        "aTargets": [2,3], // 目标列位置，下标从0开始
                        "data": "name", // 数据列名
                        "mRender": function(data,type,full){
                            if(data!=null&&$.type(data)!="undefined") {
                                return data;
                            }else {
                                return "<font color='font-red-mint'>尚未填写</font>";
                            }
                        }
                    },
                    {
                        "aTargets": [4], // 目标列位置，下标从0开始
                        "data": "name", // 数据列名
                        "mRender": function(data,type,full){
                            if(data!=null&&data!="") {
                                return data;
                            }else {
                                return "<font color='font-red-mint'>尚未填写</font>";
                            }
                        }
                    },
                    {
                        "aTargets": [5], // 目标列位置，下标从0开始
                        "data": "name", // 数据列名
                        "mRender": function (data, type, full) {
                            if (data != null && data != ""&&data!="未填写") {
                                return  "<span class='label label-sm label-warning'>"+data+"</span>"
                            } else {
                                return  "<span class='label label-sm label-warning'>"+"南京市鼓楼区玉桥国际公寓"+"</span>"
                            }
                        }
                    },

                    {
                        "aTargets": [6], // 目标列位置，下标从0开始
                        "data": "name", // 数据列名
                        "mRender": function(data,type,full){
                            return '<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons"> \<a class="blue" href="#?'+data+'" name="viewDetail"> <i class="icon-zoom-in bigger-130"></i> </a> <a class="green" href="#?'+data+'" name="edit"> <i class="icon-pencil bigger-130"></i> </a> <a href="#?'+data+'" name="id-btn-dialog" class="red"><i class="icon-trash bigger-130"></i></a></div><div class="visible-xs visible-sm hidden-md hidden-lg"> <div class="inline position-relative"> <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown"> <i class="icon-caret-down icon-only bigger-120"></i> </button> <ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close"> <li> <a href="#?'+data+'" class="tooltip-info" data-rel="tooltip" title="View" name="viewDetail"> <span class="blue"> <i class="icon-zoom-in bigger-120"></i> </span> </a> </li> <li> <a href="#?'+data+'" class="tooltip-success" data-rel="tooltip" title="Edit" name="edit"> <span class="green"> <i class="icon-edit bigger-120"></i> </span> </a> </li> <li> <a href="#?'+data+'" name="id-btn-dialog" class="tooltip-error" data-rel="tooltip" title="Delete"><span class="red"> <i class="icon-trash bigger-120"></i> </span> </a> </li> </ul> </div> </div> </td>'
//
                        }
                    }

                ],
                "pagingType": "scrolling"

            } );
            // //Jump to delete user information

        }

        function reloadTable(info) {
            //将数据清除
            $('#userInfo-table').dataTable().fnClearTable();
            $.each(info,function (index,element) {
                $("#userInfo-table").dataTable().fnAddData(element)
            });

        }

        initTableDatas(basicInfo);


        //override dialog's title function to allow for HTML titles
        $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
            _title: function(title) {
                var $title = this.options.title || '&nbsp;'
                if( ("title_html" in this.options) && this.options.title_html == true )
                    title.html($title);
                else title.text($title);
            }
        }));
        $('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
            $(this).prev().focus();
        });
        $('input[name=date-range-picker]').daterangepicker({
                    "timePicker": true,
                    "timePicker24Hour": false,
                    "showOtherMonths":true,
                    "showDropdowns":true,
                    "linkedCalendars": false,
                    "autoUpdateInput": true,
                    "format":'YYYY-MM-DD HH:mm:ss',
                    "locale": {
                        fromLabel:"起始日期",
                        toLabel:"截止日期",
                        applyLabel: "应用",
                        cancelLabel: "取消",
                        resetLabel: "重置",
                        daysOfWeek:["日", "一", "二", "三", "四", "五", "六"],
                        monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]
                    }
                }).prev().on(ace.click_event, function(){
                        $(this).next().focus();
        });

        $('#spinner1').ace_spinner({value:100,min:0,max:200,step:10, btn_up_class:'btn-info' , btn_down_class:'btn-info'})
                .on('change', function(){
                    //alert(this.value)
                });

        $('#spinner2').ace_spinner({value:100,min:0,max:200,step:10, btn_up_class:'btn-success' , btn_down_class:'btn-danger'})
                .on('change', function(){
//                    alert(this.value)
                });

        $("#cTButton").on("click",function (e) {
            e.preventDefault();
            var t=$("#createTF").serializeArray();
            var selectParam={};
            $.each(t,function () {
                var params=this.value.split(" - ");
                selectParam["fromTime"]=params[0];
                selectParam["endTime"]=params[1];
            })
            var hrefParam=$.param(selectParam).replaceAll("\\+","%20");


            $.ajax({
                type: 'GET',
                url: LOCALHOST+"/user/0/create_time?"+hrefParam,
                dataType: 'json',
                complete: function (XMLHttpRequest, textStatus) {
                },
                success: function (data) {
                  $.each(data,function (index,element) {
                      var User=new Object();
                      User.first=" ";
                      User.nickName=element.name;
                      User.credit=element.credit;
                      User.point=element.point;
                      User.createTime=element.createTime;
                      User.address="江苏省南京市江宁区江南骏园";
                      var params={"userKind":element.userKind,"userName":element.name};
                      User.hrefParam=$.param(params);
                      createTimeInfo.push(User);
                  })
                    reloadTable(createTimeInfo)

                },
                error: function (err) {
                    console.log(err);
                }
            });

        })



    })
</script>
<!-- ace scripts -->
</@override>
<@extends name="base.ftl"/>

