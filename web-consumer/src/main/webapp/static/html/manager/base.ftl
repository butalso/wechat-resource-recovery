<div class="content">
    <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
        </script>
       <@block name="breadcrumb">
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home home-icon"></i>
                    <a href="#">首页</a>
                </li>
                <li class="active">控制台</li>
            </ul><!-- .breadcrumb -->
       </@block>

        <div class="nav-search" id="nav-search">
        <form class="form-search">
                    <span class="input-icon">
                        <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
                        <i class="icon-search nav-search-icon"></i>
                    </span>
        </form>
    </div><!-- #nav-search -->
    </div>

    <div class="page-content">
        <@block name="page-header">
            <div class="page-header">
                <h1>
                    控制台
                    <small>
                        <i class="icon-double-angle-right"></i>
                        查看
                    </small>
                </h1>
            </div><!-- /.page-header -->
        </@block>

        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <@block name="content">
                </@block>
                <div id="dialog-confirm" class="hide">
                    <div class="alert alert-info bigger-110">
                        用户信息将被永久删除，无法找回
                    </div>

                    <div class="space-6"></div>

                    <p class="bigger-110 bolder center grey">
                        <i class="icon-hand-right blue bigger-120"></i>
                        Are you sure?
                    </p>
                </div><!-- #dialog-confirm -->
                <div id="dialog-success" class="hide">
                    <div class="alert alert-info bigger-110">
                        用户信息删除成功
                    </div>

                    <div class="space-6"></div>

                    <p class="bigger-110 bolder center grey">
                        <i class="icon-hand-right blue bigger-120"></i>
                        返回查询页面
                    </p>
                </div><!-- #dialog-confirm -->
                <!-- PAGE CONTENT ENDS -->
            </div>
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div><!-- content -->
<@block name="js"></@block>