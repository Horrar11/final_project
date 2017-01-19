import java.util.Random;
public class Enemy extends Unit{
    public Enemy(int x, int y, int seed){
	Random rand = new Random();
	xcor = x;
	ycor = y;
	hp = 100.00;
	atk = 25;
	def = rand.nextInt(11);
	displayChar = 'E';
	}
    public void attack(){}
	
    public void move(int dir){
		switch(dir){
			case 0: xcor --; break;
			case 1: xcor ++; break;
			case 2: ycor --; break;
			case 3: ycor ++; break;
			default: break;
		}
	}

    public void auto(){}
}
