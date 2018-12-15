package chatapplication;

import java.io.*;
import java.net.*;

public class Client
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("127.0.0.1", 3000);
        OutputStream os = s.getOutputStream(); 
        InputStream is = s.getInputStream();
        PrintWriter pw = new PrintWriter(os, true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader isbr = new BufferedReader(new InputStreamReader(is));
        System.out.println("Start the chitchat, type and press Enter key");
        String rm, sm;               
        while(true)
        {
            sm = br.readLine(); 
            pw.println(sm); 
            System.out.flush();    
            if((rm = isbr.readLine()) != null)
                System.out.println(rm);         
        }               
    }                    
}