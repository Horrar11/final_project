import java.util.Random;
public class Map{
    public char[][] grid;
    public char saveChar = ' ';
    public int lengthX, lengthY;
    public int stairX, stairY;
	public Money[] monies = new Money[300];
    public Random randGen;


    //sets up the border of the map and randomly places the player
    public Map(int row, int col, int seed){
	randGen = new Random(seed);
	grid = new char[row][col];
	lengthX = row;
	lengthY = col;
	for(int i = 0;i < row;i++){
	    for(int ind = 0;ind < col;ind++){
			//for(int mon = 0; mon < monies.length; mon++){
		if(randGen.nextInt(100) < 10){grid[i][ind] = '$';}//{monies[mon] = new Money(i, ind);grid[i][ind] = '$';}
		else{grid[i][ind] = ' ';}
		if(i == 0 || ind == 0 || i == row -1 || ind == col -1){
		grid[i][ind] = '#';}
		
	    }
	}
		stairX = Math.abs(randGen.nextInt(row - 2)) + 1;
		stairY = Math.abs(randGen.nextInt(col - 2)) + 1;
		grid[stairX][stairY] = 'S';
    }
    public void clear(){
	for(int i = 0;i < lengthX;i++){
	    for(int ind = 0;ind < lengthY;ind++){
			//for(int mon = 0; mon < monies.length; mon++){
			grid[i][ind] = ' ';
			if(randGen.nextInt(1000) == 0){grid[i][ind] = 'T';}
				//grid[monies[mon].x][monies[mon].y] = '$';
		if(i == 0 || ind == 0 || i == lengthX - 1 || ind == lengthY - 1){
		    grid[i][ind] = '#';
		}
	    }
	    grid[stairX][stairY] = 'S';
	
    }
	}
    
    public void setPos(int x, int y, char symbol){grid[x][y] = symbol;}
	
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
		
    public void mOOB(){
	System.out.println("\t\t\tYou cannot go there!");
    }
	
	
	
    public void makeLand(int xcor, int ycor){grid[xcor][ycor] = saveChar;}
    
    public void saveLand(int xcor, int ycor){
	saveChar = grid[xcor][ycor];
    }
	
    public boolean notOccupied(int dir, int x, int y){
	char[] valid = new char[5];
	valid[0] = ' '; valid[1] = 'X'; valid[2] = 'S'; valid[3] = '$'; valid[4] = 'T';
	switch(dir){
	case 0: for(int i = 0; i < valid.length; i++){if(grid[x-1][y] == valid[i]){return true;}} break;
	case 1: for(int i = 0; i < valid.length; i++){if(grid[x+1][y] == valid[i]){return true;}} break;
	case 2: for(int i = 0; i < valid.length; i++){if(grid[x][y-1] == valid[i]){return true;}} break;
	case 3: for(int i = 0; i < valid.length; i++){if(grid[x][y+1] == valid[i]){return true;}} break;
	default: return false;
	}
	return false;
    }
	
	
    public boolean interpret(String arg, int pxcor, int pycor, char plop){
	String given = arg;
	switch(given){
	case "w":
	    makeLand(pxcor, pycor);
	    if(notOccupied(0, pxcor, pycor)){
			saveLand(pxcor - 1, pycor);
			setPos(pxcor - 1, pycor, plop);
			return true;
	    }
		setPos(pxcor, pycor, plop);
		return false;

	case "a":
		makeLand(pxcor, pycor);
	    if(notOccupied(2, pxcor, pycor)){
			saveLand(pxcor, pycor - 1);
			setPos(pxcor, pycor - 1, plop);
			return true;
	    }
		setPos(pxcor, pycor, plop);
		return false;

	case "s":
	    makeLand(pxcor, pycor);
	    if(notOccupied(1, pxcor, pycor)){
			saveLand(pxcor + 1, pycor);
			setPos(pxcor + 1, pycor, plop);
			return true;
	    }
		setPos(pxcor, pycor, plop);
		return false;

	case "d":
	    makeLand(pxcor, pycor);
	    if(notOccupied(3, pxcor, pycor)){
			saveLand(pxcor, pycor + 1);
			setPos(pxcor, pycor + 1, plop);
			return true;
	    }
		setPos(pxcor, pycor, plop);
		return false;
	default: System.out.println("404 command not found.\nTry typing help for\na list of available commands.");
	}
	return true;
	}	
}