import java.util.Random;
public class Character extends Unit{
    //weapon decides how the player attacks(ranged vs melee)
    public String weapon;
    //public Inventory inv;

    
    //basic character trope
    public Character(){
	hp = 100;
	atk = 10;
	weapon = "sword";
	//weapon = inv.getWeapon();
	//inv = new Inventory();
    }

    //implemented later
    public void attack(){}


    /*
     *don't think this is necessary, but I'm just commenting in case I do need it later
    public void setXY(int x, int y){
	xcor = x;
	ycor = y;
    }
    public boolean inRangeEnemy(){return false;}
    public boolean inRangeShop(){return false;}
    */
}
