package cn.yucheno8.day08response.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 重定向
 */

@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Demo01......");

        // 访问/responseDemo01，会自动跳转到/responseDemo02资源
        /*// 1.设置状态码为302
        response.setStatus(302);
        // 2.设置响应头location
        response.setHeader("location", "/day08Response/responseDemo02");*/

        request.setAttribute("msg", "response");

        // 动态获取虚拟目录
        String contextPath = request.getContextPath();

        // 简单的重定向方法
        response.sendRedirect(contextPath + "/responseDemo02");
        // response.sendRedirect("https://www.baidu.com");
    }
}
