
class Pyramid
{
 public static void main(String arg[])
 {
  int a=Integer.parseInt(arg[0]);
  System.out.println("\tPyramid:\n\n"); 
  int n=0;
  int p=a/2;
  for(int i=0;i<a;i++)
  {
   if(n<a/2+1)
   { 
    for(int j=0;j<=n;j++)
    {
     System.out.print("*");
    }
    n++;
   }
   else
   {
    for(int k=0;k<p;k++)
    {
     System.out.print("*");
    }
    p--;
   }  
   System.out.println("\n");
  }
 }
}




