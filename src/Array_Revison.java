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



    /**
     * Merges overlapping intervals
     * Time Complexity: O(n log n), Space Complexity: O(n)
     * @param intervals Array of intervals to merge
     * @return Array of merged intervals
     */

    public static int[][] merge(int [][] intervals){
        if(intervals.length <=1){
            return intervals;
        }

        //sort intervals based on start time
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        List<int []> merged = new ArrayList<>();
        int [] current = intervals[0];

        merged.add(current);

        for(int [] interval : intervals) {

            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                current = interval;
                merged.add(current);
            }

        }

        return merged.toArray(new int[merged.size()][]);
    }


    /**
     * Computes product of array except self for each element
     * Time Complexity: O(n), Space Complexity: O(n)
     * @param nums The input array
     * @return Array where each element is product of all elements except itself
     */
    public static int [] productExceptSelf(int [] nums){

        //Array to Store the all left multiplication
        int [] left = new int[nums.length];

        //Array to store all right multiplication
        int [] right = new int[nums.length];

        left[0] =1;
        for(int i=1; i<nums.length ;i++){
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length - 1] = 1;
        for(int i = nums.length -2 ; i>-1;i--){
            right[i] = right[i+1] * nums[i+1];
        }

        int [] ans = new int[nums.length];
        for(int i=0 ; i<nums.length ;i++){
            ans[i] = left[i] * right[i];
        }

        return ans;
    }


    /**
     * Sorts array of 0s, 1s and 2s (Dutch National Flag problem)
     * Time Complexity: O(n), Space Complexity: O(1)
     * @param arr The input array to sort
     */
    public static void swap(int [] arr , int i , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortColors(int [] arr){
        int low = 0 ;
        int mid = 0;
        int high = arr.length-1;

        while(mid<=high){
            if(arr[mid] == 0){
                swap(arr,low,mid);
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            } else if (arr[mid]==2) {
                swap(arr,mid,high);
                high--;
            }
        }
    }


    /**
     * Moves all zeros to the end while maintaining relative order of other elements
     * Time Complexity: O(n), Space Complexity: O(1)
     * @param nums The input array
     */
    public static void moveZeros(int [] nums){

        int insertPos = 0;

        for(int i= 0 ; i< nums.length ; i++){

            if(nums[i] != 0){
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        while (insertPos<nums.length){
            nums[insertPos++] = 0;
        }

    }




    /**
     * Finds majority element (appears more than n/2 times) using Moore's Voting Algorithm
     * Time Complexity: O(n), Space Complexity: O(1)
     * @param nums The input array
     * @return The majority element
     */

    public static int majorityElement(int [] nums){
        int majority = nums[0] , votes = 1;

        for(int i =1 ; i< nums.length ; i++){

            if(votes == 0){
                votes++;
                majority = nums[i];
            }else if(majority == nums[i]){
                votes++;
            }else {
                votes--;
            }
        }
        return majority;
    }



    /**
     * Calculates maximum profit from buying and selling stock (single transaction)
     * Time Complexity: O(n), Space Complexity: O(1)
     * @param prices Array of daily stock prices
     * @return Maximum possible profit
     */

    public static int maxProfit(int[] prices){
        int maxProfit = 0;
        int n = prices.length;
        int minSoFar = prices[0];


        for(int i = 0 ; i< n ; i++){
            minSoFar = Math.min(minSoFar,prices[i]);
            int profit = prices[i] - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
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


        // Sample input: overlapping intervals
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] merged = merge(intervals);

        // Print the result
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }


        int [] productInput = {3,4,6,1,2};
        int [] result1 = productExceptSelf(productInput);
        System.out.println("Product Except Self:");
        for (int val : result1) {
            System.out.print(val + " ");
        }

        System.out.println();

        int [] arr5 = {2,0,2,1,1,0};
        sortColors(arr5);
        System.out.println("Sort colors:");
        for (int val :arr5) {
            System.out.print(val + " ");
        }

        System.out.println();

        int [] arr6 = {2,0,2,1,1,0};
        moveZeros(arr6);
        System.out.println("Move Zeros:");
        for (int val :arr6) {
            System.out.print(val + " ");
        }


        System.out.println();

        int [] arr7 = {2,1,2,4,2,2,1,1};
        int result4 = majorityElement(arr7);
        System.out.println("Majority Element is " + result4);


        System.out.println();

        int [] arr8 = {7,1,5,3,6,4};
        int maxprofit = maxProfit(arr8);
        System.out.println("Maximum profit : " + maxprofit);






    }
}

