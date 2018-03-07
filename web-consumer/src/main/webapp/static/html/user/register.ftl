<@override name="content">
    <section>
        <div id="page-wrapper" class="sign-in-wrapper">
            <div class="graphs">
                <div class="sign-up">
                    <form id="registerForm">
                        <h1>注册一个新帐户</h1>
                        <p class="creating">在这方面，我们很熟链</p>
                        <h2>个人信息</h2>
                        <div class="sign-u">
                            <div class="sign-up1">
                                <h4>帐号* :</h4>
                            </div>
                            <div class="sign-up2">
                                <input type="text" class="user" name="userName" placeholder='账户'/>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="sign-u">
                            <div class="sign-up1">
                                <h4>密码* :</h4>
                            </div>
                            <div class="sign-up2">
                                <input type="password" class="lock" name="password" placeholder='密码'/>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="sign-u">
                            <div class="sign-up1">
                                <h4>确认密码* :</h4>
                            </div>
                            <div class="sign-up2">
                                <input type="password" class="lock" name="confirmPassword" placeholder='确认密码'/>
                            </div>
                            <div class="clearfix"></div>
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
