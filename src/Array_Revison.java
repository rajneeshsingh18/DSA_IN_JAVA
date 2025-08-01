import java.util.*;

public class Array_Revison {

    /**
     * Finds the index of the largest element in the array
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    static int largestElement(int[] a) {
        if (a == null || a.length == 0) throw new IllegalArgumentException("Array is empty");

        int n = a.length;
        int max = 0; // Initialize with first index

        for (int i = 1; i < n; i++) {
            if (a[i] > a[max]) {
                max = i;
            }
        }
        return max;
    }



    /**
     * Finds the index of the second largest element in the array
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    static int secondLargestElement(int[] arr) {
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
        }
        return secondLargest;
    }



    /**
     * Removes duplicates from a sorted array in-place
     * Returns the new length of the array without duplicates
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    static int removeDuplicates(int[] arr) {
        int n = arr.length;

        if (arr == null) return 0;
        if (n <= 1) return n;

        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }




    /**
     * Finds maximum subarray sum using Kadane's Algorithm
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }

        return maxGlobal;
    }





    /**
     * Finds indices of two numbers that add up to target (HashMap approach)
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static int[] twoSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is not valid input");
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(arr[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }




    /**
     * Finds all unique triplets that sum to zero (Three Sum problem)
     * Time Complexity: O(n^2), Space Complexity: O(n)
     */
    static public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3 || nums == null) return new ArrayList<>();

        Set<List<Integer>> resultSet = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    resultSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(resultSet);
    }



    public static void main(String[] args) {
        // Test largest element
        int[] arr = {3, 5, 2, 8, 1};
        System.out.println("Index of Largest element: " + largestElement(arr));

        // Test second largest element
        System.out.println("Index of Second Largest element: " + secondLargestElement(arr));

        // Test remove duplicates
        int[] arr2 = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(arr2);
        System.out.println("Array after removing duplicates (length = " + newLength + "): "
                + Arrays.toString(Arrays.copyOf(arr2, newLength)));

        // Test maximum subarray sum
        int[] arr3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum: " + maxSubArray(arr3));

        // Test two sum
        int target = 6;
        int[] resultIndices = twoSum(arr3, target);
        System.out.println("Two sum indices for target " + target + ": ["
                + resultIndices[0] + ", " + resultIndices[1] + "]");

        // Test three sum
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println("Triplets that sum to zero:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}

