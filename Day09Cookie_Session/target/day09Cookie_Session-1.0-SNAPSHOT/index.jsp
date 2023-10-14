<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
    <h1><%= "Hello World!" %></h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>


    <%
        System.out.println("hello jsp");
        int i = 5;
        String contextPath = request.getContextPath(); // day09Cookie_Session
        out.print(contextPath);
    %>
    <% response.getWriter().write("response"); %>


    <%!
        int i = 3;
    %>

    <%=
        i
    %>

</body>
</html>