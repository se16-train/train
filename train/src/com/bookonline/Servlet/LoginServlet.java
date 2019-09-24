package com.bookonline.Servlet;


import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookonline.JavaBean.*;
import com.bookonline.DB.*;

public class LoginServlet extends HttpServlet{
	
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
        String userName = (String)request.getParameter("userName");
        String password = (String)request.getParameter("password");
        UserDao userDao=new UserDao();
        // check������ѯ���ݿ����Ƿ��и��û���Ϣ
        boolean value=userDao.check(connection,userName,password);
        if(value)
		{
			// ��¼�ɹ�
        	request.getSession().setAttribute("userName", userName);
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			// ��¼ʧ��
			request.getSession().setAttribute("message", "�û�����������������µ�¼��");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
       
         
    }

}
