import java.util.Scanner;

public class Game{
    private static Map map = new Map(10, 20);
    public static void main(String[]args){
		//Map map = new Map(10, 20);
		boolean alive = true;
		
		while(alive){
			game();
		}
    }
    
    public static void game(){
		System.out.println(map.display());
		System.out.print("\tCommand:");
		Scanner console = new Scanner(System.in);
		String command = console.nextLine();
		System.out.println("\n\n\n\n\n\n\n\n\n");
		//map.interpret(command);
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