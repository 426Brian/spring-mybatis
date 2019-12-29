package com.filter;



import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Brian in 17:29 2018/3/12
 */
public class FilterDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=== FilterDemo init() ===");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("=== FilterDemo start ===");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("=== FilterDemo end ===");
    }

    @Override
    public void destroy() {
        System.out.println("=== FilterDemo destroy() ===");
    }


}
