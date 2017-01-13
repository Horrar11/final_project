import java.util.Random;
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
		case "yes": if(map.saveChar == 'S'){map = new Map(20,30); spawnEnemies();} break;
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
