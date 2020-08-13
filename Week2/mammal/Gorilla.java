public class Gorilla extends Mammal {
    public Gorilla() {
        super("Gorilla", 500);
    }

    public void eatBanana() {
        this.setHealth(health + 10);
        System.out.println("The Gorilla ate a banana");
    }

    @Override
    public void takeDamage(int damageAmount) {
        this.health -= damageAmount/2;
    }
}