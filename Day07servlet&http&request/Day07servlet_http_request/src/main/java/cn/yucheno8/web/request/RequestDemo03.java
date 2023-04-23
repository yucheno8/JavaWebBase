package cn.yucheno8.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RequestDemo03", value = "/RequestDemo03")
public class RequestDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 演示获取请求投数据：user-agent

        String agent = request.getHeader("user-agent");
        // 判断agent的浏览器版本
        if (agent.contains("Chrome")) {
            // 谷歌
            System.out.println("谷歌来了...");
        } else if (agent.contains("Firefox")) {
            // 火狐
            System.out.println("火狐来了...");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
