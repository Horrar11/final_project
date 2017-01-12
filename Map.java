import java.util.Random;
public class Map{
    public char[][] grid;
	//these here declared stuff is for the map
	//to get input from the game to properly
	//render enemies and the player
	private int playerX, playerY;
    private char saveChar = ' ';//read the code if you dont understand
	public int lengthX, lengthY;

    //sets up the border of the map and randomly places the player
    public Map(int row, int col){
		grid = new char[row][col];
		lengthX = row;
		lengthY = col;
		for(int i = 0;i < row;i++){
			for(int ind = 0;ind < col;ind++){
				grid[i][ind] = ' ';
				if(i == 0 || ind == 0 || i == row -1 || ind == col -1){
					grid[i][ind] = '#';
				}
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
		}
	}
	
    //puts a 'P' on the map wherever the player is
    public void setPlayerPos(){grid[playerX][playerY] = 'P';}
	
	//puts a 'E' on the map wherever an enemy is
    public void setEnemyPos(int x, int y){grid[x][y] = 'E';}
	
	//this method is a helper method for makeLand() and restoreLand()
	public void setXY(int x, int y){playerX = x; playerY = y;}

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
    
    public void makeLand(){grid[playerX][playerY] = saveChar;}
	
    public boolean restoreLand(){
	if(!(grid[playerX][playerY] == ' ' || grid[playerX][playerY] == 'X'))
	    {return true;}
		else{
		    saveChar = grid[playerX][playerY];
		    return false;
		}
    }
    
    public boolean interpret(String arg){
	String given = arg;
	given = given.toLowerCase();
	switch(given){
	case "w":
	    try{
		makeLand();
		playerX --;
		if(restoreLand()){
		    throw new InvalidAreaException();
		}
		setPlayerPos();
	    } catch (ArrayIndexOutOfBoundsException|InvalidAreaException e){
		playerX ++;
		mOOB();
		setPlayerPos();
		return false;
	    } break;
	case "a":
	    try{
		makeLand();
		playerY --;
		if(restoreLand()){
		    throw new InvalidAreaException();
		}
		setPlayerPos();
	    } catch (ArrayIndexOutOfBoundsException|InvalidAreaException e){
		playerY ++;
		mOOB();
		setPlayerPos();
		return false;
	    } break;
	case "s":
	    try{
		makeLand();
		playerX ++;
		if(restoreLand()){
		    throw new InvalidAreaException();
		}
		setPlayerPos();
	    } catch (ArrayIndexOutOfBoundsException|InvalidAreaException e){
		playerX --;
		mOOB();
		setPlayerPos();
		return false;
	    } break;
	case "d":
	    try{
		makeLand();
		playerY ++;
		if(restoreLand()){
		    throw new InvalidAreaException();
		}
		setPlayerPos();
	    } catch (ArrayIndexOutOfBoundsException|InvalidAreaException e){
		playerY --;
		mOOB();
		setPlayerPos();
		return false;
	    } break;
	default: System.out.println("\tMap \n");
	}
	return true;}
    
    
    
    public boolean notOccupied(int dir, int x, int y){
	switch(dir){
	case 0: grid[x-1][y] == ' ' || grid[x-1][y] == 'X'; break;
	case 1: grid[x+1][y] == ' ' || grid[x+1][y] == 'X'; break;
	case 2: grid[x][y-1] == ' ' || grid[x][y-1] == 'X'; break;
	case 3: grid[x][y+1] == ' ' || grid[x][y+1] == 'X'; break;
	default: return false;
	}
	
	return false;
    }
}
