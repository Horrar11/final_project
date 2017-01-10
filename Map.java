import java.util.Random;

public class Map{
    public char[][] grid;
    private int playerX;
    private int playerY;
    private char saveChar = ' ';//don't know why anton has this

    //sets up the border of the map and randomly places the player
    public Map(int row, int col){
	grid = new char[row][col];
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
	setPlayerPos();
    }

    //puts a 'P' on the map wherever the player is
    public void setPlayerPos(){grid[playerX][playerY] = 'P';}
	
    public void setPXY(int x, int y){playerX = x; playerY = y;}

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

    //generic error for invalid movements to make code neater
    public void mOOB(String input) throws ArrayIndexOutOfBoundsException{
	throw new ArrayIndexOutOfBoundsException(input);
    }

    //for replacing the old 'P's with ' ' 
    public void makeLand(int x, int y){grid[x][y] = ' ';}
    //No idea what anton wanted this to be
    public void restoreLand(int x, int y){saveChar = grid[x][y];}


    //determines how the the commands it gets from Game affects the grid
    //returns false if movement is invalid in case that's usefull
    public boolean interpret(String arg){
	try{
	switch(arg){
	case "w":
	    if(playerX - 1 <= 0){mOOB("invalid movement up");}
	    makeLand(playerX, playerY);
	    playerX --;
	    setPlayerPos();
	    break;
	case "a":
	    if(playerY - 1 <= 0){mOOB("invalid movement left");}
	    makeLand(playerX, playerY);
	    playerY --;
	    setPlayerPos();
	    break;
	case "s":
	    if(playerX + 1 >= grid.length - 1){mOOB("invalid movement down");}
	    makeLand(playerX, playerY);
	    playerX ++;
	    setPlayerPos();
	    break;
        case "d":
	    if(playerY + 1 >= grid[0].length - 1){mOOB("invalid movement right");}
	    makeLand(playerX, playerY);
	    playerY ++;
	    setPlayerPos();
	    break;
	default: System.out.println("404 command not found.\nTry typing help for\na list of available commands.");
	    
	}}catch(ArrayIndexOutOfBoundsException e){
	    System.out.println(e.getMessage());
	    return false;
	}
	return true;
    }
}
