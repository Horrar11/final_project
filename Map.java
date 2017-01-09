public class Map{
	public char[][] grid;
	private int playerX = 1;
	private int playerY = 1;
	
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
	
	public void mOOB(){
	System.out.println("\t\t\tMovement was out of bounds!");
    }
    public void interpret(String arg) throws ArrayIndexOutOfBoundsException{
		String given = arg;
		switch(given){
		case "w":
			try{
				playerX --;
				setPlayerPos();
			}
			catch (ArrayIndexOutOfBoundsException e){
				playerX ++;
				mOOB();
			} break;
		case "a":
			try{
				playerY --;
				setPlayerPos();
			}
			catch (ArrayIndexOutOfBoundsException e){
				playerY ++;
				mOOB();
			} break;
	case "s":
			try{
				playerX ++;
				setPlayerPos();
			}
			catch (ArrayIndexOutOfBoundsException e){
				playerX --;
				mOOB();
			} break;
	case "d":
			try{
				playerY ++;
				setPlayerPos();
			}
			catch (ArrayIndexOutOfBoundsException e){
				playerY --;
				mOOB();
			} break;
	default: System.out.println("\tMap \n");
	}
    }
}