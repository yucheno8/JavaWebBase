package cn.yucheno8.day08response.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo03")
public class ServletContextDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            1. 获取MIME类型：
            2. 域对象：共享数据
            3. 获取文件的真实(服务器)路径
         */

        // 2.通过HttpServlet对象获取
        ServletContext context = this.getServletContext();
        // 设置数据
        context.setAttribute("msg","haha");

    }
}
