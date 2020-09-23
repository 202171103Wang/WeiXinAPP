package online_db2;
import javabean2.*;
import java.sql.*;
public class PersonDB extends DbConn{
	
	public int addUser(Person u) {
    	int result=0;
    	if(conn!=null) {
    		try {
 			PreparedStatement pst=conn.prepareStatement("insert into [Person] values(?,?,?,?,?,?)");
				pst.setString(1,u.getPerson_id());
			    pst.setString(2,u.getPerson_name());
			    pst.setString(3, u.getPerson_img());
			    pst.setInt(4, u.getPerson_professor());
				pst.setString(5,u.getPerson_call());
				pst.setString(6, u.getPerson_pwd());
				result=pst.executeUpdate();
    		}
    		catch(SQLException e)
    		{
    		    
    			System.out.println(e.getMessage());
    		}
    	}
    	return result;
    }
	
	public String iscall(String Person_id){
		String flag ="";
		if(conn!=null){
			try{
				PreparedStatement pst=conn.prepareStatement("select Person_call from [Person] where Person_id=? ");
				pst.setString(1, Person_id);
				ResultSet rs=pst.executeQuery();
				if(rs.next()){
					flag=rs.getString("Person_call");
				}
				rs.close();
			}
			catch(SQLException ex){
				System.err.println(ex.getMessage());
			}
		}
		return flag;
	}
	public boolean isLogin(String Person_id,String Person_pwd){
		boolean flag =false;
		if(conn!=null){
			try{
				PreparedStatement pst=conn.prepareStatement("select * from [Person] where Person_id=? and Person_pwd=? and Person_professor=0");
				pst.setString(1, Person_id);
				pst.setString(2, Person_pwd);
				ResultSet rs=pst.executeQuery();
				if(rs.next()){
					flag=true;
				}
				rs.close();
			}
			catch(SQLException ex){
				System.err.println(ex.getMessage());
			}
		}
		return flag;
	}
	 public int updatecall(String Person_id,String call){
		int result=0;
		if(conn!=null){
			try{
				PreparedStatement pst=conn.prepareStatement("update  Person set Person_call = ? where Person_id=? ");
				pst.setString(1, call);
				pst.setString(2,Person_id);
				result=pst.executeUpdate();
			}
			catch(SQLException ex){
				System.err.println(ex.getMessage());
			}
		}
		return result;
	 }
}
