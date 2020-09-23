package online_db2;
import javabean2.*;
import java.sql.*;
import java.util.*;
public class GoodDB extends DbConn{
	public ArrayList<Goods> goodselect(String shopid)   // 根据商铺id寻找商铺所有的商品
	{
		ArrayList<Goods> goods=new ArrayList<Goods>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Good where Good_shopid=?");
				pst.setString(1,shopid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Goods g=new Goods();
					g.setGoodid(rs.getString("Good_id"));
					g.setGoodname(rs.getString("Good_name"));
					g.setGoodimg(rs.getString("Good_img"));
					g.setGoodnum(rs.getInt("Good_num"));
					g.setGoodprice(rs.getFloat("Good_price"));
					g.setGoodkind(rs.getString("Good_kind"));
					g.setGoodmess(rs.getString("Good_mess"));
					g.setShopid(rs.getString("Good_shopid"));
					g.setBuynum("0");
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
	public ArrayList<String> goodselects(String shopid)   // 根据商铺id寻找商铺所有的商品
	{
		ArrayList<String> goods=new ArrayList<String>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select distinct Good_kind from Good where Good_shopid=?");
				pst.setString(1,shopid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					String g=rs.getString("Good_kind");
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
	public ArrayList<Goods> menuselect(String shopid, String kind) {
		ArrayList<Goods> goods=new ArrayList<Goods>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Good where Good_shopid=? and Good_kind=?");
				pst.setString(1,shopid);
				pst.setString(2,kind);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Goods g=new Goods();
					g.setGoodid(rs.getString("Good_id"));
					g.setGoodname(rs.getString("Good_name"));
					g.setGoodimg(rs.getString("Good_img"));
					g.setGoodnum(rs.getInt("Good_num"));
					g.setGoodprice(rs.getFloat("Good_price"));
					g.setGoodkind(rs.getString("Good_kind"));
					g.setGoodmess(rs.getString("Good_mess"));
					g.setShopid(rs.getString("Good_shopid"));
					g.setBuynum("0");
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