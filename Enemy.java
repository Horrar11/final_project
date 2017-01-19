import java.util.Random;
//should be abstract
public class Enemy extends Unit{

    //basic 
    public Enemy(int x, int y){
	Random rand = new Random();
	cords[0] = x;
	cords[1] = y;
	hp = 100
	atk = 25;
    }
    
    public void attack(){}

    public void auto(){}
}
