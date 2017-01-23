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
	cords = new int[2];
	//weapon = inv.getWeapon();
	//inv = new Inventory();
    }

    //implemented later
    public void attack(){}


    public String toString(){
	return "Player";
    }
}
