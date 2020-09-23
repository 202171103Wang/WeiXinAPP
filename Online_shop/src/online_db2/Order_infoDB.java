package online_db2;
import javabean2.*;
import java.util.*;
import java.sql.*;
public class Order_infoDB extends DbConn{
	public int addinfo(Order_info i) {
    	int result=0;
    	if(conn!=null) {
    		try {
 			PreparedStatement pst=conn.prepareStatement("insert into [Order_info] values(?,?,?,?,?, getDate() ,?,?,?)");
 			    pst.setInt(1, i.getOrder_id());
				pst.setInt(2,i.getOrder_num());
			    pst.setString(3,i.getOrder_personid());
			    pst.setInt(4, i.getOrder_good_num());
			    pst.setFloat(5, i.getOrder_sum());
				pst.setString(6,i.getOrder_wait_time());
				pst.setInt(7, 0);
				pst.setString(8, i.getOrder_shopid());
				result=pst.executeUpdate();
    		}
    		catch(SQLException e)
    		{
    		    
    			System.out.println(e.getMessage());
    		}
    	}
    	return result;
    }
	public int maxid() {
    	int id=0;
    	if(conn!=null) {
    		try {
 			      PreparedStatement pst=conn.prepareStatement("select MAX(Order_id) as id from [Order_info]");
 			     ResultSet rs=pst.executeQuery();
 				while(rs.next())
 				{
 					id=rs.getInt("id");
 				}
 				rs.close();
    		}
    		catch(SQLException e)
    		{
    		    
    			System.out.println(e.getMessage());
    		}
    	}
    	return id;
    }
	public int maxnum() {
    	int id=0;
    	if(conn!=null) {
    		try {
 			      PreparedStatement pst=conn.prepareStatement("select MAX(Order_num) as id \r\n" + 
 			      		"from [Order_info] \r\n" + 
 			      		"where year(Order_time)=year(getDate()) \r\n" + 
 			      		"and month(Order_time)=month(getDate())\r\n" + 
 			      		"and day(Order_time)=day(getDate())");
 			     ResultSet rs=pst.executeQuery();
 				while(rs.next())
 				{
 					id=rs.getInt("id");
 				}
 				rs.close();
    		}
    		catch(SQLException e)
    		{
    		    
    			System.out.println(e.getMessage());
    		}
    	}
    	return id;
    }
	
}
