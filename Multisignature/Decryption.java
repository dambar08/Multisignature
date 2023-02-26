

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Decryption
{
	String s;
    FileInputStream fin=null;
   	FileOutputStream fout =null;
    RandomAccessFile keydesc=null;
   	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    MathCalc mc = new MathCalc();
    DESalgorithm DES = new DESalgorithm();
    int index=0;
    int i=0, cnt =0,a=0,keyelem=0,found=0,len;
    String s2 ="", s3="",fstr="",kstr="",c="", keyarr,inpkey="";
    String keystr="";
    char x;
    int wr;
    String key1;
    int[] eachblk =new int[8];
    int inparr[] = new int[8];
    int []datablock=new int[64];
    int []keyblock=new int[64];
    int []encdecblock = new int[64];
	public Decryption(String file,String key)
 	{
		try
		{
			file.trim();
			key.trim();
			test(file,key);
		}
		catch(Exception ex)
		{
			System.out.println("File Exception while Decrypting "+ex);
		}
 	}


 	public void test(String file,String key)throws Exception
    {
		for(int h=0;h<64;h++)
		{
		          datablock[h]=0;
   		}
        for(i=0;i<8;i++)
		{
	           inparr[i]=0;
   		}
	    fin= new FileInputStream(file);
	    for(int j=0;j<8;j++)
		{
		        x = key.charAt(j);
		        s2=mc.convertToBinary((int)x);
		        s3=s3.concat(s2);
    	}
	    keyblock= mc.convertToInt(s3);
	    s3="";
	    s2="";

		File f= new File("Receive.txt");
		if(f.isFile())
			f.delete();
       	fout = new FileOutputStream("Receive.txt");
      	i=0;
     	do{
           inparr[i] = fin.read();
           cnt++;
           i++;

           s3="";
           if(cnt==8)
           {
               	for(int j=0;j<8;j++)
				{
                   	s2 = mc.convertToBinary(inparr[j]);
	           		s3 = s3.concat(s2);
               	}
               	datablock= mc.convertToInt(s3);
               	i=0;
               	cnt=0;
               	encdecblock=DES.enc_dec(keyblock,datablock,'d');
               	for(int ocnt=0,w=0;((ocnt<8)&&(w<64));ocnt++)
				{
                    for(int msb=0;msb<8;msb++,w++)
		     		{
                         eachblk[msb]=encdecblock[w];
                    }
               		wr=mc.convertBinToInt(eachblk,8);
               		fout.write(wr);
               		System.out.print((char)wr);
               }
        	}

     	}while(inparr[0]!=-1);

        fin.close();
        fout.close();
 	}
 }