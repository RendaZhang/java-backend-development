<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/1
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Success</title>
</head>
<body>

    <h3>访问成功</h3>

    'msg' from ReuestScope: <br>
    ${ msg } <br>
    ${ requestScope.msg }

    <br><br>

    'msg' from SessionScop: <br>
    ${ sessionScope.msg }

</body>
</html>
