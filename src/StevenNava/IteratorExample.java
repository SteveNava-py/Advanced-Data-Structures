package StevenNava;

//creating object of linked list
public class IteratorExample {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        //appending the six nodes
        list.append(new Node(5));
        list.append(new Node(10));
        list.append(new Node(15));
        list.append(new Node(20));
        list.append(new Node(25));
        list.append(new Node(30));

        //the og list
        System.out.println("original List:");
        list.printList();

        //printing the iterated list
        System.out.println("\niterated list:");
        for (int value : list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

