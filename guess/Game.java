import java.util.*;
import java.lang.Math.*;
public class Game
{

    Player player ;
    private boolean isCreated;
    private boolean win;
    private String playerName;
    LuckyGuessGenerator lucky = new LuckyGuessGenerator();
    int pcscore = 0;
    
    public Game()
    {
        
    }
    
    public void displaymenu()
    {
        System.out.println("Welcome to the Guessing Game");
        System.out.println("====================================");
        System.out.println("(1) Set Up New Player");
        System.out.println("(2) Guess");
        System.out.println("(3) What Have I Won So Far?");
        System.out.println("(4) Display Game Help");
        System.out.println("(5) Exit Game");
        System.out.println("====================================");
        System.out.println("Choose an option:");
    }
    
        public int getChoice()
    {
       Scanner choiceScanner = new Scanner(System.in);
       int choice;
       displaymenu();
       choice = choiceScanner.nextInt();
       return choice;
       
    }
    
    public void setNewPlayer()
    {
        String name = "";
        Scanner playerNameScanner = new Scanner(System.in);
        System.out.print("Enter Player's Name: ");
        name = playerNameScanner.nextLine();
        if(name.trim().isEmpty())
        {
            System.out.println("Error: The Player's name must not be blank!");
        }
        else
        {

            playerName = name;

            isCreated = true;
        }
        
    }
    
    public String getplayerName()
    {
        return playerName;
    }

    
    public boolean getisCreated()
    {
        return isCreated;
    }
   
    private int convertStringtoInt(String input) //method to convert String to Integer
    {
        //intialised variables
        String S = input;
        int i = 0;
        //try catch to handle NumberFormatException
        try
        {
            // the String to int conversion happens here
            i = Integer.parseInt(input.trim());

            // print out the value after the conversion
            //System.out.println("int i = " + i);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage() + ", please input an integer!");
        }
        return i;
    }
   
    public void vending()
    {
       int guessedNumber;
       int pcguess = lucky.getrandomNumber();
       int realGuess = lucky.getrandomNumber();
       boolean win = false;
       boolean whowin;
       int tries = 0;
       int round = 0;
       int winscore = 0;
       while (round < 4){
       win = false;
       
       int ABrandomNumber = lucky.getABrandomNumber();
       round = round + 1;
       while (win == false){  //This while loop false the code with in it repeat until win === true
         Scanner prizeScanner = new Scanner(System.in);
         System.out.print("Guess a number between 1-100 : ");
         pcguess = lucky.getrandomNumber();
         String sguessedNumber = prizeScanner.nextLine();
         while(validBlanknumber(sguessedNumber))
         sguessedNumber = prizeScanner.nextLine();
         guessedNumber = convertStringtoInt(sguessedNumber);
         
         if (guessedNumber == 999){
            System.out.println("AB");
            win = true;
            player.addguess("AB",0,round);
        }
        else
        if(pcguess == ABrandomNumber){
            
            System.out.println("AB");
            win = true;
            player.addguess("AB",0,round);
            }
            else
            if(guessedNumber >= 1 && guessedNumber <= 100){
         
         
         
                tries = tries + 2; //Increasing the number set in the variable tries by 1
            if (tries == 6){
            System.out.println("Noone get the one");
                
                int pcabs;
                int youabs;
                pcabs = Math.abs(pcguess-realGuess);
                youabs = Math.abs(guessedNumber-realGuess);
                if(pcabs >= 10&& youabs >= 10 ){
                    
                System.out.println("this round all you lose");
                player.addscore(0);
                player.addpcscore(0);
                win = true;
               
                }
                else
                if(pcabs > youabs){
                System.out.println("this round you win");
                System.out.println("you get"+ (10-youabs));
                player.addscore(10-youabs);
                player.addpcscore(0);
                player.addguess("you",guessedNumber,round);
                win = true;
                whowin = true;
                }
                else if(pcabs == youabs){
                
                System.out.println("this round all you win");
                System.out.println("PC get and you"+ (10-pcabs));
                player.addscore(10-youabs);
                player.addpcscore(10-pcabs);
                player.addguess("you",guessedNumber,round);
                player.addguess("pc",pcguess,round);
                win = true;
                }
                else if(pcabs < youabs){
                System.out.println("this round you lose");
                System.out.println("PC get"+ (10-pcabs));
                player.addscore(0);
                player.addpcscore(10-pcabs);
                player.addguess("pc",pcguess,round); 
                whowin = false;
                win = true;
                }
                
            }

            else
            if (guessedNumber == realGuess){
                switch(tries)
                {
                case 2:winscore = 20;
                break;
                case 4:winscore = 11;
                break;
                case 6:winscore =6;
                break;
                }
                win = true; 
                whowin = true;
                System.out.println("this round you win");
                
                System.out.println("you get" + winscore);
                player.addscore(winscore);
                player.addpcscore(0);
                player.addguess("you",guessedNumber,round);

            }
            else if (pcguess == realGuess){
                switch(tries)
                {
                case 2:winscore = 15;
                break;
                case 4:winscore = 8;
                break;
                case 6:winscore =5;
                break;
                }
                System.out.println("this round you lose");
                
                System.out.println("Pc get" + winscore);
                player.addpcscore(winscore);
                player.addscore(0);
                player.addguess("pc",pcguess,round);
                win = true; 
                whowin = false;

            }



            else if(guessedNumber < realGuess){

                System.out.println("Number is to low, tray again");

                //2nd thing guess is compared too.

            }



            else if(guessedNumber > realGuess){

                System.out.println("Number is to high, try again");

                //3rd thing guess is compared too.

            }

            }
        else 
        {
        System.out.println("Error : only choose 1-100 or 999");
        }
        
        
        }
        tries = 0 ;
    }

    prizeWonSoFar();


        



    }
    
   public void prizeWonSoFar()
    {
       System.out.println(player.getguess());
       System.out.println("PC score is" + player.getpcscore());
       System.out.println( getplayerName() +"score is" + player.getscore());

       
    }
     private boolean validBlanknumber(String iobuffer) //method to check insert any empties or blanks
    {
        if (iobuffer.matches("[0-9]*"))
        {
            return false;
        }
        System.out.println("Error:   should be number!...Please enter again:");
        return true;
    }
    
   
    public void rungame()
    {
       boolean exit = false;
       player = new Player();
       while (!exit)
       {
           switch(getChoice())
           {
                case 1: player = new Player();
                        setNewPlayer(); 
                        break;
                case 2: if(getisCreated())
                        {
                            vending();   
                        }
                        else
                        {
                            System.out.println("Error : player has not been set up!");
                        }
                        break;
                case 3: if(getisCreated())
                        {
                           
                            
                        }
                        else
                        {
                            System.out.println("Error : player has not been set up!");
                        }   
                        break;
                case 4: player.help();
                        break;
                case 5: exit = true;
                        System.out.println("Goodbye. Thank you for playing.");
                        break;
        
               
            }
            
       } 
       
    } 
    
}