public class Map{
    public char[][] grid;
	private int playerPosX = 0;
	private int playerPosY = 0;
	
    public Map(int row, int col){
		grid = new char[row][col];
	for(int i = 0;i < row;i++){
	    for(int ind = 0;ind < col;ind++){
		grid[i][ind] = 'X';
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
	
	/**public void interpret(String arg) throws ArrayIndexOutOfBoundsException{
		String given = arg;
		switch(given) {
			case "w":
				if(playerPosY -- < 0){
					System.out.println("Invalid movement");
					break;
				}
				else{
					playerPosY --;
					grid[playerPosX][playerPosY] = 'P';
				}
			case "a":
				if(playerPosX -- < 0){
					System.out.println("Invalid movement");
					break;
				}
				else{
					playerPosX --;
					grid[playerPosX][playerPosY] = 'P';
				}
			case "s":
				try{
					playerPosY ++;
					grid[playerPosX][playerPosY] = 'P';
				}
				catch (ArrayIndexOutOfBoundsException e){
					playerPosY --;
					System.out.println("\t\tMovement out of bounds!");
				}
				finally{
					
				}
			case "d":
				if(playerPosX ++ > grid[playerPosY].length){
					System.out.println("Invalid movement");
					break;
				}
				else{
					playerPosX ++;
					grid[playerPosX][playerPosY] = 'P';
				}
			default:
				System.out.println("\tMap \n");
		}
	}**/
}