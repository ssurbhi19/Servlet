package com.java.servlet;

import com.java.model.StudentRecord;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Show data after searching from hashmap
public class SearchStudentServlet extends HttpServlet
{
    private ServletConfig servletConfig;
    public void init()
    {
        servletConfig=getServletConfig();
        servletConfig.getServletContext().log(this.getClass()+" init()");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        servletConfig.getServletContext().log(this.getClass()+" GET()");
        String roll_no = req.getParameter("check");
        StudentRecord studentRecord = AddStudentServlet.student.get(roll_no);

        if(AddStudentServlet.student.containsKey(roll_no))
        {
            req.setAttribute("student",studentRecord);
        }
        else
        {
            resp.getWriter().println("Student record doesnot exist..");
        }
    }

    @Override
    public void destroy()
    {
        servletConfig.getServletContext().log(this.getClass()+" GET()");
    }
}
