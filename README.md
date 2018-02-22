# 开发工作流

1. 在master分支上，运行`git pull`
2. 跑一遍测试，通常来说都是不会出错误的。
3. 新建分支`feature`，然后在新分支上开发自己的功能。分支命名通常用`-`来连接单词，建议以功能或者行为来命名。
4. 在自己的`feature`分支上可以多次commit，还可以push到远端（github），以便下次可能在另一台设备开发以及防止本地文件丢失。
5. 当`feature`分支功能开发完毕（包括业务逻辑开发和单元测试），测试通过后，运行`git push`或`git push origin feature`到远端，在github网页端申请合并到master分支（MR, Merge Request）。
6. 合并后远程会删掉这个`feature`分支，而你的工作也进入到下一阶段，checkout到master，重复第一步

注意：

1. 以上`feature`分支只是代指，不要用feature这个单词直接命名分支。
2. 第一次直接使用`git push origin feature`时，远端并没有对应的分支，所以要加一个`-u`或`--set-upstream`来指定上游分支，即`git push -u origin feature`。之后就可以直接`git push origin feature`。
3. 如果直接运行`git push`，git提供了两种方式，simple模式是push当前所在分支，matching模式将会把你本地所有分支push到远端对应的分支，比较危险。建议使用simple模式，运行`git config --global push.default simple` 即可。这样你在`feature`分支下，运行`git push origin feature`可以简写为`git push`。
4. 全程要有一种思想，测试一定要通过，再考虑commit和MR。但测试不是万能的，实际在网页端手动功能测试也是必要的。虽然也是可以自动化功能测试，但考虑到时间精力，暂时不采用。

# 模块说明
## service-api模块：
定义web所需要的接口，把数据库操作和web操作分开。

## service-provider：
定义了数据库操作，并把数据库操作封装进service-api接口。是dubbo服务
的提供者。

## web-consumer：
web模块，dubbo服务的消费者。调用service-api提供的接口，处理web请求，
页面跳转等。（页面放入/WEB-INF/html下，依赖的js，css，image之类放
入static文件下）


### 接口规范（使用谷歌浏览器插件postman测试）：
#### userKind:
0->业主,1->回收员,2->企业

#### 路径
##### 1、/ 
get请求 <br>
结果：返回index.html <br>

##### 2、/login: <br>
get请求 <br>
结果： 返回login.html

(ajax)post请求 <br>
参数例子：userName:狙击手,
        password:123456,
        userKind:0(还有1或2)<br>
        
结果：401 用户不存在,
     401 密码错误,
     200 登录成功<br>

##### 3、/logout
get 请求 <br>
结果： 重定向到index.html <br>

##### 4、/register
get 请求 <br>
结果： 注册页面 <br>

(ajax)post 请求 <br>
请求体：

结果： 添加用户，返回注册成功

###### 4、/user/info

get请求  <br>
结果： 返回 customer.html或collector.html或company.html <br>

(ajax)post请求 <br>
请求头：Content-Type:application/json
请求体：
业主：
{
    "name": "小华仔",
    "phone": "15867620882",
    "address": {
        "province": "广东省",
        "city": "湛江市",
        "area": "雷州市",
        "housingEstate": "召唤森林"
    },
    "userKind": 0,
    "nickName": "狙击手",
    "gender": "F"
} <br>

回收员：
{
    "name": "问自己",
    "phone": "13822105068",
    "address": {
        "province": "广东省",
        "city": "湛江市",
        "area": "雷州市",
        "housingEstate": "青青草原"
    },
    "userKind": 1,
    "nickName": "巫医",
    "companyName": "回收哥",
    "gender": "M",
    "idcardNo": "130682199005066998"
} <br>

企业：
{
    "name": "回收哥哥",
    "phone": "13825672120",
    "address": {
        "province": "广东省",
        "city": "湛江市",
        "area": "遂溪县"
    },
    "addrDetail": "西湖大道18号"
} <br>

##### 5、/user/info/detail
(ajax)get 请求 <br> 
结果：
业主：
{
    "name": "小华",
    "phone": "15867620882",
    "createTime": "2018-02-10 22:11:05",
    "address": {
        "province": "广东省",
        "city": "湛江市",
        "area": "雷州市",
        "housingEstate": "召唤森林"
    },
    "userKind": 0,
    "nickName": "狙击手",
    "gender": "M",
    "credit": 500
} <br>

