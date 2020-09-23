package online_db;
import java.sql.*;
import java.util.ArrayList;
import javabean.*;
public class Order_db extends DbConn{
	
	//查询所有历史订单
		public ArrayList<Order_info> select_all_Order(String shopid){
	       ArrayList<Order_info> orders=new ArrayList<Order_info>();
	       if(conn!=null)
			{
				try
				{
					PreparedStatement pst=conn.prepareStatement("select * from Order_info where  Order_shopid=?");
					pst.setString(1, shopid);
			    	ResultSet rs=pst.executeQuery();
			    	while(rs.next())
			    	{     
			    		Order_info o=new Order_info();
			    		o.setOrder_id(rs.getString("Order_id"));
			    		o.setOrder_num(rs.getInt("Order_num"));
			    		o.setOrder_personid(rs.getString("Order_personid"));
			    		o.setGood_num(rs.getInt("Order_good_num"));
			    		o.setOrder_sum(rs.getFloat("Order_sum"));
			    		o.setOrder_time(rs.getDate("Order_time"));
			    		o.setOrder_wait_time(rs.getString("Order_wait_time"));
			    		o.setOrder_state(rs.getInt("Order_state"));
			    		o.setOrder_shopid(rs.getString("Order_shopid"));
			    	    orders.add(o);
			    	}
			    	rs.close();
				}
				catch(SQLException ex)
				{
					System.out.println(ex.getMessage());
				}
		   }
	       return orders;
		}
		//查询当日订单
		public ArrayList<Order_info> select_today_Order(String shopid){
		       ArrayList<Order_info> orders=new ArrayList<Order_info>();
		       if(conn!=null)
				{
					try
					{
						PreparedStatement pst=conn.prepareStatement("select * from Order_info\r\n" + 
								"where Year(Order_time)=DATENAME(YEAR,getdate())\r\n" + 
								"and Month(Order_time)=DAteName(MONTH,getDate())\r\n" + 
								"and Day(Order_time)=DateName(Day,getDate()) and Order_shopid=?");
						pst.setString(1, shopid);
				    	ResultSet rs=pst.executeQuery();
				    	while(rs.next())
				    	{     
				    		Order_info o=new Order_info();
				    		o.setOrder_id(rs.getString("Order_id"));
				    		o.setOrder_num(rs.getInt("Order_num"));
				    		o.setOrder_personid(rs.getString("Order_personid"));
				    		o.setGood_num(rs.getInt("Order_good_num"));
				    		o.setOrder_sum(rs.getFloat("Order_sum"));
				    		o.setOrder_time(rs.getDate("Order_time"));
				    		o.setOrder_wait_time(rs.getString("Order_wait_time"));
				    		o.setOrder_state(rs.getInt("Order_state"));
				    		o.setOrder_shopid(rs.getString("Order_shopid"));
				    	    orders.add(o);
				    	}
				    	rs.close();
					}
					catch(SQLException ex)
					{
						System.out.println(ex.getMessage());
					}
			   }
		       return orders;
			}
		//查询当日没有完成的订单
		public ArrayList<Order_info> select_todayn_Order(String shopid){
		       ArrayList<Order_info> orders=new ArrayList<Order_info>();
		       if(conn!=null)
				{
					try
					{
						PreparedStatement pst=conn.prepareStatement("select * from Order_info\r\n" + 
								"where Year(Order_time)=DATENAME(YEAR,getdate())\r\n" + 
								"and Month(Order_time)=DAteName(MONTH,getDate())\r\n" + 
								"and Day(Order_time)=DateName(Day,getDate()) and Order_state=0 and Order_shopid=?");
						pst.setString(1, shopid);
				    	ResultSet rs=pst.executeQuery();
				    	while(rs.next())
				    	{     
				    		Order_info o=new Order_info();
				    		o.setOrder_id(rs.getString("Order_id"));
				    		o.setOrder_num(rs.getInt("Order_num"));
				    		o.setOrder_personid(rs.getString("Order_personid"));
				    		o.setGood_num(rs.getInt("Order_good_num"));
				    		o.setOrder_sum(rs.getFloat("Order_sum"));
				    		o.setOrder_time(rs.getDate("Order_time"));
				    		o.setOrder_wait_time(rs.getString("Order_wait_time"));
				    		o.setOrder_state(rs.getInt("Order_state"));
				    		o.setOrder_shopid(rs.getString("Order_shopid"));
				    	    orders.add(o);
				    	}
				    	rs.close();
					}
					catch(SQLException ex)
					{
						System.out.println(ex.getMessage());
					}
			   }
		       return orders;
			}
		//订单处理
		public int updateGood(String orderid) {
			int num=0;
			if(conn!=null)
			{
				try {
					PreparedStatement pst=conn.prepareStatement("update Order_info set Order_state=1 where Order_id= ?");
					pst.setString(1,orderid);
					num=pst.executeUpdate();
				}catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
			}
			return num;
		 }
		//根据日期查询订单
		public ArrayList<Order_info> select1_Order(String year,String month,String day,String shopid){
		       ArrayList<Order_info> orders=new ArrayList<Order_info>();
		       if(conn!=null)
				{
					try
					{
						PreparedStatement pst=conn.prepareStatement("select * from Order_info\r\n" + 
								"where Year(Order_time)= ?\r\n" + 
								"and Month(Order_time)= ?\r\n" + 
								"and Day(Order_time)= ? and Order_shopid= ?");
						pst.setString(1, year);
						pst.setString(2, month);
						pst.setString(3, day);
						pst.setString(4, shopid);
				    	ResultSet rs=pst.executeQuery();
				    	while(rs.next())
				    	{     
				    		Order_info o=new Order_info();
				    		o.setOrder_id(rs.getString("Order_id"));
				    		o.setOrder_num(rs.getInt("Order_num"));
				    		o.setOrder_personid(rs.getString("Order_personid"));
				    		o.setGood_num(rs.getInt("Order_good_num"));
				    		o.setOrder_sum(rs.getFloat("Order_sum"));
				    		o.setOrder_time(rs.getDate("Order_time"));
				    		o.setOrder_wait_time(rs.getString("Order_wait_time"));
				    		o.setOrder_state(rs.getInt("Order_state"));
				    		o.setOrder_shopid(rs.getString("Order_shopid"));
				    	    orders.add(o);
				    	}
				    	rs.close();
					}
					catch(SQLException ex)
					{
						System.out.println(ex.getMessage());
					}
			   }
		       return orders;
			}
		public ArrayList<Order_info> select2_Order(String year,String shopid){
		       ArrayList<Order_info> orders=new ArrayList<Order_info>();
		       if(conn!=null)
				{
					try
					{
						PreparedStatement pst=conn.prepareStatement("select * from Order_info\r\n" + 
								"where Year(Order_time)= ?\r\n" +  
								"and Order_shopid= ?");
						pst.setString(1, year);
						pst.setString(2, shopid);
				    	ResultSet rs=pst.executeQuery();
				    	while(rs.next())
				    	{     
				    		Order_info o=new Order_info();
				    		o.setOrder_id(rs.getString("Order_id"));
				    		o.setOrder_num(rs.getInt("Order_num"));
				    		o.setOrder_personid(rs.getString("Order_personid"));
				    		o.setGood_num(rs.getInt("Order_good_num"));
				    		o.setOrder_sum(rs.getFloat("Order_sum"));
				    		o.setOrder_time(rs.getDate("Order_time"));
				    		o.setOrder_wait_time(rs.getString("Order_wait_time"));
				    		o.setOrder_state(rs.getInt("Order_state"));
				    		o.setOrder_shopid(rs.getString("Order_shopid"));
				    	    orders.add(o);
				    	}
				    	rs.close();
					}
					catch(SQLException ex)
					{
						System.out.println(ex.getMessage());
					}
			   }
		       return orders;
			}
		public ArrayList<Order_info> select3_Order(String year,String month,String shopid){
		       ArrayList<Order_info> orders=new ArrayList<Order_info>();
		       if(conn!=null)
				{
					try
					{
						PreparedStatement pst=conn.prepareStatement("select * from Order_info\r\n" + 
								"where Year(Order_time)= ?\r\n" + 
								"and Month(Order_time)= ?\r\n" + 
								"and Order_shopid= ?");
						pst.setString(1, year);
						pst.setString(2, month);
						pst.setString(3, shopid);
				    	ResultSet rs=pst.executeQuery();
				    	while(rs.next())
				    	{     
				    		Order_info o=new Order_info();
				    		o.setOrder_id(rs.getString("Order_id"));
				    		o.setOrder_num(rs.getInt("Order_num"));
				    		o.setOrder_personid(rs.getString("Order_personid"));
				    		o.setGood_num(rs.getInt("Order_good_num"));
				    		o.setOrder_sum(rs.getFloat("Order_sum"));
				    		o.setOrder_time(rs.getDate("Order_time"));
				    		o.setOrder_wait_time(rs.getString("Order_wait_time"));
				    		o.setOrder_state(rs.getInt("Order_state"));
				    		o.setOrder_shopid(rs.getString("Order_shopid"));
				    	    orders.add(o);
				    	}
				    	rs.close();
					}
					catch(SQLException ex)
					{
						System.out.println(ex.getMessage());
					}
			   }
		       return orders;
			}
		//查询今日未处理订单数目
		public int select_num_Order(String shopid){
		      int num=0;
		       if(conn!=null)
				{
					try
					{
						PreparedStatement pst=conn.prepareStatement("select count(*) as num\r\n" + 
								"from Order_info\r\n" + 
								"where Order_state=0\r\n" + 
								"and Year(Order_time)=DATENAME(YEAR,getdate()) \r\n" + 
								"and Month(Order_time)=DAteName(MONTH,getDate())\r\n" + 
								"and Day(Order_time)=DateName(Day,getDate()) \r\n" + 
								"and Order_shopid= ?");
						pst.setString(1, shopid);
				    	ResultSet rs=pst.executeQuery();
				    	while(rs.next())
				    	{     
				    		num=rs.getInt("num");
				    	}
				    	rs.close();
					}
					catch(SQLException ex)
					{
						System.out.println(ex.getMessage());
					}
			   }
		       return num;
			}
}
