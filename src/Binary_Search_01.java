public class Binary_Search_01 {

    /**
     * Standard binary search implementation
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    static int binarySearch(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents integer overflow
            if (a[mid] == key) return mid;
            if (key > a[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }





    /**
     * Finds first occurrence (leftmost) of key in sorted array
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    static int leftOccurrence(int[] a, int key) {
        if (a.length == 0) return -1;

        int l = 0;          // Left pointer
        int r = a.length - 1; // Right pointer
        int ans = -1;       // Default answer if key not found

        while (l <= r) {
            int mid = l + (r - l) / 2; // Prevents overflow

            if (a[mid] == key) {
                ans = mid;    // Update answer
                r = mid - 1;  // Search left half for earlier occurrence
            } else if (key > a[mid]) {
                l = mid + 1;  // Key is in right half
            } else {
                r = mid - 1;  // Key is in left half
            }
        }
        return ans;
    }





    /**
     * Finds last occurrence (rightmost) of key in sorted array
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    static int rightOccurrence(int[] a, int key) {
        int l = 0;
        int r = a.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (a[mid] == key) {
                ans = mid;
                l = mid + 1; // Search right half for later occurrence
            } else if (key > a[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }





    /**
     * Searches for key in rotated sorted array
     * Time Complexity: O(log n), Space Complexity: O(1)
     */
    static int searchRotatedSortedArray(int[] a, int key) {
        if (a.length == 0) return -1;

        int l = 0, r = a.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (a[mid] == key) return mid; // Key found

            if (a[l] <= a[mid]) { // Left half is sorted
                if (key >= a[l] && key < a[mid]) {
                    r = mid - 1; // Search left half
                } else {
                    l = mid + 1; // Search right half
                }
            } else { // Right half is sorted
                if (key > a[mid] && key <= a[r]) {
                    l = mid + 1; // Search right half
                } else {
                    r = mid - 1; // Search left half
                }
            }
        }
        return -1; // Key not found
    }




    public static void main(String[] args) {
        // Test standard binary search
        int[] arr = {2, 5, 21, 45, 254, 321};
        int key = 45;
        System.out.println("Standard binary search (45): " + binarySearch(arr, key));

        // Test first occurrence search
        int[] arr1 = {1, 2, 2, 2, 3, 4, 4, 5};
        System.out.println("First occurrence of 4: " + leftOccurrence(arr1, 4));

        // Test last occurrence search
        System.out.println("Last occurrence of 2: " + rightOccurrence(arr1, 2));

        // Test rotated sorted array search
        int[] arr2 = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        System.out.println("Search in rotated array (10): " + searchRotatedSortedArray(arr2, 10));
        System.out.println("Search in rotated array (3): " + searchRotatedSortedArray(arr2, 3));
    }
}


