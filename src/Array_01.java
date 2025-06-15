public class Array_01 {

    // === Array Deletion Operation ===
    /**
     * Deletes the first occurrence of a key from an array and returns the new size
     * @param arr The input array
     * @param key The element to be deleted
     * @return The new size of the array after deletion (or original size if key not found)
     */


    public static int deleteElement(int[] arr, int key) {
        int i = 0;
        int n = arr.length;

        // Find the index of the key
        for (; i < n; i++) {
            if (arr[i] == key) {
                break;
            }
        }

        if (i == n) return n; // Key not found

        // Shift elements left to fill the gap
        for (int j = i; j < n - 1; j++) {
            arr[j] = arr[j + 1];
        }

        return n - 1;
    }



    // === Find Maximum Element ===
    /**
     * Finds the index of the maximum element in an array
     * @param array The input array
     * @return Index of the maximum element, or -1 if array is empty
     */


    public static int findMaxElementIndex(int[] array) {
        if (array.length == 0) return -1;

        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }



    // === Find Second Largest Element ===
    /**
     * Finds the second largest element in an array
     * @param arr The input array
     * @return The second largest element, or -1 if not found
     */


    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) return -1;

        int largest = 0;
        int secondLargest = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
                secondLargest = largest;
                largest = i;
            } else if (arr[i] < arr[largest]) {
                if (secondLargest == -1 || arr[i] > arr[secondLargest]) {
                    secondLargest = i;
                }
            }
            // Equal elements are ignored
        }
        return (secondLargest == -1) ? -1 : arr[secondLargest];
    }

    // === Remove Duplicates from Sorted Array ===
    /**
     * Removes duplicates from a sorted array in-place
     * @param arr The sorted input array
     * @return The count of unique elements
     */


    public static int removeDuplicates(int[] arr) {
        int n = arr.length;

        if (arr == null) return 0;
        if (n <= 1) return n;

        // Two pointers approach
        int i = 0; // Slow pointer (last unique element)
        for (int j = 1; j < n; j++) { // Fast pointer
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    // === Linear Search ===

    /**
     * Searches for a key in an array using linear search
     * @param arr The input array
     * @param key The element to search for
     * @return Index of the key if found, -1 otherwise
     */

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // === Utility Methods ===
    /**
     * Prints the elements of an array
     * @param arr The array to be printed
     */
    public static void printArray(int[] arr) {
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }


    // === Main Method ===
    public static void main(String[] args) {
        // Test delete operation
        int[] arr1 = {2, 1, 4, 6, 5};
        int keyToDelete = 4;
        System.out.println("Original array:");
        printArray(arr1);

        int newSize = deleteElement(arr1, keyToDelete);
        System.out.println("After deleting " + keyToDelete + ":");
        printArray(arr1);
        System.out.println("New size: " + newSize + "\n");

        // Test find max element
        int maxIndex = findMaxElementIndex(arr1);
        System.out.println("Index of maximum element: " + maxIndex);
        System.out.println("Maximum element is: " + arr1[maxIndex] + "\n");

        // Test second largest element
        int[] arr2 = {5, 1, 7, 2, 4, 24};
        System.out.println("Array for second largest test:");
        printArray(arr2);

        int secondLargest = findSecondLargest(arr2);
        System.out.println("Second largest element: " + secondLargest + "\n");

        // Test remove duplicates
        int[] arr3 = {1, 1, 2, 2, 2, 3, 3};
        System.out.println("Original array with duplicates:");
        printArray(arr3);

        int uniqueCount = removeDuplicates(arr3);
        System.out.println("After removing duplicates (" + uniqueCount + " unique elements):");
        printArray(arr3);
        System.out.println();

        // Test linear search
        int[] arr4 = {2, 1, 4, 6, 5};
        int keyToFind = 6;
        System.out.println("Searching for " + keyToFind + " in array:");
        printArray(arr4);

        int searchResult = linearSearch(arr4, keyToFind);
        if (searchResult == -1) {
            System.out.println("Key not found");
        } else {
            System.out.println("Key found at index: " + searchResult);
        }
    }
}



/*
 * DAY 1 REVISION NOTES - ARRAY OPERATIONS
 *
 * Key Operations Implemented:
 * 1. Deletion: O(n) time - Find element then shift remaining elements left
 * 2. Max Element: O(n) time - Single pass tracking max index
 * 3. Second Largest: O(n) time - Track both largest and second largest indices
 * 4. Remove Duplicates: O(n) time - Two pointers technique (in-place)
 * 5. Linear Search: O(n) time - Basic element-by-element search
 *
 * Important Observations:
 * - Most array operations require O(n) time complexity
 * - In-place modifications often use shifting or two-pointer techniques
 * - Edge cases matter: empty arrays, single-element arrays, all duplicates
 *
 * Common Patterns:
 * - Index tracking for max/min elements
 * - Left-shifting for deletions
 * - Slow/fast pointers for in-place modifications
 *
 * Tomorrow's Goals:
 * - Implement binary search on sorted arrays
 * - Practice more two-pointer problems
 * - Learn efficient array rotation algorithms
 */