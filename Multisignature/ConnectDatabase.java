

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;


public  class ConnectDatabase

{
	public static Statement st1;
	public ConnectDatabase()

	{

		try
		{

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	
			Connection con1=DriverManager.getConnection("jdbc:odbc:signature","sa", "");
			st1=con1.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("exception" + e );
		}
	}

}	
	
	



