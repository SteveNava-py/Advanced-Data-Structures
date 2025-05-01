/*
Name: Steven Navarrette
Assignment: Java Warmup Exercise 3
Date: 2/12/2025
*/


import java.util.*;

//declare the array list that is a queue
//declares random variable
public class RandomizedQueue<Item> implements Iterable<Item> {
    private final List<Item> queue;
    private final Random random;

    //create array list that is organized using a queue
    public RandomizedQueue() {
        queue = new ArrayList<>();
        random = new Random();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    //method that enqueues item if its address in memory is not null
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Null items not allowed");
        queue.add(item);
    }

    //method that dequeues an item if its address in memory is not empty
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        int index = random.nextInt(queue.size());
        return queue.remove(index);
    }

    //method that gets a random element from the queue array list
    //first checks if it is empty
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        int index = random.nextInt(queue.size());
        return queue.get(index);
    }


    @Override
    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    //private class that has iterator method that returns a randomized iterator by shuffling the indexes of the queue array list
    //shuffled list is declared
    //current item in memory is declared
    private class RandomizedIterator implements Iterator<Item> {
        private final List<Item> shuffled;
        private int current;

        //method that creates a new shuffled array list
        //shuffles the array list randomly
        public RandomizedIterator() {
            shuffled = new ArrayList<>(queue);
            Collections.shuffle(shuffled, random);
            current = 0;
        }

        //hasNext and next override methods
        @Override
        public boolean hasNext() {
            return current < shuffled.size();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return shuffled.get(current++);
        }
    }

    //main method that prints out each step the code executes in order
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        System.out.println("Is queue empty? " + rq.isEmpty());
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);
        rq.enqueue(5);

        System.out.println("Queue size: " + rq.size());
        System.out.println("Sample item: " + rq.sample());
        System.out.println("Dequeue: " + rq.dequeue());
        System.out.println("Queue size after dequeue: " + rq.size());

        System.out.println("Iterator output:");
        for (int item : rq) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("Iterator test:");
        for (Integer integer : rq) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println("New Iterator test:");
        for (Integer integer : rq) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
