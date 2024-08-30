package org.CharlesBorabon.JavaBasics;

public class Main {

    public static class Quicksort {
        int partition(int arr[], int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                // If current element is smaller than the pivot
                if (arr[j] < pivot) {
                    i++;
                    // Swap arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // Swap arr[i + 1] and arr[high] (or pivot)
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }
    
        void sort(int arr[], int low, int high) {
            if (low < high) {
                // pi is partitioning index, arr[pi] is now at right place
                int pi = partition(arr, low, high);
                // Recursively sort elements before partition and after partition
                sort(arr, low, pi - 1);
                sort(arr, pi + 1, high);
            }
        }
    }
    public static void main(String[] args) {
        
        // Simple print statement using args
        // pass in 3 arguments to see the output
        if (args.length > 2) {
            String firstName = args[0];
            String lastName = args[1];
            int age = Integer.parseInt(args[2]);
            System.out.println("Hello, my name is " + firstName + " " + lastName + " and I am " + age + " years old.");
        } else {
            System.out.println("Hello, World!");
        }

        System.out.println();


        // Quicksort test
        int[] arr = {5, 2, 9, 1, 5, 6};
        System.out.println("Before sorting: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        Quicksort quicksort = new Quicksort();

        quicksort.sort(arr, 0, arr.length - 1);
        // Print sorted array
        System.out.println("\nAfter sorting: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}