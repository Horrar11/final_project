import java.util.Random;
public class Map{
    public char[][] grid;
    public char saveChar = ' ';
    public int lengthX, lengthY;
    public int stairX, stairY;
    public Random randGen;


    //sets up the border of the map and randomly places the player
    public Map(int row, int col,Random randGen){
	this.randGen = randGen;
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
    
    public void setPos(int x, int y, char symbol){grid[x][y] = symbol;}
	
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
	
    public void makeLand(){grid[player.xcor][player.ycor] = saveChar;}
    
    public void restoreLand(){
	saveChar = grid[player.xcor][player.ycor];
    }
    
    public boolean interpret(String arg){
	String given = arg;
	switch(given){
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
	    if(notOccupied(2, player.xcor, player.ycor)){
		player.ycor --;
		restoreLand();
		setPlayerPos()
	    }
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
	default: System.out.println("404 command not found.\nTry typing help for\na list of available commands.");
	}
	return true;}
	
	
	
    public boolean notOccupied(int dir, int x, int y){
	switch(dir){
	case 0: if(grid[x-1][y] == ' ' || grid[x-1][y] == 'X' || grid[x-1][y] == 'S'){return true;} break;
	case 1: if(grid[x+1][y] == ' ' || grid[x+1][y] == 'X' || grid[x+1][y] == 'S'){return true;} break;
	case 2: if(grid[x][y-1] == ' ' || grid[x][y-1] == 'X' || grid[x][y-1] == 'S'){return true;} break;
	case 3: if(grid[x][y+1] == ' ' || grid[x][y+1] == 'X' || grid[x][y+1] == 'S'){return true;} break;
	default: return false;
	}
		
	return false;
    }
}
