public class Game{
    private static Map map;
    private static Enemy[] enemies;
    private static Character player;

    //default constructors
    public Game(){
	map = new Map();
	player = new Character();
    }

    //checks if the player is alive or not
    public boolean getAlive(){
	return player.getAlive();
    }

    //not finished 
    public void interpret(String command){
    }


    //should print out all the nessecary information
    public String toString(){
	String printOut = map.toString();
	printOut += "/n/n";
	return printOut;
    }
}
