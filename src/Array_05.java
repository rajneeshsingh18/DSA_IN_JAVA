import java.util.Arrays;
import java.util.HashMap;

public class Array_05 {

    // Helper method to swap elements in an array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Dutch National Flag algorithm to sort an array of 0s, 1s, and 2s
     * Time Complexity: O(n), Space Complexity: O(1)
     */


    public static void sortColors(int[] arr) {
        int low = 0;        // Tracks the boundary of 0s
        int mid = 0;         // Current element being processed
        int high = arr.length - 1;  // Tracks the boundary of 2s

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }
    }



    /**
     * Rotates array by k positions using extra space
     * Time Complexity: O(n), Space Complexity: O(n)
     */


    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = arr[i];
        }
        System.arraycopy(temp, 0, arr, 0, n);
    }



    /**
     * Rotates array right by one position
     * Time Complexity: O(n), Space Complexity: O(1)
     */


    public static void rotateByOne(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        int last = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }



    /**
     * Finds maximum j-i such that arr[j] > arr[i]
     * Time Complexity: O(n), Space Complexity: O(n)
     */


    public static int maxValueOfJMinusI(int[] a) {
        int n = a.length;
        int[] rightMax = new int[n];  // Stores max values from right
        int[] leftMin = new int[n];   // Stores min values from left

        rightMax[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], a[i]);
        }

        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        int i = 0, j = 0;
        int ans = -1;
        while (i < n && j < n) {
            if (leftMin[i] < rightMax[j]) {
                ans = Math.max(ans, j - i);
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }



    /**
     * Checks if two numbers in a sorted array sum to target (Two-pointer approach)
     * Time Complexity: O(n), Space Complexity: O(1)
     */


    public static boolean twoSum(int[] a, int sum) {
        int l = 0;
        int r = a.length - 1;

        while (l < r) {
            int curSum = a[l] + a[r];
            if (curSum < sum) l++;
            else if (curSum > sum) r--;
            else return true;
        }
        return false;
    }



    /**
     * Finds indices of two numbers that sum to target (HashMap approach)
     * Time Complexity: O(n), Space Complexity: O(n)
     */


    public static int[] twoSumUsingHashMap(int[] a, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int needed = target - a[i];
            if (map.containsKey(needed)) {
                return new int[]{map.get(needed), i};
            }
            map.put(a[i], i);
        }
        return new int[0];  // Return empty array if no solution
    }



    public static void main(String[] args) {
        // Test Dutch National Flag algorithm
        int[] colors = {2, 0, 1, 1, 2, 0};
        sortColors(colors);
        System.out.println("Sorted colors: " + Arrays.toString(colors));


        // Test max j-i difference
        int[] arr = {4, 3, 5, 1, 4, 2, 1};
        System.out.println("Max j-i difference: " + maxValueOfJMinusI(arr));


        // Test twoSum in sorted array
        int[] sortedArr = {1, 2, 7, 8, 10, 12};
        int target = 15;
        System.out.println("Two sum exists (" + target + "): " + twoSum(sortedArr, target));


        // Test twoSum with HashMap
        int[] nums = {2, 6, 5, 8, 11};
        int[] indices = twoSumUsingHashMap(nums, 14);
        System.out.println("Two sum indices: " + indices[0] + ", " + indices[1]);


        // Test array rotation
        int[] toRotate = {1, 2, 3, 4};
        rotateArray(toRotate, 2);
        System.out.println("Rotated array (k=2): " + Arrays.toString(toRotate));


        // Test single rotation
        int[] singleRotate = {1, 2, 3, 4, 5};
        rotateByOne(singleRotate);
        System.out.println("Rotated by one: " + Arrays.toString(singleRotate));


    }
}

