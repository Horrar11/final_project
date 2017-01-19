public abstract class Unit{
    //necessary stats
    public int hp, atk,;
    //stores where the unit should be 0 -> x 1-> y
    public int[] cords;

    //how a unit attacks depends on its type
    abstract void attack();

    //if this unit is alive, then it will be displayed/interacted with
    public boolean getAlive(){
	return hp >= 0;
    }
    
    //all units should be able to move
    public void move(int dir){
	switch(dir){
	case 0: xcor --; break;
	case 1: xcor ++; break;
	case 2: ycor --; break;
	case 3: ycor ++; break;
	default: break;
	}
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
