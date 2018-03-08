<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- basic styles -->

    <link rel="stylesheet" href="/web-consumer/static/css/bootstrapone.min.css" />
    <link rel="stylesheet" href="/web-consumer/static/css/font-awesomeone.min.css" />

    <!--[if IE 7]>
    <link rel="stylesheet" href="/web-consumer/static/css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!-- page specific plugin styles -->


    <!-- ace styles -->
    <link rel="stylesheet" href="/web-consumer/static/css/ace.min.css" />
    <link rel="stylesheet" href="/web-consumer/static/css/rtl.min.css" />
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="/web-consumer/static/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <!--<script src="assets/js/html5shiv.js"></script>-->
    <!--<script src="assets/js/respond.min.js"></script>-->
    <![endif]-->
</head>

<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="icon-leaf green"></i>
                            <span class="red">资源回收</span>
                            <span class="white">后台管理系统</span>
                        </h1>
                        <h4 class="blue">&copy;蓝鸥科技有限公司</h4>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-pencil green"></i>
                                        请输入你的信息
                                    </h4>

                                    <div class="space-6"></div>

                                    <form id="loginForm">
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon ">
															<i class="icon-user"></i>
															<input type="text" class="form-control" placeholder="账户" name="userName" />
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon ">
															<i class="icon-lock"></i>
															<input type="password" class="form-control" placeholder="密码" name="password" />
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon ">
															<input type="hidden" class="form-control"  name="userKind" value=3 />
														</span>
                                            </label>

                                            <div class="space"></div>

                                            <div class="clearfix">
                                                <label class="inline">
                                                    <input type="checkbox" class="ace" />
                                                    <span class="lbl">记住密码</span>
                                                </label>

                                                <button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="loginBtn">
                                                    <i class="icon-key"></i>
                                                    登录
                                                </button>
                                            </div>

                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>

                                    <div class="social-or-login center">
                                        <span class="bigger-110">使用第三方登录</span>
                                    </div>

                                    <div class="social-login center">
                                        <a  class="btn btn-info" href="otherLogin.html">
                                            <i class="icon-qq"></i>
                                        </a>

                                        <a class="btn btn-success">
                                            <i class="icon-wechat"></i>
                                        </a>

                                        <a class="btn btn-warning">
                                            <i class="icon-weibo"></i>
                                        </a>
                                    </div>
                                </div><!-- /widget-main -->

                                <div class="toolbar clearfix">
                                    <div>
                                        <a href="#"  class="forgot-password-link">
                                            <i class="icon-reply"></i>
                                            忘记密码
                                        </a>
                                    </div>

                                    <div>
                                        <a href="#" class="user-signup-link">
                                            注册账号
                                            <i class="icon-only icon-share-alt"></i>
                                        </a>
                                    </div>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /login-box -->

                        <div id="forgot-box" class="forgot-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header red lighter bigger">
                                        <i class="icon-key"></i>
                                        忘记密码
                                    </h4>

                                    <div class="space-6"></div>
                                    <p>
                                        Enter your email and to receive instructions
                                    </p>

                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Email" />
															<i class="icon-envelope"></i>
														</span>
                                            </label>

                                            <div class="clearfix">
                                                <button type="button" class="width-35 pull-right btn btn-sm btn-danger">
                                                    <i class="icon-lightbulb"></i>
                                                    Send Me!
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div><!-- /widget-main -->

                                <div class="toolbar center">
                                    <a href="#" class="back-to-login-link">
                                        返回登录界面
                                        <i class="icon-only icon-share-alt"></i>
                                    </a>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /forgot-box -->

                        <div id="signup-box" class="signup-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header green lighter bigger">
                                        <i class="icon-group blue"></i>
                                        New User Registration
                                    </h4>

                                    <div class="space-6"></div>
                                    <p> Enter your details to begin: </p>

                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Email" />
															<i class="icon-envelope"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Username" />
															<i class="icon-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Password" />
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Repeat password" />
															<i class="icon-retweet"></i>
														</span>
                                            </label>

                                            <label class="block">
                                                <input type="checkbox" class="ace" />
                                                <span class="lbl">
															I accept the
															<a href="#">User Agreement</a>
														</span>
                                            </label>

                                            <div class="space-24"></div>

                                            <div class="clearfix">
                                                <button type="reset" class="width-30 pull-left btn btn-sm">
                                                    <i class="icon-refresh"></i>
                                                    Reset
                                                </button>

                                                <button type="button" class="width-65 pull-right btn btn-sm btn-success">
                                                    Register
                                                    <i class="icon-only icon-share-alt"></i>
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>

                                <div class="toolbar center">
                                    <a href="#" class="back-to-login-link">
                                        <i class="icon-only icon-share-alt"></i>
                                        返回登录界面
                                    </a>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /signup-box -->
                    </div><!-- /position-relative -->
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div>
</div><!-- /.main-container -->
<!-- basic scripts -->

<!--[if !IE]> -->

<script src="/web-consumer/static/manager/jquery-2.0.3.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="/web-consumer/static/manager/jquery-1.10.2.min.js"></script>
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='/web-consumer/static/manager/jquery-2.0.3.min.js'>"+"<"+"script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='/web-consumer/static/manager/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->

<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='/web-consumer/static/manager/jquery.mobile.custom.min.js'>"+"<"+"script>");
</script>

<script type="text/javascript" src="/web-consumer/static/manager/project/login.js"></script>

</body>
</html>