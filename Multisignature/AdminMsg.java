

import java.io.*;
import java.net.*;
import java.sql.*;
import java.math.BigInteger;

public class AdminMsg
{
	Socket s;
	ServerSocket ss;
	String str,id,sctkey,sender,receiver,subject,fname,flag,gettable;
	DataInputStream dis=null;
	DataOutputStream dos = null;
	public AdminMsg( )
	{
		try
		{
			System.out.println("Waiting for the Message");
			ss=new ServerSocket(1000);
			DBClass db = new DBClass();
			while(true)
			{
				s=ss.accept();
				System.out.println("Server socket accepts socket request");
				
				dis = new DataInputStream(s.getInputStream());
				String packet = dis.readUTF();
				System.out.println("The Received Packet = "+packet);
				String info[] = packet.split("#");
				new ShowAdminMsg(info[0],info[1],info[2],info[3],info[4],info[5]);
				System.out.println("Show the Requisition Information to the Admin...");
				
				int i = db.getResultInfo(info[0], info[1], info[2]);
				if(i==1)
				{
					dos = new DataOutputStream(s.getOutputStream());
					dos.writeUTF("Accepted");
				}
				else
				{
					dos = new DataOutputStream(s.getOutputStream());
					dos.writeUTF("Rejected");
				}
			}

		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}
	public static void main(String args[])
	{
		new AdminMsg();

	}
}