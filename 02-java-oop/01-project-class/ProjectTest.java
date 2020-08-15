public class ProjectTest {
    public static void main(String[] args) {
        Project test = new Project();
        System.out.println(test.getName());
        test.setName("Tree Business");
        System.out.println(test.getName());
        System.out.println(test.getDescription());
        test.setDescription("Paper made from Bamboo");
        System.out.println(test.getDescription());
        System.out.println(test.elevatorPitch());
        
        Project test2 = new Project("Ecommerce");
        System.out.println(test2.getName());
        System.out.println(test2.getDescription());
        System.out.println(test2.elevatorPitch());
        
        Project test3 = new Project("Froyo stand", "Froyo with a twist");
        System.out.println(test3.getName());
        System.out.println(test3.getDescription());
        System.out.println(test3.elevatorPitch());
    }
}