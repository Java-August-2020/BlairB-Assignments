import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
    public ArrayList<Integer> sumAndGreaterThan() {
        int[] arr = {3,5,1,2,7,9,8,13,25,32};
        int total = 0;
        ArrayList<Integer> greaterThan = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            if (arr[i] > 10) {
                greaterThan.add(arr[i]);
            }
        }

        System.out.println(total);
        System.out.println(greaterThan);
        return greaterThan;
    }

    public ArrayList<String> shuffleNames() {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Nancy");
        arr.add("Jinichi");
        arr.add("Fujibayashi");
        arr.add("Momochi");
        arr.add("Ishikawa");
        Collections.shuffle(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
            if (arr.get(i).length() <= 5) {
                arr.remove(i);
            }
        }
        return arr;
    }

    public void shuffleAlphabet() {
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            alphabet.add(ch);
        }
        Collections.shuffle(alphabet);
        System.out.println(alphabet.get(alphabet.size()-1));
        System.out.println(alphabet.get(0));
        String vowels = "aeiou";
        if (vowels.indexOf(alphabet.get(0)) != -1) {
            System.out.println("First letter is a vowel");
        }
    }

    public int[] tenRandom() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(45) + 55;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public int[] sortedTenRandom() {
        int[] arr = tenRandom();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[0]);
        System.out.println(arr[arr.length-1]);
        return arr;
    }

    public String randomString() {
        String str = "";
        Random r = new Random();
        int randomNum;
        ArrayList<Character> alphabet = new ArrayList<Character>();

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);
        }

        for (int i = 0; i < 5; i++) {
            randomNum = r.nextInt(26);
            str += alphabet.get(randomNum);
        }

        System.out.println(str);
        return str;
    }

    public void randomStringArray() {
        String[] arr = new String[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomString();
        }

        System.out.println(Arrays.toString(arr));
    }
}