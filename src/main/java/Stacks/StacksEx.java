package Stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StacksEx {
    public static void main(String[] args) {
        // LIFO
        // Extends the Vecor Class
        // Push Pop Empty Search Peek
        // Thread sage class which adds overhead
        // Can use Array Deque for single thread environment

        Stack<Integer> stack = new Stack<>();

        //Add element using push
        stack.push(10);
        stack.push(20);
        stack.push(15);

        System.out.println(stack);

        // Remove from top of the stack using Pop
        Integer element = stack.pop();
        System.out.println("Element popped " + element);
        System.out.println(stack);

        // Display element at the top
        Integer top = stack.peek();
        System.out.println("Top element " + top);
        System.out.println(stack);

        ///Search element if not found returns -1
        Integer pos = stack.search(new Integer(10));

        if ( pos == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at position " + pos);

    }
}

class ArrayDequeueEx{
    public static void main(String[] args) {
        // Not thread safe stack implenentation
        // For use with single threaded env

        Deque<Character> dq = new ArrayDeque<>();
        dq.push('A');
        dq.push('B');
        System.out.println(dq);

        //Return the head which is B
        System.out.println(dq.peek());

        //Removes head B
        System.out.println(dq.pop());
        System.out.println(dq);
    }
}
