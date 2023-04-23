package cn.yucheno8.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RequestDemo02", value = "/RequestDemo02")
public class RequestDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 演示获取请求投数据

        // 1.获取所有的请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();

        // 2.遍历
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            // 根据名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name + "---" + value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
