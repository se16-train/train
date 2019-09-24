package com.bookonline.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookonline.JavaBean.*;
import com.bookonline.DB.*;
//���ж�Ʊ
public class BookServlet extends HttpServlet 
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
        String checi = (String)request.getParameter("checi");
        TicketDao ticketDao=new TicketDao();
        // System.out.println("===="+checi+"====="+qidian+"===="+zhongdian);
        // update���������Ѿ����˵�Ʊ
        boolean value = false;
		try {
			value = ticketDao.update(connection,checi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(value)
		{
			// ��Ʊ�ɹ�
			RequestDispatcher dispatcher = request.getRequestDispatcher("booksuccess.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			// ��Ʊʧ��
			RequestDispatcher dispatcher = request.getRequestDispatcher("bookfailed.jsp");
			dispatcher.forward(request, response);
		}         
    }
}
