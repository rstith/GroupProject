/*This is the connector to the MySQL database. It contains just read and write functions, handled by other classes
 * Please don't touch
 * 
 */
package database;

import java.sql.*;

public class SQLDriver {

			private static String url = "jdbc:mysql://162.226.167.3:3306/";
			private static String dbName = "BankHW";
			//private static String driver = "com.mysql.jdbc.Driver";
			private static String userName = "testuser";
			private static String password = "password";
			private static Statement st;
			private static Connection conn;

			public SQLDriver()
			{
				try{
					conn = DriverManager.getConnection(url+dbName,userName,password);
					st = conn.createStatement();
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}

			
	public Object select(String statement)
	{
		try{
		ResultSet rs = st.executeQuery(statement);
		return rs;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	public void insert(String statement)
	{
		try
		{
			st.execute(statement);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
		
}

