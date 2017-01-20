import java.util.Random;
//should be abstract
public class Enemy extends Unit{

    //basic initialization
    public Enemy(int x, int y){
	Random rand = new Random();
	setXY(x,y);
	hp = 100;
	atk = 25;
	cords = new int[2];
    }
    
    public void attack(){}

    public void auto(){}

    public String toString(){
	return "Enemy";
    }	
}
