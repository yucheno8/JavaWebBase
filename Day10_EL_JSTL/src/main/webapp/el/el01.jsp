<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: yucheno8-PC
  Date: 2023/10/7/007
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    ${3 > 4}
    \${3 > 4}
<hr>

    <h3>算术运算符</h3>
    ${3 + 4}<br>
    ${3 / 4}<br>
    ${3 div 4}<br>
    ${3 % 4}<br>
    ${3 mod 4}<br>
    <h3>比较运算符</h3>
    ${3 == 4}<br>
    <h3>逻辑运算符</h3>
    ${3 > 4 && 3 < 4}<br>
    ${3 > 4 and 3 < 4}<br>

    <h4>empty运算符</h4>
    <%
        String str = null;
        request.setAttribute("str", str);

        List list = new ArrayList();
        request.setAttribute("list", list);
    %>

    ${not empty str}<br>

    ${not empty list}<br>
</body>
</html>
