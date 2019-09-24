package com.bookonline.Servlet;

import com.bookonline.JavaBean.*;
import com.bookonline.DB.*;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

public class AddServlet extends HttpServlet 
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
      
            String userName=(String)request.getSession().getAttribute("userName");
            UserDao userDao=new UserDao();
            // ����userName �������ݿ�Ĳ�ѯ
            // �����ص��û���Ϣ����UserBean������
            UserBean user=userDao.getUser(connection, userName);
            int admin = user.getAdmin();
            if(admin == 1){
            	request.getRequestDispatcher("addtrain.jsp").forward(request, response);
            }
            else{
            	request.getRequestDispatcher("adderror.jsp").forward(request, response);
            }
                     
    }
}
