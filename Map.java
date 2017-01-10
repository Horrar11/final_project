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
	
    public void mOOB(String input) throws ArrayIndexOutOfBoundsException{
	throw new ArrayIndexOutOfBoundsException(input);
    }

    //for replacing the old p
    public void makeLand(int x, int y){grid[x][y] = saveChar;}
    //for replacing the old p	
    public void restoreLand(int x, int y){saveChar = grid[x][y];}
	
    public boolean interpret(String arg){
	try{
	switch(arg){
	case "w":
	    if(playerX -- <= 0){mOOB("invalid movement up");}
	    
	    break;
	case "a":
	    if(playerY -- <= 0){mOOB("invalid movement left");}
	    break;
	case "s":
	    if(playerX ++ >= grid.length - 1){mOOB("invalid movement down");}
	    break;
        case "d":
	    if(playerY ++ >= grid[0].length - 1){mOOB("invalid movement right");}
	    break;
	default: System.out.println("404 command not found.\nTry typing help for\na list of available commands.");
	    
	}}catch(ArrayIndexOutOfBoundsException e){
	    System.out.println(e.getMessage());
	    return false;
	}
	return true;
    }
}
