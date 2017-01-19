import java.util.Scanner;
import java.util.Random;
public class RPG{
    //contains all the data
    private static Game game;
    private static String prompt;
    
    private static final String fightUI = "An enemy is in range!\nFight\tItem\nSuicide\tSurrender";
    private static final String shopUI = "Shopkeeper> Oh, hello there!\nBuy\tSell\tForge\nLeave via the W-A-S-D keys";
    private static final String standardUI = "Move around with W-A-S-D keys\nAccess your items through INVENTORY";
    private static final String start = "Welcome to LKBFCW's Terminal based RPG \nThis game should be ran with the following parameters with the ones in [] being optional \n\tjava RPG [seed] \nUse \"random\" in place of seed for a random seed /nUse wasd to move and ijkl to attack";
    private static final String help = "help\nHere is a list of Available Commands:\nhelp - displays help (a.k.a. this)\nw - move up\na - move left\ns - move down\nd - move right\n";
    private static final String stairs = "Would you like to go down the stairs?\nYes\tNo";
    public static Random randGen;
    

    //interprets commands and passes it to game()
    public static void main(String[]args){
	//checks the parameters and does stuff based on that
	if(args.length == 0){
	    System.out.println(start);
	    System.exit(1);
	}
	if(args.length > 0){
	    randGen = new Random(Integer.parseInt(args[0]));
	    game = new Game(randGen);
	}else{
	    game = new Game();
	}
	clearScreen();
	System.out.print("Hello adventurer, what would you like to be called?\nEnter your name>");
	Scanner toPrompt = new Scanner(System.in);
	prompt = toPrompt.nextLine();
	prompt += "> ";
	game.name= prompt;
	while(game.getAlive()){
	    routine();
	}
    }

    //clears screen
    private static void clearScreen(){
	System.out.println("\033[2J\033[;H");
    }

    //chooses the proper UI 
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
	//game's toString prints out map
	System.out.print(game);
	displayUI();
	//gets the command that the player types in
	System.out.print("\t" + prompt);	
	Scanner console = new Scanner(System.in);
	String command = console.nextLine();
	command = command.toLowerCase();
	clearScreen();
	//moves all the enemies
	for (int i = 0; i < game.enemies.length; i++){
	    int direction = randGen.nextInt(4);
	    if(game.map.notOccupied(direction, game.enemies[i].cords[0], game.enemies[i].cords[1])){
		game.enemies[i].move(direction);
	    }
	}
	//refreshes the map
	game.map.clear();
	game.map.setPlayerPos();
	for (int i = 0; i < game.enemies.length; i++){
	    game.map.setEnemyPos(game.enemies[i].cords[0], game.enemies[i].cords[1]);
	}
	switch(command){
	case "help": System.out.println(help);
	default: game.interpret(command);
	}
    }

    
}
