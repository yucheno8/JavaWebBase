package cn.yucheno8.day10_case.web.servlet;

import cn.yucheno8.day10_case.domain.PageBean;
import cn.yucheno8.day10_case.domain.User;
import cn.yucheno8.day10_case.service.UserService;
import cn.yucheno8.day10_case.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("utf-8");

        // 1.获取参数
        String currentPage = request.getParameter("currentPage"); // 当前页码
        String rows = request.getParameter("rows"); // 每页显示的条数

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        // 获取条件查询的参数
        Map<String, String[]> condition = request.getParameterMap();


        // 2.调用service查询
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage, rows, condition);

        // System.out.println(pb);

        // 3.将PageBean存入request
        request.setAttribute("pb", pb);
        request.setAttribute("condition", condition); // 将查询条件存入request

        // 4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }
}
