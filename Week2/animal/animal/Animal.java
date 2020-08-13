public class Animal {
    private int numLegs;
    private String color;
    private String species;
    private int health;

    public Animal(int numLegs, String color, String species, int health) {
        this.numLegs = numLegs;
        this.color = color;
        this.species = species;
        this.health = health;
    }

    public Animal(int numLegs, String color, String species) {
        this.numLegs = numLegs;
        this.color = color;
        this.species = species;
        this.health = 100;
    }

    public int getNumLegs(){
        return this.numLegs;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public String getColor(String color) {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpecies(String species) {
        return this.species;
    }

    public void setspecies(String species) {
        this.species = species;
    }

    public int getHealth(int health) {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void battle(Animal target, String powerMove) {
        int damage;
        if (powerMove.equals("Fireball")) {
            damage = 3;
        } else if (powerMove.equals("Roar")) {
            damage = 5;
        } else {
            System.out.println("No move");
            return;
        }

        target.health -= damage;

        // System.out.println("%s attacks %s for %d damage points", this, target, powerMove);
    }

    public void battle(Animal target) {
        this.battle(target, "Roar");
    }
}