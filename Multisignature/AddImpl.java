

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.sql.*;
import java.io.*;
public class AddImpl 
{
	public String tableName = "";
	public AddImpl() throws Exception
	{
		tableName = ShowAdminMsg.tableName;
		ConnectDatabase cd=new ConnectDatabase();
	}

	public ArrayList getMember(String query) throws Exception
	{
		ArrayList list=new ArrayList();
		try
		{
			System.out.println(query);
			
			ResultSet rs=ConnectDatabase.st1.executeQuery(query);
		
			while(rs.next())
			{

				list.add(rs.getString(1));
			}
			rs.close();
		}
		catch (Exception e)
		{

		}
		return list;
	}	
	public ArrayList getChilds(String query) throws Exception
	{
		ArrayList list=new ArrayList();
		try
		{			
			ResultSet rs=ConnectDatabase.st1.executeQuery(query);

			while(rs.next())
			{
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
			}
			rs.close();
		}
		catch (Exception e)
		{

		}
		return list;
	}


	public ArrayList getChild1(String query) throws Exception
	{
		ArrayList list=new ArrayList();
		try
		{			
			ResultSet rs=ConnectDatabase.st1.executeQuery(query);

			while(rs.next())
			{
				list.add(rs.getString(1));
				list.add(rs.getString(2));

			}
			rs.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

 
	public void dataUpdate(String query) throws Exception
	{
		
		try
		{			
			ConnectDatabase.st1.executeUpdate(query);

		}
		catch (Exception e)
		{

		}

	}
	public void sendRequestAll(String qrs) throws Exception
	{
		
		try
		{		
			ConnectDatabase.st1.executeUpdate(qrs);

		}
		catch (Exception e)
		{

		}

	}

	/*public void deleteRequest(String dq) throws Exception
	{
		System.out.println("This is Delte Request "+dq);
		try
		{

			ConnectDatabase.st1.executeUpdate(dq);

		}
		catch (Exception de)
		{
			de.printStackTrace();
		}

	}

	public void deleteRequestAll(String dqall) throws Exception
	{
		System.out.println("This is Delte Request All "+dqall);
		
		try
		{

			
			ConnectDatabase.st1.executeUpdate(dqall);

		}
		catch (Exception dea)
		{
			dea.printStackTrace();
		}

	}
	//public void addmem(String q123) throws Exception
	//{
	//	
	//	try
	//	{
	//
	//		
	//		ConnectDatabase.st1.executeUpdate(q123);
	//
	//	}
	//	catch (Exception e)
	//	{
	//
	//	}
	//
	//}*/

	public void requestUpdate(String rq) throws Exception
	{
		
		try
		{

			
			ConnectDatabase.st1.executeUpdate(rq);

		}
		catch (Exception re)
		{

		}

	}
	public ArrayList getKey(String query) throws Exception
	{
		ArrayList list=new ArrayList();
		try
		{

			
			ResultSet rs=ConnectDatabase.st1.executeQuery(query);

			while(rs.next())
			{
				list.add(rs.getString(1));


			}
			rs.close();
		}
		catch (Exception e)
		{

		}
		return list;
	}



	public ArrayList getGroupKey(String query) throws Exception
	{
		ArrayList list=new ArrayList();
		try
		{

			
			ResultSet rs=ConnectDatabase.st1.executeQuery(query);

			while(rs.next())
			{

				list.add(rs.getString(1));

			}
			rs.close();
		}
		catch (Exception e)
		{
			
		}
		return list;
	}


	public ArrayList getMemberNames(String query) throws Exception
	{
		ArrayList list=new ArrayList();
		try
		{
			System.out.println(query);
			
			ResultSet rs=ConnectDatabase.st1.executeQuery(query);

			while(rs.next())
			{

				String filename=rs.getString(1);
				list.add(filename);
                File f = new File(filename);
                   f.mkdir();
                  

			}
			rs.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}	


	/*public void writeFile(String content, String filename, String desname, String username,java.util.Date date) throws Exception
	{

   try
   {

	File f=new File("");
	String fname=f.getAbsolutePath()+"/"+username+"/"+filename;




	DataOutputStream dos=new DataOutputStream(new FileOutputStream(fname));

	dos.writeUTF(desname);
	dos.writeUTF(date.toLocaleString());
	dos.writeUTF(content);

   }
   catch (Exception e)
   {
		e.printStackTrace();
   }


	}



	public void writeFileAll(String content, String filename, java.util.Date date, String username) throws Exception
	{

	   try
	   {

			File f=new File("");
			String s="select memname from "+tableName+" where s1 is null or s2 is null";

			ResultSet rs=ConnectDatabase.st1.executeQuery(s);

			while(rs.next())
			{
				String getValue=rs.getString(1);

				if(!getValue.equals(username))
				{

					String fname=f.getAbsolutePath()+"/"+getValue+"/"+filename;

					DataOutputStream dos=new DataOutputStream(new FileOutputStream(fname));

					dos.writeUTF(username);
					dos.writeUTF(date.toLocaleString());
					dos.writeUTF(content);
				}
			}
		 }
		 catch (Exception e)
		 {
			e.printStackTrace();
		 }
	}

	public String[] getFileNames(String username) throws Exception
	{
		String filenames[]=null; 
		try
		{
	
			File f=new File("");
			String fname=f.getAbsolutePath()+"/"+username+"/";

			File f1=new File(fname);
			filenames=f1.list();

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return filenames;

	}


	public boolean getAuthentication(String query) throws Exception
	{
		try
		{
			System.out.println(query);
			
			ResultSet rs=ConnectDatabase.st1.executeQuery(query);

			if(rs.next())
			{

				return true;
                  

			}
			rs.close();
		}
		catch (Exception ee)
		{
			ee.printStackTrace();
		}
		return false;
	}



	public ArrayList getMemberNamesList(String query, String username) throws Exception
	{
		ArrayList list=new ArrayList();
		try
		{
			System.out.println(query);
			
			ResultSet rs=ConnectDatabase.st1.executeQuery(query);




			while(rs.next())
			{

				String filename=rs.getString(1);
			if(!filename.equals(username))	
				{
				
				list.add(filename);
                }
			}
			rs.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}	




public ArrayList getMemberNamesList1(String query123, String username123) throws Exception
{
	ArrayList list=new ArrayList();
	try
	{
		System.out.println("wwwwwwwwwwwwww"+query123);
		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzz"+username123);
		
		ResultSet rs=ConnectDatabase.st1.executeQuery(query123);




		while(rs.next())
		{
		String filename123=rs.getString(1);
		if(!filename123.equals(username123))	
			{
			System.out.println(filename123);
			list.add(filename123);
            }
		}
		rs.close();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	return list;
}	


	public ArrayList getFiles(String username) throws Exception
	{
		ArrayList list=new ArrayList();
		try
		{

				File f=new File(new File("").getAbsolutePath()+"\\"+username);
				String path=f.getAbsolutePath()+"\\"+username;




				System.out.println();
				File files[]=f.listFiles();
				for(int i=0;i<files.length;i++)
				{
					String fname=files[i].getAbsolutePath();
					
					DataInputStream dis=new  DataInputStream(new FileInputStream(fname));
					String s=dis.readUTF()+"   "+files[i].getName()+"   "+dis.readUTF();
					String content=dis.readUTF();
					
					list.add(s);
					list.add(content);
				}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}*/

	public int getMembers(String query) throws Exception
	{
		int member=0;
		try
		{
			System.out.println("The Passed Query = "+query);
			ResultSet rs=ConnectDatabase.st1.executeQuery(query);
			//System.out.println("The Result Set is Executed");
			if(rs.next())
			{
				//System.out.println("Inside the Result Set");
				member=rs.getInt(1);
				int l=2*member+1;
				String qry = "INSERT INTO "+tableName+" (members) values ("+l+")";
				ConnectDatabase.st1.executeUpdate(qry);
				int r=2*member+2;
				System.out.println("..................");
				qry = "INSERT INTO "+tableName+" (members) values ("+r+")";
				ConnectDatabase.st1.executeUpdate(qry);				
				ResultSet rs1=ConnectDatabase.st1.executeQuery("select memname,pass from "+tableName+"  where members="+member);
				if(rs1.next())
				{
					ConnectDatabase.st1.executeUpdate("update "+tableName+"  set memname='"+rs1.getString(1)+"',pass='"+rs1.getString(2)+"' where members="+l);
					ConnectDatabase.st1.executeUpdate("update "+tableName+"  set s1="+l+",s2="+r+",memname='  ',pass='  ' where members="+member);
				}

				member=r;
			}
			else
			{
				int no = 0;
				int t=ConnectDatabase.st1.executeUpdate("INSERT INTO "+tableName+" (members) values("+no+")");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return member;
	}
	public String getMemName(String query) throws Exception
	{
		String memname="";
		try
		{
			ResultSet rs=ConnectDatabase.st1.executeQuery(query);
			if(rs.next())
				memname=rs.getString(1);



		}
		catch (Exception ee)
		{
			ee.printStackTrace();
		}
		return memname;
	}

	public boolean deleteFile(String username, String filename) throws Exception
	{
boolean status=false;
   try
   {
	   System.out.println("USERNAME "+username.trim());
	   System.out.println("FILE NAME"+filename.trim());

	File f=new File("\\username\filename");
	System.out.println(f.getAbsolutePath());



if(f.isFile())


	   {
	f.delete();
	boolean status1= true;
	System.out.println("file delete"+status1);
	   }
   }
   catch (Exception e)
   {
e.printStackTrace();
   }
return status;

	}
public String getRequest(String qqq) throws Exception
{
	String strr=null;
	//System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+qqq);
try
{
	ResultSet rss = ConnectDatabase.st1.executeQuery(qqq);
	if(rss.next())
	{
		strr = rss.getString(2);
		System.out.println("Requst is processed");
	}
	else
	{
		strr = "No Request";
	}
	
}catch (Exception eee) {
	eee.printStackTrace();
	
	// TODO: handle exception
}
return strr;
}

public String getRequest123(String qqq1) throws Exception
{
	String strr1=null;
	String str123=null;
	//System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+qqq);
try
{
	ResultSet rss1 = ConnectDatabase.st1.executeQuery(qqq1);
	if(rss1.next())
	{
		strr1 = rss1.getString(2);
		System.out.println("Requst is processed123456789"+qqq1+"eeeeeeeeee"+strr1);	
	}
	
	
}catch (Exception eeee) {
	eeee.printStackTrace();
	
	// TODO: handle exception
}
return strr1;
}



	public void deleteMember(String membername) throws Exception
	{
		String member="";
		String password="";
		String memname="";
		String query="";
		try
		{
			ResultSet rs=ConnectDatabase.st1.executeQuery("select members from "+tableName+"  where memname='"+membername+"'");
			if(rs.next())
			{
				member=rs.getString(1);
			}
			rs.close();
			ResultSet rs1=ConnectDatabase.st1.executeQuery("select members,s1,s2 from "+tableName+"  where s1='"+member+"' or s2='"+member+"'");
			if(rs1.next())
			{
				String mem=rs1.getString(1);
				String s1=rs1.getString(2);
				String s2=rs1.getString(3);
				rs1.close();
				if(!s1.equalsIgnoreCase(member))
					query="select memname,pass from "+tableName+"  where members='"+s1+"'";
				else
					query="select memname,pass from "+tableName+"  where members='"+s2+"'";
				ResultSet rs2=ConnectDatabase.st1.executeQuery(query);
				if(rs2.next())
				{
					memname=rs2.getString(1);
					password=rs2.getString(2);
				}
				int a=ConnectDatabase.st1.executeUpdate("delete from "+tableName+"  where members='"+s1+"'");
				int b=ConnectDatabase.st1.executeUpdate("delete from "+tableName+"  where members='"+s2+"'");
				int t=ConnectDatabase.st1.executeUpdate("update "+tableName+"  set s1=null,s2=null,memname='"+memname+"',pass='"+password+"' where members='"+mem+"'");
				//ConnectDatabase.st1.addBatch("delete from tree1 where memname ='"+membername+"'");
				//ConnectDatabase.st1.addBatch("update tree1 set request=replace(request,'"+membername+"#','')");
				//ConnectDatabase.st1.executeUpdate("delete from tree1 where memname ='"+membername+"'");
				//ConnectDatabase.st1.executeUpdate("update tree1 set request=replace(request,'"+membername+"#','')");
				ConnectDatabase.st1.executeBatch();
			}

			//File folObj=new File("");
			//String folDel=folObj.getAbsolutePath()+"\\"+membername;

			//File folderDelete=new File(folDel);

			//boolean status=folderDelete.delete();
			//System.out.println("folder delete"+status);		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}











}