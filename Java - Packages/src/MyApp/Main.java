package MyApp;

import java.util.Scanner;
import play1.Player1;
import play2.Player2;
import Win.W;
import rand.*;

public class Main
{
 public static void main(String[] args) 
 {
  Scanner in= new Scanner(System.in);
  int t=0,n=0,i,num,score;
  Player1 a=new Player1();
  Player2 b=new Player2();
  R1 r=new R1();
  do
  {
   System.out.println("\nDifficulty Mode:\n1.Easy \n2.Medium\n3.Hard\n4.Exit");
   num=in.nextInt();
   if(num==4)
    break;
   else
    n=num*3;
   a.input1(n);
   r.random(n);
   for(i=0;i<40;i++)
   System.out.println("");
   score=b.input2(n);
   W.win(score,n);
   System.out.println("The Answers Are:");
   for(i=0;i<n;i++)
   System.out.println(Arr.Array.words[i]);
  }while(t==0);
 }   
}
