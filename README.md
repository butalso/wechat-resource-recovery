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



