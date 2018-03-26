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
                    <div id="tree1" class="tree"></div>
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
                    <div id="tree2" class="tree"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</@override>
<@override name="js">
<!-- page specific plugin scripts -->

<script src="/web-consumer/static/manager/fuelux/fuelux.tree-sampledata.js"></script>
<script src="/web-consumer/static/manager/fuelux/fuelux.tree.min.js"></script>

<!-- ace scripts -->
</@override>
<@extends name="base.ftl"/>