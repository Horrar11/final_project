import java.util.Scanner;

public class Game{
    private char[][] map;
    public static void main(String[]args){
	game();
    }
    public static void genMap(int genSeed){
	
    }
    public static String displayMap(){
	for(int row = 0;row < map.length;row++){
	    for(int col = 0;col < map[].length;col++){
		System.out.print(map[row][col]);
	    }
	    System.out.println()
	}
    }
    public static void game(){
	Scanner console = new Scanner(System.in);
	displayMap();
    }
}
