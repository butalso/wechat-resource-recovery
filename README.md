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

# 接口规范
运行项目，访问http://localhost:8000/web-consumer/swagger-ui.html
## 说明
###userKind:
0->业主,1->回收员,2->企业

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
"废纸":[
{"name": "废书纸",
"weight": "0.5"
},
{"name": "废报纸",
"weight" : "0.7"
}
]
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
[
    {
    "orderId": 22,
    "name": "废纸箱",
    "weight": 22.5
    },
    ...
]

##### 10、/order/confirm
post 请求 <br>
请求头：Content-Type:application/json
{
	"orderId": 5,
	"grade": 3
}

##### 11、 /account/info
get 请求 <br>
返回 空字符串 或 
{
    "wechatId": "听妈妈的话",
    "balance": 0
}

##### 12、 /account/create
请求头：Content-Type:application/x-www-form-urlencoded <br>
post 请求
password:123456、
wechatId:听妈妈的话 <br>

结果 返回 "添加账户成功"或"账户已存在"

##### 13、 /account/update
请求头：Content-Type:application/x-www-form-urlencoded <br>
post 请求
wechatId:听爸爸的话 <br>

结果 返回 "修改账户成功"。

##### 13、 /account/password
请求头：Content-Type:application/x-www-form-urlencoded <br>
post 请求
oldPass:123456、
newPass:123456 <br>

结果 返回 "密码修改成功"或"旧密码不正确" <br>

##### 14、 /account/withdraw

请求头：Content-Type:application/x-www-form-urlencoded <br>
post 请求
value: 200 <br>
结果 返回 "充值提现成功"或"充值提现失败"

##### 15、 /address/linkage
get 请求（可选参数）
province:广东省、
city:湛江市、
area:雷州市 <br>

结果 字符串数组

##### 16、 /address/housingEstate
post 请求
{
	"province": "广东省",
	"city": "湛江市",
	"area": "雷州市",
	"housingEstate": "天庭"
}

# 拦截器：
## 1、Login
未登录状态拦截，重定向到login页面：
### 匹配路径
/user/info <br>


