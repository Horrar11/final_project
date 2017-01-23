import java.util.Random;
public class Character extends Unit{
    public double hp,mp, maxhp, maxmp;
    public int atk, def, dex, vit, wis, xcor, ycor;
    public String weapon;
    public int seed;
    //public Inventory inv;

    public Character(int seed){
	hp = 100.00;
	mp = 100.00;
	maxhp = 100.00;
	maxmp = 100.00;
	atk = 10;
	def = 0;
	dex = 10;
	vit = 10;
	wis = 10;
	displayChar = 'P';
	this.seed = seed;
	//weapon = inv.getWeapon();
	//inv = new Inventory();
    }
    
	public boolean getAlive(){return hp >= 0.00;}
	
    public void setSpawn(int row, int col){
	Random rand = new Random(seed);
		xcor = rand.nextInt(Math.abs(row - 2) + 1);
		ycor = rand.nextInt(Math.abs(col - 2) + 1);
	}
    public void attack(){}

    public void setXY(int x, int y){
	xcor = x;
	ycor = y;
    }
    public boolean inRangeEnemy(){return false;}
    public boolean inRangeShop(){return false;}
    }