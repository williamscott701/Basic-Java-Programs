import java.util.Scanner;

class Matrix
{
 public static void main(String arg[])
 {
  Scanner in=new Scanner(System.in);
     int choice=1;
   do
  {
   System.out.print("\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Transpose\n5.Inverse\nEnter Your Choice: ");
   int h=in.nextInt();
   int a[][]=new int[2][2],b[][]= new int[2][2];
   System.out.print("\nEnter Two Matrices Of Order 2*2\n\nMatrix A:\n");
   for(int ai=0;ai<2;ai++)
    for(int aj=0;aj<2;aj++)
     a[ai][aj]=in.nextInt(); 
   System.out.print("\nMatrix B:\n");
    for(int bi=0;bi<2;bi++)
     for(int bj=0;bj<2;bj++)
      b[bi][bj]=in.nextInt(); 
   switch(h)
   {
    case 1:
    {
     int c[][]=new int[2][2];
     System.out.print("\nResultant Matrix:\n\n");
     for(int i=0;i<2;i++)
      for(int j=0;j<2;j++)
       c[i][j]=a[i][j]+b[i][j];
     for(int ci=0;ci<2;ci++)
     {
      for(int cj=0;cj<2;cj++)
       System.out.print(" "+c[ci][cj]);
      System.out.print("\n");
     }
     break;
    }
    case 2:
    {
     int c[][]=new int[2][2];
     System.out.print("\nResultant Matrix:\n\n");
     for(int i=0;i<2;i++)
      for(int j=0;j<2;j++)
       c[i][j]=a[i][j]-b[i][j];
     for(int ci=0;ci<2;ci++)
     {
      for(int cj=0;cj<2;cj++)
       System.out.print(" "+c[ci][cj]);
      System.out.print("\n");
     }
     break;
    }
    case 3:
    {
     int sum=0;
     int c[][]=new int[2][2];
     System.out.print("\nResultant Matrix:\n\n");
     for(int i=0;i<2;i++)
      for(int j=0;j<2;j++)
       {
        for(int k=0;k<2;k++)
         sum=sum+a[i][k]*b[k][j];
        c[i][j]=sum;
        sum=0;
       }
     for(int ci=0;ci<2;ci++)
     {
      for(int cj=0;cj<2;cj++)
       System.out.print(" "+c[ci][cj]);
      System.out.print("\n");
     }
     break;
    }
    case 4:
    {
     int c[][]=new int[2][2];
     int d[][]=new int[2][2];
     for(int i=0;i<2;i++)
      for(int j=0;j<2;j++)
        {
         c[i][j]=a[j][i];
         d[i][j]=b[j][i];
        }
     System.out.print("\nTranspose Of Matrix A:\n\n");
     for(int ci=0;ci<2;ci++)
     {
      for(int cj=0;cj<2;cj++)
       System.out.print(" "+c[ci][cj]);
      System.out.print("\n");
     }
     System.out.print("\nTranspose Of Matrix B:\n\n");
     for(int ci=0;ci<2;ci++)
     {
      for(int cj=0;cj<2;cj++)
       System.out.print(" "+d[ci][cj]);
      System.out.print("\n");
     }
     break;
    }
    case 5:
    {
     double c[][]=new double[2][2];
     double d[][]=new double[2][2];
     c[0][0]=a[1][1]; c[1][1]=a[0][0]; c[0][1]=-a[0][1]; c[1][0]=-a[1][0];
     d[0][0]=b[1][1]; d[1][1]=b[0][0]; d[0][1]=-b[0][1]; d[1][0]=-b[1][0];
     double deta=(a[0][0]*a[1][1])-(a[1][0]*a[0][1]);
     double detb=(b[0][0]*b[1][1])-(b[1][0]*b[0][1]);
     for(int i=0;i<2;i++)
      for(int j=0;j<2;j++)
        {
         c[i][j]=c[i][j]/deta;
         d[i][j]=d[i][j]/detb;
        }
     if(deta==0)
      System.out.println("Inverse Of A Is Not Possible");
     else
     {
      System.out.print("\nInverse Of Matrix A:\n\n");
      for(int ci=0;ci<2;ci++)
      {
       for(int cj=0;cj<2;cj++)
        System.out.print(" "+c[ci][cj]);
       System.out.print("\n");
      }
     }
     if(detb==0)
      System.out.println("Inverse Of B Is Not Possible");
     else
     {
      System.out.print("\nInverse Of Matrix B:\n\n");
      for(int ci=0;ci<2;ci++)
      {
       for(int cj=0;cj<2;cj++)
        System.out.print(" "+d[ci][cj]);
       System.out.print("\n");
      }
     } 
     break;
    }
   }
   System.out.println("If You Want To repeat again press 1");
   choice=in.nextInt();
  }while(choice==1);
 }
}