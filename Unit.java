public abstract class Unit{
    public double hp;
    public int atk, def, xcor, ycor;
    public char displayChar;

    abstract void attack();

    public boolean getAlive(){
	return hp >= 0;
    }

    public boolean takeDmg(int a){
	if(a < 0){
	    return false;
	}
	hp -= a;
	return true;
    }
}
