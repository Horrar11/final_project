public class Map{
    public char[][] grid;
    private int playerX = 1;
    private int playerY = 1;
    private char saveChar = ' ';

    
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
	setPlayerPos();
    }
    
    public void setPlayerPos(){grid[playerX][playerY] = 'P';}
	
    public void setPXY(int x, int y){playerX = x; playerY = y;}


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
	
    public void mOOB(){
	System.out.println("\t\t\tMovement was out of bounds!");
    }
	
    public void makeLand(){grid[playerX][playerY] = saveChar;}
	
    public void restoreLand(){saveChar = grid[playerX][playerY];}
	
    public boolean interpret(String arg) throws ArrayIndexOutOfBoundsException{
	String given = arg;
	    
	switch(given){
	case "w":
	    if(playerX - 1 <= 0){mOOB(); return false;}
	    try{
		makeLand();
		playerX --;
		restoreLand();
		setPlayerPos();
	    }
	    catch (ArrayIndexOutOfBoundsException e){
		mOOB();
		playerX++;
		setPlayerPos();
		return false;
	    } break;
	case "a":
	    if(playerY - 1 <= 0){mOOB(); return false;}
	    try{
		makeLand();
		playerY--;
		restoreLand();
		setPlayerPos();
	    }
	    catch (ArrayIndexOutOfBoundsException e){
		mOOB();
		playerY++;
		setPlayerPos();
		return false;
	    } break;
	case "s":
	    if(playerX ++ >= grid[0].length - 1){mOOB(); return false;}
	    try{
		makeLand();
		playerX ++;
		restoreLand();
		setPlayerPos();
	    }
	    catch (ArrayIndexOutOfBoundsException e){
		mOOB();
		playerX --;
		setPlayerPos();
		return false;
	    } break;
	case "d":
	    if(playerY ++ >= grid.length - 1){mOOB(); return false;}
	    try{
		makeLand();
		playerY++;
		restoreLand();
		setPlayerPos();
	    }
	    catch (ArrayIndexOutOfBoundsException e){
		mOOB();
		playerY--;
		setPlayerPos();
		return false;
	    } break;
	default: System.out.println("\tMap \n");
	}
	return true;}
}
