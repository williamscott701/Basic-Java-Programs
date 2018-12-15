package play2;

import java.util.Scanner;
import Arr.*;

public class Player2
{
 Scanner in= new Scanner(System.in);
 public int input2(int n)
 {
  int score=0;
  String temp=new String();
  System.out.println("Player 2:");
  System.out.println("Rearrange the letters shown, and form a word");
  for(int i=0;i<n;i++)
  {
   System.out.println("\n" + Array.jumbledwords[i]+"\nEnter Your Guess: ");
   temp=in.next();
   if(temp.equals(Array.words[i]))
    score++;
  }
  return score;
 }
}
