package org.CharlesBorabon.CollectionsAndGenerics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Initialize five different Collectoin objects
        List<String> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new PriorityQueue<>();
        Map<String, Integer> map = new HashMap<>();
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();

        // Add elements to list and print
        list.add("Hello");
        list.add("Hello");
        list.add("World");
        list.add("Earth");
        System.out.println("List: " + list);
        System.out.println("--------------------");

        // Add elements to set and print
        set.add(4);
        set.add(4); // Will not be added due to duplicate
        set.add(2);
        set.add(3);
        set.add(1);
        System.out.println("Set: " + set);
        System.out.println("--------------------");

        // Add elements to queue and print
        queue.add(4);
        queue.add(2);
        queue.add(3);
        queue.add(1);
        System.out.println("Queue: " + queue);
        // Remove one element from queue and print
        queue.poll();
        System.out.println("Queue: " + queue);
        System.out.println("--------------------");

        // Add elements to map and print
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println("Map: " + map);
        System.out.println("--------------------");

        // Add elements to linked list and print
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("Linked List: " + linkedList);
        // Show current head and tail
        System.out.println("Head: " + linkedList.getHead());
        System.out.println("Tail: " + linkedList.getTail());
    }
}
