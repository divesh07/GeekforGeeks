package DoublyLinkedList;

import java.io.*;
import java.util.*;

// Write code to remove a node from a doubly linked list

class Node {
    int data;

    Node next;

    Node prev;

    public Node(int key) {
        data = key;
    }
}

public class DoublyLLEx {
    public void remove(Node node, Node head) {

        if (node == null) {
            // Sytem.out.println("INValid Node");

            return;

        }

        // Last node:
        if (node.next == null && node.prev != null) {
            node.prev.next = null;
            node.prev = null;

        }

        // Head node - but single node
        else if (node.prev == null) {

            if (node.next == null) {
                node = null;
                head = null;

            } else if (node.next != null) {
                head = node.next;
                node.next.prev = null;
                node = null;

            } else {
                // Middle element
                if (node.prev != null && node.next != null) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    node = null;
                }

            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
    }
}

//-----------------------------

/* Unit tests
1_>  Single element in the list ( remove the only element )
2 -> Two elemsent in the list ( Remove  tail / remove head )
3->  Three elements ( Remove middle )
4 -> data values of the node ( small.. big , null values  )
5->  Perf testing with lots of nodes
*/

