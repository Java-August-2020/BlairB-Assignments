import java.util.Arrays;

public class BasicJavaTest {
    public static void main(String[] args) {
        BasicJava test = new BasicJava();
        test.print1to255();
        test.print1to255Odd();
        test.print1to255Sum();
        int[] arr = {3, -2, 6, 0, 10};
        test.iteratingArray(arr);
        test.findMax(arr);
        test.getAverage(arr);
        test.arrayWithOdd();
        System.out.println(test.greaterThan(arr, 5));
        test.squareValues(arr);
        test.eliminateNegative(arr);
        System.out.println(Arrays.toString(test.minMaxAverage(arr)));
        test.shiftingArray(arr);
    }
}