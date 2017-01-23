public abstract class Unit{
    //necessary stats
    public int hp, atk;
    //stores where the unit should be 0 -> x 1-> y
    public int[] cords;

    //how a unit attacks depends on its type
    abstract void attack();

    //if this unit is alive, then it will be displayed/interacted with
    public boolean getAlive(){
	return hp >= 0;
    }
    
    /*all units should be able to move
     *0 -> 3 corresponds to up -> left clockwise 
     */
    public void move(int dir){
	switch(dir){
	case 0: cords[0] --; break;
	case 1: cords[1]++; break;
	case 2: cords[0] ++; break;
	case 3: cords[1] --; break;
	default: break;
	}
    }

    //convience
    public void setXY(int x, int y){
	System.out.println(x + "   " + y);
	cords[0] = x;
	cords[1] = y;
    }
    //basic function every unit should have
    public boolean takeDmg(int a){
	if(a < 0){
	    return false;
	}
	hp -= a;
	return true;
    }
}
