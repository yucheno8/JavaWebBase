package cn.yucheno8.day08response.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo05")
public class ServletContextDemo05 extends HttpServlet {
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
        // 获取文件的服务器路径
        String realPath = context.getRealPath("/b.txt"); // web目录下资源访问
        System.out.println(realPath); // G:\workstation\IdeaProjects\JavaWebBase\out\artifacts\Day08Response_war_exploded\b.txt
        // File file = new File(realPath);

        String c = context.getRealPath("/WEB_INF/c.txt"); // WEB_INF目录下的资源访问
        System.out.println(c); // G:\workstation\IdeaProjects\JavaWebBase\out\artifacts\Day08Response_war_exploded\WEB_INF\c.txt

        String a = context.getRealPath("/WEB_INF/classes/a.txt"); // src目录下的资源访问
        System.out.println(a);
    }
}
