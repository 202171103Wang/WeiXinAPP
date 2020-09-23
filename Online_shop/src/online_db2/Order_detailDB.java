package online_db2;
import javabean2.*;
import java.util.*;
import java.sql.*;
public class Order_detailDB extends DbConn{
	public int adddetail(Order_detail d) {
    	int result=0;
    	if(conn!=null) {
    		try {
 			PreparedStatement pst=conn.prepareStatement("insert into [Order_detail] values(?,?,?)");
				pst.setInt(1,d.getOrder_id());
			    pst.setString(2,d.getGood_id());
			    pst.setString(3,d.getNum());
				result=pst.executeUpdate();
    		}
    		catch(SQLException e)
    		{
    		    
    			System.out.println(e.getMessage());
    		}
    	}
    	return result;
    }
	
}