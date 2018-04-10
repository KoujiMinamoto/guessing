import java.util.Random;

public class LuckyGuessGenerator
{
    private int randomNumber;
    private int ABrandomNumber;
    private int firstNumber;
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
    public void firstNumber()
    {
       Random randomObject = new Random();
       firstNumber = randomObject.nextInt(1) + 1;
    }
    public int getrandomNumber()
    {
        GenerateRandomNumber();
        return randomNumber;
    }
    public int getfirstNumber()
    {
        firstNumber();
        return firstNumber;
    }
    public int getABrandomNumber()
    {
        ABRandomNumber();
        return ABrandomNumber;
    }
}