jQuery(function($) {
    //存放用户详细信息
    var usersDetail=[];
    //存放用户基本信息
    var basicInfo=[];
    //获取用户数据
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

//            $.each(usersDetail,function (index,element) {
//                var params={"userKind":element.userKind,"userName":element.nickname};
//                var str=$.param(params);
//                var user=new Array()
//                user=['<label> <input type="checkbox" class="ace" /> <span class="lbl"></span> </label>',
//                    '<a href="'+element.url+'">'+element.nickname+'</a>',
//                    element.credit,
//                    element.point,
//                    element.createTime,
//                    '<span class="label label-sm label-warning">'+element.address+'</span>',
//                    '<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons"> <a class="blue" href="#"> <i class="icon-zoom-in bigger-130"></i> </a> <a class="green" href="#"> <i class="icon-pencil bigger-130"></i> </a> <a href="#?'+str+'" name="id-btn-dialog" class="red"><i class="icon-trash bigger-130"></i></a></div><div class="visible-xs visible-sm hidden-md hidden-lg"> <div class="inline position-relative"> <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown"> <i class="icon-caret-down icon-only bigger-120"></i> </button> <ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close"> <li> <a href="#" class="tooltip-info" data-rel="tooltip" title="View"> <span class="blue"> <i class="icon-zoom-in bigger-120"></i> </span> </a> </li> <li> <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit"> <span class="green"> <i class="icon-edit bigger-120"></i> </span> </a> </li> <li> <a href="#?'+str+'" name="id-btn-dialog" class="tooltip-error" data-rel="tooltip" title="Delete"><span class="red"> <i class="icon-trash bigger-120"></i> </span> </a> </li> </ul> </div> </div> </td>'
//                ]
//                oTable1.fnAddData(user)
//            });
    }

    $('table th input:checkbox').on('click' , function(){
        var that = this;
        $(this).closest('table').find('tr > td:first-child input:checkbox')
            .each(function(){
                this.checked = that.checked;
                $(this).closest('tr').toggleClass('selected');
            });

    });


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

    function initTableDatas() {
        loading_data();
        var userTable = $("#userInfo-table").dataTable( {
            "bProcessing": true,
            "bStateSave": true,
            "aaData": basicInfo,
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
                    "aTargets": [2,3,4], // 目标列位置，下标从0开始
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
        $( "td a[name='id-btn-dialog']" ).each(function (index,element) {
            $(element).on("click",function (e) {
                e.preventDefault();
                var param=$(this).attr("href").substr(1);
                var userKind=$.getUrlParam("userKind",param)
                var userName=$.getUrlParam("userName",param)

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
                                                            start = $("#userInfo-table").dataTable().fnSettings().iDisplayStart;
                                                            total = $("#userInfo-table").dataTable().fnSettings().fnRecordsDisplay();
                                                            window.location.reload();
                                                            if((total-start)==1){
                                                                if (start > 0) {
                                                                    $("#userInfo-table").dataTable().fnPageChange( 'previous', true );
                                                                }
                                                            }
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
            });
        })
        //Jump to view detail user information
        $("td a[name='viewDetail']").each(function (index,element) {
            $(element).on("click",function () {
                var param=$(this).attr("href").substr(1);
                var userKind=$.getUrlParam("userKind",param);
                var userName=$.getUrlParam("userName",param);
                console.log(userName)
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
        })
        $("td a[name='edit']").each(function (index,element) {
            $(element).on("click",function () {
                var param=$(this).attr("href").substr(1);
                var userKind=$.getUrlParam("userKind",param)
                var userName=$.getUrlParam("userName",param)
                $(element).on("click",function () {
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
            })
        })

    }

    initTableDatas();


    //override dialog's title function to allow for HTML titles
    $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
        _title: function(title) {
            var $title = this.options.title || '&nbsp;'
            if( ("title_html" in this.options) && this.options.title_html == true )
                title.html($title);
            else title.text($title);
        }
    }));

})