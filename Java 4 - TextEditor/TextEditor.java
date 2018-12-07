import java.util.Scanner; 

class Entry
{
 Scanner t = new Scanner(System.in);
 int f=0;
 public String name, owner, text="",tr,e="end";
 void Add()
 {
  System.out.print("\nFile Name:\n");
  name=t.nextLine();
  System.out.print("\nFile Owner Name:\n");
  owner=t.nextLine();
  System.out.print("\nEnter Your Text:\tNote: Press Enter For New Line And End To End Your Input\n");
  do
  {
   tr=t.nextLine();
   if(tr.equals(e))
   f=0;
   else
   {
    f=1;
    text+="\n\t    "+tr;
   }
  }while(f==1);
 }
 void display()
 {
  System.out.print("\nFile Name   : " + name);
  System.out.print("\nOwner Name  : " + owner);
  System.out.println("\nText        : " + text); 
 }
}

class Main
{
 public static void main(String arg[])
 {
  int choice,q=0,c=1,i;
  String n, f;
  Entry list[]=new Entry[100];
  Scanner in = new Scanner(System.in);
  do
  {
   System.out.print("\n1.Create New File \n2.Edit An Existing File \n3.Search And Display A File\n4.Display All Files Available\n5.Exit\n");
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
     int ta=0, p, t=1;
     System.out.print("\nEnter The File Name: ");
     in.nextLine();
     f=in.nextLine();
     for(i=0;i<q;i++)
     {
      if(list[i].name.equals(f))
      {
       System.out.print("\nData Of The File Present: ");
       list[i].display();
       System.out.print("\n\nModify: ");
       do
       {
        System.out.print("\n1.Name\t2.Owner\t3.Edit Complete Text\t4.Add Text\t5.Exit Modify\n");
        p=in.nextInt();
        in.nextLine();
        switch(p)
        {
         case 1: 
         {
          System.out.print("\nModify Name: ");
          list[i].name=in.nextLine(); 
          break;
         }
         case 2: 
         {
          System.out.print("\nModify Owner Name: ");
          list[i].owner=in.nextLine(); 
          break;
         }
         case 3: 
         {
          System.out.print("\nModify Text: ");
          list[i].text=in.nextLine();
          break;
         }
         case 4:
         {
          System.out.print("\nAdd Text: "); 
          String temp; temp=in.nextLine(); 
          list[i].text+=" "+temp; 
          break;
         }
         case 5:
         {
          t=0;
          break;
         }
         default: 
         {
          System.out.print("\nInvalid Option\n");
          break;
         }
        }
       }while(t==1);
       break; 
      }
      else
      ta=1;
     }
     if(ta==1)
     {
      System.out.print("\nFile Dosent Exist\n");
      break;
     }
     break; 
    }
    case 3:
    {
     int tb=0;
     System.out.print("\nEnter The File Name\n");
     n=in.next();
     for(i=0;i<q;i++)
     {
      if(list[i].name.equals(n))
      {
       list[i].display();
       break; 
      }
      else
       tb=1;
     }
     if(tb==1)
     {
      System.out.print("\nFile Dosent Exist\n");
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
