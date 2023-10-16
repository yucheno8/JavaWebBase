package cn.yucheno8.day11_filter_listener.web.filter;

import javax.servlet.*;
import java.io.IOException;

// 浏览器直接请求index.jsp资源时，该过滤器会被执行
// @javax.servlet.annotation.WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)
// 只有转发访问index.jsp时，该过滤器才会被执行
// @javax.servlet.annotation.WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)
// 浏览器直接请求index.jsp资源或者转发访问index.jsp时，该过滤器都会被执行
// @javax.servlet.annotation.WebFilter(value = "/index.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class FilterDemo05 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo05...");
        chain.doFilter(request, response);
    }
}
