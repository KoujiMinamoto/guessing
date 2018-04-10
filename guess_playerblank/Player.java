import java.util.*;
public class Player
{
    
    private int score;
    private String guesses = "";
    private String name = "";
    public Player()
    {
        
    }
    
     public String getname()
    {
        return name;
    }
    
    public void setname(String newname){

        name = newname;
    
    }
    public void addguess(String guess)
    {
    
        guesses = guess;
    
    }
    
    public String getguess()
    {
        return guesses;
        
    }
    

    
    public void addscore(int score1)
    {
        score = score1;
        
    }

    public int getscore()
    {
        return score;
        
    }
   

    
    
}
