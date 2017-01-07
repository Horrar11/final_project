public abstract class Unit{
    private int hp;
    private int atk;
    private String weapon;

    abstract void attack();

    abstract boolean move();

    public boolean getAlive(){
	return hp > 0;
    }

    public boolean takeDmg(int a){
	if(a < 0){
	    return false;
	}
	hp -= a;
	return true;
    }
}
