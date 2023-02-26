

import java.io.*;
import java.net.*;
import java.sql.*;
import java.math.BigInteger;

public class ReceiveMsg
{
	Socket skt;
	ServerSocket ss;
	String str,id,sctkey,sender,receiver,subject,fname,flag,gettable;
	Connection con,con1;
	Statement st,st1;
	ResultSet rs;
	public ReceiveMsg( )
	{
		try
		{
			System.out.println("Waiting for the Message");
			ss=new ServerSocket(3000);
			
			while(true)
			{				
				
				skt=ss.accept();	
				System.out.println("Server socket accepts socket request");
				ObjectInputStream dis = new ObjectInputStream(skt.getInputStream());
				byte[] bb = (byte[])dis.readObject();				
				String s = new String(bb);
				System.out.println(s);
				String info[] = s.split("#");
				String sender = info[0];
				String gid = info[1];
				String subject = info[2];
				String key = info[4];
				String values[] = info[3].split(",");
				BigInteger p = new BigInteger(values[2]);
				BigInteger g = new BigInteger(values[3]);
				BigInteger y = new BigInteger(values[4]);				
				new ElGamalPublicKey(p,g,y);	
				bb = (byte[])dis.readObject();
				String s1 = null;
				try
				{
					FileOutputStream fos = new FileOutputStream(subject+".txt");
					fos.write(bb);
					System.out.println("The Encrypted File is Writted");
					new Decryption(subject+".txt",key);
					System.out.println("Successfully Decrypted");
					FileInputStream fis = new FileInputStream("Receive.txt");
					byte[] b = new byte[fis.available()];
					fis.read(b);
					s1 = new String(b);
					System.out.println("The Received Message ========= "+s);
					s1 = s1.substring(0,s1.indexOf("ÿ"));
				}
				catch (Exception e)
				{
					System.out.println("Exception :"+e);
				}
				SignatureGeneration sg = new SignatureGeneration(s.getBytes());
				s =  values[0]+","+values[1];
				byte[] signature = s.getBytes();
				boolean flag = sg.engineVerify(signature); 
				ObjectOutputStream dos = new ObjectOutputStream(skt.getOutputStream());
				if(flag)
				{
					System.out.println("Signature is Verified Successfully");
					new ShowMessage(sender,gid,subject,s1,key);
					s = new String("Success");
					dos.writeObject(s.getBytes());
				}
				else
				{
					System.out.println("Signature is Not Verified Successfully");
					s = new String("failure");
					dos.writeObject(s.getBytes());
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
		new ReceiveMsg();

	}
}