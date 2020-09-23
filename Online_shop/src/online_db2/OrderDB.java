package online_db2;
import javabean2.*;
import java.sql.*;
import java.util.*;
public class OrderDB extends DbConn{
	public ArrayList<Orders> orderselect(String personid)   // 根据personid寻找所有的订单
	{
		ArrayList<Orders> goods=new ArrayList<Orders>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * "
						+ "from order_info,shop "
						+ "where order_personid=? "
						+ "and shop.shop_id=order_info.order_shopid "
						+ "and Year(Order_time)=DATENAME(YEAR,getdate())\r\n" 
						+ "and Month(Order_time)=DAteName(MONTH,getDate())\r\n" 
						+ "and Day(Order_time)=DateName(Day,getDate())"
						+ "order by Order_time desc");
				pst.setString(1,personid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Orders g=new Orders();
					g.setOrdertime(rs.getString("order_time"));
					g.setOrderid(rs.getString("order_id"));
					g.setGoodnum(rs.getInt("order_good_num"));
					g.setOrdernum(rs.getInt("order_num"));
					g.setOrderstate(rs.getInt("order_state"));
					g.setShopid(rs.getString("order_shopid"));
					g.setOrdersum(rs.getFloat("order_sum"));
					g.setShopname(rs.getString("shop_name"));
					g.setShopimg(rs.getString("shop_img"));
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
	public ArrayList<Orders> orderselect2(String personid)   // 根据personid寻找所有的订单
	{
		ArrayList<Orders> goods=new ArrayList<Orders>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * "
						+ "from order_info,shop "
						+ "where order_personid=? "
						+ "and shop.shop_id=order_info.order_shopid "
						+ "order by Order_time desc");
				pst.setString(1,personid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Orders g=new Orders();
					g.setOrdertime(rs.getString("order_time"));
					g.setOrderid(rs.getString("order_id"));
					g.setGoodnum(rs.getInt("order_good_num"));
					g.setOrdernum(rs.getInt("order_num"));
					g.setOrderstate(rs.getInt("order_state"));
					g.setShopid(rs.getString("order_shopid"));
					g.setOrdersum(rs.getFloat("order_sum"));
					g.setShopname(rs.getString("shop_name"));
					g.setShopimg(rs.getString("shop_img"));
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
	public int updateGood(String orderid) {
		int num=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("update Order_info set Order_state=3 where Order_id= ?");
				pst.setString(1,orderid);
				num=pst.executeUpdate();
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return num;
	 }
}
