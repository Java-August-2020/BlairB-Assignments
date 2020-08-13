public class StringManipulatorTesting {
    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();
        System.out.println(manipulator.trimAndConcat("  hello", "  world   "));

        char letter = 'a';
        System.out.println(manipulator.getIndexOrNull("good day sir", letter));
        System.out.println(manipulator.getIndexOrNull("off week sir", letter));

        System.out.println(manipulator.getIndexOrNull("off week sir", "week"));
        System.out.println(manipulator.getIndexOrNull("off week sir", "today"));
        
        System.out.println(manipulator.concatSubstring("hello", 1, 2, "world"));

    }
}