package com.bookonline.Servlet;

import com.bookonline.JavaBean.*;
import com.bookonline.DB.*;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

public class PasswordServlet extends HttpServlet 
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
            String pass=user.getPassword();
            String passed=request.getParameter("Password1");
            String newpass=request.getParameter("password");
            // ���ݽ���������������û���������бȽ�
            if(pass.equals(passed))
            {
                //�������ֵ��� 
                //UpdatePass ���������޸Ĳ���
                int value=userDao.UpdatePass(connection,newpass,userName);
                if(value>0)
                {	
                	 request.getSession().setAttribute("errorMessage", "�����޸ĳɹ�,3���к���ת����ҳ��");
                     request.getRequestDispatcher("passwordmodify.jsp").forward(request,response);
                }
                else
                {
                	 request.getSession().setAttribute("errorMessage", "�޸�ʧ�ܣ�");
                     request.getRequestDispatcher("passwordmodify.jsp").forward(request,response);
                }
               
            }
            else
            {
                //������벻���
            	request.getSession().setAttribute("errorMessage", "���벻һ�£��޸�ʧ�ܣ�");
               request.getRequestDispatcher("passwordmodify.jsp").forward(request,response);
            } 
    }
}
