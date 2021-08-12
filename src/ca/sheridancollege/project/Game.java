/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 */
public abstract class Game 
{
    private final String gameName; //the title of the game
    private ArrayList <Player> players;// the players of the game
    public static int playerScore = 0;
    public static int cpuScore = 0;
    public static boolean playerWin;
    public static boolean cpuWin;
    
    public Game(String roulette)
    {
        gameName = roulette;
        players = new ArrayList();
    }

    /**
     * @return the gameName
     */
    public String getGameName() 
    {
        return gameName;
    }
    
     /**
     * @return the players of this game
     */
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList <Player> players) 
    {
        this.players = players;
    }
    
    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
    //public abstract void play();
    
    public static void main(String[] args)
    {
    
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        Player.playerID = input.nextLine();
        System.out.println("Hello " + Player.playerID + ", Welcome to Roulette!"
                + " Enter a cards suit and it's value to try and match with the"
                + " computers randomized card. If it is a match, you win! You "
                + "have a 1 out of 52 chance, good luck! ");
        boolean loop = true;
        while(loop == true){
            Card[] magicHand = new Card[1];
            
            for (Card magicHand1 : magicHand) {
                boolean continueLoop = true;
                Card c = new Card();
                c.setValue((int)(Math.random()*13+1));
                c.setSuit(Card.SUITS[(int)(Math.random()*4)]);
                
                System.out.println("Enter a card suit");
                Card.playersuit = input.nextLine();
                System.out.println("Enter a card value");
                Card.playervalue = input.nextInt();
                
                if(Card.playersuit == c.getSuit() && Card.playervalue == 
                        c.getValue()){
                    playerScore++;
                    System.out.println("Match: your card was: " +
                            Card.playersuit + " " + Card.playervalue +
                            " Computer's card was: " + c.getSuit() + " " + 
                            c.getValue());
                    System.out.println("Player Score: " + playerScore);
                    System.out.println("Computers Score: " + cpuScore);
                }
                else{
                    cpuScore++;
                    System.out.println("No match. Your card was: " +
                            Card.playersuit + " " + Card.playervalue +
                            " Computer's card was: " + c.getSuit() + " " + 
                            c.getValue());
                    System.out.println("Player Score: " + playerScore);
                    System.out.println("Computers Score: " + cpuScore);
                }
                
                System.out.println("Would you like to try again? (y/n) ");
                input.nextLine();
                
                loop = input.nextLine().trim().equalsIgnoreCase("y");
                
                if(loop == false)
                    if(playerScore > cpuScore){
                        System.out.println("You won with " + playerScore + 
                                " points! " + "Congratulations and thanks for "
                                        + "playing!");
                    }
                    else
                        System.out.println("Sorry, you lost with " + playerScore 
                                + " points. Thanks for playing anyways!");
                    
            }
        }
    }
    
    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public static void declareWinner(){
        if(playerScore > cpuScore){
            playerWin = true;
            System.out.println("Player Score: " + playerScore);
            System.out.println("Computer Score: " + cpuScore);
        }
        
        else{
            cpuWin = true;
            System.out.println("Player Score: " + playerScore);
            System.out.println("Computer Score: " + cpuScore);
        }
    }
    

   
    
}//end class
