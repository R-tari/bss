package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


	public class UserDAO 
	{
		private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		public UserDAO()
		{
			try
			{
				String dbURL = "jddc;mysql://localhost:3306/bbs";
				String dbID="root";
				String dbPassword="root";
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(dbURL, dbID,dbPassword);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public int login(String userID,String userPassword)
		{
			String SQL="SELECT userPassword FROM user WHERE userID = ?";
			try
			{
				pstmt=conn.prepareStatement(SQL);
				pstmt.setString(1, userID);
				rs=pstmt.executeQuery();
				
				
				
				if(rs.next())
				{
					//아이디 존재
					if(rs.getString(1).equals(userPassword))
					{
						return 1;
					}
					else
					{
						return 0;
					}
				}
				else
				{
					return -1; //아이디가 존재하지 않음
				}
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return -2; //데이터베이스 오류
		}
		
		public int join(user)
		{
			String SQL="INSERT INTO user VALUES(?,?,?,?,?)";
			try
			{
				pstmt=conn.prepareStatement(SQL);
				pstmt.setString(1,user.getUserID());
				pstmt.setString(2,user.getUserPassword());
				pstmt.setString(3,user.getUserName());
				pstmt.setString(4,user.getUserEmail());
				pstmt.setString(5,user.getUserPhone());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return -300;
		}

}

