public class Map{
    public char[][] grid;
	private int playerPosX = 1;
	private int playerPosY = 1;
	
    public Map(int row, int col){
	grid = new char[row][col];
	for(int i = 0;i < row;i++){
	    for(int ind = 0;ind < col;ind++){
		grid[i][ind] = ' ';
		if(i == 0 || ind == 0 || i == row -1 || ind == col -1){
		    grid[i][ind] = 'X';
		}
	    }
	}
	grid[playerPosX][playerPosY] = 'P';
    }
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
	public String display(){
		String toRet = "";
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				toRet += grid[i][j];
			}
			toRet += "\n";
		}
		return toRet;
	}
	
	public void interpret(String arg) throws ArrayIndexOutOfBoundsException{
		String given = arg;
		switch(given) {
			case "w":
			        try{
					playerPosX --;
					grid[playerPosX][playerPosY] = 'P';
				}
				catch (ArrayIndexOutOfBoundsException e){
					playerPosX ++;
					System.out.println("\t\tMovement out of bounds!");
				}
			case "a":
			        try{
					playerPosY --;
					grid[playerPosX][playerPosY] = 'P';
				}
				catch (ArrayIndexOutOfBoundsException e){
					playerPosY ++;
					System.out.println("\t\tMovement out of bounds!");
				}
			case "s":
				try{
					playerPosX ++;
					grid[playerPosX][playerPosY] = 'P';
				}
				catch (ArrayIndexOutOfBoundsException e){
					playerPosX --;
					System.out.println("\t\tMovement out of bounds!");
				}
				finally{
					
				}
			case "d":
			        try{
					playerPosY ++;
					grid[playerPosX][playerPosY] = 'P';
				}
				catch (ArrayIndexOutOfBoundsException e){
					playerPosY --;
					System.out.println("\t\tMovement out of bounds!");
				}
			default:
				System.out.println("\tMap \n");
		}
	}
}
