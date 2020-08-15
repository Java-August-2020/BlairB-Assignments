import java.util.ArrayList;

public class ListExceptions {
    public ArrayList<Object> createList() {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                myList.set(i, castedValue);
            } catch (ClassCastException e) {
                System.out.println(String.format("Error at myList[%d] with value %s", i, myList.get(i)));
                System.out.println("Error: " + e);
            }
        }

        return myList;
    }
}