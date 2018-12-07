

import java.util.Scanner;
import java.util.Random;

class player1 extends array
{
    Scanner in= new Scanner(System.in);
    void input1(int n)
    {
        System.out.println("Player 1:\n");
        System.out.println("Enter " + n + " Words");
        for(int i=0;i<n;i++)
        {
                words[i]=new String();
                jumbledwords[i]=new String();
                jumbledwords[i]="";
                words[i]=in.next();
        }
    }    
}

class player2 extends array
{
    Scanner in= new Scanner(System.in);
    
    int input2(int n)
    {
        int score=0;
        String temp=new String();
        System.out.println("Player 2:\n");
        System.out.println("Rearrange the letters and form a word\n");
        for(int i=0;i<n;i++)
        {
            System.out.println("\n" + jumbledwords[i]+"\nEnter Your Guess: ");
            temp=in.next();
            if(temp.equals(words[i]))
            {
                score++;
            }
        }
        return score;
    }
}

class win
{
    static void win(int score,int n)
    {
        if(score==n)
            System.out.println("\nPlayer 2 Won\n");
        else
            System.out.println("\nPlayer 1 Won\n");
    }
}

class array
{
    static String words[]=new String[100];
    static String jumbledwords[]=new String[100];
}

class random extends array
{
    Random rand=new Random();
    Scanner in= new Scanner(System.in);
    void random(int n)
    {
        for(int i=0;i<n;i++) 
        {
            while(words[i].length()!=jumbledwords[i].length())
            {
                char letter=words[i].charAt(rand.nextInt(words[i].length()));
                if(!jumbledwords[i].contains(""+letter))
                    jumbledwords[i]+=letter;
            }
        }
    }
}

public class Main extends array
{
    public static void main(String[] args) 
    {
        Scanner in= new Scanner(System.in);
        int t=0,n=0,i,num,score;
        player1 a=new player1();
        player2 b=new player2();
        random r=new random();
        do
        {
            System.out.println("Difficulty Mode:\n1.Easy \n2.Medium\n3.Hard\n4.Exit");
            num=in.nextInt();
            if(num==4)
                break;
            else
                n=num*3;
            a.input1(n);
            r.random(n);
            for(i=0;i<40;i++)
                System.out.println("");
            score=b.input2(n);
            win.win(score,n);
        }while(t==0);
    }   
}
