<%--
  Created by IntelliJ IDEA.
  User: yucheno8-PC
  Date: 2023/10/7/007
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="top.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- <h1>hello</h1> --%>
    <h3>主体信息</h3>

    <%--
        <%
            System.out.println("hi~~~");
        %>
    --%>
    <%-- <input> --%>

    <%
        pageContext.setAttribute("msg", "hello");
    %>

    <%=
        pageContext.getAttribute("msg")
    %>
</body>
</html>
