import java.util.Random;

public class Game{
    public static Map map;
    public static Enemy[] enemies;
    public static Character player;
    //public static int floorMulitplier;
    public static String name;
    public static Random randGen;

    //default constructors
    public Game(){
	randGen = new Random();
	player = new Character();
	map = new Map(20, 30, player, randGen);
	player.setSpawn(20, 30);
	map.setXY( map.lengthX / 2, map.lengthX / 2);
	spawnEnemies();
	map.setPlayerPos();
    }

      public Game(Random randgen){
	this();
	this.randGen = randgen;
	
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
	case "yes": if(map.saveChar == 'S'){map = new Map(20,30,player,randGen); spawnEnemies();} break;
	default: System.out.println("404 command not found.\nTry typing help for\na list of available commands.");
	}
    }
    
    //populate the enemies array
    public void spawnEnemies(){
	enemies = new Enemy[randGen.nextInt(10)+1];
	for (int i = 0; i < enemies.length; i++){
	    enemies[i] = new Enemy(randGen.nextInt(Math.abs(map.lengthX - 2) + 1),randGen.nextInt(Math.abs(map.lengthY - 2) + 1));
	}
    }
    
    //should print out all the nessecary information
    public String toString(){
	String printOut = map.toString();
	printOut += "\n";
	return printOut;
    }
}
