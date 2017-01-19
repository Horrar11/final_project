import java.util.Random;
public class Map{
    public char[][] grid;
    //these here declared stuff is for the map
    //to get input from the game to properly
    //render enemies and the player
    public char saveChar = ' ';
    public int lengthX, lengthY;
    public int stairX, stairY;
    public Character player;
    public Random randGen;


    //sets up the border of the map and randomly places the player
    public Map(int row, int col, Character player,Random randGen){
	this.randGen = randGen;
	this.player = player;
	grid = new char[row][col];
	lengthX = row;
	lengthY = col;
	for(int i = 0;i < row;i++){
	    for(int ind = 0;ind < col;ind++){
		grid[i][ind] = ' ';
		if(i == 0 || ind == 0 || i == row -1 || ind == col -1){
		    grid[i][ind] = '#';
		}
		stairX = Math.abs(randGen.nextInt(row - 2)) + 1;
		stairY = Math.abs(randGen.nextInt(col - 2)) + 1;
		grid[stairX][stairY] = 'S';
	    }
	}
    }
    public void clear(){
	for(int i = 0;i < lengthX;i++){
	    for(int ind = 0;ind < lengthY;ind++){
		grid[i][ind] = ' ';
		if(i == 0 || ind == 0 || i == lengthX - 1 || ind == lengthY - 1){
		    grid[i][ind] = '#';
		}
	    }
	    grid[stairX][stairY] = 'S';
	}
    }

	
    //puts a 'P' on the map wherever the player is
    public void setPlayerPos(){grid[player.cords[0]][player.cords[1]] = 'P';}
	
    //puts a 'E' on the map wherever an enemy is
    public void setEnemyPos(int x, int y){grid[x][y] = 'E';}
    
    //this method is a helper method for makeLand() and restoreLand()
    public void setXY(int x, int y){
	player.setXY(x,y);
    }

    //prints out the map
    public String toString(){
	String toRet = "";
	for(int row = 0;row < grid.length;row++){
	    for(int col = 0;col < grid[row].length;col++){
		toRet += grid[row][col];
	    }
	    toRet += "\n";
	}
	return toRet;
    }
	
    public class InvalidAreaException extends Exception{
	public InvalidAreaException(){}
	public InvalidAreaException(String message){
	    super(message);
	}
    }
	
    public void mOOB(){
	System.out.println("\t\t\tYou cannot go there!");
    }

    /*this should be irrelevant for my moving system
    public void makeLand(){grid[player.xcor][player.ycor] = saveChar;}
	
    public boolean restoreLand(){
	if(!(grid[player.xcor][player.ycor] == ' ' || grid[player.xcor][player.ycor] == 'X'))
	    {return true;}
	else{
	    saveChar = grid[player.xcor][player.ycor];
	    return false;
	}
	}
    */
	
    public boolean interpret(String arg){
	String given = arg;
	switch(given){
	    /*going to redo moving
	case "w":
	    try{
		makeLand();
		player.xcor --;
		if(restoreLand()){
		    throw new InvalidAreaException();
		}
		setPlayerPos();
	    } catch (ArrayIndexOutOfBoundsException|InvalidAreaException e){
		player.xcor ++;
		mOOB();
		setPlayerPos();
		return false;
	    } break;
	case "a":
	    try{
		makeLand();
		player.ycor --;
		if(restoreLand()){
		    throw new InvalidAreaException();
		}
		setPlayerPos();
	    } catch (ArrayIndexOutOfBoundsException|InvalidAreaException e){
		player.ycor ++;
		mOOB();
		setPlayerPos();
		return false;
	    } break;
	case "s":
	    try{
		makeLand();
		player.xcor ++;
		if(restoreLand()){
		    throw new InvalidAreaException();
		}
		setPlayerPos();
	    } catch (ArrayIndexOutOfBoundsException|InvalidAreaException e){
		player.xcor --;
		mOOB();
		setPlayerPos();
		return false;
	    } break;
	case "d":
	    try{
		makeLand();
		player.ycor ++;
		if(restoreLand()){
		    throw new InvalidAreaException();
		}
		setPlayerPos();
	    } catch (ArrayIndexOutOfBoundsException|InvalidAreaException e){
		player.ycor --;
		mOOB();
		setPlayerPos();
		return false;
	    } break;
	case "":break;
	    */
	default: System.out.println("404 command not found.\nTry typing help for\na list of available commands.");
	}
	return true;}
	
	
	
    public boolean notOccupied(int dir, int x, int y){
	switch(dir){
	case 0: if(grid[x-1][y] == ' ' || grid[x-1][y] == 'X'){return true;} break;
	case 1: if(grid[x+1][y] == ' ' || grid[x+1][y] == 'X'){return true;} break;
	case 2: if(grid[x][y-1] == ' ' || grid[x][y-1] == 'X'){return true;} break;
	case 3: if(grid[x][y+1] == ' ' || grid[x][y+1] == 'X'){return true;} break;
	default: return false;
	}
		
	return false;
    }
}
