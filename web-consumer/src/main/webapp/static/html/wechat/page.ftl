<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>homepage</title>

    <style>
        .top {
            float: left;
            width: 100%;
            position: relative;
        }

        .item {
            display: block;
            width: 100%;
            height: 180px;
            background-size: cover;
            background-image: url('/web-consumer/static/html/wechat/images/2663a7076cfea496b07d493c6539cdb0.jpg')
        }

        .item p {
            position: absolute;
            left: 0;
            right: 0;
            bottom: 0;
            height: 0.4em;
            font-size: 16px;
            padding: 20px 50px 12px 13px;
            color: #fff;
        }

        .tab div {
            height: 44px;
            line-height: 44px;
            box-sizing: border-box;
            width: 33.33%;
            text-align: center;
            float: left;
        }

        .tab .active {
            color: #21b100;
        }

        .tab::after {
            content: '';
            display: block;
            clear: both;
        }

        .article {
            display: block;
            padding: 15px 15px 10px 10px;
            overflow: hidden;
            position: relative;
            text-decoration: none;
        }

        .article .cover {
            float: left;
            margin-right: 10px;
        }

        .article .cover img {
            display: block;
            width: 80px;
            height: 60px;
        }

        .article .cont {
            overflow: hidden;
        }

        .article .cont .title {
            margin: 0px;
            font-weight: 400;
            font-size: 16px;
            color: #000;
            width: 100%;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            word-wrap: normal;
        }

        .article .cont .desc {
            margin: 0px;
            font-size: 13px;
            color: #999;
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-box-orient: vertical;
            -webkit-line-clamp: 2;
            line-height: 1.3;
        }
    </style>
</head>

<body>
    <div class="top">
        <a class="item" href="">

            <p></p>
        </a>
    </div>

    <div class="tab">
        <div class="active">最新消息</div>
        <div>国外情况</div>
        <div>国内情况</div>
    </div>

    <div class="article-list">
        <a class="article" href="https://m.baidu.com/from=1012852s/bd_page_type=1/ssid=0/uid=0/pu=usm%403%2Csz%401320_1004%2Cta%40iphone_2_4.4_11_9.5/baiduid=CE38537E1815617CAA8B6F1834210965/w=0_10_/t=iphone/l=3/tc?ref=www_iphone&lid=7458030116973229810&order=19&fm=alop&srd=1&dict=32&otn=1&tj=insp_normal_19_0_10_l1&wd=&eqid=67803ee0865ab800100000065acf5f29&w_qd=IlPT2AEptyoA_yk5seEctvqxJyFUg8cpqVANage&tcplug=1&sec=29005&di=7c148907d88dc206&bdenc=1&tch=124.98.27.3285.1.680&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ztFAz3vo935h3KlItgfEFXwLmiHZpPPs8GAashXtXLR0WYn7hF0u_9StGdu9nqxbPTthB4LGRB3qgph0dCWISVw6Oqb7qgewQ2fBg--KDS&clk_info=%7B%22srcid%22%3A28341%2C%22tplname%22%3A%22insp_normal%22%2C%22t%22%3A1523539838638%2C%22xpath%22%3A%22div-div-div-a-h3%22%7D&sfOpen=1">
            <div class="cover">
                <img src="/web-consumer/static/html/wechat/images/b00919fe0c96b0fda9831e15daf039fa.jpg" />
            </div>
            <div class="cont">
                <h2 class="title">废品怎么分类</h2>
                <p class="desc">红色，表示堆放有害垃圾；蓝色表示堆放可回收物；绿色表示堆放厨房垃圾；蓝色表示可回收垃圾。不仅如此，分类垃圾桶的标识统一采用白色，正面有指示性标识，下面还有解释性标识和文字说明。
                </p>
            </div>
        </a>

        <a class="article" href="">
                <div class="cover">
                    <img src="/web-consumer/static/html/wechat/images/14810f943a1c42b0bb4ee7b1d3cd71d1.jpg" />
                </div>
                <div class="cont">
                    <h2 class="title">塑料回收</h2>
                    <p class="desc">塑料回收是指采用一定的回收工艺将废弃塑料回收再利用实现变废为宝的目的。目前我国废弃塑料主要为塑料薄膜、塑料丝及编织品、泡沫塑料、塑料包装箱及容器、日用塑料制品、塑料
                    </p>
                </div>
        </a>

        <a class="article" href="">
            <div class="cover">
                <img src="/web-consumer/static/html/wechat/images/b00919fe0c96b0fda9831e15daf039fa.jpg" />
            </div>
            <div class="cont">
                <h2 class="title">回收与可持续发展</h2>
                <p class="desc">再生资源回收以物资不断循环利用的经济发展模式，目前正在成为全球潮流。可持续发展的战略，得到大家一致同意。可持续发展就是，既符合当代人类的需求，又不致损害后代人满足其需求能力的发展，是我们在注意经济增长的数量，同时要注意追求经济增长的质量。主要的标志是资源能够永远利用，保持良好的生态环境。
                </p>
            </div>
        </a>
    </div>

</body>

</html>