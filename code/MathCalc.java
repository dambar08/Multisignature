

import java.math.*;
public class MathCalc
{
   //Convert an integer to a Binary String
    public String convertToBinary(int intobj)
{
      String s="";
      String pad="00000000";
       // convert an ascii char to binary string
      s=(Integer.toBinaryString(intobj)); 
          
 // if the length is less than eight then pad it with zeroes
      if(s.length()<8) 
          s=pad.substring(0, 8-s.length())+s;
      return s;
    }
    
 //Takes a Binary String as input and returns an integer array of binary digits as its elements.
    public int[] convertToInt(String s)
{
       int len=0,inparr[];
       len=s.length();
       inparr = new int[len];
       for(int i=0;i<len;i++)
{
         inparr[i]=Integer.parseInt(s.substring(i,i+1));
       }
        return inparr;
    }
    
 //Takes two integer arrays as input and returns the exored value of each element
  public int[] exOr(int[] a,int[]b,int len)
{
      int[] c = new int[len];
            for (int i=0;i<len;i++)
{
          c[i]=a[i]^b[i];
      }
      return c;
  }
   //Takes an integer array of binary digits as input and returns its ascii value as output.
  public int convertBinToInt(int[] block,int len)
{
      int ans=0;
      for(int i=(len-1),j=0;i>=0;i--,j++)
{
           if(block[j]==1)
{
               ans=ans+(int)(Math.pow(2,(double)i));             
           }
      }
      return ans;
  }
  
  //Takes the integer array as input and shifts with given number of bits.
  public int[] toShiftLeft(int[] arr,int sh)
{
      int[] tarr=new int[28];
          for(int i=27,j=27-sh;i>=sh;i--,j--)
	{
          tarr[j]=arr[i];
      }
      tarr[27]=arr[0];
      
      if ( sh == 2)
 {
          tarr[26] = arr[0];
          tarr[27] = arr[1];
      }
      return tarr;
      }
   }
