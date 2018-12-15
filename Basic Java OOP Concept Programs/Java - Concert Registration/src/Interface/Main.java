package Interface;

import java.util.Scanner;

public class Main
{
 public static void main(String arg[])
 {
  int choice,q=0,c=1,i;
  System.out.print("\t Note: Only 50 Seats are available\n");
  String n, f;
  Entry list[]=new Entry[100];
  Scanner in = new Scanner(System.in);
  do
  {
   System.out.print("\n1.New Entry\n2.Remaining Tickets \n3.Search And Display An Entry\n4.Display All Entries Available\n5.Exit\n");
   choice=in.nextInt();
   switch(choice)
   {
    case 1:
    {
     list[q]=new Entry();
     list[q].Add();
     q++;
     System.out.print("\n\t*Your Ticket Is Confirmed*\n");
     break;
    }
    case 2:
    {
     System.out.println("\nThe Remaining Tickets are: "+(50-q));
     break; 
    }
    case 3:
    {
     int tb=0;
     System.out.print("\nEnter The Your Name\n");
     n=in.next();
     for(i=0;i<q;i++)
     {
      if(list[i].name.equals(n))
      {
       list[i].Display();
       break; 
      }
      else
       tb=1;
     }
     if(tb==1)
     {
      System.out.print("\nEntry Dosent Exist\n");
      break;
     }
     break; 
    }
    case 4:
    {
     System.out.print("\n");
     for(int x=0;x<q;x++)
     System.out.print((x+1)+". "+list[x].name+"\n");
     break;
    }
    case 5:
    {
     c=0;
     break;
    }
   }
  }while(c==1);
 }
}