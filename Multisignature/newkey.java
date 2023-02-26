

/****************************************************************/
/*                      key	                            */
/*                                                              */
/****************************************************************/
import java.io.*;
import java.net.*;
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Summary description for key
 *
 */

class calculation
{
	 long great,a;
	 double aa,bb,cc,rm;
	 long rd;
	 long eval;
	 long calE(long pi,long p,long q)
	 {
		  great=0;
		  aa=Math.log(pi)/Math.log(10);
		  bb=Math.floor(aa);
		  cc=Math.pow(10,bb);
		  rm=Math.random()*cc;
		
		  rd=Math.round(rm);
		
		  while(great != 1)
		  {
			   rd=rd+1;
			   great=GCD(rd,pi);
			   pi=(p-1)*(q-1);
		  }
		  return rd;
	 }

	 long GCD(long e,long pi)
	 {
		
		  if(e > pi)
		  {
			   while(e%pi != 0)
			   {
					a=e%pi;
					e=pi;
					pi=a;
			   }
			   great=pi;
		  }
		  else
		  {
			   while(pi%e != 0)
			   {
					a=pi%e;
		
					pi=e;
		
					e=a;
		
			   }
			   great=e;
		  }
		  return great;
	 }
}



public class newkey 
{

	String pstr = "";
	String qstr = "";
	String s, output;
	long p,q,pi,e,val,ds,r,qd;;
	static long d,n;
		int i,cnt;
	long rst[] = new long[100];
	long div[] = new long[100];
	long qud[] = new long[100];
	long rem[] = new long[100];
	static 	String fe = "";
	static	String fd = "";
	String fn = "";
	String PubKey = "";
	String PriKey = "";

		// End of variables declaration


	public newkey()
	{
		super();
		calculation cal = new calculation();
		Random rnd1 = new Random(0);
		Random rnd2 = new Random(0);
		BigInteger prime1 = BigInteger.probablePrime(10, rnd1);
		BigInteger prime2 = BigInteger.probablePrime(15, rnd2);

		//	p = prime1.longValue();

		//	q = prime2.longValue();

		//Primitive ps=new Primitive();
		long primenumber=227;
		p=primenumber;
		q=primenumber;

		
		

		//		System.out.println(p);
		//q=p;
			 n=p*q;
  			 pi=(p-1)*(q-1);
		
		
  			 e=cal.calE(pi,p,q);
  		

			qd=pi/e;
   			r=pi%e;
   			cnt=0;
   			rst[cnt]=pi;
   			div[cnt]=e;
   			qud[cnt]=qd;
   			rem[cnt]=r;
		
   			do
   			{
				cnt++;
				val=div[cnt-1];	//val=e
				ds=rem[cnt-1];//ds = r
				qd=val/ds; // qd=e/r
				r=val%ds;  //  r=e%r
		
				if(r != 0)
				{
					 rst[cnt]=val;		//e
					 div[cnt]=ds;		//r
					 qud[cnt]=qd;		//e/r
					 rem[cnt]=r; 		//e%r
				}
   			}while(r != 0);
   			long p1,q1,s1,t1,p2,q2,s2,t2,t;

			p1=rst[cnt-1];
			q1=-qud[cnt-1];
			s1=div[cnt-1];
			t=1;

			for(i=(cnt-2);i>=0;i--)
			{
				 p2=rst[i];
				 q2=-qud[i];
				 s2=div[i];
				 if(s1==rem[i])
				 {
				   if(p1==s2)
	   				{
						p1=p2;
						t1=t;
						t=q1;
						q1=t1+(q1*q2);
						s1=s2;
	   				}
				 }
			}
			if(q1<0)
				 d=pi+q1;
			else
				 d=q1;
				fe = String.valueOf(e);
				fd = String.valueOf(d);
				fn = String.valueOf(n);
		
				output ="\n\nPublic Key :"+"\n   Exponent Value (e) = "+fe+"\n   N Value (n)        ="+fn+"\n\nPrivate Key :"+"\n  Decryption Key (d)  ="+fd+"\n  N Value (n)         ="+fn;
	    
             
           //  PubKey = "(e, n) = ("+fe+", "+fn+")";
          // PriKey = "(d, n) = ("+fd+", "+fn+")";
	} 

	//============================= Testing ================================//
	//=                                                                    =//
	//= The following main method is just for testing this class you built.=//
	//= After testing,you may simply delete it.                            =//
	//======================================================================//
	public static void main(String[] args)
	{
		
		new newkey();
	}

}
