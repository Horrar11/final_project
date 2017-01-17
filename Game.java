import java.util.Random;

public class Game{
    public static Map map;
    public static Enemy[] enemies;
    public static Character player;
    //public static int floorMulitplier;
    private static final String help = "help\nHere is a list of Available Commands:\nhelp - displays help (a.k.a. this)\nw - move up\na - move left\ns - move down\nd - move right\n";
    public static String name;
    public static Random randGen;

    //default constructors
    public Game(){
	randGen = new Random();
	player = new Character();
	System.out.println(player);
	map = new Map(20, 30, player);
	player.setSpawn(20, 30);
	map.setXY( map.lengthX / 2, map.lengthX / 2);
	spawnEnemies();
	map.setPlayerPos();
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
    //nothing happens and the player recieves a
    //"You can't go there!" message.
    public void interpret(String command){
	String given = command;
	switch(given){
	case "w": if (map.interpret(command)){player.xcor--;} break;
	case "a": if (map.interpret(command)){player.ycor--;} break;
	case "s": if (map.interpret(command)){player.xcor++;} break;
	case "d": if (map.interpret(command)){player.ycor++;} break;
	case "yes": if(map.saveChar == 'S'){map = new Map(20,30,player); spawnEnemies();} break;
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
    }
}
