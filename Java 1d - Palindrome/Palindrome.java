class Palindrome
{
 public static void main(String arg[])
 {
  int a=Integer.parseInt(arg[0]);
  int b=a;
  int t=0;
  int d;
  do
  {
   b=b/10;
   t++;
  }while(b!=0);
 

 String rev="";
b=a;
 for(int i=0; i<t;i++)
 {
  
  d=b%10;
  rev=rev+d;
  b=b/10;
 }
 int num=Integer.parseInt(rev);
 if(num==a)
  System.out.println("The Entered Number Is a Palindrome Number");
 else if(num!=a)
  System.out.println("The Entered Number Is Not  a Palindrome Number");
 }
}