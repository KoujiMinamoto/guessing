import java.util.Random;

public class LuckyGuessGenerator
{
    private int randomNumber;
    public void GenerateRandomNumber()
    {
       Random randomObject = new Random();
       randomNumber = randomObject.nextInt(99) + 1;
    }
    
    public int getrandomNumber()
    {
        GenerateRandomNumber();
        return randomNumber;
    }
}