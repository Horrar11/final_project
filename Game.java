import java.util.Random;

public class Game{
	public static int score;
    public static Map map;
    public static Enemy[] enemies;
    public static Character player;
    public static int floorMultiplier;
    public static String name;
    public static Random randGen;
	private int seed;
	private static final String help = "help\nHere is a list of Available Commands:\nhelp - displays help (a.k.a. this)\nw - move up\na - move left\ns - move down\nd - move right\n";
	
    //default constructors
    public Game(int seed){
	randGen = new Random(seed);
	this.seed = seed;
	player = new Character(seed);
	map = new Map(30, 50, seed);
	player.setSpawn(map.lengthX, map.lengthY);
	spawnEnemies(seed);
	map.setPos(player.xcor, player.ycor, player.displayChar);
	floorMultiplier = 0;
    }
    
    //checks if the player is alive or not
    public boolean getAlive(){return player.getAlive();}
	
	public void testMoney(){if(map.saveChar == '$'){score += ((randGen.nextInt(10) + 1) * floorMultiplier / 2); map.saveChar = ' ';}}
    
    public void interpret(String command){
	switch(command){
	case "w": if (map.interpret(command, player.xcor, player.ycor, player.displayChar)){player.xcor --;testMoney();} break;
	case "a": if (map.interpret(command, player.xcor, player.ycor, player.displayChar)){player.ycor --;testMoney();} break;
	case "s": if (map.interpret(command, player.xcor, player.ycor, player.displayChar)){player.xcor ++;testMoney();} break;
	case "d": if (map.interpret(command, player.xcor, player.ycor, player.displayChar)){player.ycor ++;testMoney();} break;
	case "help": System.out.println(help);break;
	case "suicide": player.hp -= 1000.00;
	case "yes": if(map.saveChar == 'S'){floorMultiplier++;score += 1000 * floorMultiplier - 100 * enemies.length; map = new Map(30,50,seed + floorMultiplier); spawnEnemies(seed); map.setPos(player.xcor, player.ycor, player.displayChar);} break;
	default: System.out.println("Invalid Arguement!!!");
	}
    }
    
    //populate the enemies array
    public void spawnEnemies(int number){
	enemies = new Enemy[randGen.nextInt(10)+1];
	for (int i = 0; i < enemies.length; i++){
	    enemies[i] = new Enemy(randGen.nextInt(Math.abs(map.lengthX - 2)) + 1,randGen.nextInt(Math.abs(map.lengthY - 2)) + 1, number);
		//System.out.println("+1 to enemies");
	}
    }
	
	public void testTrap(){if(map.saveChar == 'T'){if(randGen.nextInt(3) == 1){score += randGen.nextInt(1000) * floorMultiplier;} else{player.hp -= 1000.00;}}};
    
	public void moveAll(){
		testTrap();
		for (int i = 0; i < enemies.length; i++){
			int direction = randGen.nextInt(4);
			//if(Ai(enemies[i])){}
			if(map.notOccupied(direction, enemies[i].xcor, enemies[i].ycor)){
				//System.out.println("Error check");
				enemies[i].move(direction);
				testTrap();
				//System.out.println("Error clean!");
			}
		}
		map.clear();
		//System.out.println("Map clean");
		map.setPos(player.xcor, player.ycor, player.displayChar);
		testTrap();
		for (int i = 0; i < enemies.length; i++){
			map.setPos(enemies[i].xcor, enemies[i].ycor, enemies[i].displayChar);
			testTrap();
		}
	}
	
	/*public boolean Ai(Enemy Bob){
		//boolean Searched = false;
		//int radius = 2;
		for(int dir = 0; dir < 4, dir ++){
			if(!map.notOccupied(dir, Bob.xcor, Bob.ycor)){
				Bob.attack(dir);
			}
		}
		for(int i = 0; !Searched; i++){
			for(int dir = 0; dir < 4; dir++){
				if(!map.notOccupied(dir, Bob.xcor + i, Bob.ycor + i) ){
					Bob.move(dir);
					break;
				}
				else if(!map.notOccupied(dir, Bob.xcor - i, Bob.ycor - i) ){
					Bob.move(dir);
					break;
				}
				else if(!map.notOccupied(dir, Bob.xcor + i, Bob.ycor - i) ){
					Bob.move(dir);
					break;
				}
				else if(!map.notOccupied(dir, Bob.xcor - i, Bob.ycor + i) ){
					Bob.move(dir);
					break;
				}
			}
		}
	}*/
	
    //should print out all the nessecary information
    public String toString(){
	String printOut = map.toString();
	printOut += "\n";
	return printOut;
    }
}
