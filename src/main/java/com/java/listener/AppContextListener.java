package com.java.listener;

import com.java.servlet.SearchStudentServlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//Used for reading from property file.
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        String propertyFilePath=servletContextEvent.getServletContext().getInitParameter("properties");
        try {

            Properties prop = readPropertiesFile(propertyFilePath);
            servletContextEvent.getServletContext().setAttribute("propertyFile",prop);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        System.out.println("EXITING");
    }
    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        return prop;
    }
}
