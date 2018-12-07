package filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandling 
{
    static String dir="";
    static FileOperations Q =new FileOperations();
    static Scanner in=new Scanner(System.in);
    static FileHandling N=new FileHandling();
    public static void main(String[] args)
    {
        int t=1;
        do
        {
            try{
                System.out.println("\n-------------------------------------");
                System.out.println("Enter Your Choices");
                System.out.println("1.Create File\n2.Browse & Select a File\n3.Select File using Directory\n4.Exit");
                switch(in.nextInt())
                {
                    case 1:
                        Q.GetDIR();
                        Q.CreateFile();
                        if(Q.p==1)
                            N.Operations();
                        break;
                    case 2:
                        Q.Search();
                        N.Operations();
                        break;
                    case 3:
                        Q.GetDIR();
                        Q.CheckFile();
                        N.Operations();
                        break;
                    case 4:
                        t=0;
                        break;
                    default:
                        System.out.println("Invalid Input! Try Agagin...");       
                }
            }
            catch(Exception e)
            {
                System.out.println(e+"Exception Handled! Try Again");
            }
        }while(t==1);
    }
    
    void Operations() throws IOException
    {
        int t=1;
        FileHandling.dir=FileOperations.dir;
        if(new File(dir).exists()&&dir.endsWith(".txt"))
        {
            do
            {
                try 
                {
                    System.out.println("\n1.Add Text     2.Flush\n3.Display      4.Rename\n5.Delete File  6.Go Back");
                    switch(in.nextInt())
                    {
                        case 1:
                            Q.AddText();
                            break;
                        case 2:
                            Q.Flush();
                            break;
                        case 3:
                            Q.Display();
                            break;
                        case 4:
                            Q.Rename();
                            break;
                        case 5:
                            Q.Delete();
                            if(!new File(dir).exists())
                                t=0;
                            break;
                        case 6:
                            t=0;
                            break;
                        default:
                            System.out.println("Invalid Option");
                            break;
                    }
                }
                catch (FileNotFoundException ex) 
                {
                    System.out.println(ex+" Exception handled");
                }
            }while(t==1);
        }
    }
}

class FileOperations
{
    FileHandling N=new FileHandling();
    static String dir="";
    Scanner in=new Scanner(System.in);
    int p=1;
    
    void CreateFile()
    {
        p=1;
        try
        {
            if(new File(dir).exists()==false&&dir.endsWith(".txt"))
            {
                new File(dir).createNewFile();
                System.out.println("File Created");
            }
            else if(new File(dir).isFile()==true&&dir.endsWith(".txt"))
            {
                System.out.println("\nFile Already Exists!\n1.Overwrite\n2.Go Back");
                switch(in.nextInt())
                {
                    case 1:
                        new File(dir).delete();
                        new File(dir).createNewFile();
                        System.out.println("Overwritten");
                        N.Operations();
                    case 2:
                        p=0;
                        break;
                    default:
                        System.out.println("Inavalid Option");
                        break;
                }
            }
        }
        catch(IOException e)
        {
            System.out.println(e+"Exception Handled");
        }
    }
    
    void CheckFile()
    {
        if(new File(dir).exists()&&dir.endsWith(".txt"))
            System.out.println("File Selected");
        else if(dir.endsWith(".txt"))
            System.out.println("File Not Found");
    }
    
    void GetDIR()
    {
        dir="";
        System.out.println("1.Specific Location   2.Desktop");
        try
        {
            switch(in.nextInt())
            {
                case 1:
                    dir="";
                    System.out.println("\nEnter Directory Without Filename");
                    dir=in.next();
                    break;
                case 2:
                    dir="C:/Users/William Scott/Desktop/";
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
            if(new File(dir).isDirectory()&&dir.endsWith("/"))
            {
                System.out.println("\nEnter File Name");
                dir+=in.next()+".txt";
            }
            else
                System.out.println("Invalid Directory! Try Again...");
        }
        catch(Exception e)
        {
            System.out.println("\n"+e);
        }
    }
    
    void Delete()
    {
        if(new File(dir).delete())
            System.out.println("File Deleted");
        else
            System.out.println("Cannot be Deleted");
    }
    
    void Search()
    {
        System.out.println("\nNote: Press exit to stop Browsing");
        int tr=1,d;
        dir="";
        String t=null,yu="";
        System.out.println("\nEnter Your Directory\nc: d: e: f:");
        do
        {
            System.out.println("");
            t=in.next();
            if(!t.equals("exit"))
                System.out.println("Selected "+new File(dir).getName());
            else
                System.out.println("Selected "+t);
            dir+=t;
            if(dir.endsWith(".txt")||t.equals("exit"))
                tr=0;
            else
            {  
                dir+="/";
                File temp[]=new File(dir).listFiles();
                for(File s:temp)
                    if(!s.isHidden())
                        System.out.println(s);
            }
//            if(t.equals("back"))
//            {
//                dir.substring(0, (dir.length()-1));
//                yu=new File(dir).getName();
//                System.out.println(yu);
//            }
        }while(!t.equals("exit")&&tr==1);
    }        

    void AddText() throws IOException
    {
        FileWriter fw = new FileWriter(dir,true);
        PrintWriter pw = new PrintWriter(fw);
        System.out.println("\nNote:To Exit Editor Type exit\n");
        try
        {
            int t=1;
            String text="";
            System.out.println("Enter Text To Add\n");
            do
            {
                text=in.nextLine();
                if(text.endsWith("exit"))
                {
                    t=0;
                    pw.close();
                }
                else                   
                    pw.println(text);
            }while(t==1);
        } 
        catch (Exception ex) 
        {
            System.out.println(ex+"Exeption Handled");
        }
        finally
        {
            pw.close();
        }
    }
    
    void Flush()
    {
        PrintWriter pw = null;
        try 
        {
            pw = new PrintWriter(new File(dir));
            pw.println("");
            pw.close();
            System.out.println(new File(dir).getName()+" is Flushed");
        } 
        catch (FileNotFoundException ex)
        {
            System.out.println(ex+" Exception Caught");
        }
        finally
        {
            pw.close();
        }
    }

    void Display() throws FileNotFoundException, IOException
    { 
        BufferedReader br=new BufferedReader(new FileReader(dir));
        try 
        {
            String line = null;
            System.out.println("\nText in File:");
            while((line=br.readLine())!=null)
                System.out.println(line);
            br.close();
        } 
        catch (IOException ex)
        {
            System.out.println(ex+" Exception Caught");
        }finally
        {
            br.close();
        }
    }

    void Rename()
    {
        int d;
        System.out.println("Enter Name");
        d=dir.length()-new File(dir).getName().length();
        File old = new File(dir);
        dir=dir.substring(0,d)+in.next()+".txt";
        File changed = new File(dir);
        if(old.renameTo(changed)) 
            System.out.println("File Renamed");
        else
            System.out.println("Unable to Rename");
    }
}