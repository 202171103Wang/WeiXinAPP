package online_db;
import java.sql.*;
import java.util.ArrayList;
import javabean.*;
public class Good_db extends DbConn {
	
	//查询所有商品
	public ArrayList<Good> select_all_Good(String shopid){
       ArrayList<Good> goods=new ArrayList<Good>();
       if(conn!=null)
		{
			try
			{
				PreparedStatement pst=conn.prepareStatement("select * from Good where Good_shopid=?");
				pst.setString(1, shopid);
		    	ResultSet rs=pst.executeQuery();
		    	while(rs.next())
		    	{     
		    		Good g=new Good();
		    	     g.setGood_id(rs.getString("Good_id"));
		    	     g.setGood_name(rs.getString("Good_name"));
		             g.setGood_img(rs.getString("Good_img"));
		    	     g.setGood_price(rs.getFloat("Good_price"));
		    	     g.setGood_num(rs.getInt("Good_num"));
		    	     g.setGood_kind(rs.getString("Good_kind"));
		    	     g.setGood_mess(rs.getString("Good_mess"));
		    	     goods.add(g);
		    	}
		    	rs.close();
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
	   }
       return goods;
	}
	//增加商品
	public int addGood(Good g) {
		int num=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("insert into Good(Good_name,Good_img,Good_price,Good_num,Good_kind,Good_mess,Good_shopid) values(?,?,?,?,?,?,?)");
				pst.setString(1,g.getGood_name());
				pst.setString(2,g.getGood_img());
				pst.setFloat(3, g.getGood_price());
				pst.setInt(4, g.getGood_num());
				pst.setString(5,g.getGood_kind());
				pst.setString(6,g.getGood_mess());
				pst.setString(7,g.getGood_shopid());
				num=pst.executeUpdate();
			  }
			  catch(SQLException e)
			  {
				System.out.println(e.getMessage());
			  }
		}
		return num;
	}
	 //修改商品信息
	 public int updateGood(Good g) {
		int num=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("update Good set Good_name= ?,Good_price= ?,Good_num= ?,Good_kind= ?,Good_mess= ?,Good_shopid= ? where Good_id= ?");
				pst.setString(1, g.getGood_name());
				pst.setFloat(2, g.getGood_price());
				pst.setInt(3, g.getGood_num());
				pst.setString(4, g.getGood_kind());
				pst.setString(5, g.getGood_mess());
				pst.setString(6, g.getGood_shopid());
				pst.setString(7, g.getGood_id());
				num=pst.executeUpdate();
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return num;
	 }
	 //删除商品信息
	 public int delete(String i)
		{
			int result=0;
			if(conn!=null)
			{
				try {
					PreparedStatement pst=conn.prepareStatement("delete Good where Good_id= ?");
					pst.setString(1,i);
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
