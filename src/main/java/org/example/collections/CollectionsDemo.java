package org.example.collections;

import java.util.*;

public class CollectionsDemo {

    public static void demonstrateCollections() {
        demonstrateList();
        demonstrateSet();
        demonstrateMap();
        demonstrateQueue();
    }



    private static void demonstrateList() {
        System.out.println("\n>>> ArrayList Demo:");
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");

        System.out.println("Fruits List: " + fruits);
        System.out.println("Size: " + fruits.size());
        System.out.println("First fruit: " + fruits.get(0));
        System.out.println("Contains 'Banana': " + fruits.contains("Banana"));

        // Iteration
        System.out.print("Iterating: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // LinkedList
        System.out.println("\n>>> LinkedList Demo:");
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.addFirst(5);
        numbers.addLast(30);
        System.out.println("LinkedList: " + numbers);
    }



    private static void demonstrateSet() {
        System.out.println("\n>>> HashSet Demo:");
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("Alice");
        uniqueNames.add("Bob");
        uniqueNames.add("Charlie");
        uniqueNames.add("Alice"); // Duplicate, won't be added

        System.out.println("HashSet (no duplicates): " + uniqueNames);
        System.out.println("Size: " + uniqueNames.size());

        // TreeSet - sorted
        System.out.println("\n>>> TreeSet Demo:");
        Set<Integer> sortedNumbers = new TreeSet<>();
        sortedNumbers.add(50);
        sortedNumbers.add(10);
        sortedNumbers.add(30);
        sortedNumbers.add(20);
        System.out.println("TreeSet (sorted): " + sortedNumbers);
    }



    private static void demonstrateMap() {
        System.out.println("\n>>> HashMap Demo:");
        Map<String, Integer> studentGrades = new HashMap<>();
        studentGrades.put("John", 85);
        studentGrades.put("Sarah", 92);
        studentGrades.put("Mike", 78);
        studentGrades.put("Emma", 95);

        System.out.println("Student Grades: " + studentGrades);
        System.out.println("Sarah's grade: " + studentGrades.get("Sarah"));
        System.out.println("Contains 'Mike': " + studentGrades.containsKey("Mike"));

        // Iterate through map
        System.out.println("\nIterating through map:");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // TreeMap - sorted by keys
        System.out.println("\n>>> TreeMap Demo:");
        Map<String, String> sortedMap = new TreeMap<>();
        sortedMap.put("Zebra", "Black and White");
        sortedMap.put("Elephant", "Gray");
        sortedMap.put("Lion", "Golden");
        System.out.println("TreeMap (sorted by keys): " + sortedMap);
    }



    private static void demonstrateQueue() {
        System.out.println("\n>>> Queue (LinkedList) Demo:");
        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        System.out.println("Queue: " + queue);
        System.out.println("Peek (view front): " + queue.peek());
        System.out.println("Poll (remove front): " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // PriorityQueue
        System.out.println("\n>>> PriorityQueue Demo:");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(30);
        priorityQueue.offer(10);
        priorityQueue.offer(20);

        System.out.print("Priority Queue (natural order): ");
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println();
    }
}
