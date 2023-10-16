package cn.yucheno8.day11_filter_listener.web.filter;

import javax.servlet.*;
import java.io.IOException;

// @javax.servlet.annotation.WebFilter("/*")
public class FilterDemo03 implements Filter {
    /**
     * 在服务器启动后，会创建Filter对象，然后调用inti方法。只执行一次。用于加载资源
     * @param config a <code>FilterConfig</code> object containing the
     *                     filter's configuration and initialization parameters
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。用于释放资源
     */
    public void destroy() {
        System.out.println("destroy...");
    }

    /**
     * 每一次请求被拦截资源时，会执行。执行多次
     * @param request the <code>ServletRequest</code> object contains the client's request
     * @param response the <code>ServletResponse</code> object contains the filter's response
     * @param chain the <code>FilterChain</code> for invoking the next filter or the resource
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("dofilter...");
        chain.doFilter(request, response);
    }
}
