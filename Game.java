public class Game{
    public static Map map;
    public static Enemy[] enemies;
    public static Character player;
	//public static int floorMulitplier;

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
		String given = command;
		switch(given){
			case "w": map.interpret(command); player.xcor--; break;
			case "a": map.interpret(command); player.ycor--; break;
			case "s": map.interpret(command); player.xcor++; break;
			case "d": map.interpret(command); player.ycor++; break;
			default: System.out.println("404 command not found");
		}
    }


    //should print out all the nessecary information
    public String toString(){
	String printOut = map.toString();
	printOut += "\n";
	return printOut;
    }
}
