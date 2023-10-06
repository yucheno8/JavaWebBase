<%--
  Created by IntelliJ IDEA.
  User: yucheno8-PC
  Date: 2023/10/6/006
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h1><%=request.getSession().getAttribute("user")%>，欢迎您！</h1>
</body>
</html>
