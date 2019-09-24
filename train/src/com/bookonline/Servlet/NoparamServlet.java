package com.bookonline.Servlet;


import com.bookonline.JavaBean.*;
import com.bookonline.DB.*;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

public class NoparamServlet extends HttpServlet 
{
        private Connection connection;
       public void init() throws ServletException
       {
           super.init();
               connection=DB.getConnection();
       }
       public void destroy()
       {
        super.destroy();
                //关闭数据库连接 
        DB.closeConnection(connection);
       }
   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        doPost(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        String param=request.getParameter("param");
        if(param.equalsIgnoreCase("1"))
        {
           
            UserBean user =new UserBean();
            user.setUserName(request.getParameter("userName"));
            user.setRealName(request.getParameter("realName"));
            user.setGender(request.getParameter("gender"));
            user.setTel(request.getParameter("tel"));
            user.setEmail(request.getParameter("email"));
            UserDao userDao=new UserDao();
            // Update 根据用户输入的信息 进行数据库的修改
            int value=userDao.Update(connection,user);
            if(value>0)
            {
            	 String gender=user.getGender();
                 String genderChange;
                 if(gender.equals("男"))
                 {
                     genderChange="女";
                 }
                 else
                 {
                      genderChange="男";
                 }
                 // 将性别放入session 中 
                  request.getSession().setAttribute("gender",gender);
                  request.getSession().setAttribute("genderChange",genderChange);
                 request.getSession().setAttribute("user",user);
                request.getSession().setAttribute("errorMessage","修改成功，返回！");
                request.getRequestDispatcher("modifyinfo.jsp").forward(request,response);
            }
            else  
            {
            	request.getSession().setAttribute("errorMessage","修改失败，请重新修改！");
                request.getRequestDispatcher("modifyinfo.jsp").forward(request,response);
            }           
        }
         
    }

}
