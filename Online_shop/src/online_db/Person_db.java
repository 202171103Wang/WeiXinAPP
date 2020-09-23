package online_db;
import javabean.*;
import java.sql.*;
public class Person_db extends DbConn
{
	public boolean isLogin(String person_id,String person_pwd)
	{
		boolean flag=false;
		if(conn!=null)
		{
			try
			{
				PreparedStatement pst=conn.prepareStatement("select * from Person where Person_id= ? and Person_pwd= ? and Person_professor=1;");
				pst.setString(1, person_id);
				pst.setString(2, person_pwd);
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					flag=true;
				}
				rs.close();
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		return flag;
	}
	public Person SelectById(String person_id)
	{
		Person p=new Person();
		if(conn!=null)
		{
			try
			{
				PreparedStatement pst=conn.prepareStatement("select * from Person where Person_id= ?");
				pst.setString(1, person_id);
		    	ResultSet rs=pst.executeQuery();
		    	while(rs.next())
		    	{
			      p.setPerson_id(rs.getString("Person_id"));
			      p.setPerson_name(rs.getString("Person_name"));
			      p.setPerson_img(rs.getString("Person_img"));
			      p.setPerson_call(rs.getString("Person_call"));
			      p.setPerson_pwd(rs.getString("Person_pwd"));
		     	}
		    	rs.close();
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		return p;
	}
	public int updatePerson(Person p) {
		int num=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("update Person set Person_name= ?,Person_call= ?,Person_pwd= ? where Person_id= ?");
				pst.setString(1, p.getPerson_name());
				pst.setString(2, p.getPerson_call());
				pst.setString(3, p.getPerson_pwd());
				pst.setString(4, p.getPerson_id());
				num=pst.executeUpdate();
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return num;
	 }
}
