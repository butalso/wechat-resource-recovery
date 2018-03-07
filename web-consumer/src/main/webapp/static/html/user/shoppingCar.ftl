<@override name="content">
    <!-- Services -->
    <div class="total-ads main-grid-border">
        <div class="container">
            <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
                <div id="myTabContent" class="tab-content">
                    <div role="tabpanel" class="tab-pane fade in active" id="home" aria-labelledby="home-tab">
                        <div id="container">
                            <div class="clearfix"></div>
                            <ul class="list">
                                <li>
                                    <section class="list-left">
                                        <h5 class="title">废报纸</h5>
                                        <p class="catpath">单价：7元/kg</p>
                                    </section>
                                    <section class="list-right">
                                        <span class="date">重量100KG</span>
                                        <span class="cityname">删除</span>
                                    </section>
                                    <div class="clearfix"></div>
                                </li>
                            </ul>
                            <div>
                                <button type="button" class="btn btn-default btn-lg btn-block" name="button">下单</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <!-- // Services -->
</@override>

<@override name="js">
<script src="/web-consumer/static/index/shoppingCar.js"></script>
</@override>
<@extends name="layout.ftl"/>
