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
	/**public static void genMap(int row, int col){
        for(int i = 0;i < map.length;i++){
			for(int ind = 0;ind < map[i].length;ind++){
				map[i][ind] = 'X';
			}
		}
		map[0][0] = 'P';
		}**/
    
    /**public String displayMap(){
		for(int row = 0;row < map.length;row++){
			for(int col = 0;col < map[row].length;col++){
				System.out.print(map[row][col]);
			}
			System.out.println();
	}
    }**/
}
