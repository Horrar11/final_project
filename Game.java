import java.util.Random;

public class Game{
    public static Map map;
    public static Enemy[] enemies;
    public static Character player;
    //public static int floorMulitplier;
    public static String name;
    public static Random randGen;

    //game has to run with a parameter
    public Game(long seed){
	this.randGen = new Random(seed);
	//passes seed to map as well so that randgen is unified
	map = new Map(20, 30, seed);
	//generates character and centers him
	player = new Character();
	player.setXY(map.lengthX / 2, map.lengthY / 2);
	spawnEnemies();
    }
    
    //checks if the player is alive or not
    public boolean getAlive(){
	return player.getAlive();
    }
    
    //
    public void interpret(String command){
	switch(command){
	    //checks to see if new floor should be generated
	case "yes": if(player.cords[0] == map.stairX && player.cords[1] == map.stairY){
		map = new Map(20, 30, randGen.nextInt(1000000));
		spawnEnemies();
	    }
	    break;
	    //checks to see if the place you're moving to is empty/stairs then it moves you
	case "w": try{
		map.notOccupied(0, player.cords[0], player.cords[1]);
	    }catch(ArrayIndexOutOfBoundsException e){
		System.out.println(e.getMessage());
		return;
	    }
	    player.move(0);
	    break;
	case "d": try{
		map.notOccupied(1, player.cords[0], player.cords[1]);
	    }catch(ArrayIndexOutOfBoundsException e){
		System.out.println(e.getMessage());
		return;
	    }
	    player.move(1);
	    break;
	case "s": try{
		map.notOccupied(2, player.cords[0], player.cords[1]);
	    }catch(ArrayIndexOutOfBoundsException e){
		System.out.println(e.getMessage());
		return;
	    }
	    player.move(2);
	    break;
	case "a": try{
		map.notOccupied(3, player.cords[0], player.cords[1]);
	    }catch(ArrayIndexOutOfBoundsException e){
		System.out.println(e.getMessage());
		return;
	    }
	    player.move(3);
	    break;
	case "": break;
	default: map.interpret(command);
	}
    }
    
    //populate the enemies array
    public void spawnEnemies(){
	enemies = new Enemy[randGen.nextInt(10)+1];
	System.out.println("      " + map.lengthX + " " + map.lengthY);
	for (int i = 0; i < enemies.length; i++){
	    //spawns enemies at a random spot on the map
	    enemies[i] = spawnEnemy();
	}
    }

    //going to loop itself if it cannot be placed in the random spot(not done yet)
    public Enemy spawnEnemy(){
	int x = randGen.nextInt(map.lengthX - 2 + 1);
	int y = randGen.nextInt(map.lengthY - 2 + 1);
	if(map.notOccupied2(x,y)){
	    Enemy ans = new Enemy(x,y);
	    return ans;
	}else{
	    return spawnEnemy();
	}
    }
    
    //should print out all the nessecary information
    public String toString(){
	String printOut = map.toString();
	printOut += "\n";
	return printOut;
    }
}
