import java.util.Random;
public class Map{
    public char[][] grid;
    private int playerX;
    private int playerY;
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
	Random rand = new Random();
	playerX = rand.nextInt(row - 2) + 1;
	playerY = rand.nextInt(col - 2) + 1; 
	saveChar = grid[playerX][playerY];
	setPlayerPos();
    }

    //puts a 'P' on the map wherever the player is
    public void setPlayerPos(){grid[playerX][playerY] = 'P';}
	
	//puts a 'E' on the map wherever an enemy is
    public void setEnemyPos(int x, int y){grid[x][y] = 'E';}
	
	//update the coordinates of the player to place on the map
    public void getXY(int x, int y){playerX = x; playerY = y;}

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
		if(grid[playerX][playerY] == '#')
			{return true;}
		else{
			saveChar = grid[playerX][playerY];
			return false;
		}
	}
	
    public boolean interpret(String arg) throws InvalidAreaException, ArrayIndexOutOfBoundsException{
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
	
}