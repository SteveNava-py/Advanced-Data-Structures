package StevenNava;
import java.util.Iterator;

//modified linked list class from last semester in data structures
//commented out the methods from that assignment that are not necessary
public class LinkedList implements Iterable<Integer> {
    Node head;
    int size;

    // Constructor
    public LinkedList() {
        head = null;
        size = 0;
    }

    /*public int size() {
        return size;
    }*/

    /*
    public void prepend(Node newNode) {
        newNode.next = head;
        head = newNode;
        size++;
    }*/

    // Appends a node at the end of the linked list
    public void append(Node newNode) {
        // Check if the linked list is empty
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        // Traverse to the last node
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        // Attach new node to the last node
        ptr.next = newNode;
        size++;
    }

    /*
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    } */

    //method that checks if the list is empty or not and prints the list otherwise prints "null"
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " ---> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    //implementing the iterator class
    @Override
    public Iterator<Integer> iterator() {
        return new LinkedIterator(head);
    }
}

