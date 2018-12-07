class Pascal
{
 public static void main(String arg[])
 {
  int r=Integer.parseInt(arg[0]);
  int s=r;
  for(int i=0;i<r;i++)
  {
   int a=i, b=1, sum=1;
   for(int t=0;t<s;t++)
    System.out.print(" "); 
   s--;  
   while(a!=-1&&b<=r)
   {
    System.out.print(" " + sum);
    sum=sum*a/(b);
    a--;
    b++;
   }
  System.out.println("");
  }
 }
}