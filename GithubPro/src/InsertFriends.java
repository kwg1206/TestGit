import java.sql.*;
public class InsertFriends
{
	public static void main(String args[])
	{
		String[][] friends = {{"wang", "1345464313", "beijing", "lover"},
				{"xie", "172742353", "guangdong", "friend"},
				{"wang", "272372742", "wuhan", "myself"}};
		String url = "jdbc:mysql://localhost:3306/ctea";  //CTea 是我的数据库所在的目录
		Connection con;
		Statement stmt;
		String query = "select Name, Telephone from my_test";		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch(java.lang.ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try
		{
			con = DriverManager.getConnection(url,"root","");
			stmt = con.createStatement();
			stmt.executeUpdate("delete from sys");//my_test是数据库名
			for(int i=0;i<3;i++)
			{
				stmt.executeUpdate("insert into my_test(Name,Telephone,Address,Note) values" +
						"(\""+friends[i][0]+"\",\""+friends[i][1]+"\",\""+friends[i][2]+"\",\""+friends[i][3]+"\")");
			}
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(" Name    Telephone:");
			while (rs.next())
			{
				String n = rs.getString("Name");
				String t = rs.getString("Telephone");
				System.out.println(n + "  " + t);
			}
			stmt.close();
			con.close();
		}catch(SQLException ex){
			System.err.println("SQLException: " + ex.getMessage());
		}

	}
}