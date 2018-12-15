import java.awt.Graphics;
import java.applet.Applet;
import java.awt.Color;

public class appl extends Applet implements Runnable
{  
    int hutx[]=new int[]{511,415,607};
    int huty[]=new int[]{160,235,235};
    private int suny, sunx, flag, r=255;
    
    public void init()
    {
        new Thread(this).start();
        sunx=180;
        suny=-50;
    }
    
    public void run()
    {
        while(true)
        {
            repaint();
            if(r>20)
                r-=2;
            if(flag==0)
                suny+=3;
            if(suny>370)
                flag=1;
            else          
                flag=0;
            try
            {
                Thread.sleep(75);
            }
            catch(InterruptedException e){}
        }       
    }
    
    public void paint(Graphics g)
    {
        setSize(800,500);
        g.setColor(new Color(0, r, r));
        g.fillRect(0, 0, 800, 500);        
        g.setColor(Color.YELLOW);//sun
        g.fillOval(sunx, suny, 50, 50);
        g.setColor(Color.GREEN); //grass
        g.fillRect(0, 370, 800, 500);
        g.setColor(Color.darkGray);//rect
        g.fillRect(450, 235,122, 170);
        g.setColor(Color.GRAY);
        g.fillPolygon(hutx, huty, 3);
        g.drawArc(220, 220, 220,220, 220, 220);
    }    
}