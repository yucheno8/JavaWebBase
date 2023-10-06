package cn.yucheno8.day09cookie_session.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionDemo03")
public class SessionDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用session获取数据
        // 1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);
        // 期望客户端关闭后，session也能相同
        Cookie c = new Cookie("JSESSIONID", session.getId());
        c.setMaxAge(60 * 60);
        response.addCookie(c);


    }
}
