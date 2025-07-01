import java.util.*;

public class String_02 {

    /**
     * Naive pattern matching algorithm
     * Time Complexity: O(n*m), Space Complexity: O(1)
     */


    static void patternMatching(String s, String p) {
        int n = s.length();
        int m = p.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            for (; j < m; j++) {
                if (s.charAt(i + j) != p.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                System.out.println("Pattern found at " + i);
            }
        }
    }



    /**
     * Finds length of longest possible palindrome from characters
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    public static int lenghthOfLongestPalindrom(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                res += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }

        if (set.size() > 0) {
            res += 1;
        }
        return res;
    }



    /**
     * Checks if one string is rotation of another
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static boolean rotationalString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String doubleString = s1 + s1;
        return doubleString.contains(s2);
    }




    /**
     * Finds all anagram occurrences of p in s using sliding window
     * Time Complexity: O(n), Space Complexity: O(1)
     */


    public static List<Integer> findAllAnagrams(String s, String p) {
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        List<Integer> result = new ArrayList<>();

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            if (i >= p.length() - 1 && Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }



    /**
     * Groups anagrams together using frequency map
     * Time Complexity: O(n*k), Space Complexity: O(n)
     */
    public static List<List<String>> groupAnagrams(String[] str) {
        if (str == null || str.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> freqStringMap = new HashMap<>();

        for (String s : str) {
            String frequencyString = getFrequencyString(s);

            if (freqStringMap.containsKey(frequencyString)) {
                freqStringMap.get(frequencyString).add(s);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(s);
                freqStringMap.put(frequencyString, strList);
            }
        }

        return new ArrayList<>(freqStringMap.values());
    }



    /**
     * Helper method to create frequency string for groupAnagrams
     */
    private static String getFrequencyString(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder frequencyString = new StringBuilder("");
        char c = 'a';
        for (int i : freq) {
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }

        return frequencyString.toString();
    }




    public static void main(String[] args) {
        // Test pattern matching
        String s = "abcabdabbacbda";
        String p = "bda";
        System.out.println("Pattern matching results:");
        patternMatching(s, p);



        // Test longest palindrome length
        String s1 = "abccccdd";
        System.out.println("\nLongest palindrome length: " + lenghthOfLongestPalindrom(s1));



        // Test rotational strings
        String s2 = "abcd";
        String s3 = "cdab";
        System.out.println("\nAre strings rotations? " + rotationalString(s2, s3));



        // Test find all anagrams
        String s5 = "cbaebabacd";
        String p1 = "abc";
        List<Integer> result1 = findAllAnagrams(s5, p1);
        System.out.println("\nAnagram indices: " + result1);



        // Test group anagrams
        String[] input1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("\nGrouped anagrams:");
        System.out.println(groupAnagrams(input1));
    }
}

