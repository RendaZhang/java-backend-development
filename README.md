## Java后台开发：Java框架，JavaWeb以及数据库相关的代码。*持续更新中...*
***
### 环境简述：
- 使用了Intellij Idea作为后台开发工具，HBuilder X 作为前端开发工具
- 使用了Maven作为项目管理工具
- 使用了Postman进行Rest相关的测试
- 模拟服务器搭建在跟开发同一个电脑使用localhost连接，或者使用虚拟机（LinuxCentOS6）搭建服务器，或者使用另外一台双系统（LinuxUbuntu18+Windows10）的电脑来搭建服务器，连接的都是同一个WIFI。
    - 使用FileZilla作为FTP软件传输开发部署相关的文件。
    - 使用secureCRT在Windows下登录UNIX或Linux服务器主机
***
### 文件简介：
+ `demo`：各种Demo代码练习
    + `IntelliJ_IDEA`: 混合练习。
    + `RendaTest`: Idea的模块化, Tomcat的三大组件（Filter,listener,servlet）, Redis内存数据库，数据库连接池C3P0和Druid测试
    + `demo-vue/hello-vue`: 基于nodejs的MVVM前端框架的Vuejs的相关练习
    + `hello-spring-elasticsearch`: Spring Data ElasticSearch的使用练习
    + `hello_jdbcoracle`: Oracle数据库的连接jdbc配置测试获取数据，存储过程，函数调用。
    + `hello_jndi`: 使用jndi作为MyBatis的数据源类型
    + `hello_maven`: 测试Maven项目的功能
    + `hello_mybatis`: 使用MyBatis框架，MySql数据库，InnoDB存储引擎
    + `hello_spring`: 测试Spring框架的IoC和AOP功能
    + `hello_springboot`: 整合SpringBoot和SpringCloud微服务框架
    + `hello_springmvc`: 使用SpringMVC框架
    + `hello_ssm`: 整合Spring, SpringMCV, MyBatis三大框架
    + `thymeleaf-demo`: 服务器端Java模板引擎Thymeleaf的练习使用
+ `测试数据和配置文件`: MySQL, Oracle的sql测试语句；ElasticSearch 的测试语句；Nginx的配置文件。
+ `xxx-manage-web`: xxx商城项目的后台管理系统的前端代码。基于vuejs的单页应用；使用Vuetify前端脚手架；使用ajax框架axios进行Rest请求；使用webpack加载打包代码。
+ `xxx-portal`: xxx商城的门户系统的前端代码。基于原生态Web(HTML+CSS+JS+JQuery)的多页应用；嵌入了vuejs进行开发；使用live-server实现开发时的热部署。
+ `xxx`: xxx商城项目的后端代码。
***
### 补充：
- 使用了Nginx根据域名进行反向代理，对应关系：
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
            <td>图片服务器，默认端口22122</td>
        </tr>
        <tr align="left">
            <td>manage.xxx.com</td>
            <td>后台管理系统服务器，默认端口9091</td>
        </tr>
        <tr align="left">
            <td>www.xxx.com</td>
            <td>门户系统服务器，默认端口9002</td>
        </tr>"
        <tr align="left">
            <td>www.xxx.com/item</td>
            <td>静态页微服务，默认端口8084</td>
        </tr>
        <tr align="left">
            <td>api.xxx.com</td>
            <td>网关微服务，默认端口10010</td>
        </tr>
        <tr align="left">
            <td>api.xxx.com/api/upload</td>
            <td>图片上传微服务，默认端口8082</td>
        </tr>
        <tfoot>
            <td colspan="2">
                <ol>
                    <li>使用Nginx对门户系统的商品详情请求进行监听，并指向本地Nginx的静态页面。如果本地没找到请求的页面, 把以/item开头的商品详情请求，反向代理到静态页微服务。</li>
                    <li>在Nginx把经过网关微服务的以/api/upload开头的请求，转到图片上传微服务的真实地址。</li>
                </ol>
            </td>
        </tfoot>
    </tbody>
</table>

- 网关微服务 (xxx-gateway) 使用Zuul网关或者GateWay网关。
    + 使用了CorsFilter解决跨域问题，Rest请求需要配置对应的域名，否则使会返回403 - Invalid CORS request。
    + 搜索微服务和商品微服务都经过网关，但是忽略了图片上传微服务，避免了高并发时的网络堵塞。
        + 搜索微服务 -- api.xxx.com/search 默认端口8083
        + 商品微服务 -- api.xxx.com/item 默认端口8081
- 图片服务器使用了FastDFS分布式文件系统，配置在Linux虚拟机中或者另外一台电脑里。
- 图片上传微服务 (upload-service) 提供上传图片到图片服务器的服务
    + 因为绕过了网关，重新配置CorsFilter
- 搜索微服务 (search-service) 使用了ElasticSearch全文搜索引擎作为搜索服务器，提高了检索响应时间，配置在Linux虚拟机或另外一台电脑里。
- 静态页微服务 (goods-web) 使用Thymeleaf实现静态化。
    + 静态的HTML页面部署在本地Nginx中，从而大大提高并发能力，减小tomcat压力。
    + 静态页微服务可以用来展示浏览量比较大而且并发高的商品详情页面。
- 商品微服务 (item-service) 使用mySQL作为基础的数据库，提供了存取数据库中的数据的服务。为了处理效率，使用了Hikari作为数据库连接池，另外做了一些数据库表的优化：
    + 数据库中避免使用Foreign Key（外键），通过在Service业务逻辑里面维护相关联的两张表；
    + 把一个逻辑表中数据很大的元素拆分出来成为一个独立的存储在SQL数据库的表，增加了查询效率；
    + 把一个逻辑表中‘写’频率较高的元素拆分出来成为一个独立的存储在SQL数据库的表，减少读写之间的干扰；
    + 使用了电商中的SKU和SPU的概念作为相关表的设计


