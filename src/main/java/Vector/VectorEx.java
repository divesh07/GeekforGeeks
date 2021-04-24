package Vector;

import java.util.ArrayList;
import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {
        // Like Array List but synchronized
        Vector v = new Vector<>();

        //Appends to the end
        v.add(1);
        v.add(2);
        v.add("geeks");
        v.add("forGeeks");
        v.add(3);

        System.out.println(v);

        // Insert at specified element
        v.add(2, 10);
        System.out.println(v);

        // Add all the elements in the collection to the vector

        ArrayList arr = new ArrayList();
        arr.add(5);
        arr.add("iitb");

        v.addAll(arr);
        System.out.println(v);

        // Check if element exists
        if (v.contains(new Integer(10))) {
            System.out.println("FOUND");
        }

        // Default capacity of vector is 10
        System.out.println(v.capacity());

        // Increase the capacity
        v.ensureCapacity(20);

        System.out.println(v.capacity());

        // Gets the element at index
        System.out.println(v.get(5));

        // Get the indx of the element
        int x = v.indexOf(new Integer(10));
        System.out.println(x);
    }
}
