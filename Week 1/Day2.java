import java.util.ArrayList;
import java.util.HashMap;

public class Day2 {
    public static void main(String[] args) {
        // Arrays
        String[] people = new String[]{"Matt", "Lily", "Blair", "Mike"};
        String[] notPresent = {"other people", "not here", "etc."} //Use this syntax
        String[] newStringArray = new String[5];
        newStringArray[0] = "My"
        newStringArray[1] = "My"
        newStringArray[2] = "My"
        newStringArray[3] = "My"
        newStringArray[4] = "My"

        Object[] myObjectArray = {true, 55, "hii"}; //To Contain multiple data types.

        System.out.println(Arrays.toString(people));
        System.out.println(people); //Will print the reference pointer.

        int[] numbers = new int[10];
        for (int i=0; i<numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // ArrayList
        ArrayList<Integer> numsArrayList = new ArrayList<Integer>();
        numsArrayList.add(3);
        numsArrayList.add(6);
        numsArrayList.add(23);
        for (int i=0; i<numsArrayList.size(); i++) {

        }
        System.out.println(numsArrayList.get(2)); //Can't use [] indexing. Need to use .get()

        for (Integer num : numsArrayList) {
            System.out.println(num)
        }

        // HashMap
        HashMap<String, String> ourHobbies = new HashMap<String, String>();
        ourHobbies.put("Blair", "Music Making");
        ourHobbies.put("Lily", "Eating");
        ourHobbies.put("Mike", "Snowboarding");
        ourHobbies.put("Matt", "Photography");

        System.out.println(ourHobbies);
        System.out.println(ourHobbies.get("Blair"));

        for(String name : ourHobbies.keySet()){
        // for(String name : ourHobbies.values()){
            System.out.println(name);
        }

        for (HashMap.Entry<String, String> map : ourHobbies.entrySet()) {
            System.out.println("Key: " + map.getKey() + map.getValue())
        }

        // Errors
        for (int i = 0; i <= numbers.length; i++) {
            try {
                System.out.println(numbers[i]);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println(biggestNumber(numbers))
    }

    //Static lets you run a method from a class without instantiating an object.
    public static int getMaxValue(int[] nums) {
        int biggestNumber = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > biggestNumber) {
                biggestNumber = nums[i];
            }
        }
        return biggestNumber;
    }
}