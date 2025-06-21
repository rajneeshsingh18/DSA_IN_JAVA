import java.util.HashSet;
import java.util.Set;

public class Array_04 {

    /**
     * Prefix Sum Technique:
     * ----------------------------------
     * Find if there exists a subarray with a sum of 0.
     *
     * Logic:
     * - We keep adding elements to a cumulative sum (prefix sum).
     * - If the prefix sum is seen again in a HashSet, it means the subarray between the two indices has a sum of 0.
     *
     * Example: {1, 2, -3, 3}
     * Prefix sum: 1, 3, 0 => Since 0 is seen, subarray exists.
     */
    public static boolean subArrayWithZeroSum(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // If prefix sum becomes 0 or is already present, zero-sum subarray found
            if (sum == 0 || set.contains(sum)) {
                return true;
            }

            // Store the prefix sum
            set.add(sum);
        }

        return false;
    }

    /**
     * Print a matrix (n x n) in row-wise order
     */
    public static void printMatrix(int a[][]) {
        int n = a.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(a[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(); // For better spacing
    }

    /**
     * Transpose a square matrix (n x n)
     * Swaps elements across the diagonal
     */
    public static void transpose(int a[][]) {
        int n = a.length;
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                int swap = a[row][col];
                a[row][col] = a[col][row];
                a[col][row] = swap;
            }
        }
    }

    /**
     * Rotate a square matrix by 90 degrees clockwise
     *
     * Steps:
     * 1. Transpose the matrix
     * 2. Reverse each row
     */
    static void rotateAMatrix(int a[][]) {
        int n = a.length;

        transpose(a); // Step 1

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int swap = a[i][j];
                a[i][j] = a[i][n - j - 1];
                a[i][n - j - 1] = swap;
            }
        }
    }

    /**
     * Search for an element in a matrix that is sorted row-wise and column-wise
     *
     * Start from top-right corner and move:
     * - Left if current > key
     * - Down if current < key
     */
    public static boolean searchInAMatrix(int a[][], int key) {
        int i = 0;
        int j = a[0].length - 1; // Use a[0].length for accurate column size

        while (i < a.length && j >= 0) {
            if (a[i][j] == key) {
                return true;
            } else if (key > a[i][j]) {
                i++; // Move down
            } else {
                j--; // Move left
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Prefix Sum: Check for subarray with sum 0
        int a[] = {2, 3, 1, -4, 4, -2};
        System.out.println("Subarray with zero sum: " + subArrayWithZeroSum(a));

        // Original matrix
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Transpose matrix
        transpose(matrix);
        System.out.println("After Transpose:");
        printMatrix(matrix);

        // Rotate matrix by 90 degrees
        rotateAMatrix(matrix);
        System.out.println("After 90 Degree Rotation:");
        printMatrix(matrix);

        // Matrix sorted row-wise and column-wise
        int sortedMatrix[][] = {
                {1, 4, 5, 7},
                {2, 5, 6, 9},
                {6, 10, 11, 13},
                {8, 12, 15, 18}
        };

        int key = 8; // Element to search
        System.out.println("Key " + key + " found in matrix: " + searchInAMatrix(sortedMatrix, key));
    }
}
