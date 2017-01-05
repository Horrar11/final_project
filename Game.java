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

    private static void clearScreen(){
	System.out.print("\033[2J\033[;H");
    }
    
    private static void game(){
	System.out.println(map.display());
	System.out.print("\tCommand:");
	Scanner console = new Scanner(System.in);
	String command = console.nextLine();
	clearScreen();
	map.interpret(command);
    }
    public static boolean getAlive(){
	return alive;
    }
    public static void setAlive(boolean val){
	alive = val;
    }
}
