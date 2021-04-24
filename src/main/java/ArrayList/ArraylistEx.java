package ArrayList;

import java.util.ArrayList;

public class ArraylistEx {
    /*
        Dynamic arrays
        Slower than standard arrays
        Arraylist > implements List interface > extends Collection
     */

    public static void main(String[] args) {
        // Size of the list
        int n = 5;

        // Declare the array list and initialize
        ArrayList<Integer> list = new ArrayList<>(n);

        // Initialize
        for ( int i = 0 ; i < n ; i++)
            list.add(i);
        System.out.println(list);
        // prints 0 1 2 3 4

        // Add at particular index
        // Add element 9 at index
        list.add(5,9);
        System.out.println(list);
        //

        //Remove index 3
        list.remove(3);

        // Add at the end
        list.add(10);

        //Change elements
        list.set(0, 7);

        //Remove based on object and not index
        list.remove(new Integer(10));

        System.out.println(list);


    }
}
