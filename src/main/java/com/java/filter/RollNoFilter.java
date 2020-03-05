package com.java.filter;


import javax.servlet.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Validates the Roll no
public class RollNoFilter implements Filter
{
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        this.filterConfig = filterConfig;
        filterConfig.getServletContext().log(this.getClass()+" init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        filterConfig.getServletContext().log(this.getClass()+" doFilter()");
        String roll_no= servletRequest.getParameter("roll_no");
        Pattern p =Pattern.compile("rn[0-9]+");
        Matcher m = p.matcher(roll_no);
        if(m.matches())
            filterChain.doFilter(servletRequest,servletResponse);
        else
            servletResponse.getWriter().println("Not a valid roll Number");
    }

    @Override
    public void destroy() {
        filterConfig.getServletContext().log(this.getClass()+" destroy()");
    }
}
