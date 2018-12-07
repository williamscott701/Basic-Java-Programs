package chatapplication;

import java.io.*;
import java.net.*;

public class Server 
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket c = new ServerSocket(3000);
        Socket s = c.accept();
        System.out.println("Server  ready for chatting");
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        PrintWriter pw = new PrintWriter(os, true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader isbr = new BufferedReader(new InputStreamReader(is));
        String rm, sm;
        while (true) 
        {
            if ((rm = isbr.readLine()) != null)
                System.out.println(rm);
            sm = br.readLine();
            pw.println(sm);
            System.out.flush();
        }
    }
}