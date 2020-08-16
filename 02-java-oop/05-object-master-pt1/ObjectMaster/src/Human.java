
public class Human {
	protected int strength = 3;
	protected int intelligence = 3;
	protected int stealth = 3;
	protected int health = 100;
	
	public void attack(Human human) {
		human.health -= this.stealth;
	}
	
	public void getHealth() {
		System.out.println(this.health);
	}
}
