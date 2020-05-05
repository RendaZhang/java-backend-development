<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/24
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Hello</title>
</head>
<body>
    Hello JSP.
    <c:forEach begin="0" end="10" var="i" step="1" varStatus="s">
        ${i} ${key} ${s.index} ${s.count}
    </c:forEach>

</body>
</html>
