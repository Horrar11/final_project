import java.util.Scanner;
import java.util.Random;
public class RPG{
    //contains all the data
    private static Game game;
    private static String prompt;
    
    private static final String fightUI = "An enemy is in range!\nFight\tItem\nSuicide\tSurrender";
    private static final String shopUI = "Shopkeeper> Oh, hello there!\nBuy\tSell\tForge\nLeave via the W-A-S-D keys";
    private static final String standardUI = "Move around with W-A-S-D keys\nAccess your items through INVENTORY";
    private static final String start = "Welcome to LKBFCW's Terminal based RPG \nThis game should be ran with the following parameters with the ones in [] being optional \n\tjava RPG [seed] \nUse a non-number in place of seed for a random seed /nUse wasd to move /nUse \"yes\" to go to the next floor once you reached the stirs";
    private static final String help = "help\nHere is a list of Available Commands:\nhelp - displays help (a.k.a. this)\nw - move up\na - move left\ns - move down\nd - move right\n";
    private static final String stairs = "Would you like to go down the stairs?\nYes\tNo";
    
    public static Random randGen;
    public static long seed;
    

    //interprets commands and passes it to game()
    public static void main(String[]args){
	//checks the parameters and does stuff based on that

	//if there is no parameters, it prints out the default start up 'tutorial'
	if(args.length == 0){
	    System.out.println(start);
	    System.exit(1);
	}
	//if there is at least 1 parameter then it uses the first as the seed
	try{//checks to see if its a number
	    seed = Long.parseLong(args[0]) % 1000000;
	}catch (NumberFormatException e){//if it isn't it just uses a random seed
	    seed = System.currentTimeMillis();
	}
	randGen = new Random(seed);
	game = new Game(seed);
	clearScreen();
	//lets player enter their desired name as well as display the seed	
	System.out.println("Seed: " + seed);
	System.out.print("Hello adventurer, what would you like to be called?\nEnter your name>");
	Scanner toPrompt = new Scanner(System.in);
	prompt = toPrompt.nextLine();
	prompt += "> ";
	game.name = prompt;
	//set up is done and game begins
	while(game.getAlive()){
	    routine();
	}
    }

    //clears screen
    private static void clearScreen(){
	System.out.println("\033[2J\033[;H");
    }

    //chooses the proper UI; I feel this is too complex for little payoff
    private static void displayUI(){
	/*gives the proper display of commands based on position
	if(game.map.saveChar == 'S'){
	    System.out.print(stairs);
	}
	else if(game.player.inRangeEnemy()){
	    System.out.print(fightUI);
	}
	else if(game.player.inRangeShop()){
	    System.out.print(shopUI);
	}
	else {System.out.print(standardUI);}
	*/
    }

    
    //loop that continously runs
    private static void routine(){	
	//refreshes the map (gets rid of old map and replots the new points)
	clearScreen();
	game.map.clear();
	game.map.setPlayerPos(game.player);
	for (int i = 0; i < game.enemies.length; i++){
	    game.map.setEnemyPos(game.enemies[i].cords[0], game.enemies[i].cords[1], 'E');
	}
	//game's toString prints out map
	System.out.print(game);
	//gets the command that the player types in
	System.out.print("\t" + prompt);	
	Scanner console = new Scanner(System.in);
	String command = console.nextLine();
	command = command.toLowerCase();
	//this processes what the player wants
	switch(command){
	case "help": System.out.println(help);
	    break;
	default: game.interpret(command);
	}
	//moves all the enemies
	for (int i = 0; i < game.enemies.length; i++){
	    int direction = randGen.nextInt(4);
	    boolean boo = false;
	    //same movement system as the player, but it doesn't do anything with the exception
	    try{
	        boo = game.map.notOccupied(direction, game.enemies[i].cords[0], game.enemies[i].cords[1]);
	    }catch(ArrayIndexOutOfBoundsException e){
	    }
	    if(boo){
		game.enemies[i].move(direction);
	    }
	}
    }

    
}
