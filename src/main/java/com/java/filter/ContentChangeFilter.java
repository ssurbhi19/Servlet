package com.java.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
//Changes the java object into JSON or XML according to the accept field of HTTP Header.
public class ContentChangeFilter implements Filter
{
    private FilterConfig filterConfig;
    private ObjectMapper objectMapper = new ObjectMapper();
    private XmlMapper xmlMapper = new XmlMapper();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        this.filterConfig=filterConfig;
        filterConfig.getServletContext().log(this.getClass()+" init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        filterConfig.getServletContext().log(this.getClass()+" doFilter()");

        String accept= ((HttpServletRequest)servletRequest).getHeader("Accept");
        filterChain.doFilter( servletRequest, servletResponse );
        Object data=  servletRequest.getAttribute("student");

        if(accept == null)
        {
            servletResponse.getWriter().println(data);
        }
        else {
            if (accept.equals("application/json"))
            {

                String json = objectMapper.writeValueAsString(data);
                servletResponse.getWriter().println(json);
            }
            else if (accept.equals("application/xml"))
            {
                String xml = xmlMapper.writeValueAsString(data);
                servletResponse.getWriter().println(xml);
            }
            else {
                servletResponse.getWriter().println(data);
            }
        }

    }

    @Override
    public void destroy() {
        filterConfig.getServletContext().log(this.getClass()+" destroy()");
    }
}
