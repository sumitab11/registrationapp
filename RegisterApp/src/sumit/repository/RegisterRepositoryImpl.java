package sumit.repository;

import sumit.model.LoginModel;
import sumit.model.Register;
import java.sql.*;


public class RegisterRepositoryImpl implements RegisterRepository {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	public RegisterRepositoryImpl()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","sumit@1234");
			
			
		}catch(Exception ex) {
			
			System.out.println("Error is " +ex);
		}
		
		
		
	}
	
	@Override
	public boolean isRegisterUser(Register register) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.prepareStatement("insert into register6 values('0',?,?,?,?,?)");
			stmt.setString(1, register.getName());
			stmt.setString(2, register.getEmail());
			stmt.setString(3, register.getContact());
			stmt.setString(4, register.getUsername());
			stmt.setString(5, register.getPassword());
			int value=stmt.executeUpdate();
			if(value>0) {
				return true;
				
			}else {
				return false;
			}
			
			
		}catch(Exception ex) {
			System.out.println("Error is" +ex);
			return false;
		}
		
		
		
		
		
	}

	@Override
	public boolean isValidateUser(LoginModel loginmodel) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.prepareStatement("select * from register6 where name=? and password=?");
			stmt.setString(1, loginmodel.getName());
			stmt.setString(2, loginmodel.getPassword());
			rs=stmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
			
			
		}catch(Exception ex) {
			System.out.println("Error is " +ex);
			return false;
		}
		
	}

	
}
