//µÇÂ½Êý¾Ý¿â
package online_db;
import java.sql.*;
public class DbConn {
	private String sDBDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String sConnStr="jdbc:sqlserver://localhost:1433;DatabaseName=online_shop";
	private String sUsername="sa",sPassword="123456";
	protected Connection conn=null;
	public DbConn()
	{
		Connection con=null;
		try {
			Class.forName(sDBDriver);
			con=DriverManager.getConnection(sConnStr,sUsername,sPassword);
			
		}catch(java.lang.ClassNotFoundException e)
		{
			System.out.println( e.getMessage());
		}
		catch(SQLException e)
		{
			System.out.print(e.getMessage());
		}
		this.conn=con;
		System.out.println("Success!");
	}
	public void close()
	{
		try
		{
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
