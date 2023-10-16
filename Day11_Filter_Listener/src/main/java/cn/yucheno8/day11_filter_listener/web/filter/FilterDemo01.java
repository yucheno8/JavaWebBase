package cn.yucheno8.day11_filter_listener.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器快速入门程序
 */

// @WebFilter("/*") // 访问所有资源之前都会执行该过滤器
public class FilterDemo01 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterDemo01被执行了...");

        // 放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Filter.super.destroy();
    }
}
