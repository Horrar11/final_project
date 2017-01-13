import java.util.Random;
public class Character extends Unit{
    public double hp,mp;
    public int atk, def, dex, vit, wis, xcor, ycor;
    public String weapon;
    //public Inventory inv;

    public Character(){
	hp = 100.00;
	mp = 100.00;
	atk = 10;
	def = 0;
	dex = 10;
	vit = 10;
	wis = 10;
	//weapon = inv.getWeapon();
	//inv = new Inventory();
    }
    public void setSpawn(int row, int col){
	Random rand = new Random();
		xcor = rand.nextInt(Math.abs(row - 2) + 1);
		ycor = rand.nextInt(Math.abs(col - 2) + 1);
	}
    public void attack(){}
    public boolean inRangeEnemy(){return false;}
    public boolean inRangeShop(){return false;}
}
