public class String_01 {

    /**
     * Checks if two strings are anagrams of each other
     * Time Complexity: O(n), Space Complexity: O(1) [fixed size array]
     */


    public static boolean anagram(String s1, String s2) {
        int [] a = new int[256]; // Using constant space for ASCII characters

        // Count characters in first string
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i)]++;
        }

        // Subtract characters from second string
        for (int i = 0; i < s2.length(); i++) {
            a[s2.charAt(i)]--;
        }

        // Check all counts are zero
        for (int e : a) {
            if (e != 0) return false;
        }

        return true;
    }



    /**
     * Reverses characters in array between indices i and j (inclusive)
     */
    static void reverseCharacter(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * Reverses words in a string while maintaining word order
     * Time Complexity: O(n), Space Complexity: O(n)
     */


    static String reverseWords(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int start = 0;

        // Reverse each word individually
        for (int end = 0; end <= n; end++) {
            if (end == n || c[end] == ' ') {
                reverseCharacter(c, start, end - 1);
                start = end + 1;
            }
        }

        // Reverse the entire character array
        reverseCharacter(c, 0, n - 1);

        return new String(c);
    }




    public static void main(String[] args) {
        // Test anagram check
        String s1 = "acbda";
        String s2 = "aadbc";
        System.out.println("Are '" + s1 + "' and '" + s2 + "' anagrams? " + anagram(s1, s2));

        // Test word reversal
        String s3 = "Never Give Up";
        System.out.println("Original: " + s3);
        System.out.println("Reversed: " + reverseWords(s3));
    }
}

