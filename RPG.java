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
	System.out.print("\tCommand:");
	Scanner console = new Scanner(System.in);
	String command = console.nextLine();
	clearScreen();
	//hands the command to game
	game.interpret(command);
    }
}
