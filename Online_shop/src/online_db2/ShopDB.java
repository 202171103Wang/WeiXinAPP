package online_db2;

import java.sql.*;
import java.util.ArrayList;
import javabean2.*;
public class ShopDB extends DbConn{
	public ArrayList<Shops> selectshops()  //չʾ��һ����
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
	public ArrayList<Shops> select1shops()  //չʾ��һ����
	{
		ArrayList<Shops> shops=new ArrayList<Shops>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Shop where Shop_place like '��һ%%' ");
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
	public ArrayList<Shops> select2shops()  //չʾ��������
	{
		ArrayList<Shops> shops=new ArrayList<Shops>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Shop where Shop_place like '����%%' ");
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
	public ArrayList<Shops> select3shops()  //չʾ��������
	{
		ArrayList<Shops> shops=new ArrayList<Shops>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Shop where Shop_place like '��һ%%' ");
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
	public ArrayList<Shops> select4shops()  //չʾ��������
	{
		ArrayList<Shops> shops=new ArrayList<Shops>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from Shop where Shop_place like '����%%' ");
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
	public ArrayList<Shops> selectshopsbyname(String name)  //չʾ��������
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
	public Shops selectshopbyid(String shopid)  //չʾ��һ����
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

