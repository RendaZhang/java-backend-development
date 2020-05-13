## Java 后台开发：Java 框架，JavaWeb 以及数据库相关的代码。*持续更新中...*
***
### 环境简述：
- 使用了 Intellij Idea 作为后台开发工具，HBuilder X 作为前端开发工具
- 使用了 Maven 作为项目管理工具
- 使用了 Postman 进行 Rest 相关的测试
- 模拟服务器可以选择搭建在跟开发同一个电脑使用 localhost 连接，或者使用虚拟机 (Linux CentOS6) 搭建服务器，或者使用另外一台双系统 (Linux Ubuntu18 + Windows10) 的电脑来搭建服务器，连接的都是同一个 WIFI。
    - 使用 FileZilla 作为 FTP 软件传输开发部署相关的文件。
    - 使用 secureCRT 在 Windows 下登录 UNIX 或 Linux 服务器主机
***
### 文件简介：
+ `demo`：各种 Demo 代码练习
    + `IntelliJ_IDEA`: 混合练习
    + `RendaTest`: Idea 的模块化, Tomcat 的三大组件 (Filter, listener, servlet), Redis内存数据库，数据库连接池 C3P0 和 Druid 测试
    + `demo-vue/hello-vue`: 基于 nodejs 的 MVVM 前端框架的 Vuejs 的相关练习
    + `hello-spring-elasticsearch`: Spring Data ElasticSearch 的使用练习
    + `hello_jdbcoracle`: Oracle 数据库的连接 jdbc 配置测试获取数据，存储过程，函数调用
    + `hello_jndi`: 使用 jndi 作为 MyBatis 的数据源类型
    + `hello_maven`: 测试 Maven 项目的功能
    + `hello_mybatis`: 使用 MyBatis 框架，MySql 数据库，InnoDB 存储引擎
    + `hello_spring`: 测试 Spring 框架的 IoC 和 AOP 功能
    + `hello_springboot`: 整合 SpringBoot 和 SpringCloud 微服务框架
    + `hello_springmvc`: 使用 SpringMVC 框架
    + `hello_ssm`: 整合 Spring, SpringMCV, MyBatis 三大框架
    + `thymeleaf-demo`: 服务器端 Java 模板引擎 Thymeleaf 的练习使用
+ `测试数据和配置文件`: MySQL, Oracle 的 sql 测试语句；ElasticSearch 的测试语句；Nginx 的配置文件
+ `xxx-manage-web`: xxx 商城项目的后台管理系统的前端代码。基于 vuejs 的单页应用；使用 Vuetify 前端脚手架；使用 ajax 框架 axios 进行 Rest 请求；使用 webpack 加载打包代码
+ `xxx-portal`: xxx 商城的门户系统的前端代码。基于原生态 Web (HTML+CSS+JS+JQuery) 的多页应用；嵌入了 vuejs 进行开发；使用 live-server 实现开发时的热部署
+ `xxx`: xxx 商城项目的后端代码
***
### 补充：
- 反向代理web服务使用了 Nginx 网页服务器软件。 根据域名进行反向代理，对应关系：
<table border="1">
    <thead>
        <tr>
            <th>域名</th>
            <th>服务器</th>
        </tr>
    </thead>
    <tbody>
        <tr align="left">
            <td>image.xxx.com</td>
            <td>图片服务器，默认端口 22122</td>
        </tr>
        <tr align="left">
            <td>manage.xxx.com</td>
            <td>后台管理系统服务器，默认端口 9091</td>
        </tr>
        <tr align="left">
            <td>www.xxx.com</td>
            <td>门户系统服务器，默认端口 9002</td>
        </tr>"
        <tr align="left">
            <td>www.xxx.com/item</td>
            <td>静态页微服务，默认端口 8084</td>
        </tr>
        <tr align="left">
            <td>api.xxx.com</td>
            <td>网关，默认端口 10010</td>
        </tr>
        <tr align="left">
            <td>api.xxx.com/api/upload</td>
            <td>图片上传微服务，默认端口 8082</td>
        </tr>
        <tfoot>
            <td colspan="2">
                <ol>
                    <li>使用 Nginx 对门户系统的商品详情请求进行监听，并指向本地 Nginx 的静态页面。如果本地没找到请求的页面, 把以 /item 开头的商品详情请求，反向代理到静态页微服务。</li>
                    <li>在 Nginx 把经过网关微服务的以 /api/upload 开头的请求，转到图片上传微服务的真实地址。</li>
                </ol>
            </td>
        </tfoot>
    </tbody>
