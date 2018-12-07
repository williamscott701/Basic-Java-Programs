package play1;

import java.util.Scanner;
import Arr.*;

public class Player1
{
 Scanner in= new Scanner(System.in);
 public void input1(int n)
 {
  System.out.println("\nPlayer 1:");
  System.out.println("Rules: Enter Words Without Repetition Of Letters\n");
  System.out.println("Enter " + n + " Words");
  for(int i=0;i<n;i++)
  {
   Array.words[i]=new String();
   Array.jumbledwords[i]=new String();
   Array.jumbledwords[i]="";
   Array.words[i]=in.next();
  }
 }    
}