回收员：
{
    "name": "问自己",
    "phone": "13822105068",
    "createTime": "2018-02-10 22:15:09",
    "address": {
        "province": "广东省",
        "city": "湛江市",
        "area": "雷州市",
        "housingEstate": "天辉阵营"
    },
    "userKind": 1,
    "nickName": "巫医",
    "companyName": "回收哥",
    "gender": "M",
    "credit": 500,
    "idcardNo": "130682199005066998"
} <br>

企业：
{
    "name": "回收哥",
    "phone": "13825672120",
    "createTime": "2018-02-10 22:15:10",
    "address": {
        "province": "广东省",
        "city": "湛江市",
        "area": "雷州市"
    },
    "userKind": 2,
    "addrDetail": "西湖大道8号"
} <br>

##### 5、/user/register
get 请求 <br>
返回 register.html <br>

post请求 <br>
请求头：Content-Type:application/json <br>

业主：
{
       "name": "小圣",
       "phone": "15867620882",
       "password": "123456",
       "address": {
           "province": "广东省",
           "city": "湛江市",
           "area": "雷州市",
           "housingEstate": "召唤森林"
       },
       "userKind": 0,
       "nickName": "圣坛刺客",
       "gender": "F"
}<br>

回收员：
{
    "name": "问月",
    "phone": "13822105068",
    "password": "123456",
    "address": {
        "province": "广东省",
        "city": "湛江市",
        "area": "雷州市",
        "housingEstate": "天辉阵营"
    },
    "userKind": 1,
    "nickName": "巫妖",
    "companyName": "回收哥",
    "gender": "M",
    "idcardNo": "130682199005066998"
} <br>

企业：
{
    "name": "回收弟",
    "phone": "13825672120",
    "password": "123456",
    "address": {
        "province": "广东省",
        "city": "湛江市",
        "area": "雷州市"
    },
    "userKind": 2,
    "addrDetail": "雷南大道8号"
} <br>

##### 6、/order/info
get 请求 <br>
结果：
[
    {
            "id": 10,
            "address": {
                "province": "广东省",
                "city": "湛江市",
                "area": "雷州市",
                "housingEstate": "召唤森林"
            },
            "createTime": "2018-02-12 21:24:37",
            "finishTime": "2018-02-12 21:24:37",
            "stateInfo": "回收员已接单",
            "customerName": "狙击手",
            "collectorName": "恐怖利刃",
            "companyName": "回收哥",
            "userGrade": 0,
            "collectorGrade": 0,
            "map": {
                "Garbage{id=1, typeName='废纸', name='废报纸', price=0.8}": 4.5,
                "Garbage{id=2, typeName='废纸', name='废纸箱', price=0.5}": 13.5,
                "Garbage{id=3, typeName='废纸', name='废书纸', price=0.6}": 12.5
            }
        },
        ...
] <br>


##### 7、/order/create
post 请求 <br>
请求头：Content-Type:application/json
{
	"废书纸": 5.5,
	"废报纸": 10
}

##### 8、/order/receive
post 请求 <br>
"orderId": 5

##### 9、/order/new
get 请求 <br>
[
        {
            "id": 11,
            "address": {
                "province": "广东省",
                "city": "湛江市",
                "area": "雷州市",
                "housingEstate": "召唤森林"
            },
            "createTime": "2018-02-22 19:17:54",
            "finishTime": "2018-02-22 19:17:54",
            "stateInfo": "订单已创建",
            "customerName": "狙击手",
            "userGrade": 0,
            "collectorGrade": 0,
            "map": {
                "Garbage{id=3, typeName='废纸', name='废书纸', price=0.6}": 5.5,
                "Garbage{id=1, typeName='废纸', name='废报纸', price=0.8}": 10
            }
        },
        ...
]

##### 10、/order/update
post 请求 <br>
请求头：Content-Type:application/json
{
	"orderId": 10,
	"garbages": {
		"废书纸": "15.5",
		"废报纸": "100"
	}
}

##### 10、/order/confirm
post 请求 <br>
请求头：Content-Type:application/json
{
	"orderId": 5,
	"grade": 3
}

# 拦截器：
## 1、Login
未登录状态拦截，重定向到login页面：
### 匹配路径
/user/info <br>


