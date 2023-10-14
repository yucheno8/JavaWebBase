package cn.yucheno8.day10_case.web.servlet;

import cn.yucheno8.day10_case.service.UserService;
import cn.yucheno8.day10_case.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取id
        String id = request.getParameter("id");
        // 2.调用service删除
        UserService service = new UserServiceImpl();
        service.deleteUser(id);

        // 3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath() + "/userListServlet");
    }
}
