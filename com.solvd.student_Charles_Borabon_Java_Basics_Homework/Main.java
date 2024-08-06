public class Main {
    public static void main(String[] args) {
        
        // Simple print statement using variables 
        String firstName = "Charles";
        String lastName = "Borabon";
        int age = 23;
        
        System.out.println("Hello, my name is " + firstName + " " + lastName + " and I am " + age + " years old.");
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