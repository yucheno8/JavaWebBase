package cn.yucheno8.day08response.web.servletcontext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "servletContextDemo01", value = "/servletContextDemo01")
public class ServletContextDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            Servlet对象的获取：
                1.通过request对象获取
                    request.getServletContext();
                2.通过HttpServlet对象获取
                    this.getServletContext();
         */

        // 1.通过request对象获取
        ServletContext context1 = request.getServletContext();
        // 2.通过HttpServlet对象获取
        ServletContext context2 = this.getServletContext();
        System.out.println(context1); // org.apache.catalina.core.ApplicationContextFacade@5dd063be
        System.out.println(context2); // org.apache.catalina.core.ApplicationContextFacade@5dd063be
        System.out.println(context1 == context2); // true
    }
}
