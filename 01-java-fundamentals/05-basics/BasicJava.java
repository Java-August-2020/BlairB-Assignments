import java.util.Arrays;

public class BasicJava {
    public void print1to255() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }
    public void print1to255Odd() {
        for (int i = 1; i <= 255; i += 2) {
            System.out.println(i);
        }
    }

    public void print1to255Sum() {
        int total = 0;
        for (int i = 1; i <= 255; i ++) {
            total += i;
            System.out.println(String.format("Current num: %d Sum: %d", i, total));
        }
    }

    public void iteratingArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void findMax(int[] arr) {
        Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);
    }

    public void getAverage(int[] arr) {
        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        System.out.println(total/arr.length);
    }

    public void arrayWithOdd() {
        int[] y = new int[128];
        int currentIndex = 0;
        for (int i = 1; i <= 255; i += 2) {
            y[currentIndex] = i;
            currentIndex++;
        }
        System.out.println(Arrays.toString(y));
    }

    public int greaterThan(int[] arr, int y) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > y) {
                count++;
            }
        }
        return count;
    }

    public void squareValues(int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] *= x[i];
        }
        System.out.println(Arrays.toString(x));
    }

    public void eliminateNegative(int[] x) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] < 0) {
                x[i] = 0;
            }
        }
        System.out.println(Arrays.toString(x));
    }

    public double[] minMaxAverage(int[] x) {
        Arrays.sort(x);
        int min = x[0];
        int max = x[x.length-1];
        double average = 0;
        for (int i = 0; i < x.length; i++) {
            average += x[i];
        }
        double[] ans = {max, min, average/x.length};
        return ans;
    }

    public void shiftingArray(int[] x) {
        for (int i = 0; i < x.length; i++) {
            if (i+1 == x.length) {
                x[i] = 0;
            } else {
                x[i] = x[i+1];
            }
        }
        System.out.println(Arrays.toString(x));
    }
}