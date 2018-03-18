<@override name="content">
    <section>
        <div id="page-wrapper" class="sign-in-wrapper">
            <div class="graphs">
                <div class="sign-up">
                    <form class="form-horizontal">
                        <h1>注册一个新帐户</h1>
                        <p class="creating">在这方面，我们很熟链</p>
                        <h2>个人信息</h2>
                        <div class="form-group">
                            <label for="focusedinput" class="col-sm-2 control-label">name</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="focusedinput" class="col-sm-2 control-label">phone</label>
                            <div class="col-sm-8">
                                <input type="phone" class="form-control" name="phone">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="focusedinput" class="col-sm-2 control-label">password</label>
                            <div class="col-sm-8">
                                <input type="password" class="form-control1" name="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="focusedinput" class="col-sm-2 control-label">nickName</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control1" name="nickName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="province" class="col-sm-2 control-label">address</label>
                            <div class="col-sm-8">
                                <div class="col-sm-4 col-xs-4">
                                    <select name="province" class="form-control1"> </select>
                                </div>
                                <div class="col-sm-4 col-xs-4">
                                    <select name="city" class="form-control1"> </select>
                                </div>
                                <div class="col-sm-4 col-xs-4">
                                    <select name="area" class="form-control1"> </select>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" class="form-control1" name="userKind" value="0">
                        <div class="form-group">
                            <label for="focusedinput" class="col-sm-2 control-label">gender</label>
                            <div class="col-sm-8">
                                <div class="radio-inline">
                                    <label>
                                        <input type="radio" name="gender" value="F" checked>F
                                    </label>
                                </div>
                                <div class="radio-inline">
                                    <label>
                                        <input type="radio" name="gender" value="M">M
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="sub_home">
                            <div class="sub_home_left">
                                <form>
                                    <input type="button" id="registerBtn" value="注册">
                                </form>
                            </div>
                            <div class="sub_home_right">
                                <p>回到<a href="/web-consumer/index">主页</a></p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    <@override name="footer">
        <!--footer section start-->
        <footer class="diff">
            <p class="text-center">没什么版权，都是抄的</p>
        </footer>
        <!--footer section end-->
    </@override>

</@override>

<@override name="js">
<script src="/web-consumer/static/index/register.js"></script>
</@override>
<@extends name="layout.ftl"/>
