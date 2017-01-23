import java.util.Random;
public class Enemy extends Unit{
    public Enemy(int x, int y, int seed){
	Random randGen = new Random(seed);
	xcor = x;
	ycor = y;
	hp = 100.00;
	atk = 25;
	def = randGen.nextInt(11);
	displayChar = 'E';
	}
    public void attack(int looking){
		switch(looking){
			case 0: //return atk; break;
			case 1: //return atk; break;
			case 2: //return atk; break;
			case 3: //return atk; break;
			default: break;
		}
	}
	
    public void move(int dir){
		switch(dir){
			case 0: xcor --; break;
			case 1: xcor ++; break;
			case 2: ycor --; break;
			case 3: ycor ++; break;
			default: break;
		}
	}
}