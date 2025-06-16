import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Array Operations - Day 2
 * Contains implementations of various array algorithms:
 * 1. Kadane's Algorithm (Maximum Subarray Sum)
 * 2. Finding Leaders in Array
 * 3. Array Sorting Check
 * 4. Minimum Element Finding
 */
public class Array_02 {

    // ================== KADANE'S ALGORITHM ================== //
    /**
     * Finds the maximum sum of any contiguous subarray
     * @param nums Input array of integers
     * @return Maximum subarray sum
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */


    public static int findMaxSubarraySum(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            currentSum += num;
            if (currentSum < 0) currentSum = 0;
            if (maxSum < currentSum) maxSum = currentSum;
        }
        return maxSum;
    }



    // ================== ARRAY LEADERS ================== //
    /**
     * Prints leaders in array (elements greater than all to their right)
     * @param nums Input array
     * Time Complexity: O(n)
     * Space Complexity: O(n) for the result array
     */


    public static void printLeadersBruteForce(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int[] result = new int[nums.length];
        int j = 0;

        // Right to left traversal
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > largest) {
                largest = nums[i];
                System.out.print(nums[i] + " ");
                result[j++] = nums[i];
            }
        }
        System.out.println();

        // Print in original order
        for (j = j - 1; j >= 0; j--) {
            System.out.print(result[j] + " ");
        }
    }



    /**
     * Optimized solution to find leaders using List
     * @param nums Input array
     * @return List of leaders in original order
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */


    public static List<Integer> findLeadersOptimized(int[] nums) {
        List<Integer> leaders = new ArrayList<>();
        int maxFromRight = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= maxFromRight) {
                maxFromRight = nums[i];
                leaders.add(maxFromRight);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }



    // ================== ARRAY VALIDATION ================== //
    /**
     * Checks if array is sorted in non-decreasing order
     * @param nums Input array
     * @return true if sorted, false otherwise
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */


    public static boolean isArraySorted(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }



    // ================== MINIMUM ELEMENT ================== //
    /**
     * Finds the index of minimum element in array
     * @param nums Input array
     * @return Index of minimum element, -1 if empty
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */


    public static int findMinElementIndex(int[] nums) {
        if (nums.length == 0) return -1;

        int minIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }



    // ================== MAIN METHOD ================== //
    public static void main(String[] args) {
        // Test cases for all operations

        // Test isArraySorted
        int[] sortedArr = {1, 2, 3, 4};
        int[] unsortedArr = {1, 3, 2, 32};
        System.out.println("Is array sorted? " + isArraySorted(unsortedArr));

        // Test findMinElementIndex
        int[] testArr = {16, 15, 32, 14, 23};
        int minIndex = findMinElementIndex(testArr);
        System.out.println("Index of minimum element: " + minIndex);
        System.out.println("Value of minimum element: " + testArr[minIndex]);

        // Test leaders functions
        int[] leadersTestArr = {2, 7, 6, 4, 1, 3};
        System.out.println("\nLeaders (Brute Force):");
        printLeadersBruteForce(leadersTestArr);

        System.out.println("\n\nLeaders (Optimized):");
        List<Integer> leadersResult = findLeadersOptimized(leadersTestArr);
        System.out.println(leadersResult);

        // Test Kadane's algorithm
        int[] kadaneTestArr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = findMaxSubarraySum(kadaneTestArr);
        System.out.println("\nMaximum subarray sum: " + maxSum);
    }
}

/*
 * REVISION NOTES:
 *
 * 1. Kadane's Algorithm:
 *    - Handles all cases except when all numbers are negative
 *    - For all-negative arrays, needs modification to track least negative
 *
 * 2. Leaders Problem:
 *    - Two approaches demonstrated (brute force and optimized)
 *    - Right-to-left traversal is key optimization
 *
 * 3. Edge Cases Handled:
 *    - Empty arrays
 *    - Null inputs
 *    - Single-element arrays
 *
 * 4. Common Patterns:
 *    - Single pass for min/max finding
 *    - Reverse traversal for right-side comparisons
 *    - In-place operations where possible
 *
 * 5. Improvements Made:
 *    - Consistent naming conventions
 *    - Added time/space complexity comments
 *    - Separated test cases in main method
 *    - Added detailed JavaDoc comments
 */