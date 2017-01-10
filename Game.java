public class Game{
    public static Map map;
    public static Enemy[] enemies;
    public static Character player;
    //public static int floorMulitplier;
    private static final String help = "help\nHere is a List of Available Commands:\nhelp - displays help (a.k.a. this)\nw - move up\na - move left\ns - move down\nd - move right\n";

    //default constructors
    public Game(){
	map = new Map(20, 30);
	player = new Character();
    }

    //checks if the player is alive or not
    public boolean getAlive(){
	return player.getAlive();
    }
	
    //not finished 
    public void interpret(String command){
	RPG.clearScreen();
	//push the handling to map
	map.interpret(command);
    }


    //should print out all the nessecary information in the game
    public String toString(){
	String printOut = map.toString();
	printOut += "\n";
	return printOut;
    }
}
