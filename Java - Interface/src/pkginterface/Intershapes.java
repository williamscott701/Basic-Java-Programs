package pkginterface;

import java.util.*;

interface Shape
{
    void values();
    void area();
    void perimeter();
}

class Rectangle implements Shape
{
    int l, b;
    double area, peri;
    Scanner s=new Scanner(System.in);
    public void values() 
    {
        System.out.println("\nEnter Length and Breadth");
        l=s.nextInt();
        b=s.nextInt();
    }
    public void area()
    {
        area=l*b;
        System.out.println("Area :" + area);
    }
    public void perimeter()
    {
        peri=(l+b)*2;
        System.out.println("Perimeter :"+peri);
    }
    
}

class Square implements Shape
{
    Scanner s=new Scanner(System.in);
    int a;
    double area, peri;
    public void values() 
    {
        System.out.println("\nEnter Length of side");
        a=s.nextInt();
    }
    public void area()
    {
        area=a*a;
        System.out.println("Area :"+area);
    }
    public void perimeter()
    {
        peri=4*a;
        System.out.println("Perimeter :"+peri);
    }
}

class Triangle implements Shape
{
    int a, b, c;
    double area, s, peri;
    Scanner in=new Scanner(System.in);
    public void values() 
    {
        System.out.println("\nEnter Length of Sides");
        a=in.nextInt();
        b=in.nextInt();
        c=in.nextInt();
        s=(a+b+c)/2;
    }
    public void area()
    {
        area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
        System.out.println("Area :"+area);
    }
    public void perimeter()
    {
        peri=2*s;
        System.out.println("Perimeter :"+peri);
    }
}

class Circle implements Shape
{
    Scanner s=new Scanner(System.in);
    int r;
    double area,peri;
    public void values() 
    {
        System.out.println("\nEnter Radius");
        r=s.nextInt();
    }
    public void area()
    {
        area=3.14*r*r;
        System.out.println("Area :"+area);
    }
    public void perimeter()
    {
        peri=2*3.14*r;
        System.out.println("Perimeter :"+peri);
    }
}

public class Intershapes
{ 
    public static void main(String arg[])
    {
        int ch, d=1;
        Scanner in=new Scanner(System.in);
        do
        {
            System.out.println("\nEnter Your Choice");
            System.out.println("1.Rectangle\n2.Square\n3.Triangle\n4.Circle\n5.Exit");
            ch=in.nextInt();
            switch(ch)
            {
                case 1:
                    Rectangle r=new Rectangle();
                    r.values();
                    r.area();
                    r.perimeter();
                    break;
                case 2:
                    Square sq=new Square();
                    sq.values();
                    sq.area();
                    sq.perimeter();
                    break;
                case 3:
                    Triangle t=new Triangle();
                    t.values();
                    t.area();
                    t.perimeter();
                    break;
                case 4:
                    Circle c=new Circle();
                    c.values();
                    c.area();
                    c.perimeter();
                    break;
                case 5:
                    d=0;
                    break;
                default:
                    System.out.println("Invalid Option! Try Again...");
            }
        }while(d==1);
    }
}