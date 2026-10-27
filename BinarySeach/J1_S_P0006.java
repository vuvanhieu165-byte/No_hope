import java.util.Random;
import java.util.Scanner;

public class J1_S_P0006 {

    public static void main(String[] args) {
        // Step 1: Users enter number of array
        int numberOfArray = inputNumber("Enter number of array: ", 1, 100);
        // Step 2: Ask users to enter a search value
        int searchOfArray = inputNumber("Enter search value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        // Step 3: Generate random integer array
        int[] arr = getRandomArray(numberOfArray);
//      int[] arr = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};

        // Step 4: Sort array using Bubble Sort
        sortArray(arr);
        // Step 5: Display sorted array
        displayArray(arr);
        
        // Step 6: Find the index of search number in array
        int index = binarySearch(arr, searchOfArray, 0, arr.length - 1);
        
        // Step 7: Test algorithm
        testAlgorithm(arr, searchOfArray);
        
        // Step 8: Display index result
        displayIndex(searchOfArray, index);
    }

    private static int inputNumber(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        String input;
        int output;

        while (true) {
            System.out.println(msg);
            input = sc.nextLine().trim();
            // Check input empty
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty, please try again: ");
                continue;
            }
            try {
                // Change text into an integer
                output = Integer.parseInt(input);
                // Check input range [min, max]
                if (output < min || output > max) {
                    System.out.println("Error: Input must be from " + min + " to " + max + ". Please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input must be an integer (no letters, no decimals, not too large). Please try again.");
            }
        }
        return output;
    }

    private static int[] getRandomArray(int numberOfArray) {
        Random rd = new Random();
        int[] arr = new int[numberOfArray];
        // Use loop to access each element from first to last
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(numberOfArray);
        }
        return arr;
    }

    private static int[] sortArray(int[] arr) {
        // Use loop to access first element to last element
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    private static void displayArray(int[] arr) {
        System.out.print("Sorted Array: [");
        // Loop each element from first to last index
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static int binarySearch(int[] sortArray, int searchOfArray, int left, int right) {
        // Use loop while enter search is valid
        while (left <= right) {
       
            int mid = left + (right - left) / 2;
            //check if 
            if (sortArray[mid] == searchOfArray) {
                return mid;
            } else if (sortArray[mid] > searchOfArray) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static void testAlgorithm(int[] sortArray, int searchOfArray) {
        int left = 0;
        int right = sortArray.length - 1;
        int step = 1;
        boolean testAlgorithm = true;
        
        if (testAlgorithm) {
            // Use loop while search space is valid
            while (left <= right) {
                int mid = left + (right - left) / 2;

                String compareArr = "";
                // Check if element is found at mid
                if (sortArray[mid] == searchOfArray) {
                    compareArr = sortArray[mid] + " = " + searchOfArray;
                } else if (sortArray[mid] > searchOfArray) {
                    compareArr = sortArray[mid] + " > " + searchOfArray;
                } else {
                    compareArr = sortArray[mid] + " < " + searchOfArray;
                }

                System.out.print(String.format("Step %d (Middle element is %s):", step, compareArr));

                // Print array elements and highlight the middle element
                for (int i = 0; i < sortArray.length; i++) {
                    if (i == mid) {
                        System.out.print("[" + sortArray[i] + "]");
                    } else {
                        System.out.print(" " + sortArray[i] + " ");
                    }
                }
                System.out.println();
                
                if (sortArray[mid] == searchOfArray) {
                    return;
                } else if (sortArray[mid] > searchOfArray) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                step++;
            }
            
          
            System.out.println("Step " + step + " (search value is absent): Not Found!!");
        }
    }

    private static void displayIndex(int searchOfArray, int index) {
        // Check if index is -1
        if (index == -1) {
            System.out.println("Not Found!!");
        } else {
            System.out.println("Found " + searchOfArray + " at index: " + index);
        }
    }
}