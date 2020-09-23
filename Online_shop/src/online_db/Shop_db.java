package online_db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javabean.*;
public class Shop_db extends DbConn
{
	public Shop select_shop(String shopid) {
		Shop s=new Shop();
		if(conn!=null)
		{
			try
			{
				PreparedStatement pst=conn.prepareStatement("select * from Shop where Shop_id= ?");
				pst.setString(1, shopid);
		    	ResultSet rs=pst.executeQuery();
		    	while(rs.next())
		    	{     

                     s.setShop_id(rs.getString("Shop_id"));
                     s.setShop_img(rs.getString("Shop_img"));
                     s.setShop_name(rs.getString("Shop_name"));
                     s.setShop_state(rs.getInt("Shop_state"));
                     s.setShop_place(rs.getString("Shop_place"));
		    	}
		    	rs.close();
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
	   }
       return s;
	}
	 public int updateShop(Shop s) {
			int num=0;
			if(conn!=null)
			{
				try {
					PreparedStatement pst=conn.prepareStatement("update Shop set Shop_name= ?,Shop_state= ? where Shop_id= ?");
					pst.setString(1, s.getShop_name());
					pst.setInt(2, s.getShop_state());
					pst.setString(3, s.getShop_id());
					num=pst.executeUpdate();
				}catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
			}
			return num;
		 }

}
