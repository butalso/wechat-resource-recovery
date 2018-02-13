service-api模块：
定义web所需要的接口，把数据库操作和web操作分开。

service-provider：
定义了数据库操作，并把数据库操作封装进service-api接口。是dubbo服务
的提供者。

web-consumer：
web模块，dubbo服务的消费者。调用service-api提供的接口，处理web请求，
页面跳转等。（页面放入/WEB-INF/html下，依赖的js，css，image之类放
入static文件下）

接口规范（使用谷歌浏览器插件postman测试）：
1、/
get请求
返回index.html

2、/login:
post请求 
参数例子：userName:狙击手
        password:123456
        userKind:customer
        
结果：401 用户不存在
     401 密码错误
     200 登录成功

3、/logout
get 请求
结果： 重定向到index.html

4、/{userKind}/{nickName}/personal
如http://localhost:8000/web-consumer/customer/狙击手/personal

get请求 
结果例子（还没有页面，先返回json，有需要再商量）：
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
    "nickName": "狙击手",
    "gender": "M",
    "credit": 500
}

post请求



拦截器：
1、Login
未登录状态拦截，返回 “用户未登录”：
/**/**/personal/**

登录拦截，修改返回json

