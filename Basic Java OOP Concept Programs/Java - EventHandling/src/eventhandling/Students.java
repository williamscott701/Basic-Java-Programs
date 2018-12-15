package eventhandling;

import java.awt.*;
import java.awt.event.*;

public class Students extends Frame implements ActionListener
{
    String str[]=new String[10];
    String str1[]=new String[10];
    String str2[]=new String[10];
    int i,l;
    String msg,msg1,msg2,strprev;
    Button b1=new Button("save");
    Button b2= new Button("Quit");
    Button b3= new Button("<<Prev");
    Button b4= new Button("next>>");
    Label l11=new Label("Student details",Label.CENTER);
    Label l1=new Label("Name:",Label.LEFT);
    Label p1=new Label("Student id:",Label.LEFT);
    Label l2=new Label("Age:",Label.LEFT);
    Label l3=new Label("Sex(M/F):",Label.LEFT);
    Label l4=new Label("Address:",Label.LEFT);
    Label l5=new Label("Course:",Label.LEFT);
    Label l6=new Label("Semester:",Label.LEFT);
    Label l7=new Label("",Label.RIGHT);
    TextField t1=new TextField();
    TextField tp=new TextField();
    Choice c1=new Choice();
    CheckboxGroup cbg=new CheckboxGroup();
    Checkbox ck1=new Checkbox("Male",false,cbg);
    Checkbox ck2=new Checkbox("Female",false,cbg);
    TextArea t2=new TextArea("",180,90,TextArea.SCROLLBARS_VERTICAL_ONLY);
    Choice course=new Choice();
    Choice sem=new Choice();
    Choice age=new Choice();
    
    public Students()
    {
        i=0;
        l=0;
        addWindowListener(new myWindowAdapter());
        setBackground(Color.cyan);
        setForeground(Color.black);
        setLayout(null);
        add(l11);
        add(l1);
        add(p1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(t1);
        add(tp);
        add(t2);
        add(ck1);
        add(ck2);
        add(course);
        add(sem);
        add(age);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        b1.addActionListener(this);
        add(b1);
        b2.addActionListener(this);
        add(b2);
        b3.addActionListener(this);
        add(b3);
        b4.addActionListener(this);
        add(b4);
        course.add("Btech CIVIL");
        course.add("Btech ELECTRONI C");
        course.add("Btech COMPUTER C");
        course.add("Btech MECHENICAL");
        course.add("Btech AEROSPACE");
        course.add("Btech ELECTRICAL");
        course.add("Btech INSTRUMENTATION");
        sem.add("1");
        sem.add("2");
        sem.add("3");
        sem.add("4");
        sem.add("5");
        sem.add("6");
        sem.add("7");
        sem.add("8");
        age.add("16");
        age.add("17");
        age.add("18");
        age.add("19");
        age.add("20");
        age.add("21");
        age.add("22");
        age.add("23");
        age.add("24");
        l1.setBounds(25,65,90,20);
        p1.setBounds(300,65,90,20);
        l2.setBounds(25,90,90,20);
        l3.setBounds(25,120,90,20);
        l4.setBounds(25,185,90,20);
        l5.setBounds(25,260,90,20);
        l6.setBounds(25,290,90,20);
        l7.setBounds(25,260,90,20);
        l11.setBounds(10,40,280,20);
        t1.setBounds(120,65,170,20);
        tp.setBounds(390,65,170,20);
        t2.setBounds(120,185,170,60);
        ck1.setBounds(120,120,50,20);
        ck2.setBounds(170,120,60,20);
        course.setBounds(120,260,150,20);
        sem.setBounds(120,290,50,20);
        age.setBounds(120,90,50,20);
        b1.setBounds(120,350,50,30);
        b2.setBounds(180,350,50,30);
        b3.setBounds(240,350,50,30);
        b4.setBounds(300,350,50,30);
    }
    
    public void paint(Graphics g)
    {
        g.drawString(strprev, 100, 450);
        g.drawString("Entry number"+(l+1), 100, 480);
        g.drawString(str[l],100,500);
        g.drawString(str1[l],100,520);
        g.drawString(str2[l],100,540);
        g.drawString("Data Saved....", 100, 570);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("save"))
        {
            strprev="Previous Entry";
            msg="name:  "+t1.getText();//"Student details saved!";
            msg1="Address:  "+t2.getText();
            msg2="Student ID:"+ tp.getText();
            str[i] = t1.getText();
            str1[i] = tp.getText();
            str2[i] = t2.getText();
            l=i;
            repaint();
            System.out.println("\n\n______________________________________");
            System.out.println("Entry number: "+(i+1));
            System.out.println("name: "+str[i]);
            System.out.println("Student ID: "+str1[i]);
            System.out.println("Address: "+str2[i]);
            i++ ;
            t1.setText("");
            t2.setText("");
            tp.setText("");
            setForeground(Color.red); }
        else if(ae.getActionCommand().equals("Quit"))
        {
            System.exit(0);
        }
        else if(ae.getActionCommand().equals("<<Prev"))
        {
            l--;
            repaint();   
        }
        else if(ae.getActionCommand().equals("next>>"))
        {
            l++;
            repaint();
        }    
    }

    public static void main(String g[])
    {
        Students stu=new Students();
        stu.setSize(new Dimension(900,700));
        stu.setTitle("KARUNYA UNIVERSITY COMPUTER SCIENCE RESULT");
        stu.setVisible(true);
    }
}

class myWindowAdapter extends WindowAdapter
{
    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }
}