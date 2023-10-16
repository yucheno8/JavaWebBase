package cn.yucheno8.day11_filter_listener.web.filter;

import javax.servlet.*;
import java.io.IOException;

// @javax.servlet.annotation.WebFilter("/index.jsp") // /index.jsp   只有访问index.jsp资源时，过滤器才会被执行
// @javax.servlet.annotation.WebFilter("/user/*") // /user/*	访问/user下的所有资源时，过滤器都会被执行
// @javax.servlet.annotation.WebFilter("*.jsp") // *.jsp		访问所有后缀名为jsp资源时，过滤器都会被执行
// @javax.servlet.annotation.WebFilter("/*") // /*		访问所有资源时，过滤器都会被执行
public class FilterDemo04 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo04...");
        // 放行
        chain.doFilter(request, response);
    }
}
