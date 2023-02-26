

import java.math.*;
class Primitive
{
	static int count;
	static long a;
	public Primitive()
	{
		int t=227;
		boolean b=checkPrime(t);
		if(t>2 && b)
		{
			a=t;
			int index=(int)a;
			long num1[]=new long[index+1];
			long num2[]=new long[index+1];
			for(int j=0;j<a;j++)
				num1[j]=j+1;
			for(count=2;count<a;count++)
			{
				int f=0;
				for (int j=0;j<a-1;j++)
				{		
					BigDecimal big=new BigDecimal(count);
					BigDecimal rem=new BigDecimal(a);
					num2[j]=big.pow((int)num1[j]).remainder(rem).longValue();
					if(num2[j]==0)
					{
						f=1;
						System.out.println(a);
						System.out.println("Count "+count+"Power "+num1[j]+"K "+big.pow((int)num1[j]).toString());
						System.exit(0);
						break; 
					}

				}
				if(f==1)break;

				for(int j=0;j<a-1;j++)
				{
					for(int k=0;k<a-1;k++)
					{
						if(num2[j]==num1[k] && num1[k]!=0)
						{
						             num1[k]=0;
				  		             break;
						}
					}	
				}
				int kk=0;
				for( kk=0;kk<a-1;kk++)
				{
					 if(num1[kk]!=0)
					 break;
				}
				if(kk==a-1)
				{
					//System.out.println("The Number "+a+" The primitive root is "+count);		//System.exit(0);	
					break;
				}
				for(int j=0;j<a;j++)
					num1[j]=j+1;

			}
		}

	}

	 static boolean checkPrime(long n)
	 {
		 int flag=0;
		  if(n==0 || n==1)
		  {
		 // System.out.println("not prime number");
		  }
		  else
		  {
			   for(int i=2;i<n;i++)
			   {
					if(n%i == 0)
					{
						 flag=1;
						 break;
					}
			   }
		  }
		  if(flag==1)
			   return false;
		  else
			   return true;
	 }

	public static void main(String args[])
	{
		Primitive dd=new Primitive();
	}
}