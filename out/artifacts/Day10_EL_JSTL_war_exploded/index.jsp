<%@ page contentType="text/html; charset=gbk" pageEncoding="GBK" errorPage="500.jsp" language="java" buffer="16kb" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
  <%
    List<String> list = new ArrayList<>();
    int i = 3 / 0;
  %>

  <c
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>