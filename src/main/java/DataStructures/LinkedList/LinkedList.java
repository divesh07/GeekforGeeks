package DataStructures.LinkedList;

public class LinkedList {
    Node head;

    //inner class is made static so that main can access it
    static class Node{
        int data;
        Node next;

        //constructor
        Node(int x) {
            data = x ;
            next = null;
        }
    }

    // Function to print the content of linked list from head
    public void printList(){
        Node n = head;
        while ( n != null){
            System.out.println(n.data + " ");
            n = n.next;
        }
    }

    // Node can be added in 3 ways:
    // 1. At front - O(1)
    // 2. After a given node - O(1)
    // 3. At the end of the linked list. - O(N)

    // Add at front - O(1)
    public void pushNode(int new_data){
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        head = new_Node;
    }

    // Inserts node after O(1)
    public void insertAfter( Node prev_node , int new_data){
        //Check if prev node is null
        if (prev_node == null){
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_Node = new Node(new_data);
        new_Node.next = prev_node.next;
        prev_node.next = new_Node;
    }

    // append Node to the end O(N)
    public void append(int new_data){
        Node new_node = new Node(new_data);

        if ( head == null){
            head = new_node;
            return;
        }

        //Since its last node:
        new_node.next = null;

        //traverse till last node
        Node last = head;
        while( last.next !=null){
            last = last.next;
        }

        last.next = new_node;
        return;

    }

    //Create single linked list with 3 nodes:
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        list.head.next = second;
        second.next = third;

        list.printList();
    }

}
