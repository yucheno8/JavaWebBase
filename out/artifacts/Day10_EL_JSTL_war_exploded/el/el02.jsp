<%--
  Created by IntelliJ IDEA.
  User: yucheno8-PC
  Date: 2023/10/7/007
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>
    <%
        // 在域中存储数据
        session.setAttribute("name", "李四");

        request.setAttribute("name", "张三");
        session.setAttribute("age", "23");

        request.setAttribute("str", "");
    %>

    <h3>el获取值</h3>
    ${requestScope.name}
    ${sessionScope.age}
    ${sessionScope.haha}
    ${sessionScope.name}
</body>
</html>
