package cn.yucheno8.day07test.web.servlet;

import cn.yucheno8.day07test.domain.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取request域中共享的user对象
        User user = (User) req.getAttribute("user");

        if (user != null) {
            // 给页面写一句话

            // 设置编码
            resp.setContentType("text/html;charset=utf-8");
            // 输出
            resp.getWriter().write("登录成功！" + user.getUsername() +  "用户名，欢迎您！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req, resp);
    }
}
