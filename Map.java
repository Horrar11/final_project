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
	
	public void getXY(int x, int y){playerX = x; playerY = y;}
	
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
	
    public boolean interpret(String arg) throws ArrayIndexOutOfBoundsException, InvalidAreaException{
		String given = arg;
		switch(given){
		case "w":
			try{
				makeLand();
				playerX --;
				if(restoreLand()){
					throw new InvalidAreaException();
				}
				setPlayerPos();
			}
			catch (ArrayIndexOutOfBoundsException|InvalidAreaException e){
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
			}
			catch (ArrayIndexOutOfBoundsException|InvalidAreaException e){
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
			}
			catch (ArrayIndexOutOfBoundsException|InvalidAreaException e){
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
			}
			catch (ArrayIndexOutOfBoundsException|InvalidAreaException e){
				playerY --;
				mOOB();
				setPlayerPos();
				return false;
			} break;
	default: System.out.println("\tMap \n");
	}
    return true;}
	
}