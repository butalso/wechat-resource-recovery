<@override name="content">
    <section>
        <div id="page-wrapper" class="sign-in-wrapper">
            <div class="graphs">
                <div class="sign-in-form">
                    <div class="sign-in-form-top">
                        <h1>登录</h1>
                    </div>
                    <div class="signin">
                        <form id="loginForm">
                            <div class="log-input">
                                <div class="log-input-left">
                                    <input type="text" class="user" name="userName" placeholder='账户'/>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="log-input">
                                <div class="log-input-left">
                                    <input type="password" class="lock" name="password" placeholder='密码'/>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="userKind" value=0 checked>我是业主
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="userKind" value=1>我是回收员
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="userKind" value=2>我是企业
                                </label>
                            </div>
                            <input type="button" id="loginBtn" value="登录">
                        </form>
                    </div>
                    <div class="new_people">
                        <h2>送给新朋友</h2>
                        <p>在这方面，我们很熟练</p>
                        <a href="/web-consumer/register">现在注册</a>
                    </div>
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
<script src="/web-consumer/static/index/login.js"></script>
</@override>
<@extends name="layout.ftl"/>
