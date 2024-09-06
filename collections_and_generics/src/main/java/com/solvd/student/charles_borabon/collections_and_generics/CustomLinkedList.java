package com.solvd.student.charles_borabon.collections_and_generics;

public class CustomLinkedList<T> {
    // Helper class to represent a node in the linked list
    public class node<K> {
        T data;
        node<T> next;
        node<T> prev;
        
        public node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Head and tail pointers
    private node<T> head;
    private node<T> tail;

    // Constructor
    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Add a new node to the end of the linked list
    public void add(T data) {
        node<T> newNode = new node<>(data);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }
    }

    // Remove a node from the linked list
    public void remove(T data) {
        node<T> current = this.head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else if (current == this.tail) {
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    // Get the head of the linked list
    public T getHead() {
        return this.head.data;
    }

    // Get the tail of the linked list
    public T getTail() {
        return this.tail.data;
    }

    // Clear Linked List
    public void clear() {
        this.head = null;
        this.tail = null;
    }

    // Override toString method to print the linked list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        node<T> current = this.head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}
