class Harmonic
{
 public static void main(String arg[])
 {
  int n=Integer.parseInt(arg[0]);
  double b=0;
  for(int i=1;i<=n;i++)
  {
   b=b+(1.0/i);
  }
 System.out.println("The Harmonic is "+b);
 }
}

