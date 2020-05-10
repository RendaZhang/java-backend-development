<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/1
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>
    <%--请求参数绑定--%>
   <%-- <a href="params/testParam?username=RendaZhang&password=1234">请求参数绑定</a>--%>

<%--    <form action="params/saveAccount" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        金额：<input type="text" name="money" /><br/>
        用户姓名：<input type="text" name="user.name" /><br/>
        用户年龄：<input type="text" name="user.age" /><br/>
        <input type="submit" value="提交"/>
    </form>--%>

<%--    <form action="params/saveAccount" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        金额：<input type="text" name="money" /><br/>

        用户姓名：<input type="text" name="list[0].name" /><br/>
        用户年龄：<input type="text" name="list[0].age" /><br/>

        用户姓名：<input type="text" name="map['one'].name" /><br/>
        用户年龄：<input type="text" name="map['one'].age" /><br/>
        <input type="submit" value="提交"/>
    </form>--%>

<%--    <form action="params/saveUser" method="post">
        姓名：<input type="text" name="name" /><br/>
        年龄：<input type="text" name="age" /><br/>
        生日：<input type="text" name="date" /><br/>
        <input type="submit" value="提交"/>
    </form>--%>

    <a href="params/testServlet">Servlet原生API</a>

</body>
</html>
