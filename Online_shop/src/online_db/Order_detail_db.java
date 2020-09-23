package online_db;

import java.sql.*;
import java.util.ArrayList;

import javabean.*;

public class Order_detail_db extends DbConn{
	
	 //查询所买的商品
			public ArrayList<Order_detail_good> select_all_Order_detail(String orderid){
		       ArrayList<Order_detail_good> order_details=new ArrayList<Order_detail_good>();
		       if(conn!=null)
				{
					try
					{
						PreparedStatement pst=conn.prepareStatement("select Good.Good_id,Good_name,Good_img,Good_price,Good_kind,Good_mess,Order_id,Good_shopid,num\r\n" + 
								"from Good,Order_detail\r\n" + 
								"where Good.Good_id=Order_detail.Good_id\r\n" + 
								"and Order_detail.Order_id=?");
						pst.setString(1, orderid);
				    	ResultSet rs=pst.executeQuery();
				    	while(rs.next())
				    	{     
				    		Order_detail_good g=new Order_detail_good();
				    		g.setGood_id(rs.getString("Good_id"));
				    		g.setGood_name(rs.getString("Good_name"));
				    		g.setGood_img(rs.getString("Good_img"));
				    		g.setGood_price(rs.getFloat("Good_price"));
				    	    g.setGood_kind(rs.getString("Good_kind"));
				    	    g.setGood_mess(rs.getString("Good_mess"));
				    	    g.setGood_shopid(rs.getString("Good_shopid"));
				    	    g.setOrder_id(rs.getString("Order_id"));
				    	    g.setNum(rs.getInt("num"));
				    	    order_details.add(g);
				    	}
				    	rs.close();
					}
					catch(SQLException ex)
					{
						System.out.println(ex.getMessage());
					}
			   }
		       return order_details;
			}

}
