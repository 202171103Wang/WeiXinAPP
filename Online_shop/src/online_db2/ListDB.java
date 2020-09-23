package online_db2;

import java.util.ArrayList;
import java.sql.*;
import javabean2.*;

public class ListDB extends DbConn{
	public ArrayList<Lists> listselect(String orderid)   // 根据orderid寻找所有的订单
	{
		ArrayList<Lists> goods=new ArrayList<Lists>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from order_info,shop,Order_detail,good "
						+ "where order_info.order_id=? "
						+ "and shop.shop_id=order_info.order_shopid "
						+ "and Order_detail.Order_id=Order_info.Order_id "
						+ "and good.Good_id=Order_detail.Good_id");
				pst.setString(1,orderid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Lists g=new Lists();
					g.setOrderid(rs.getString("order_id"));
					g.setGoodnum(rs.getInt("num"));
					g.setShopid(rs.getString("order_shopid"));
					g.setOrdersum(rs.getFloat("order_sum"));
					g.setShopname(rs.getString("shop_name"));
					g.setShopimg(rs.getString("shop_img"));
					g.setGoodimg(rs.getString("good_img"));
					g.setGoodname(rs.getString("good_name"));
					g.setShopadd(rs.getString("shop_place"));
					g.setGoodprice(rs.getFloat("good_price"));
					goods.add(g);
				}
				rs.close();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return goods;
	}
}
