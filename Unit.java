public abstract class Unit{
    public double hp;
    public int atk;
    public int def;
    public int xcor;
    public int ycor;

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
