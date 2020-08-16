
public class Bat extends Mammal {
	public Bat() {
		this.energy = 300;
	}
	
	public void fly() {
		System.out.println("Whoosh");
		this.energy -= 50;
	}
	
	public void eatHumans() {
		this.energy += 25;
	}
	
	public void attackTown() {
		System.out.println("Crackle Crackle");
		this.energy -= 100;
	}
}
