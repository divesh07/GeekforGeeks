package Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {
        // Queue is an interface , so needs a concrete class for the declaration
        // Pirority Queue and Linkedlist are the common classed - both are not thread safe
        // Priority Blocking Queue is the thread safe implementation:
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            q.add(i);
        }

        // Display contents of queue
        System.out.println(q);

        // Remove head of the queue
        int removed = q.remove();
        System.out.println(q);
        System.out.println("Element removed " + removed);

        // View head
        int head = q.peek();
        System.out.println("Head " + head);

        int size = q.size();
        System.out.println("Queue size " + size);

    }
}

class QueueEx2{
    public static void main(String[] args) {
        // Use Priority queue implementation

        Queue<String> pq = new PriorityQueue<>();

        pq.add("Test");
        pq.add("queue");
        pq.add("of");
        pq.add("removal");

        System.out.println(pq);

        //Remove element
        pq.remove("of");
        System.out.println(pq);

        // Remove head using poll and returns the element
        String head = pq.poll();
        System.out.println("HEad removed" + head);

        System.out.println(pq);

        Iterator it = pq.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}

class QueueEx3{
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(15);

        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q);
    }
}
