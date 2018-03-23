<@override name="content">
    <!--single-page-->
    <div class="single-page main-grid-border">
        <div class="container">
            <ol class="breadcrumb" style="margin-bottom: 5px;">
                <li><a href="/web-consumer">主页</a></li>
                <li class="active"><a class="secDirect" href="/web-consumer/garbage/categories"></a></li>
            </ol>
            <div class="product-desc">
                <div class="col-md-5 product-details-grid">
                    <div class="item-price">
                        <div class="itemtype">
                            <p class="p-price">选项：</p>
                            <h4></h4>
                            <div class="clearfix"></div>
                        </div>
                        <div class="product-price">
                            <p class="p-price">价格：</p>
                            <h3 class="rate">元/KG</h3>
                            <div class="clearfix"></div>
                        </div>
                        <div class="condition">
                            <p class="p-price">重量（KG）：</p>
                            <input type="number" name="" value="">
                            <div class="clearfix"></div>
                        </div>
                        <input type="button" class="btn btn-default btn-lg btn-block" name="" value="拿来换钱">
                    </div>
                </div>
                <div class="col-md-7 product-view">
                    <div class="product-details">
                        <h4>回收公司：<a href="#">中世纪科技发展有限公司</a></h4>
                        <h4>已回收量：<strong>150吨</strong></h4>
                        <p><strong>回收用途</strong>：使用魔法把废纸重新变成树。</p>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <!--//single-page-->
</@override>

<@override name="js">
<script src="/web-consumer/static/index/garbage.js"></script>
</@override>
<@extends name="layout.ftl"/>
