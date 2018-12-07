package Interface;

import java.util.Scanner;

public class Entry implements NewInterface
{
    Scanner t=new Scanner(System.in);
    public String name, age, sex, showtime;
    public void Add()
    {
        System.out.print("\nName:\n");
        name=t.nextLine();
        System.out.print("\nAge:\n");
        age=t.nextLine();
        System.out.print("\nSex:\n");
        sex=t.nextLine();
        System.out.print("\nShowtime:\t1.9AM\t2.12Am\t3.4PM\n");
        showtime=t.nextLine();
    }
    public void Display()
    {
        System.out.print("\nName     : " + name);
        System.out.print("\nAge      : " + age);
        System.out.print("\nShowtime : " + "Show - "+showtime);
        System.out.println("\nSex      : " + sex); 
    }   
}