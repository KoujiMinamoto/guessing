import java.util.Random;

public class LuckyGuessGenerator
{
    private int randomNumber;
    private int ABrandomNumber;
    public void GenerateRandomNumber()
    {
       Random randomObject = new Random();
       randomNumber = randomObject.nextInt(99) + 1;
    }
    public void ABRandomNumber()
    {
       Random randomObject = new Random();
       ABrandomNumber = randomObject.nextInt(19) + 1;
    }
    
    public int getrandomNumber()
    {
        GenerateRandomNumber();
        return randomNumber;
    }
    
    public int getABrandomNumber()
    {
        ABRandomNumber();
        return ABrandomNumber;
    }
}