package com.java.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Validates the name
public class NameFilter implements Filter
{
    private FilterConfig filterConfig;
    public void init(FilterConfig filterConfig) throws ServletException
    {
        this.filterConfig = filterConfig;
        filterConfig.getServletContext().log(this.getClass()+" init()");
        filterConfig.getServletContext().log("NAME  FILTER IS RUNNING");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        filterConfig.getServletContext().log(this.getClass()+" doFilter()");
        String name= servletRequest.getParameter("name");
        Pattern p =Pattern.compile("[A-Z]?[a-z]+");
        Matcher m = p.matcher(name);
        if(m.matches())
            filterChain.doFilter(servletRequest,servletResponse);
        else
            servletResponse.getWriter().println("Not a valid name..");
    }

    public void destroy()
    {
        filterConfig.getServletContext().log(this.getClass()+" destroy()");
    }
}
