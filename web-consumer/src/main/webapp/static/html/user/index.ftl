<@override name="content">
<div class="main-banner banner text-center">
    <div class="container">
        <h1>分类回收 绿色生活</h1>
        <p>Classification and recycling of green life</p>
        <a href="#">加入我们</a>
    </div>
</div>
<!-- content-starts-here -->
<div class="content">
    <div class="categories">
        <div class="container">
            <div class="col-md-2 focus-grid">
                <a href="/web-consumer/garbage/#parentVerticalTab1">
                    <div class="focus-border">
                        <div class="focus-layout">
                            <div class="focus-image"><i class="fa fa-file"></i></div>
                            <h4 class="clrchg">废纸</h4>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-2 focus-grid">
                <a href="/web-consumer/garbage#parentVerticalTab2">
                    <div class="focus-border">
                        <div class="focus-layout">
                            <div class="focus-image"><i class="fa fa-cubes"></i></div>
                            <h4 class="clrchg">废塑料</h4>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-2 focus-grid">
                <a href="/web-consumer/garbage#parentVerticalTab3">
                    <div class="focus-border">
                        <div class="focus-layout">
                            <div class="focus-image"><i class="fa fa-mobile"></i></div>
                            <h4 class="clrchg">手机</h4>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-2 focus-grid">
                <a href="/web-consumer/garbage#parentVerticalTab4">
                    <div class="focus-border">
                        <div class="focus-layout">
                            <div class="focus-image"><i class="fa fa-battery-1"></i></div>
                            <h4 class="clrchg">电池</h4>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-2 focus-grid">
                <a href="/web-consumer/garbage#parentVerticalTab5">
                    <div class="focus-border">
                        <div class="focus-layout">
                            <div class="focus-image"><i class="fa fa-car"></i></div>
                            <h4 class="clrchg">报废车辆</h4>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-2 focus-grid">
                <a href="/web-consumer/garbage#parentVerticalTab6">
                    <div class="focus-border">
                        <div class="focus-layout">
                            <div class="focus-image"><i class="fa fa-cogs"></i></div>
                            <h4 class="clrchg">废金属</h4>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-2 focus-grid">
                <a href="/web-consumer/garbage#parentVerticalTab7">
                    <div class="focus-border">
                        <div class="focus-layout">
                            <div class="focus-image"><i class="fa fa-television"></i></div>
                            <h4 class="clrchg">电视机</h4>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-2 focus-grid">
                <a href="/web-consumer/garbage#parentVerticalTab8">
                    <div class="focus-border">
                        <div class="focus-layout">
                            <div class="focus-image"><i class="fa fa-cutlery"></i></div>
                            <h4 class="clrchg">厨房五金</h4>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-2 focus-grid">
                <a href="/web-consumer/garbage#parentVerticalTab9">
                    <div class="focus-border">
                        <div class="focus-layout">
                            <div class="focus-image"><i class="fa fa-diamond"></i></div>
                            <h4 class="clrchg">其他</h4>
                        </div>
                    </div>
                </a>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="trending-ads">
        <div class="container">
            <!-- slider -->
            <div class="trend-ads">
                <h2>废品回收概况</h2>
                <ul id="flexiselDemo3">
                    <li>
                        <div class="col-md-3 biseller-column">
                            <a href="single.html">
                                <img src="/web-consumer/static/images/p1.jpg"/>
                                <span class="price">&#36; 450</span>
                            </a>
                            <div class="ad-info">
                                <h5>朝阳区李女士</h5>
                                <span>1小时前</span>
                            </div>
                        </div>
                        <div class="col-md-3 biseller-column">
                            <a href="single.html">
                                <img src="/web-consumer/static/images/p2.jpg"/>
                                <span class="price">&#36; 399</span>
                            </a>
                            <div class="ad-info">
                                <h5>江宁区欧学长</h5>
                                <span>3小时前</span>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="col-md-3 biseller-column">
                            <a href="single.html">
                                <img src="/web-consumer/static/images/p1.jpg"/>
                                <span class="price">&#36; 450</span>
                            </a>
                            <div class="ad-info">
                                <h5>There are many variations of passages</h5>
                                <span>1 hour ago</span>
                            </div>
                        </div>
                        <div class="col-md-3 biseller-column">
                            <a href="single.html">
                                <img src="/web-consumer/static/images/p2.jpg"/>
                                <span class="price">&#36; 399</span>
                            </a>
                            <div class="ad-info">
                                <h5>Lorem Ipsum is simply dummy</h5>
                                <span>3 hour ago</span>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <!-- //slider -->
    </div>
</div>
</@override>
<@override name="js">
<script type="text/javascript">
    // 轮播图初始化
    $(window).load(function () {
        $("#flexiselDemo3").flexisel({
            visibleItems: 1,
            animationSpeed: 1000,
            autoPlay: true,
            autoPlaySpeed: 5000,
            pauseOnHover: true,
            enableResponsiveBreakpoints: true,
            responsiveBreakpoints: {
                portrait: {
                    changePoint: 480,
                    visibleItems: 1
                },
                landscape: {
                    changePoint: 640,
                    visibleItems: 1
                },
                tablet: {
                    changePoint: 768,
                    visibleItems: 1
                }
            }
        });
    });
</script>
</@override>
<@extends name="layout.ftl"/>
