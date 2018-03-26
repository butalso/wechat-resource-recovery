<div class="form-group">
    <label for="" class="col-sm-2 text-right">地址:</label>
    <div class="col-sm-10 row" id="departmentSpecialty">
        <!--department select-->
        <div class=" col-sm-3" style="padding-right: 0">
            <select class="form-control selectChoice" id="province" >
                <option>选择省份</option>
            </select>
        </div>
        <!--domain select-->
        <div class="col-sm-3" style="padding-right: 0">
            <select class="form-control selectChoice" id="city"   >
                <option>选择城市</option>
            </select>
        </div>
        <!--grade select-->
        <div class="col-sm-2" style="padding-right: 0">
            <select class="form-control  selectChoice" id="area">
                <option>选择区域</option>
            </select>
        </div>
    </div>
</div>
<@override name="breadcrumb">
    <ul class="breadcrumb">
        <li>
            <i class="icon-home home-icon"></i>
            <a href="#">首页</a>
        </li>

        <li>
            <a href="#">用户管理</a>
        </li>
        <li class="active">用户信息</li>
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
