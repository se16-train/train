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
        if(param.equalsIgnoreCase("1"))
        {
           
            UserBean user =new UserBean();
            user.setUserName(request.getParameter("userName"));
            user.setRealName(request.getParameter("realName"));
            user.setGender(request.getParameter("gender"));
            user.setTel(request.getParameter("tel"));
            user.setEmail(request.getParameter("email"));
            UserDao userDao=new UserDao();
            // Update �����û��������Ϣ �������ݿ���޸�
            int value=userDao.Update(connection,user);
            if(value>0)
            {
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
                request.getSession().setAttribute("errorMessage","�޸ĳɹ������أ�");
                request.getRequestDispatcher("modifyinfo.jsp").forward(request,response);
            }
            else  
            {
            	request.getSession().setAttribute("errorMessage","�޸�ʧ�ܣ��������޸ģ�");
                request.getRequestDispatcher("modifyinfo.jsp").forward(request,response);
            }           
        }
         
    }

}
