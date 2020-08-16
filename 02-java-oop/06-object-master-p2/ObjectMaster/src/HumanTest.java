
public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human human = new Human();
		Human human2 = new Human();
		human.attack(human2);
		human2.getHealth();
		
		Wizard wizard = new Wizard();
		wizard.heal(human);
		human.getHealth();
		wizard.fireball(human2);
		human2.getHealth();
		
		Ninja ninja = new Ninja();
		ninja.steal(human2);
		human2.getHealth();
		ninja.getHealth();
		ninja.runAway();
		ninja.getHealth();
		
		Samurai sam = new Samurai();
		Samurai sam2 = new Samurai();
		Samurai sam3 = new Samurai();
		sam.deathBlow(human);
		human.getHealth();
		sam.getHealth();
		sam.meditate();
		sam.getHealth();
		sam2.howMany();
		
	}

}
