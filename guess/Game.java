import java.util.*;
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
   

   
    public void vending()
    {
       int guessedNumber;
       int pcguess = lucky.getrandomNumber();
       int realGuess = lucky.getrandomNumber();
       boolean win = false;
       boolean whowin;
       int tries = 0;
       int round = 0;
       while (round <= 4){
           
       round = round + 1;
       while (win == false){  //This while loop false the code with in it repeat until win === true


         
         Scanner prizeScanner = new Scanner(System.in);
         System.out.print("Guess a number between 1-100 : ");
         guessedNumber = prizeScanner.nextInt();
         pcguess = lucky.getrandomNumber();
         tries = tries + 2; //Increasing the number set in the variable tries by 1



            if (guessedNumber == realGuess){

                win = true; 
                whowin = true;
                System.out.println("this round you win");
                
                System.out.println("you get");
                player.addscore(0);
                pcscore = pcscore;

            }
            else if (pcguess == realGuess){

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
            else if(tries >= 6){

                System.out.println("Noone get the one");
                
                int pcabs;
                int youabs;
                pcabs = Math.abs(pcguess-realGuess);
                youabs = Math.abs(guessedNumber-realGuess);
                if(pcabs >= 10&& youabs >= 10 ){
                    
                System.out.println("this round all you lose");
                player.addscore(0);
                pcscore = pcscore + 0;
                    
                }
                else
                if(pcabs > youabs){
                
                System.out.println("this round you lose");
                System.out.println("PC get"+ (10-pcabs));
                player.addscore(0);
                pcscore = pcscore + (10-pcabs);
            
                }
                else if(pcabs == youabs){
                
                System.out.println("this round all you win");
                System.out.println("PC get and you"+ (10-pcabs));
                player.addscore(10-youabs);
                pcscore = pcscore + (10-pcabs);
            
                }
                else if(pcabs < youabs){
                
                System.out.println("this round you win");
                System.out.println("you get"+ (10-youabs));
                player.addscore(10-youabs);
                pcscore = pcscore + 0;
            
                }
                
                win = true; 
                whowin = false;
            }


        }
        System.out.println("You win!");

        System.out.println("It took you "+ tries/2 + " tries.");



        



    }
  
     
    }
   
    public void rungame()
    {
       boolean exit = false;
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