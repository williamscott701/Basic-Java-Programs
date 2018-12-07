class Prime
{
 public static void main(String arg[])
 {
  int n1=Integer.parseInt(arg[0]);
  int n2=Integer.parseInt(arg[1]);
  int b;
 
  for(int i=n1;i<=n2;i++)
  {
    int s=0;
    for(int j=2;j<i;j++)
    {
     b=i%j;
     if(b==0)  
       s=1;
    }
    if(s==0)
     System.out.println(" "+i);

  }

 }

}