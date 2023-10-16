package cn.yucheno8.day11_filter_listener.web.filter;

import javax.servlet.*;
import java.io.IOException;

@javax.servlet.annotation.WebFilter("/*")
public class FilterDemo07 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo07执行了...");
        chain.doFilter(request, response);
        System.out.println("filterDemo07回来了...");
    }
}
