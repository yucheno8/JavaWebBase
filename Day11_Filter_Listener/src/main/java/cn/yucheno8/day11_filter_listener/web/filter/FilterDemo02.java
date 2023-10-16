package cn.yucheno8.day11_filter_listener.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// @WebFilter("/*")
public class FilterDemo02 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 对request对象请求消息增强
        System.out.println("FilterDemo02执行了...");

        // 放行
        chain.doFilter(request, response);

        // 对response对象的相应消息增强
        System.out.println("filterDemo02回来了...");
    }
}
