package Clientserver;

import java.io.*;
import java.net.*;

public class FileClient
{
    public static void main(String srgs[])throws IOException
    {
        Socket s=null;
        BufferedReader br=null;
        PrintWriter pw=null;
        try
        {  
            s=new Socket("127.0.0.1",8081);
            br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw=new PrintWriter(s.getOutputStream(),true);
        }   
        catch(IOException e)
        {
            System.exit(0);
        }
        String u,f;
        System.out.println("Enter the file name to transfer from server:");
        DataInputStream dis=new DataInputStream(System.in);
        f=dis.readLine();
        pw.println(f);
        File f1=new File(f);
        FileOutputStream  fos=new FileOutputStream(f1);
        while((u=br.readLine())!=null)
        {  
            byte jj[]=u.getBytes();
            fos.write(jj);
        }  
        fos.close();
        System.out.println("File received");
        s.close();
    }       
} 