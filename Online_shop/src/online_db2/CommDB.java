package online_db2;
import java.sql.*;
import java.util.ArrayList;

import javabean2.*;

public class CommDB extends DbConn{
	
	public int addinfo(Comment c) {
    	int result=0;
    	if(conn!=null) {
    		try {
 			PreparedStatement pst=conn.prepareStatement("insert into [comment] values(?, getDate() ,?,?)");
 			    pst.setString(1, c.getCshopid());
				pst.setString(2, c.getCmessage());
			    pst.setString(3,c.getCpersonid());
				result=pst.executeUpdate();
    		}
    		catch(SQLException e)
    		{
    		    
    			System.out.println(e.getMessage());
    		}
    	}
    	return result;
    }
	public ArrayList<Comment> commselectbyperson(String personid)   
	{
		ArrayList<Comment> css=new ArrayList<Comment>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select *\r\n" + 
						"from comment ,Person,Shop\r\n" + 
						"where comment.c_personid=Person.Person_id\r\n" + 
						"	and comment.c_shopid=Shop_id\r\n" + 
						"	and comment.c_personid= ?\r\n" );
				pst.setString(1,personid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Comment c=new Comment();
					c.setCshopname(rs.getString("Shop_name"));
					c.setCmessage(rs.getString("c_message"));
					c.setCtime(rs.getString("c_time"));
					css.add(c);
				}
				rs.close();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return css;
	}
	public ArrayList<Comment> commselectbyshop(String shopid)   
	{
		ArrayList<Comment> css=new ArrayList<Comment>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select *\r\n" + 
						"from comment ,Person,Shop\r\n" + 
						"where comment.c_personid=Person.Person_id\r\n" + 
						"	and comment.c_shopid=Shop_id\r\n" + 
						"	and comment.c_shopid= ?\r\n" );
				pst.setString(1,shopid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Comment c=new Comment();
					c.setCshopname(rs.getString("Shop_name"));
					c.setCmessage(rs.getString("c_message"));
					c.setCpersonname(rs.getString("Person_name"));
					c.setCtime(rs.getString("c_time"));
					css.add(c);
				}
				rs.close();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return css;
	}

}
