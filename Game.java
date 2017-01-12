import java.util.Random;
public class Game{
    public static Map map;
    public static Enemy[] enemies;
    public static Character player;
    public static String name;
    public static Random randGen;
    //public static int floorMulitplier;

    //default constructors
    public Game(){
	map = new Map(20, 30);
	player = new Character();
	player.setSpawn(20, 30);
	map.setXY(player.xcor, player.ycor);
	spawnEnemies();
	map.setPlayerPos();
	randGen = new Random();
    }

    public Game(int number){
	this();
	randGen = new Random(number);
	
    }

    //checks if the player is alive or not
    public boolean getAlive(){
	return player.getAlive();
    }
	
    //sends command over to map to see if the map can place
    //the player in the place he wants to go, if not then 
    //nothing happens and the player recieves a "You can't go there!"
    //message.
    public void interpret(String command){
	String given = command;
	switch(given){
	case "w": if (map.interpret(command)){player.xcor--;} break;
	case "a": if (map.interpret(command)){player.ycor--;} break;
	case "s": if (map.interpret(command)){player.xcor++;} break;
	case "d": if (map.interpret(command)){player.ycor++;} break;
	default: System.out.println("404 command not found.\nTry typing help for\na list of available commands.");
	}
    }

    //populate the enemies array
    public void spawnEnemies(){
	Random amount = new Random();
	enemies = new Enemy[amount.nextInt(10)+1];
	for (int i = 0; i < enemies.length; i++){
	    enemies[i] = new Enemy(amount.nextInt(Math.abs(map.lengthX - 2) + 1),amount.nextInt(Math.abs(map.lengthY - 2) + 1));
	}
    }
	
    //should print out all the nessecary information
    public String toString(){
	String printOut = map.toString();
	printOut += "\n";
	return printOut;
    }
}import java.util.Random;
public class Game{
    public static Map map;
    public static Enemy[] enemies;
    public static Character player;
    //public static int floorMulitplier;
    private String help = "help\nHere is a list of Available Commands:\nhelp - displays help (a.k.a. this)\nw - move up\na - move left\ns - move down\nd - move right\n";

    //default constructors
    public Game(){
	map = new Map(20, 30);
	player = new Character();
	player.setSpawn(20, 30);
	map.setXY(player.xcor, player.ycor);
	spawnEnemies();
	map.setPlayerPos();
    }

<<<<<<< HEAD
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
=======
    //checks if the player is alive or not
    public boolean getAlive(){
	return player.getAlive();
    }
	
    //sends command over to map to see if the map can place
	//the player in the place he wants to go, if not then 
	//nothing happens and the player recieves a "You can't go there!"
	//message.
    public void interpret(String command){
		String given = command;
		switch(given){
		case "w": if (map.interpret(command)){player.xcor--;} break;
		case "a": if (map.interpret(command)){player.ycor--;} break;
		case "s": if (map.interpret(command)){player.xcor++;} break;
		case "d": if (map.interpret(command)){player.ycor++;} break;
		case "help": System.out.println(help);
		default: System.out.println("404 command not found.\nTry typing help for\na list of available commands.");
		}
    }

	//populate the enemies array
	public void spawnEnemies(){
		Random amount = new Random();
		enemies = new Enemy[amount.nextInt(10)+1];
		for (int i = 0; i < enemies.length; i++){
			enemies[i] = new Enemy(amount.nextInt(Math.abs(map.lengthX - 2) + 1),amount.nextInt(Math.abs(map.lengthY - 2) + 1));
		}
	}
	
    //should print out all the nessecary information
    public String toString(){
	String printOut = map.toString();
	printOut += "\n";
	return printOut;
>>>>>>> 0fc85d0b884e9de2d598e135d14fa7be9d801ba9
    }
}
