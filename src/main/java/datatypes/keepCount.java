package datatypes;

import java.util.Scanner;

public class keepCount {
    //Primitive - Defined by language
    //byte - 8 bits ( Range :  - 2 ^ 7 , +2 ^ 7 - 1 )
    //short - 16 bits ( Range :  - 2 ^ 15 , + 2 ^ 15 - 1 )
    //int - 32 bits ( Range :  - 2 ^ 31 , + 2 ^ 31 - 1 )
    //long - 64 bits( Range :  -2 ^ 63 , +2 ^ 63 -1 )
    // float - 32 bits with decimal ( ends with f or F ) Range : -3.4 * 10 ^ 38 to +3.4 * 10 ^ 38
    // : 7 digits after decimal
    // double - 64 bits with decimal : 15 digits after decimal
    //char and boolean -

    //Code that initialises an integer variable ‘dollars’, which keeps count of the number of
    // dollars you have in your pocket.

    public static void usage() {
        double x = Math.pow(12, 9);
        System.out.println(x);

        double a = 2.5, b = 2.5;
        int z = (int) (a * b);
        System.out.println(z);

        int i = 2, j = 2;
        double k = i * j;
        System.out.println(k);

    }

    public static void main(String[] args) {
        usage();

        // initial money
        int dollars = 20;

        // Buy bottle for $1 , bus ticket for $2
        dollars = dollars - (1 + 2);

        // got money from uncle
        dollars = dollars + 4;
        System.out.println(dollars);
    }
}

class sumFloat {
    public static void main(String[] args) {
        float myVariable = 4.5f;
        myVariable += 7.5;
        System.out.println(myVariable);
    }
}

class prompt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value for a");
        int a = scanner.nextInt();
        System.out.println("Enter value for b");
        int b = scanner.nextInt();
        System.out.println("Enter value for c");
        int c = scanner.nextInt();
        int result = (a * b) + c;
        System.out.println("Evaluate a * b + c : " + result);
    }
}

// Divide 5 digit number into one, tens , hundreds , thousands and ten thousand digit and print
class granular {
    public static void main(String[] args) {
        int x = 12345;
        for (int i = 4; i >= 0; i--) {
            int num = (int) Math.pow(10, i);
            System.out.println(x / num);
            x = x % num;
        }
    }
}

