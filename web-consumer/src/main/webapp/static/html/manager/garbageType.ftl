<@override name="breadcrumb">
<ul class="breadcrumb">
    <li>
        <i class="icon-home home-icon"></i>
        <a href="#">首页</a>
    </li>

    <li>
        <a href="#">分类管理</a>
    </li>
    <li class="active">查看分类</li>
</ul><!-- .breadcrumb -->
</@override>
<@override name="page-header">
<!-- .page-header -->
<div class="page-header">
    <h1>
        废品视图
        <small>
            <i class="icon-double-angle-right"></i>
            查看废品分类与实物
        </small>
    </h1>
</div>
<!-- /.page-header -->
</@override>
<@override name="content">
<div class="row">
    <div class="col-sm-6">
        <div class="widget-box">
            <div class="widget-header header-color-blue2">
                <h4 class="lighter smaller">查看分类</h4>
            </div>

            <div class="widget-body">
                <div class="widget-main padding-8">
                    <div id="typeTree" class="tree"></div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-sm-6">
        <div class="widget-box">
            <div class="widget-header header-color-green2">
                <h4 class="lighter smaller">废品实物</h4>
            </div>

            <div class="widget-body">
                <div class="widget-main padding-8">
                    <div id="resourceTree" class="tree"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</@override>
<@override name="js">
<!-- page specific plugin scripts -->
<script type="text/javascript">
    var garbageInfo=[];
        <#list garbageTypes as garbageType>
        garbageInfo.push("${garbageType}")
        </#list>
</script>
<script src="/web-consumer/static/manager/fuelux/fuelux.tree-sampledata.js"></script>
<script src="/web-consumer/static/manager/fuelux/fuelux.tree.min.js"></script>
<script type="text/javascript">
    jQuery(function($){

        $('#typeTree').ace_tree({
            dataSource: treeDataSource ,
            multiSelect:true,
            loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
            'open-icon' : 'icon-minus',
            'close-icon' : 'icon-plus',
            'selectable' : true,
            'selected-icon' : 'icon-ok',
            'unselected-icon' : 'icon-remove'
        });

        $('#resourceTree').ace_tree({
            dataSource: treeDataSource2 ,
            loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
            'open-icon' : 'icon-folder-open',
            'close-icon' : 'icon-folder-close',
            'selectable' : false,
            'selected-icon' : null,
            'unselected-icon' : null
        });



        /**
         $('#tree1').on('loaded', function (evt, data) {
		});

         $('#tree1').on('opened', function (evt, data) {
		});

         $('#tree1').on('closed', function (evt, data) {
		});

         $('#tree1').on('selected', function (evt, data) {
		});
         */
    });
</script>


<!-- ace scripts -->
</@override>
<@extends name="base.ftl"/>