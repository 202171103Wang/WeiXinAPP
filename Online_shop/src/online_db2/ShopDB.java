package online_db2;

import java.sql.*;
import java.util.ArrayList;
import javabean2.*;
public class ShopDB extends DbConn{
	public ArrayList<Shops> selectshops()  //展示东一商铺
	{
		ArrayList<Shops> shops=new ArrayList<Shops>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Shop");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Shops s=new Shops();
					s.setShopid(rs.getString("Shop_id"));
					s.setShopname(rs.getString("Shop_name"));
					s.setShopimg(rs.getString("Shop_img"));
					s.setShopadd(rs.getString("Shop_place"));
					s.setState(rs.getInt("Shop_state"));
					shops.add(s);
				}
				rs.close();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return shops;
	}
	public ArrayList<Shops> select1shops()  //展示东一商铺
	{
		ArrayList<Shops> shops=new ArrayList<Shops>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Shop where Shop_place like '东一%%' ");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Shops s=new Shops();
					s.setShopid(rs.getString("Shop_id"));
					s.setShopname(rs.getString("Shop_name"));
					s.setShopimg(rs.getString("Shop_img"));
					s.setShopadd(rs.getString("Shop_place"));
					s.setState(rs.getInt("Shop_state"));
					shops.add(s);
				}
				rs.close();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return shops;
	}
	public ArrayList<Shops> select2shops()  //展示所有商铺
	{
		ArrayList<Shops> shops=new ArrayList<Shops>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Shop where Shop_place like '东二%%' ");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Shops s=new Shops();
					s.setShopid(rs.getString("Shop_id"));
					s.setShopname(rs.getString("Shop_name"));
					s.setShopimg(rs.getString("Shop_img"));
					s.setShopadd(rs.getString("Shop_place"));
					s.setState(rs.getInt("Shop_state"));
					shops.add(s);
				}
				rs.close();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return shops;
	}
	public ArrayList<Shops> select3shops()  //展示所有商铺
	{
		ArrayList<Shops> shops=new ArrayList<Shops>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Shop where Shop_place like '北一%%' ");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Shops s=new Shops();
					s.setShopid(rs.getString("Shop_id"));
					s.setShopname(rs.getString("Shop_name"));
					s.setShopimg(rs.getString("Shop_img"));
					s.setShopadd(rs.getString("Shop_place"));
					s.setState(rs.getInt("Shop_state"));
					shops.add(s);
				}
				rs.close();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return shops;
	}
	public ArrayList<Shops> select4shops()  //展示所有商铺
	{
		ArrayList<Shops> shops=new ArrayList<Shops>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Shop where Shop_place like '北二%%' ");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Shops s=new Shops();
					s.setShopid(rs.getString("Shop_id"));
					s.setShopname(rs.getString("Shop_name"));
					s.setShopimg(rs.getString("Shop_img"));
					s.setShopadd(rs.getString("Shop_place"));
					s.setState(rs.getInt("Shop_state"));
					shops.add(s);
				}
				rs.close();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return shops;
	}
	public ArrayList<Shops> selectshopsbyname(String name)  //展示所有商铺
	{
		ArrayList<Shops> shops=new ArrayList<Shops>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Shop\r\n" + 
						"where shop_name like ?");
				String n="%"+name+"%";
				pst.setString(1, n);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Shops s=new Shops();
					s.setShopid(rs.getString("Shop_id"));
					s.setShopname(rs.getString("Shop_name"));
					s.setShopimg(rs.getString("Shop_img"));
					s.setShopadd(rs.getString("Shop_place"));
					s.setState(rs.getInt("Shop_state"));
					shops.add(s);
				}
				rs.close();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return shops;
	}
	public Shops selectshopbyid(String shopid)  //展示东一商铺
	{
		 Shops s=new Shops();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Shop where shop_id= ?");
				pst.setString(1, shopid);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					s.setShopid(rs.getString("Shop_id"));
					s.setShopname(rs.getString("Shop_name"));
					s.setShopimg(rs.getString("Shop_img"));
					s.setShopadd(rs.getString("Shop_place"));
					s.setState(rs.getInt("Shop_state"));
				}
				rs.close();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return s;
	}
}

