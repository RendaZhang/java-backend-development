<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/1
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="anno/testRequestParam?username=RendaZhang">RequestParam</a>

    <br>

    <form action="anno/testRequestBody" method="post">
        姓名：<input type="text" name="name" /><br/>
        年龄：<input type="text" name="age" /><br/>
        <input type="submit" value="提交"/>
    </form>

    <br>

    <a href="anno/testPathVariable/11">testPathVariable</a>

    <br>

    <a href="anno/testRequestHeader">requestHeader</a>

    <br>

    <a href="anno/testCookieValue">testCookieValue</a>

    <br>

    <form action="anno/testModelAttribute" method="post">
        姓名：<input type="text" name="name" /><br/>
        年龄：<input type="text" name="age" /><br/>
        <input type="submit" value="提交"/>
    </form>

    <a href="anno/testSessionAttributes">testSessionAttributes</a>

    <br>

    <a href="anno/getSessionAttributes">getSessionAttributes</a>

    <br>

    <a href="anno/delSessionAttributes">delSessionAttributes</a>

    <br>

</body>
</html>
