package com.bilibili.yl.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录过滤器，验证用户是否登录
 * */
public class LoginFilter implements Filter {
    private String sessionName = "";
    private String url = "";
    private String filter = "";

    @Override
    public void init(FilterConfig filterConfig) {
        this.sessionName = filterConfig.getInitParameter("sessionName") == null ? "user" : filterConfig.getInitParameter("sessionName");
        this.url = filterConfig.getInitParameter("url") == null ? "login" : filterConfig.getInitParameter("url");
        this.filter = filterConfig.getInitParameter("filter") == null ? "" : filterConfig.getInitParameter("filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //过滤的uri
        String[] filters = filter.split(",");
        //请求的uri
        String uri = request.getRequestURI();
        //获取项目根路径
        String path = request.getContextPath() + "/";
        //是否过滤
        boolean doFilter = false;
        for (String s : filters) {
            if (!s.equals("")) {
                if (uri.contains(s)) {
                    //如果uri中包含过滤的uri则进行过滤;
                    doFilter = true;
                    break;
                }
            }
        }
        //不过滤主页
        if (uri.equals(path)) doFilter = false;
        //执行过滤
        if (doFilter) {
            //从session获取登录体实体
            if (request.getSession().getAttribute(sessionName) == null) {
                boolean isAjaxRequest = isAjaxRequest(request);
                if (isAjaxRequest) {
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("{\"code\":500,\"msg\":\"你已经太长时间没有操作,请刷新页面\"}");
                    out.close();
                } else response.sendRedirect(path + url);
            } else filterChain.doFilter(request, response);
        } else filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    /**
     * 判断是否为Ajax请求
     *
     * @return 是true, 否false
     */
    private static boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(header);
    }

}
