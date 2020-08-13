public class AnimalController {
    public static void main(String[] args) {
        Animal dog = newAnimal(4, "black", "dog", 100);
        Animal cat = newAnimal(4, "white", "cat", 100);
        dog.battle(cat, "Fireball");
        System.out.println(cat.getHealth);
        dog.battle(cat);

    }
}