package cn.yucheno8.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestDemo04", value = "/RequestDemo04")
public class RequestDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 演示获取请求投数据：referer
        String referer = request.getHeader("referer");
        System.out.println(referer); // http://localhost/day07/login.html

        // 防盗链
        if (referer != null) {
            if (referer.contains("/day07")) {
                // 正常访问
                // System.out.println("播放电影...");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影...");
            } else {
                // 盗链
                System.out.println("想看电影吗？来优酷吧...");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
