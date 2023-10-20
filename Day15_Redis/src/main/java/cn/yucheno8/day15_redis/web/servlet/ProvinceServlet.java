package cn.yucheno8.day15_redis.web.servlet;

import cn.yucheno8.day15_redis.demain.Province;
import cn.yucheno8.day15_redis.service.ProvinceService;
import cn.yucheno8.day15_redis.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;


@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*// 1.调用service查询
        ProvinceService service = new ProvinceServiceImpl();
        List<Province> list = service.findAll();

        // 2.序列化list为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);*/

        // 1.调用service查询
        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();

        System.out.println(json);

        // 3.响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
