<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/2
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello SSM</title>
</head>
<body>

    <a href="account/findAll">测试查询</a> <br><br>

    <h3>测试保存</h3>

    <form action="account/save" method="post">
        姓名：<input type="text" name="name"/><br>
        金额：<input type="text" name="money"/><br>
        <input type="submit" value="保存"><br>
    </form>

</body>
</html>
