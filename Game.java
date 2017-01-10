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
	String given = command;
	//how to distinguish the inputs
	/**switch(given){
	case "w": if (map.interpret(command)){player.xcor--;} break;
	case "a": if (map.interpret(command)){player.ycor--;} break;
	case "s": if (map.interpret(command)){player.xcor++;} break;
	case "d": if (map.interpret(command)){player.ycor++;} break;
	case "help": System.out.println(help); break;
	default: System.out.println("404 command not found.\nTry typing help for\na list of available commands.");
	}*/
	map.interpret(command);
    }


    //should print out all the nessecary information
    public String toString(){
	String printOut = map.toString();
	printOut += "\n";
	return printOut;
    }
}
