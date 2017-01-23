import java.util.Random;
public class Map{
    public char[][] grid;
    //these here declared stuff is for the map
    //to get input from the game to properly
    //render enemies and the player
    public char saveChar = ' ';
    public int lengthX, lengthY;
    public int stairX, stairY;
    public Random randGen;


    //sets up the border of the map and randomly places the player
    public Map(int row, int col, long seed){
	this.randGen = new Random(seed);
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

	
    //puts a 'P' on the map wherever the player is
    public void setPlayerPos(Character player){grid[player.cords[0]][player.cords[1]] = player.toString().charAt(0);}
	
    //puts a 'E' on the map wherever an enemy is
    public void setEnemyPos(int x, int y, char a){grid[x][y] = a;}

    //prints out the map
    public String toString(){
	String toRet = "";
	for(int row = 0; row < grid.length; row++){
	    for(int col = 0; col < grid[row].length; col++){
		toRet += grid[row][col];
	    }
	    toRet += "\n";
	}
	return toRet;
    }

    
    /*this should be irrelevant for my moving system
    public void makeLand(){grid[player.xcor][player.ycor] = saveChar;}
	
    public boolean restoreLand(){
	if(!(grid[player.xcor][player.ycor] == ' ' || grid[player.xcor][player.ycor] == 'X'))
	    {return true;}
	else{
	    saveChar = grid[player.xcor][player.ycor];
	    return false;
	}
	}
    */



    
    public boolean interpret(String arg){
	String given = arg;
	switch(given){
	default: System.out.println("404 command not found.\nTry typing help for\na list of available commands.");
	}
	return true;}




    
    //generic error for invalid movements to make code neater
    public void mOOB(String input) throws ArrayIndexOutOfBoundsException{
	throw new ArrayIndexOutOfBoundsException(input);
    }



    
    //checks to see if the movement is valid
    public boolean notOccupied(int dir, int x, int y) throws ArrayIndexOutOfBoundsException{
	switch(dir){
	case 0: if(grid[x - 1][y] == ' '){
		return true;
	    }else{
		mOOB("Invalid Movement Up");
	    }
	case 1: if(grid[x][y + 1] == ' '){
		return true;
	    }else{
		mOOB("Invalid Movement Right");
	    }
	case 2: if(grid[x + 1][y] == ' '){
		return true;
	    }else{
		mOOB("Invalid Movement Down");
	    }
	case 3: if(grid[x][y - 1] == ' '){
		return true;
	    }else{
		mOOB("Invalid Movement Down");
	    }
	default: return false;
	}
    }

    //checks the one spot without direction
    public boolean notOccupied2(int x, int y) {
	if(grid[x][y] == ' '){
	    return true;
	}else{
	    return false;
	}
    }
}
