public class FirstProgram{
    // Entry Point Method
    public static void main(String[] args){
        System.out.println("Hello World");
        byte myByte = 100; // Stores whole number from -128 to 127
        short myShort = 1000; // Stores whole numbers from -32,368 to 32,707
        int myInt = 1000000; // stores whole numbers from -2,147,483,648 to
        long myLong = 10000000; // stores whole numbers from - 9,223,372,036,854,775,808
        float myFloat = 3.14f; // End float with 'f' Stores fractional numbers. up to 7 decimal places
        double myDouble = 3.14565656d; // End with 'd', up to 15 decimal points.
        boolean myBool = true; // Stores true or false;
        char myChar = 'D'; // char need single quote ''.

        // Wrapper Classes
        Integer myInteger = 10000;
        Character myCharacter = 'd';

        System.out.println(Character.toUpperCase(myCharacter));

        // Strings
        String myString = "Java Aug 20";
        System.out.println(myString.length());

        // Operators and Conditionals
        int myInt2 = 3;
        int myInt3 = 4;

        System.out.println(myInt2 == myInt3);

        String myString2 = "Java Aug 20";
        System.out.println(myString.equals(myString2));
        // System.out.println(myString == myString2); Strings are compared by where they are stored in memory. Need to use the above equals method to compare the value of strings.

        int isOdd = 5;
        if (isOdd % 2 != 0){
            System.out.println("Number is Odd");
        } else {
            System.out.println("Number is even");
        }

        // Loops

        // while

        int i = 0;
        // while(i <= 6){
        //     System.out.println(i);
        //     i++;
        // }

        // for(int j = 0; j<=5; j++){
        //     System.out.println(j);
        // }

        System.out.println(sayHello("Jasmine"));
        fizzBuzzTest();
    }

    public static String sayHello(String name){
        return "hello " + name;
    }

    public static String fizzBuzz(int number){
        if(number % 3 == 0 && number % 5 == 0){
            return "FizzBuzz";
        } else if (number % 3 == 0){
            return "Fizz";
        } else if (number % 5 == 0){
            return "Buzz";
        } else {
            return Integer.toString(number);
        }
    }

    public static void fizzBuzzTest(){
        for(int i = 1; i <= 31; i++){
            String result = fizzBuzz(i);
            System.out.println(result);
        }
    }
}