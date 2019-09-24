package com.bookonline.JavaBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao 
{
    // insert���� �����ݿ��в����û���Ϣ
	public int insert(Connection connection, UserBean user)
        {
	
		int value=-1;
		PreparedStatement statement=null;
		String sql="insert into User_(userName,password,repassword,realName,gender,tel,email,admin) values(?,?,?,?,?,?,?,?)";
                try 
                {
                    statement=connection.prepareStatement(sql);
                    statement.setString(1,user.getUserName());
                    statement.setString(2,user.getPassword());
                    statement.setString(3,user.getRepassword());
                    statement.setString(4,user.getRealName());
                    statement.setString(5,user.getGender());
                    statement.setString(6,user.getTel());
                    statement.setString(7,user.getEmail());
                    statement.setInt(8, 0);
                    value=statement.executeUpdate();
                } 
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
		finally
		{
                	try
			{
				if(statement != null) statement.close();
			}
			catch (SQLException ex)
			{
			}
		}
                return value;
        }
        //check���� ���ݵ�½���洫����û��������������ݿ���бȽ�
        // ��������û����򷵻���,ÿ���𷵻ؼ� 
    public boolean check(Connection connection, String userName, String password)
    {
		boolean value = false;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select userName from User_ where userName = ? and password = ?";
		try
		{
			// ���PreparedStatement���󣬲����
			statement = connection.prepareStatement(sql);
			statement.setString(1,userName);
			statement.setString(2,password);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				value = true;
			}
			return value;
		}
		catch (SQLException e)
		{
		}
		finally
		{
			try
			{
				if(resultSet != null) resultSet.close();
				if(statement != null) statement.close();
			}
			catch (SQLException e)
			{
			}
		}
		return value;
          }
    
 // getUser����  ����userName �������ݿ��ѯ����
 // ����ѯ����ֵ����UserBean������ �����ظö���
    public UserBean getUser(Connection connection, String userName)
    {
          UserBean user=new UserBean();
          String sql="select userName,password,realName,gender,tel,email,admin from User_ where userName=?";
          PreparedStatement statement=null;
          ResultSet result=null;
          
          try
          {
              statement=connection.prepareStatement(sql);
              statement.setString(1,userName);
              result=statement.executeQuery();
              while(result.next())
              {
                  user.setUserName(result.getString("userName"));
                  user.setPassword(result.getString("password"));
                  user.setRealName(result.getString("realName"));
                  user.setGender(result.getString("gender"));
                  user.setTel(result.getString("tel"));
                  user.setEmail(result.getString("email"));
                  user.setAdmin(Integer.parseInt(result.getString("admin")));
              }
              return user;
          }
         catch (SQLException e)
         {
         }
          finally
          {
             try
             {
                 if(statement!=null)statement.close();
                 if(result!=null)result.close();
             }
             catch(SQLException e)
             {
             }
          }
          return user;
    }
  
     // Update ����û��޸ĺ����Ϣ �������ݿ���޸Ĳ���
        public int Update(Connection connection, UserBean user)
	{
		int value = -1;
		PreparedStatement statement = null;
		String sql = "update User_ set  realName = ?, gender = ?, tel = ?, email = ? where userName = ?";

		try
		{
			// ���PreparedStatement����
			statement = connection.prepareStatement(sql);
			// ���statement�Ĳ���
			
			statement.setString(1, user.getRealName());
			statement.setString(2, user.getGender());
			statement.setString(3, user.getTel());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getUserName());			
			// ִ���޸Ĳ���
			value = statement.executeUpdate();
		}
		catch (SQLException e)
		{
		}
		finally
		{
			try
			{
				if(statement != null) statement.close();
				//if(connection != null) connection.close();
			}
			catch (SQLException e)
			{
			}
		}
		return value;
	}
        
        // UpdatePass  �����û���������� �������������޸Ĳ���
        public int UpdatePass(Connection connection,String password,String userName)
	{
		int value = -1;
		PreparedStatement statement = null;
		String sql = "update User_ set password = ? where userName = ?";

		try
		{
			// ���PreparedStatement����
			statement = connection.prepareStatement(sql);
			// ���statement�Ĳ���
			statement.setString(1, password);
			statement.setString(2, userName);
			// ִ���޸Ĳ���
			value = statement.executeUpdate();
		}
		catch (SQLException e)
		{
		}
		finally
		{
			try
			{
				if(statement != null) statement.close();
				//if(connection != null) connection.close();
			}
			catch (SQLException e)
			{
			}
		}
		return value;
	}
 
}