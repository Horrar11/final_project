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
	xcor = 1;
	ycor = 1;
	//inv = new Inventory();
    }
    
    public void attack(){}

    public void move(){
    }
}