</table>
- 消息管理系统 (MQ) 使用 RabbitMQ 为底层的 Spring AMQP 框架。
    + 实现搜索微服务、商品静态页微服务的数据同步。
    + 实现异步发送方式进行短信发送，提高了程序的响应速度。
- 微服务注册中心 (xxx-registry) 使用 SpringCloud Eureka，默认端口10086。
    + 可以开启集群以增强可用性
    + 取消把注册中心自己注册到 Eureka 服务列表
    + 开发阶段关闭自我保护
- 网关 (xxx-gateway) 使用 Spring Cloud Zuul 网关或者 Spring Cloud GateWay 网关。
    + 使用了 CorsFilter 解决跨域问题，Rest 请求需要配置对应的域名，否则使会返回 403 - Invalid CORS request
    + 以下微服务都经过网关：
        + 搜索微服务 -- api.xxx.com/search 默认端口 8083
        + 商品微服务 -- api.xxx.com/item 默认端口 8081
        + 用户微服务 -- api.xxx.com/user 默认端口 8085
    + 网关忽略了图片上传微服务，避免了高并发时的网络堵塞
- 图片服务器使用了 FastDFS 分布式文件系统。
- 图片上传微服务 (upload-service) 提供上传图片到图片服务器的服务。
    + 绕过了网关，重新配置了 CorsFilter
- 搜索微服务 (search-service) 使用了 ElasticSearch 全文搜索引擎作为搜索服务器，提高了检索响应时间。
- 静态页微服务 (goods-web) 使用 Thymeleaf 实现静态化。
    + 静态的 HTML 页面部署在本地 Nginx 中，从而大大提高并发能力，减小 tomcat 压力
    + 静态页微服务可以用来展示浏览量比较大而且并发高的商品详情页面
- 商品微服务 (item-service) 使用mySQL作为基础的数据库，提供了存取数据库中的商品相关数据的服务。
    + 当商品微服务对商品进行写操作，需要发送商品 id 到 RabbitMQ，通知其它相关的微服务
    + 使用了 Hikari 作为数据库连接池，提高了在并发较高时候的响应能力
    + 另外做了一些数据库表的优化：
        + 数据库中避免使用 Foreign Key（外键），通过在 Service 业务逻辑里面维护相关联的两张表
        + 把一个逻辑表中数据很大的元素拆分出来成为一个独立的存储在 SQL 数据库的表，增加了查询效率
        + 把一个逻辑表中‘写’频率较高的元素拆分出来成为一个独立的存储在 SQL 数据库的表，减少读写之间的干扰
        + 使用了电商中的 SKU 和 SPU 的概念作为相关表的设计
- 用户微服务 (user-service) 为用户中心，实现基本的登录和注册以及其他与用户有关的功能
    + 使用面向接口的开发方式，实现数据校验，短信验证码，用户注册，根据用户名和密码查询用户
- 短信微服务 (sms-service) 实现短信发送功能，基于阿里云的短信服务。在阿里云充值了10块钱。
    + 为了安全起见，采用阿里云的RAM角色管理系统来控制 AccessKey 以及相关权限，开发测试完成后会移除相关权限。
    + 其它服务要发送短信时，通过MQ通知短信微服务；短信服务监听MQ消息，收到消息后发送短信。


