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

public class NewUser extends HttpServlet 
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
        
        UserBean user=new UserBean();
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setRepassword(request.getParameter("repassword"));
        user.setRealName(request.getParameter("realName"));
        String gender=request.getParameter("gender");
        if(gender.equals("1"))
        {
            gender="��";
        }
        else
        {
            gender="Ů";
        }
        user.setGender(gender);
        user.setTel(request.getParameter("tel"));
        user.setEmail(request.getParameter("email"));
        user.setAdmin(0);//Ĭ�ϵ��û�ע��Ϊ0
        UserDao userDao=new UserDao();
        // insert���������ݿ�����û���Ϣ
        int value=userDao.insert(connection,user);
        if(value > 0)
		{
			// ע��ɹ�
			RequestDispatcher dispatcher = request.getRequestDispatcher("registersuccess.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			// ע��ʧ��
			RequestDispatcher dispatcher = request.getRequestDispatcher("registerfailed.jsp");
			dispatcher.forward(request, response);
		}
       
         
    }

}