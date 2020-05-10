## Java后台开发：Java框架，JavaWeb以及数据库相关的代码。*持续更新中...*
***
### 环境简述：
- 使用了Intellij Idea作为后台开发工具，HBuilder X 作为前端开发工具
- 使用了Maven作为项目管理工具
- 使用了Postman进行Rest相关的测试
- 模拟服务器搭建在跟开发同一个电脑使用localhost连接，或者使用虚拟机（LinuxCentOS6）搭建服务器，或者使用另外一台双系统（LinuxUbuntu18+Windows10）的电脑来搭建服务器，连接的都是同一个WIFI。
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
+ `sql数据和其它数据测试`: MySQL, Oracle的sql测试语句。ElasticSearch 的测试语句。
+ `xxx-manage-web`: xxx商城项目的后台管理系统的前端代码。基于vuejs的单页应用；使用Vuetify前端脚手架；使用webpack加载打包代码
+ `xxx-portal`: xxx商城的门户系统的前端代码。基于原生态Web(HTML+CSS+JS+JQuery)的多页应用；使用live-server实现开发时的热部署。
+ `xxx`: xxx商城项目的后端代码。
***
### 补充：
- 使用了Nginx根据域名进行反向代理，对应关系：
    + manage.xxx.com -- 后台管理系统ip : 端口9091
    + www.xxx.com -- 门户系统ip : 端口9002
    + api.xxx.com -- 网关服务ip : 端口10010
    + image.xxx.com -- 图片服务器 本地路径
- 为避免网络阻塞网关服务忽略了upload-service服务（上传图片到图片服务器的服务）
- 后台使用了CorsFilter解决跨域问题，Rest请求需要用对应的域名，否则使用ip地址会返回403 - Invalid CORS request。
- 使用FastDFS分布式文件系统来配置图片服务器，配置在Linux虚拟机中或者另外一台电脑里。
- 为了处理效率，做了一些数据库表的优化：
    + 数据库中避免使用Foreign Key（外键），通过在Service业务逻辑里面维护相关联的两张表；
    + 把一个逻辑表中数据很大的元素拆分出来成为一个独立的存储在SQL数据库的表，增加了查询效率；
    + 把一个逻辑表中‘写’频率较高的元素拆分出来成为一个独立的存储在SQL数据库的表，减少读写之间的干扰；


