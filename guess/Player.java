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
    
    public void addguess(int guess, int round)
    {
    
    guesses = guesses + "\n" + "in round"+ round + " number is" + guess + ".";
    
    }
    
    public String getguess()
    {
        return guesses;
        
    }
    

    
    public void addscore(int score1)
    {
        score = score + score1;
        
    }

    public int getscore()
    {
        return score;
        
    }
   

    
    public void help()
    {
        System.out.println("Welcome to Guessing Game");
        System.out.println("A game consists of four rounds");
        System.out.println("For each round a number between 1 and 100 ");
        System.out.println("enters 999  to abandon the round. ");
         
    }
    
    
}
