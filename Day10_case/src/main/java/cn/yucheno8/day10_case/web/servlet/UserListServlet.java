package cn.yucheno8.day10_case.web.servlet;

import cn.yucheno8.day10_case.domain.User;
import cn.yucheno8.day10_case.service.UserService;
import cn.yucheno8.day10_case.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.调用UserService完成查询
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();
        // 2.将list存入request域
        request.setAttribute("users", users);
        // 3.转发到list.jsp
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
