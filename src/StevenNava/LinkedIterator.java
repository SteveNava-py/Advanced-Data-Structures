package StevenNava;
import java.util.Iterator;
import java.util.NoSuchElementException;

//Iterator interface class
public class LinkedIterator implements Iterator<Integer> {
    private Node current;

    public LinkedIterator(Node head) {
        current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    //throw statement to handle the exception
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int data = current.data;
        current = current.next;
        return data;
    }
}
