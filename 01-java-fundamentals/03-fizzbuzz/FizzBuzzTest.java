public class FizzBuzzTest {
    public static void main(String[] args) {
        FizzBuzz test = new FizzBuzz();
        for(int i = 1; i <= 31; i++){
            String result = test.fizzBuzz(i);
            System.out.println(result);
        }
    }
}