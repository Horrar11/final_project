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
	map = new Map(20, 30, randGen);
	player.setXY(map.lengthX / 2, map.lengthX / 2);
	//spawnEnemies();
	//map.setPlayerPos();
    }

    public Game(Random randgen){
	this();
	this.randGen = randgen;
	
    }
    
    //checks if the player is alive or not
    public boolean getAlive(){
	return player.getAlive();
    }
    
    //
    public void interpret(String command){
	switch(command){
	    //checks to see if new floor should be generated
	case "yes": if(map.saveChar == 'S'){
		map = new Map(20, 30, randGen);
		spawnEnemies();
	    }
	    break;
	case "w": try{
		map.notOccupied(0, player.cords[0], player.cords[1]);
	    }catch(ArrayIndexOutOfBoundsException e){
		System.out.println(e.getMessage());
		return;
	    }
	    player.move(0);
	case "d": try{
		map.notOccupied(1, player.cords[0], player.cords[1]);
	    }catch(ArrayIndexOutOfBoundsException e){
		System.out.println(e.getMessage());
		return;
	    }
	case "s": try{
		map.notOccupied(2, player.cords[0], player.cords[1]);
	    }catch(ArrayIndexOutOfBoundsException e){
		System.out.println(e.getMessage());
		return;
	    }
	case "a": try{
		map.notOccupied(3, player.cords[0], player.cords[1]);
	    }catch(ArrayIndexOutOfBoundsException e){
		System.out.println(e.getMessage());
		return;
	    }
	default: map.interpret(command);
	}
    }
    
    //populate the enemies array
    public void spawnEnemies(){
	enemies = new Enemy[randGen.nextInt(10)+1];
	for (int i = 0; i < enemies.length; i++){
	    //spawns enemies at a random spot on the map
	    enemies[i] = spawnEnemy();
	}
    }

    //going to loop itself if it cannot be placed in the random spot(not done yet)
    public Enemy spawnEnemy() throws IllegalStateException{
	Enemy x = new Enemy(randGen.nextInt(Math.abs(map.lengthX - 2) + 1), randGen.nextInt(Math.abs(map.lengthY - 2) + 1));
	return x;
    }
    
    //should print out all the nessecary information
    public String toString(){
	String printOut = map.toString();
	printOut += "\n";
	return printOut;
    }
}
