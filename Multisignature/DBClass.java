
import java.sql.*;
import java.math.BigInteger;
public class DBClass
{
	Connection con,c1;
	Statement st,st1;
	ResultSet rs;
	DBClass()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:signature","sa","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Database Connectivity Error "+e);
		}

	}
	public int getResult(String id,String pass,String gid) throws Exception
	{
		rs=st.executeQuery("select * from UsersInfo where UserId = '"+id+"' and Password = '"+pass+"' and GrpId = '"+gid+"'");
		if(rs.next())
		{
			System.out.println("The Values are Found");
			return 1;
		}
		else
			return 0;
	}
	
	// new edit 
	
	public int sgetResult(String id,String gid) throws Exception
	{
		rs=st.executeQuery("select * from UsersInfo where UserId = '"+id+"' AND GrpId = '"+gid+"'");
		if(rs.next())
		{
			System.out.println("The Values are Found");
			return 1;
		}
		else
			return 0;
	}

public int getUsersCount(String gid)throws Exception
	{
		int c=0;
		if(gid=="Group 1")
		{
		rs=st.executeQuery("select UserId from usersinfo where Grpid like '"+gid+"%'");
		while(rs.next())
		{
			c++;
		}
		}
		else
		{
			rs=st.executeQuery("select UserId from usersinfo where Grpid like '"+gid+"%'");
		while(rs.next())
		{
			c++;
		}
		
		}
		return c;

	}
	public String[] getUsers(String gid,int n)throws Exception
	{
		int i=0;
		String users[]=new String[n];
		rs=st.executeQuery("select UserId from Usersinfo where Grpid like '"+gid+"%'");
		while(rs.next())
		{
			users[i]=rs.getString("UserId");
			i++;
		}
		return users;
	}



	//end------------------------------


	public int getResultInfo(String id,String pass,String gid) throws Exception
	{
		String tableName = "";
		if(gid.equalsIgnoreCase("Group 1")){
			tableName = "tree1";
		}
		else{
			tableName = "tree2";
		}
		System.out.println("The Selected Group Table = "+tableName);
		rs=st.executeQuery("select * from "+tableName+" where memname = '"+id+"' and pass = '"+pass+"'");
		if(rs.next())
		{
			System.out.println("The Values are Found");
			return 1;
		}
		else
			return 0;
	}
	public String getHostAdrs(String gid)throws Exception
	{
		String adrs="";
		rs=st.executeQuery("select UserIpAdrs from UsersInfo where UserId = '"+gid+"'");
		if(rs.next())
		{
			adrs = rs.getString(1);
		}
		return adrs;
	}
	public int addMember(String id,String pass,String gid)throws Exception
	{
		st.executeUpdate("Insert into UsersInfo (UserId,Password,GrpId) values ('"+id+"','"+pass+"','"+gid+"')");
		return 1;
	}
	public int checkMailId(String mailid,String gid)throws Exception
	{
			int i=0;
			rs=st.executeQuery("select * from UsersInfo where UserId = '"+mailid+"' AND GrpId = '"+gid+"'");
			
			if(rs.next())
			{
				System.out.println("value 1:::"+rs.getString(1));
				System.out.println("value 2:::"+rs.getString(2));
				System.out.println("value3 :::"+rs.getString(3));
				i=1;
			}
			return i;
	}
	public boolean checkPermit(String id)throws Exception
	{

		rs=st.executeQuery("Select * from UsersInfo where MailId = '"+id+"'");
		boolean flag = false;
		if(rs.next())
		{
			flag = true;
		}
		return flag;
	}
	public boolean assignKeys(String mailid,String pass,String usradrs,String gid)
	{
		boolean flag = false;
		try
		{
			String query = "Update UsersInfo set UserIpAdrs = '"+usradrs+"' where UserId='"+mailid+"' and GrpId='"+gid+"'";
			st.executeUpdate(query);
			flag = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	public boolean removeUser(String mailid,String gid)
	{
		boolean flag = false;
		try
		{
			String query = "Delete from UsersInfo where UserId='"+mailid+"' and GrpId='"+gid+"'";
			st.executeUpdate(query);
			flag = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	public String getKey(String user,String grpid)
	{
		System.out.println("Inside the getKey Method");
		String gid = "";
		if(grpid.equalsIgnoreCase("Group 1"))
			gid = "tree1";
		else if(grpid.equalsIgnoreCase("Group 2"))
			gid = "tree2";
		String key ="";
		try
		{
			rs = st.executeQuery("Select prikey from "+gid+" where memname = '"+user+"'");
			if(rs.next())
			{
				key = rs.getString(1);
				System.out.println("The Key Value = "+key);
			}
			if(key.length()>8)
				key = key.substring(0,8);
			else
			{
				int i = key.length();
				System.out.println("The Key Length = "+i);
				while(i<8)
				{
					key = key + i;
					System.out.println("The Key = "+key);
					i++;
				}
			}
			
		}
		catch (Exception e)
		{
			System.out.println("Exception :"+e);
		}
		return key;
	}
}

