package cn.yucheno8.day10_case.web.servlet;

import cn.yucheno8.day10_case.service.UserService;
import cn.yucheno8.day10_case.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取所有id
        String[] ids = request.getParameterValues("uid");
        // 2.调用service删除
        UserService service = new UserServiceImpl();
        service.delSelectedUser(ids);

        // 3.跳转到查询所有的Servlet
        response.sendRedirect(request.getContextPath() + "/userListServlet");

    }
}
