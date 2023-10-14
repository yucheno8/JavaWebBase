package cn.yucheno8.day10_case.web.servlet;

import cn.yucheno8.day10_case.domain.User;
import cn.yucheno8.day10_case.service.UserService;
import cn.yucheno8.day10_case.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置编码
        request.setCharacterEncoding("UTF-8");
        // 2.获取参数
        Map<String, String[]> map = request.getParameterMap();
        // 3.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 4.调用Service保存
        UserService service = new UserServiceImpl();
        service.addUser(user);

        // 5.跳转到userListServlet
        response.sendRedirect(request.getContextPath() + "/userListServlet");

    }
}
