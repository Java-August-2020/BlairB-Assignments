public class Mammal implements Attackable {
    protected String species;
    protected int health;

    public Mammal(String species, int health) {
        this.species = species;
        this.health = health;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setspecies(String species) {
        this.species = species;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attack(Mammal target) {
        target.health -= 5;
    }

    public void takeDamage(int damageAmount) {
        this.health -= damageAmount;
    }
}