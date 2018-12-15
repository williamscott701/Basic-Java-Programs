import java.util.Scanner; 

class Entry
{
 Scanner t = new Scanner(System.in);
 String fn,ln;
 double number;
 String address;
 void Add()
 {

  System.out.print("\nFirst Name:\n");
  fn=t.nextLine();
  System.out.print("\nLast Name:\n");
  ln=t.nextLine();
  System.out.print("\nNumber:\n");
  number=t.nextDouble();
  t.nextLine();
  System.out.print("\nAddress:\n");
  address=t.nextLine();
 }
 void display()
 {
  System.out.print("\nFirst Name: " + fn);
  System.out.print("\nLast Name : " + ln);
  System.out.print("\nNumber    : " + number);
  System.out.print("\nAddress   : " + address); 
 }
}

class Main
{
 public static void main(String arg[])
 {
  int choice,q=0,c,i;
  String n;
  double f;
  Entry list[]=new Entry[100];
  Scanner in = new Scanner(System.in);
  do
  {
   System.out.print("\n1.Add Entry \n2.Edit Existing Entry \n3.Search And Display\n");
   choice=in.nextInt();
   switch(choice)
   {
    case 1:
    {
     list[q]=new Entry();
     list[q].Add();
     q++;
     break;
    }
    case 2:
    {
     int ta=0;
     System.out.print("\nEnter The Phone Number: ");
     f=in.nextDouble();
     for(i=0;i<q;i++)
     {
      if(list[i].number==f)
      {
       list[i].display();
       list[i].Add();
       break; 
      }
      else
       ta=1;
     }
     if(ta==1)
     {
      System.out.print("\nEntry Dosent Exist\n");
      break;
     }
     break; 
    }
    case 3:
    {
     int tb=0;
     System.out.print("\nEnter The Last Name\n");
     n=in.next();
     for(i=0;i<q;i++)
     {
      if(list[i].ln.equals(n))
      {
       list[i].display();
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
   }
   System.out.print("\nIf You Want To Repeat Press 1: ");
   c=in.nextInt();
  }while(c==1);
 }
}