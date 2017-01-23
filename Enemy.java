import java.util.Random;
//should be abstract
public class Enemy extends Unit{

    //basic initialization
    public Enemy(int x, int y){
	Random rand = new Random();
	cords = new int[2];
	setXY(x,y);
	hp = 100;
	atk = 25;
    }

    public void attack(){}


    public String toString(){
	return "Enemy";
    }	
}
