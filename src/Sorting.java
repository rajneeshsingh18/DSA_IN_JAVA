public class Sorting {

    // Helper method to swap elements in an array
    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Bubble Sort algorithm with early termination
     * Time Complexity: O(n^2) worst case, O(n) best case (already sorted)
     * Space Complexity: O(1)
     */
    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    isSwapped = true;
                    swap(a, j, j + 1);
                }
            }
            if (!isSwapped) break; // Early termination if no swaps occurred
        }
    }




    /**
     * Insertion Sort algorithm
     * Time Complexity: O(n^2) worst case, O(n) best case (already sorted)
     * Space Complexity: O(1)
     */
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int temp = a[i]; // Save the current element

            // Shift larger elements to the right
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            // Place temp at its correct sorted position
            a[j + 1] = temp;
        }
    }



    /**
     * Selection Sort algorithm
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, min, i);
        }
    }



    /**
     * Finds intersection of two sorted arrays
     * Time Complexity: O(n + m) where n and m are array lengths
     * Space Complexity: O(1)
     */
    static void intersectionOfTwoSortedArray(int[] a, int[] b) {
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                System.out.print(a[i] + " ");
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
    }



    /**
     * QuickSort algorithm
     * Time Complexity: O(n log n) average case, O(n^2) worst case
     * Space Complexity: O(log n) due to recursion stack
     */
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1); // Sort left part
            quickSort(a, pivot + 1, high); // Sort right part
        }
    }

    // Helper method for QuickSort partitioning
    public static int partition(int[] a, int low, int high) {
        int pivot = a[high]; // Last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high); // Place pivot at correct position
        return i + 1;
    }




    /**
     * MergeSort algorithm
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void mergeSort(int[] a, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, h);
            merge(a, l, mid, h);
        }
    }

    // Helper method for MergeSort merging
    static void merge(int[] a, int l, int mid, int h) {
        int[] b = new int[a.length];
        int i = l;      // Pointer for left subarray
        int j = mid + 1; // Pointer for right subarray
        int k = l;      // Pointer for merged array

        // Merge both halves into b[]
        while (i <= mid && j <= h) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            b[k++] = a[i++];
        }

        // Copy remaining elements from right half
        while (j <= h) {
            b[k++] = a[j++];
        }

        // Copy sorted segment back to original array
        for (int x = l; x <= h; x++) {
            a[x] = b[x];
        }
    }



    // Utility method to print array
    static void printArray(int[] a) {
        for (int e : a) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Bubble Sort
        int[] arr = {5, 1, 4, 2, 8};
        System.out.print("Bubble Sort: ");
        bubbleSort(arr);
        printArray(arr);

        // Test Insertion Sort
        int[] arr1 = {12, 11, 13, 5, 6};
        System.out.print("Insertion Sort: ");
        insertionSort(arr1);
        printArray(arr1);

        // Test Selection Sort
        int[] arr2 = {3, 9, 2, 4, 6};
        System.out.print("Selection Sort: ");
        selectionSort(arr2);
        printArray(arr2);

        // Test Intersection of Sorted Arrays
        int[] arr3 = {2, 5, 6, 6, 8, 8};
        int[] arr4 = {1, 1, 2, 3, 6, 6, 9};
        System.out.print("Intersection: ");
        intersectionOfTwoSortedArray(arr3, arr4);
        System.out.println();

        // Test QuickSort
        int[] arr5 = {10, 7, 8, 9, 1, 5};
        System.out.print("QuickSort: ");
        quickSort(arr5, 0, arr5.length - 1);
        printArray(arr5);

        // Test MergeSort
        int[] arr6 = {38, 27, 43, 3, 9, 82, 10};
        System.out.print("MergeSort: ");
        mergeSort(arr6, 0, arr6.length - 1);
        printArray(arr6);
    }
}

