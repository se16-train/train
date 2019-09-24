package com.bookonline.Servlet;

import com.bookonline.JavaBean.*;
import com.bookonline.DB.*;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

public class ModifyServlet extends HttpServlet 
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
           //�ر����ݿ����� 
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
        if(param.equalsIgnoreCase("0"))
        {
            String userName=(String)request.getSession().getAttribute("userName");
            UserDao userDao=new UserDao();
            // ����userName �������ݿ�Ĳ�ѯ
            // �����ص��û���Ϣ����UserBean������
            UserBean user=userDao.getUser(connection, userName);
            String gender=user.getGender();
            String genderChange;
            if(gender.equals("��"))
            {
                genderChange="Ů";
            }
            else
            {
                 genderChange="��";
            }
            // ���Ա����session �� 
             request.getSession().setAttribute("gender",gender);
             request.getSession().setAttribute("genderChange",genderChange);
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("modifyinfo.jsp").forward(request, response);
        }        
    }
}

