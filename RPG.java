import java.util.Scanner;
import java.util.Random;
public class RPG{
    //contains all the data
    private static Game game;
    private static String prompt;
    private static final String fightUI = "An enemy is in range!\nFight\tItem\nSuicide\tSurrender\n";
    private static final String shopUI = "Shopkeeper> Oh, hello there!\nBuy\tSell\tForge\nLeave via the W-A-S-D keys\n";
    private static final String standardUI = "Move around with W-A-S-D keys\nMove to the S on the map to \nGet to the next floor!\n";
    private static final String start = "Welcome to LKBFCW's Terminal based RPG \nThis game should be ran with the following parameters with the ones in [] being optional \n\tjava RPG [seed] \nUse \"random\" in place of seed for a random seed \nUse wasd to move and pick up $$$";
    private static final String stairs = "Would you like to go down the stairs?\nYes\tNo(Leave via the W-A-S-D keys)\n";
    public static Random randGen;
    

    //interprets commands and passes it to game()
    public static void main(String[]args){
	//checks the parameters and does stuff based on that
	if(args.length == 0){
	    System.out.println(start);
	    System.exit(1);
	}
	if(args.length > 0){
		int seed = Integer.parseInt(args[0]);
	    randGen = new Random(seed);
	    game = new Game(seed);
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
	System.out.println("YOU HAVE DIED " + prompt + "!!!\nTHERE IS ONLY ONE ESCAPE FROM \nBEING SUCK INSIDE THIS MATRIX FOREVER...\nYOUR SCORE WAS: " + game.score + "\nTO PLAY AGAIN RUN THE GAME AGAIN.");
    }

	
    //clears screen
    private static void clearScreen(){
	System.out.println("\033[2J\033[;H");
    }

	
    //loop that continously runs
	
    private static void routine(){
	System.out.println();
	System.out.println("Floor " + (game.floorMultiplier + 1));
	System.out.println();
	System.out.print(game);
	System.out.println((int)game.player.hp + " / " + (int)game.player.maxhp);
	System.out.println((int)game.player.mp + " / " + (int)game.player.maxmp);
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
	
	
	//gets the command that the player types in
	
	System.out.print("\t" + prompt);	
	Scanner console = new Scanner(System.in);
	String command = console.nextLine();
	command = command.toLowerCase();
	
	
	clearScreen();
	//System.out.println("clearedScreen!");
	game.interpret(command);
	game.moveAll();
	}
    }