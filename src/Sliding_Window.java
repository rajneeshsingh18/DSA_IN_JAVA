import java.util.*;

public class Sliding_Window {

    // ================================
    // 1. Maximum Subarray Sum of size k
    // ================================
    public static int maxSubarraySum(int[] arr, int k) {
        int N = arr.length;

        if (N == 0 || k == 0 || k > N) return 0;

        int maxSum = 0;
        int windowSum = 0;

        // Step 1: Compute sum of first window of size k
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Step 2: Slide the window across the array
        for (int i = 1; i < N - k + 1; i++) {
            int preElement = arr[i - 1];
            int nextElement = arr[i + k - 1];
            windowSum = windowSum - preElement + nextElement; // slide
            maxSum = Math.max(maxSum, windowSum); // update max
        }

        return maxSum;
    }

    // ===================================================
    // 2. Longest Substring without Repeating Characters
    // Using HashSet (Variable length sliding window)
    // ===================================================
    public static int lengthOfLongestSubstring(String s) {
        int windowStart = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char ch = s.charAt(windowEnd);

            // Shrink window until duplicate is removed
            while (set.contains(ch)) {
                set.remove(s.charAt(windowStart));
                windowStart++;
            }

            // Expand window
            set.add(ch);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        return maxLen;
    }

    // ===================================================
    // 3. Longest Substring without Repeating Characters
    // Using HashMap (Optimized with direct jump)
    // ===================================================
    public static int lengthOfLongestNonRepeatingCharUsingHASHMAP(String s) {
        int windowStart = 0;
        int maxlen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char ch = s.charAt(windowEnd);

            // If duplicate, move windowStart just after last occurrence
            if (map.containsKey(ch) && map.get(ch) >= windowStart) {
                windowStart = map.get(ch) + 1;
            }
            map.put(ch, windowEnd);

            maxlen = Math.max(maxlen, windowEnd - windowStart + 1);
        }

        return maxlen;
    }

    // ===================================================
    // 4. Longest Substring with At Most K Distinct Characters
    // ===================================================
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Shrink window until only k distinct chars remain
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) map.remove(leftChar);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // ===================================================
    // 5. First Negative Integer in Every Window of Size k
    // ===================================================
    public static List<Integer> firstNegInt(int [] arr, int k) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>(); // store indices of negatives

        // Step 1: Process the first window
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) deque.addLast(i);
        }
        result.add(deque.isEmpty() ? 0 : arr[deque.peekFirst()]);

        // Step 2: Slide the window
        for (int i = k; i < n; i++) {
            // Remove indices outside current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            // Add current element if negative
            if (arr[i] < 0) deque.addLast(i);

            result.add(deque.isEmpty() ? 0 : arr[deque.peekFirst()]);
        }
        return result;
    }

    // ================================
    // Main Method - Testing Functions
    // ================================
    public static void main(String[] args) {

        // ---------------- Max Subarray Sum ----------------
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int result = maxSubarraySum(arr, k);
        System.out.println("1️⃣ Max sum of subarray of size " + k + " = " + result);
        // Expected: 9 (subarray [5,1,3])

        // ---------------- First Negative Integer ----------------
        int[] arr1 = {12, -1, -7, 8, -15, 30, 16, 28};
        int k1 = 3;
        List<Integer> result1 = firstNegInt(arr1, k1);
        System.out.println("2️⃣ First negative integer in every window of size " + k1 + " = " + result1);
        // Expected: [-1, -1, -7, -15, -15, 0]

        // ---------------- Longest Substring (HashSet) ----------------
        String input = "abcabcbb";
        int length = lengthOfLongestSubstring(input);
        System.out.println("3️⃣ Longest substring (HashSet) for \"" + input + "\" = " + length);
        // Expected: 3 ("abc")

        // ---------------- Longest Substring (HashMap) ----------------
        String input2 = "abcdcdea";
        int length1 = lengthOfLongestNonRepeatingCharUsingHASHMAP(input2);
        System.out.println("4️⃣ Longest substring (HashMap) for \"" + input2 + "\" = " + length1);
        // Expected: 5 ("cdcea")

        // ---------------- Longest Substring with K Distinct ----------------
        String input3 = "aabacbebebe";
        int k2 = 3;
        int length2 = lengthOfLongestSubstringKDistinct(input3, k2);
        System.out.println("5️⃣ Longest substring with at most " + k2 + " distinct chars for \"" + input3 + "\" = " + length2);
        // Expected: 7 ("cbebebe")
    }
}
