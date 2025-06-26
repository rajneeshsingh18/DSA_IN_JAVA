import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Array_06 {

    /**
     * Calculates maximum profit from buying and selling stocks (one transaction)
     * Time Complexity: O(n), Space Complexity: O(1)
     */


    public static int maxProfit(int[] prices) {

        int n = prices.length;
        int maxProfit = 0;
        int minSoFar = prices[0];

        for(int i = 0 ; i< n;i++){
            minSoFar = Math.min(minSoFar,prices[i]);
            int profit = prices[i] - minSoFar;
            maxProfit = Math.max(maxProfit , profit);
        }
        return maxProfit;
    }



    /**
     * Merges two sorted arrays into one sorted array
     * Time Complexity: O(m+n), Space Complexity: O(m+n)
     */

    public static  int[] mergeTwoSortedArrays(int[] a , int [] b){
        int [] res = new int[a.length + b.length];

        int i=0;
        int j=0;
        int k=0;

        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                res[k] = a[i];
                i++;
                k++;
            }else {
                res[k] = b[j];
                j++;
                k++;
            }
        }

        while (i<a.length){
            res[k] = a[i];
            i++;
            k++;
        }


        while (j<b.length){
            res[k] = b[j];
            j++;
            k++;
        }

        return res;
    }


    /**
     * Finds index of a peak element in array (binary search approach)
     * Time Complexity: O(log n), Space Complexity: O(1)
     */


    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        while(left<right){
            int mid = left + (right-left)/2;

            if(arr[mid] < arr[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }




    /**
     * Checks if subarray with sum k exists (HashSet approach)
     * Time Complexity: O(n), Space Complexity: O(n)
     */


    public static boolean checkKSumSubArray(int [] arr,int k){

        HashSet <Integer> mySet = new HashSet<>();

        mySet.add(0);
        int sum = 0;

        for(int i=0;i<arr.length;i++){
            sum += arr[i];

            int rem = sum -k ;
            if(mySet.contains(rem)){
                return true;
            }
            mySet.add(sum);
        }
            return false;
        }



    /**
     * Finds indices (1-based) of subarray with sum k (HashMap approach)
     * Returns [-1] if not found
     * Time Complexity: O(n), Space Complexity: O(n)
     */


        public static ArrayList<Integer> findKSumSubarrayIndex(int [] arr , int k){

        ArrayList<Integer> list = new ArrayList<>();

        list.add(-1);

        HashMap<Integer,Integer> myMap = new HashMap<>();
        myMap.put(0,-1);

        int sum = 0;
        for(int i =0 ; i<arr.length ; i++){
            sum +=arr[i];

            int rem = sum -k ;

            if(myMap.containsKey(rem)){
                int startingIndex = myMap.get(rem) +1 +1;
                list.set(0,startingIndex);
                list.add(i+1);
                break;
            }
            myMap.put(sum,i);
        }
        return list;
        }



    /**
     * Finds length of longest subarray with sum k (HashMap approach)
     * Time Complexity: O(n), Space Complexity: O(n)
     */


        public static int findLongestKSumSubarrayLength(int [] arr , int k){
        int maxLen=0;
        int sum = 0;

        HashMap<Integer , Integer> myMap = new HashMap<>();

        myMap.put(0,-1);

        for(int i = 0 ; i<arr.length ;i++){
            sum += arr[i];
            int rem = sum -k ;

            if(myMap.containsKey(rem)){
                int len = i - myMap.get(rem);
                maxLen = Math.max(maxLen , len);
            }


            if(!myMap.containsKey(sum)){
                myMap.put(sum,i);
            }
        }
        return maxLen;
        }



    /**
     * Counts total number of subarrays with sum k (HashMap approach)
     * Time Complexity: O(n), Space Complexity: O(n)
     */

        public static int findTotalKSumSubarray(int [] arr , int k){
            int count =0 ;
            int sum =0;

            HashMap<Integer,Integer> sumFreqMap = new HashMap<>();

            sumFreqMap.put(0,1);

            for(int i =0 ; i<arr.length;i++){
                sum +=arr[i];
                int rem = sum -k;

                count += sumFreqMap.getOrDefault(rem,0);

                sumFreqMap.put(sum,sumFreqMap.getOrDefault(sum,0)+1);

            }
            return count;
        }




    public static void main(String[] args) {

        // Test max profit calculation
        int[] pricesOfStocks = {5, 2, 6, 1, 4};
        System.out.println("Maximum Profit: " + maxProfit(pricesOfStocks));

        // Test merging sorted arrays
        int[] a = {1, 3, 5, 7};
        int[] b = {0, 2, 6, 8, 9};
        System.out.println("Merged Array: " + Arrays.toString(mergeTwoSortedArrays(a, b)));

        // Test peak element finding
        int[] arr = {1, 3, 2, 4, 1};
        System.out.println("Peak Element Index: " + findPeakElement(arr));

        // Test subarray sum operations
        int[] c = {2, 8, 2, 6, -6, 3, 2};
        int key = 5;
        System.out.println("Subarray with sum exists: " + checkKSumSubArray(c, key));
        System.out.println("Subarray indices (1-based): " + findKSumSubarrayIndex(c, key));
        System.out.println("Longest subarray length: " + findLongestKSumSubarrayLength(c, key));
        System.out.println("Total subarrays count: " + findTotalKSumSubarray(c, key));

    }
}
