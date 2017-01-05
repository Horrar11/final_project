import java.util.Scanner;

public class Game{
    //params for storage
    private static Map map = new Map(20, 30);
    private static boolean alive = true;

    public static void main(String[]args){
		while(alive){
			game();
		}
    }

    //clears the screen
    private static void clearScreen(){
	System.out.print("\033[2J\033[;H");
    }
    
    //heart of the game
    private static void game(){
	System.out.println(map.display());
	System.out.print("\tCommand:");
	Scanner console = new Scanner(System.in);
	String command = console.nextLine();
	clearScreen();
	map.interpret(command);
    }

    //checks whether or not 
    public static boolean getAlive(){
	return alive;
    }

    public static void setAlive(boolean val){
	alive = val;
    }
}
