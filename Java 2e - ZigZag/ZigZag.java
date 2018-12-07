class ZigZag
{
 public static void main(String arg[])
 {
  int r=Integer.parseInt(arg[0]);
  int k,o=0;
  for(int i=1;i<=r;i++)
  {
   if(i==1||i==r)
   {
    System.out.print("\n");
    for(int t=0;t<r;t++)
     System.out.print("*");
    System.out.print("\n");
   }
   else 
   {
    if(o<r/2)
    {     
     for(int f=0;f<o+1;f++)
      System.out.print(" ");
     System.out.print("*");
     for(int p=(r-2*i);p>0;p--) 
      System.out.print(" ");
     if(o!=r/2-1)
      System.out.print("*\n");
    }
    else if(o<r&&o>=r/2)
    {
     int l=r-i;
     System.out.print("\n");
     for(int p=0;p<l;p++)
      System.out.print(" ");
     System.out.print("*");
     for(int f=0;f<r-2*l-2;f++)     
      System.out.print(" ");
     System.out.print("*");
    }   
    o++;
   }
  }
 }
}