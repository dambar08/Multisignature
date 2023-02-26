

public class DESalgorithm{
    public int [][]key= new int[16][56];
    

    public int[] enc_dec(int[]keyblock, int[]datablock,char ED){
             
        int[] retblock= new int[64];
        int[] IPblock = new int[64];
        int[] roundret= new int[64];
        int[] initkey = new int[56];
        
        initkey=PC1(keyblock);
        roundret=InitialPerm(datablock);
        keyGenerator(initkey,ED);
        for(int r=1;r<=16;r++){
            roundret=SingleRound(r,roundret,ED);
        }
        IPblock=Swap32bit(roundret);
        retblock=InitialPermInv(IPblock);
        return retblock;
    }
 

    public int[] PC1(int[] keyblock){
        int[] pc1ret= new int[56];
        int index=0;
        int[] refPC1={57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,
                      27,19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,
                      30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
                
        for(int i=0;i<56;i++){
            index= refPC1[i];
            pc1ret[i]= keyblock[index-1];
        }
        return pc1ret;
    }


     public int[] InitialPerm(int[] datablock){
          int index;
          int[] IPblockret=new int[64];
          int[] refIP={58, 50, 42, 34, 26, 18, 10, 2,60, 52, 44, 36, 28, 20, 12, 4,
                       62, 54, 46, 38, 30, 22, 14, 6,64, 56, 48, 40, 32, 24, 16, 8,
                       57, 49, 41, 33, 25, 17,  9, 1,59, 51, 43, 35, 27, 19, 11, 3,
                       61, 53, 45, 37, 29, 21, 13, 5,63, 55, 47, 39, 31, 23, 15, 7};
                
           for(int i=0;i<64;i++){
               index= refIP[i];
               IPblockret[i]= datablock[index-1];
           }
           return IPblockret;
     }
     

    public void keyGenerator(int[] initkey,char ED){
         int shiftblock[][]= {
                             {1,1},{2,1},{3,2},{4,2},
                             {5,2},{6,2},{7,2},{8,2},
                             {9,1},{10,2},{11,2},{12,2},
                             {13,2},{14,2},{15,2},{16,1}
         };
         int []lblock=new int[28];
         int []rblock=new int[28];
         int shift=0,left,right;
         int[] lnext=new int[28];
         int[] rnext=new int[28];
         MathCalc mc = new MathCalc();

         for(int round=1;round<=16;round++){
              for(int i=0;i<28;i++)
                 lblock[i]=initkey[i];
                  
              for(int i=28,j=0;((i<56)&&(j<28));i++,j++){
                 rblock[j]=initkey[i];
              }
              shift=shiftblock[round-1][1];
                       
              lnext=mc.toShiftLeft(lblock,shift);
              rnext=mc.toShiftLeft(rblock,shift);
                  
              for (int i=0;i<28;i++){
                  initkey[i]=lnext[i];
              }
              for (int i=28,j=0;i<56;i++,j++)
                 initkey[i]=rnext[j];
              for(int x=0;x<56;x++){
                 key[round-1][x]=initkey[x];
              }
         }
}
   
//It calls all the routines required to execute each round
   public int[] SingleRound(int r, int[]block, char ED){
        MathCalc mc= new MathCalc();
        int []lblock = new int[32];
        int []rblock = new int[32];
        int []etableret=new int[48];
        int []subkey=new int[48];
        int []exorkey=new int[48];
        int []sboxret =new int[32];
        int[] permret=new int[32];
        int[] rnext =new int[32];
        int[] lnext=new int[32];
        
        for(int i=0;i<32;i++){
            lblock[i]=block[i];
        }
        for(int i=32,j=0;i<64;i++,j++)
            rblock[j]=block[i];
        
        etableret=Etable(rblock);
      
        if(ED=='e')
            subkey = PC2(key[r-1]);
        else
            subkey = PC2(key[16-r]);
        
        exorkey=mc.exOr(etableret,subkey,48);
        sboxret=Sbox(exorkey);
        permret=Permutation(sboxret);
        rnext=mc.exOr(permret,lblock,32);
                  
        lnext=rblock;
        for (int i=0;i<32;i++)
           block[i]=lnext[i];
        for (int i=32,j=0;i<64;i++,j++)
           block[i]=rnext[j];
        return block;
  }
  
  //Takes 32-bit Rblock of the data  and expands it to 48-bit data.
  public int[] Etable(int[] rblock){
          int index;
          int[] etableret=new int[48];
          int[] refEtable={32,  1,  2,  3,  4,  5,4,  5,  6,  7,  8,  9,
                           8,  9, 10, 11, 12, 13,12, 13, 14, 15, 16, 17,
                           16, 17, 18, 19, 20, 21,20, 21, 22, 23, 24, 25,
                           24, 25, 26, 27, 28, 29,28, 29, 30, 31, 32,  1};
                
           for(int i=0;i<48;i++){
               index= refEtable[i];
               etableret[i]= rblock[index-1];
           }
         return etableret;
    }
  
//Takes 56-bit key input and permute it to 48-bit subkey.
 public int[] PC2(int []key) { 
          int index;
          int[] keyret=new int[48];
          int[] refPC2={14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,
                2,41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32};
                
           for(int i=0;i<48;i++){
               index= refPC2[i];
               keyret[i]= key[index-1];
               }
           return keyret;
 }
 
 //This routine parses the 48-bit input block to 8 S-boxes, each S-box takes 6-bit input returning 4-bit output. 
      public int[] Sbox(int[] exorkey){
          int cnt=0,sout=0,r,c;
          String outstr="";
          MathCalc mc= new MathCalc();
          int[] sboxret= new int[32];
          int[] input6= new int[6];
          int[] output4=new int[4];
          int[] index=new int[2];
        
          int [][] S1={
                 {14,  4, 13,  1,  2, 15, 11,  8,  3, 10,  6, 12,  5,  9,  0,  7}, 
                 { 0, 15,  7,  4, 14,  2, 13,  1, 10,  6, 12, 11,  9,  5,  3,  8},
                 {4,  1, 14,  8, 13,  6,  2, 11, 15, 12,  9,  7,  3, 10,  5,  0},
                 {15, 12,  8,  2,  4,  9,  1,  7,  5, 11,  3, 14, 10,  0,  6, 13}
          };

          int [][]S2={
                {15,  1,  8, 14,  6, 11,  3,  4,  9,  7,  2, 13, 12,  0,  5, 10},
                { 3, 13,  4,  7, 15,  2,  8, 14, 12,  0,  1, 10,  6,  9, 11,  5},
                {0, 14,  7, 11, 10,  4, 13,  1,  5,  8, 12,  6,  9,  3,  2, 15},
                {13,  8, 10,  1,  3, 15,  4,  2, 11,  6,  7, 12,  0,  5, 14,  9}
          };
 
          int [][]S3={
                 {10,  0,  9, 14,  6,  3, 15,  5,  1, 13, 12,  7, 11,  4,  2,  8}, 
                 {13,  7,  0,  9,  3,  4,  6, 10,  2,  8,  5, 14, 12, 11, 15,  1},
                 {13,  6,  4,  9,  8, 15,  3,  0, 11,  1,  2, 12,  5, 10, 14,  7},
                 {1, 10, 13,  0,  6,  9,  8,  7,  4, 15, 14,  3, 11,  5,  2, 12}
          };
 
          int [][]S4={
                 { 7, 13, 14,  3,  0,  6,  9, 10,  1,  2,  8,  5, 11, 12,  4, 15},
                 {13,  8, 11,  5,  6, 15,  0,  3,  4,  7,  2, 12,  1, 10, 14,  9},
                 {10,  6,  9,  0, 12, 11,  7, 13, 15,  1,  3, 14,  5,  2,  8,  4},
                 {3, 15,  0,  6, 10,  1, 13,  8,  9,  4,  5, 11, 12,  7,  2, 14}
          };

          int [][]S5={
                 { 2, 12,  4,  1,  7, 10, 11,  6,  8,  5,  3, 15, 13,  0, 14,  9},
                 {14, 11,  2, 12,  4,  7, 13,  1,  5,  0, 15, 10,  3,  9,  8,  6},
                 {4,  2,  1, 11, 10, 13,  7,  8, 15,  9, 12,  5,  6,  3,  0, 14},
                 {11,  8, 12,  7,  1, 14,  2, 13,  6, 15,  0,  9, 10,  4,  5,  3}
          };

          int [][]S6={
                 {12,  1, 10, 15,  9,  2,  6,  8,  0, 13,  3,  4, 14,  7,  5, 11},
                 {10, 15,  4,  2,  7, 12,  9,  5,  6,  1, 13, 14,  0, 11,  3,  8},
                 {9, 14, 15,  5,  2,  8, 12,  3,  7,  0,  4, 10,  1, 13, 11,  6},
                 {4,  3,  2, 12,  9,  5, 15, 10, 11, 14,  1,  7,  6,  0,  8, 13}
          };
 
          int [][]S7={
                 {4, 11,  2, 14, 15,  0,  8, 13,  3, 12,  9,  7,  5, 10,  6,  1},
                 {13,  0, 11,  7,  4,  9,  1, 10, 14,  3,  5, 12,  2, 15,  8,  6},
                 {1,  4, 11, 13, 12,  3,  7, 14, 10, 15,  6,  8,  0,  5,  9,  2},
                 {6, 11, 13,  8,  1,  4, 10,  7,  9,  5,  0, 15, 14,  2,  3, 12}
          };
 
          int [][]S8={
                 {13,  2,  8,  4,  6, 15, 11,  1, 10,  9,  3, 14,  5,  0, 12,  7},
                 {1, 15, 13,  8, 10,  3,  7,  4, 12,  5,  6, 11,  0, 14,  9,  2},
                 {7, 11,  4,  1,  9, 12, 14,  2,  0,  6, 10, 13, 15,  3,  5,  8},
                 { 2,  1, 14,  7,  4, 10,  8, 13, 15, 12,  9,  0,  3,  5,  6, 11}
          };
    
          for(int i=0,j=0;i<48;i++){
              input6[j]=exorkey[i];
              if(j==5){
                 cnt++;
                 j = -1;
                 index=sboxCalc(input6);
                 r=index[0];
                 c=index[1];
                 if(cnt==1)
                   sout=S1[r][c];
                 if(cnt==2)
                   sout=S2[r][c];
                 if(cnt==3)
                   sout=S3[r][c];
                 if(cnt==4)
                   sout=S4[r][c];
                 if(cnt==5)
                   sout=S5[r][c];
                 if(cnt==6)
                   sout=S6[r][c];
                 if(cnt==7)
                   sout=S7[r][c];
                 if(cnt==8)
                   sout=S8[r][c];

                 String str=Integer.toBinaryString(sout);
                 String pad="00000000";
                 if(str.length()<4) 
                 str=pad.substring(0, 4-str.length())+str;
                 outstr=outstr.concat(str);
              } // if
              j++;
          } // for
           
          sboxret=mc.convertToInt(outstr);
          return sboxret;    
     }

      
 //This method acts as a subroutine for the S-box, calculating the S-box row and column from the 6-bit input.
     public int[] sboxCalc(int[] input6){
          MathCalc mc= new MathCalc();
          int[] index=new int[2];
          int[] x1=new int[2];
          int[] x2=new int[4];
          x1[0]=input6[0];
          x1[1]=input6[5];
          x2[0]=input6[1];
          x2[1]=input6[2];
          x2[2]=input6[3];
          x2[3]=input6[4];
          int ans=0,row,col;

          for(int i=1,j=0;i>=0;i--,j++){
               if(x1[j]==1){
                   ans=ans+(int)(Math.pow(2,(double)i));
               }
          }
          row=ans;
          ans=0;
          for(int i=3,j=0;i>=0;i--,j++){
               if(x2[j]==1){
                   ans=ans+(int)(Math.pow(2,(double)i));             
               }
          }
          col=ans;
          index[0]=row;
          index[1]=col;
          return index;
          
    }

 //Takes the 32-bit return value of the S-box and permute it.
     public int[] Permutation(int[] sbox){
          int index;
          int[] sboxret=new int[32];
          int[] refPermutation={16,  7, 20, 21,29, 12, 28, 17,
                                1, 15, 23, 26,5, 18, 31, 10,
                                2,  8, 24, 14,32, 27,  3,  9,
                                19, 13, 30,  6,22, 11,  4, 25};
                
           for(int i=0;i<32;i++){
               index= refPermutation[i];
               sboxret[i]= sbox[index-1];
           }
           return sboxret;
     }
       
  
   
 //Swaps L-Block and R-Block of the data     
    public int[] Swap32bit(int[] block){
        int [] swapret = new int[64];
        int []lblock = new int[32];
        int []rblock = new int[32];
        int[] rnext =new int[32];
        int[] lnext=new int[32];
        for(int i=0;i<32;i++)
            lblock[i]=block[i];
        for(int i=32,j=0;i<64;i++,j++)
            rblock[j]=block[i];
        lnext=rblock;
        rnext=lblock;
        for (int i=0;i<32;i++)
           block[i]=lnext[i];
        for (int i=32,j=0;i<64;i++,j++)
           block[i]=rnext[j];
        return block;
    }
    
 //This routine inverses the permuation done initially.
     public int[] InitialPermInv(int[] datablock){
          int index;
          int[] IPInvblockret=new int[64];
          int[] refIPInv={40, 8, 48, 16, 56, 24, 64, 32,39, 7, 47, 15, 55, 23, 63, 31,
                          38, 6, 46, 14, 54, 22, 62, 30,37, 5, 45, 13, 53, 21, 61, 29,
                          36, 4, 44, 12, 52, 20, 60, 28,35, 3, 43, 11, 51, 19, 59, 27,
                          34, 2, 42, 10, 50, 18, 58, 26,33, 1, 41,  9, 49, 17, 57, 25};
                
           for(int i=0;i<64;i++){
               index= refIPInv[i];
               IPInvblockret[i]= datablock[index-1];
           }
           return IPInvblockret;
     }

}

