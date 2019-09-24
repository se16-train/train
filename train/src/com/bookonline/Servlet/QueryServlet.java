package com.bookonline.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookonline.JavaBean.*;
import com.bookonline.DB.*;

public class QueryServlet extends HttpServlet 
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
        String qidian = (String)request.getParameter("qidian");
        String zhongdian = (String)request.getParameter("zhongdian");
        
        TicketDao ticketDao=new TicketDao();
        // System.out.println("===="+checi+"====="+qidian+"===="+zhongdian);
        // query������ѯ�Ƿ��и��ֳ��ε�Ʊ
        boolean value = false;
        List ticketList = new ArrayList();
		try {
			value = ticketDao.query(connection,checi,qidian,zhongdian);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(value)
		{
			// �иó��ε�Ʊ����ת����Ʊҳ��
        	try {
				ticketList = ticketDao.queryAll(connection, checi);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("ticketList", ticketList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("showticket.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			// û�иó��ε�Ʊ
			RequestDispatcher dispatcher = request.getRequestDispatcher("queryfailed.jsp");
			dispatcher.forward(request, response);
		}         
    }
}
