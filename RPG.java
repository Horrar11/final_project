import java.util.Scanner;

public class RPG{
    //contains all the data
    private static Game game;
    private static final String help = "Welcome to LKBFCW's Terminal based RPG \nThis game should be ran with the following parameters with the ones in [] being optional \n\tjava RPG [seed [characterType]] (so far only help is in)\nUse \"random\" in place of seed for a random seed \nUse wasd to move and ijkl to attack \n\t(w/i - up; a/j - left; s/k - down; d/l - down)"; 
    

    //interprets commands and passes it to game()
    public static void main(String[]args){
	if(args.length == 0){
	    System.out.println(help);
	    System.exit(1);
	}
	
	//initializes game
	game = new Game();

	//starts the loop of the game
	while(game.getAlive()){
	    routine();
	}
    }

    //clears screen
    public static void clearScreen(){
	System.out.println("\033[2J\033[;H");
    }

    //loop that continously runs
    private static void routine(){
	//game's toString prints out map and all other necessary information
	System.out.println(game);

	
	//checks for terminal input

	//this part here will have to change
	//we will have to test for different
	//types of scenarios. If there are
	//enemies within range then you have
	//to give a combat UI (so that it
	//lists the commands you can use to
	//fight), or if there is a shop so
	//you can can see which commands you
	//can type to buy or sell...

	// so itll be like 3 if statements
	//right here instead of this --> System.out.print("\tCommand:")
	System.out.print("\tCommand:");


	
	Scanner console = new Scanner(System.in);
	String command = console.nextLine();
	//hands the command to game
	game.interpret(command);
    }
}
