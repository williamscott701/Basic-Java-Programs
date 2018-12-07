package fileserver;

import java.io.*;
import java.net.*;

public class FileServer
{  
    public static void main(String args[])throws IOException
    {  
        ServerSocket ss=null;
        try
        {   
            ss=new ServerSocket(8081);
        } 
        catch(IOException e)
        {  
            System.out.println("couldn't listen");
            System.exit(0);
        }
        Socket cs=null;
        try
        {  
            cs=ss.accept();
            System.out.println("Connection established"+cs);
        }
        catch(IOException e)
        {  
            System.out.println("Accept failed");
            System.exit(1);
        }  
        PrintWriter pw=new PrintWriter(cs.getOutputStream(),true);
        BufferedReader breader=new BufferedReader(new InputStreamReader(cs.getInputStream()));
        String s=breader.readLine();
        System.out.println("The requested file is : "+s);
        File f=new File(s);
        if(f.exists())
        {  
            BufferedReader br=new BufferedReader(new FileReader(s));
            String line;
            while((line=br.readLine())!=null)
            {
                pw.write(line);
                pw.flush();
            }
            br.close();
            System.out.println("File transfered");
            cs.close();
            ss.close(); 
        }   
    }   
}