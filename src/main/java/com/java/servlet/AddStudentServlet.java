package com.java.servlet;

import com.java.exception.AlreadyExitsException;
import com.java.exception.EmptyException;
import com.java.model.StudentRecord;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


//Insert Student record using doPost.

public class AddStudentServlet extends HttpServlet
{
    public static HashMap<String, StudentRecord> student = new HashMap<>();

    private ServletConfig servletConfig;

    public void init()
    {
        servletConfig=getServletConfig();
        servletConfig.getServletContext().log(this.getClass()+" INIT()");
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            servletConfig.getServletContext().log(this.getClass()+" POST()");
            String roll_no = req.getParameter("roll_no");
            String name = req.getParameter("name");
            String univ = req.getParameter("univ");

                if (name.isEmpty() || univ.isEmpty())
                {

                    throw new EmptyException("Field is not provided a value.");
                }

            StudentRecord s1 = new StudentRecord(name, univ);

            if (!student.containsKey(roll_no))
            {
                student.put(roll_no, s1);
                resp.getWriter().println(student);
            }
            else {
                throw new AlreadyExitsException("Student already exits");
            }
        }
        catch(EmptyException | AlreadyExitsException e)
        {
            resp.getWriter().println(e.getMessage());
        }

    }

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

    public void destroy()
    {
        servletConfig.getServletContext().log(this.getClass()+" destroy()");
    }
}
