import java.util.*;
public class Player
{
    
    private int finalscore ;
    private int spendtimes;
    private int score;
    private int pcsc;
    private String guesses = "";
    public Player()
    {
        
    }
    
    public void addguess(String whowin ,int guess, int round)
    {
    
    guesses = guesses + "/n" + whowin +"in round"+ round + "win, number is" + guess + ".";
    
    }
    
    public String getguess()
    {
        return guesses;
        
    }
    
    public void addpcscore(int score2)
    {
        pcsc = pcsc + score2;
        
    }
    
    public void addscore(int score1)
    {
        score = score + score1;
        
    }

    public int getscore()
    {
        return score;
        
    }
   
    public int getpcscore()
    {
        return pcsc;
        
    }
    
    public void help()
    {
        System.out.println("Welcome to Lucky Machine");
        System.out.println("NumberGenerated  Price Won  Price Worth   Cost to player");
        System.out.println("1                Pen        $10           $1");
        System.out.println("2                Book       $20           $2");
        System.out.println("3                DVD        $30           $3");
        System.out.println("4                Mouse      $40           $4");
        System.out.println("5                Keyboard   $50           $5");    
    }
    
    
}
