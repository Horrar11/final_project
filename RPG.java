import java.util.Scanner;

public class RPG{
    //contains all the data
    private static Game game;

    //interprets commands and passes it to game()
    public static void main(String[]args){
	game = new Game();
	while(game.getAlive()){
	    routine();
	}
    }

    //clears screen
    private static void clearScreen(){
	System.out.println("\033[2J\033[;H");
    }

    //loop that continously runs
    private static void routine(){
	//game's toString prints out map
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
	clearScreen();
	//hands the command to game
	game.map.getXY(game.player.xcor, game.player.ycor);
	game.interpret(command);
    }
}
