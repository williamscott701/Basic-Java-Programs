package rand;

import java.util.Scanner;
import java.util.Random;
import Arr.*;

public class R1
{
 java.util.Random rand=new java.util.Random();
 Scanner in= new Scanner(System.in);
 public void random(int n)
 {
  for(int i=0;i<n;i++) 
  {
   while(Array.words[i].length()!=Array.jumbledwords[i].length())
   {
    char letter=Array.words[i].charAt(rand.nextInt(Array.words[i].length()));
    if(!Array.jumbledwords[i].contains(""+letter))
     Array.jumbledwords[i]+=letter;
   }
  }
 }
}
