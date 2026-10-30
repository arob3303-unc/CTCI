package ctci;

import java.util.Arrays;
import java.util.HashSet;

public class Chapter1 {

    // 1.1
    // my solution
    public static boolean isUnique(String s) {
        HashSet<Character> mySet = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (mySet.contains(s.charAt(i))) {
                return false;
            }
            mySet.add(s.charAt(i));
        }
        return true;
    }

    // optimal solution
    public static boolean optimalIsUnique(String s) {
        if (s.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    // 1.2
    // my solution
    public static boolean permutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charSet1 = new int[128];
        int[] charSet2 = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            int val = s1.charAt(i);
            charSet1[val] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            int val = s2.charAt(i);
            charSet2[val] += 1;
        }

        return Arrays.equals(charSet1, charSet2);
    }

    // optimal solution
    public static boolean optimalPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charSet1 = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            int val = s1.charAt(i);
            charSet1[val] += 1;
        }

        for (int i = 0; i < s2.length(); i++) {
            int val = s2.charAt(i);
            charSet1[val] -= 1;
            if (charSet1[val] < 0) {
                return false;
            }
        }
        return true;
    }

    // 1.3
    // my solution
    public static void replaceSpaces(char[] str, int length) {
        
    }

    // 1.6 String Compression
    public static String stringCompression(String s) {
        StringBuilder compression = new StringBuilder();
        int currCount = 0;

        for (int i = 0; i < s.length(); i++) {
            currCount++;

            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
                compression.append(s.charAt(i));
                compression.append(currCount);
                currCount = 0;
            }
        }
        return compression.toString();
    }

    // 1.7 matrix rotate 90 degrees
    public static void rotateMatrix(int[][] matrix, int n) {
        // book solution
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; ++i) {
                int offset = i - first;

                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }

    // my solution
    public static void rotateMatrixMine(int[][] matrix) {
        int n = matrix.length;

        // keep track of ring
        for (int i = 0; i < n / 2; i++) {
            int last = n - i - 1;
            for (int j = i; j < last; j++) {
                int offset = j - i;

                int top = matrix[i][j];
                matrix[i][j] = matrix[last-offset][i];
                matrix[last-offset][i] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }


    // 1.8 "zero matrix". Given MxN matrix, if an element is 0, the row and column for the 0 should all be 0s
    public static void zeroMatrix(int[][] matrix) {
        // my solution

        // my idea, create a copy of the matrix. This is to check if a zero is a real zero.
        // then if it is real, change the column and row into all zeros.
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] copyMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && copyMatrix[i][j] == 0) {
                    row(matrix, i);
                    column(matrix, j);
                }
            }
        }
    }
    public static void row(int[][] matrix, int i) {
        for (int m = 0; m < matrix[0].length; m++) {
            matrix[i][m] = 0;
        }
    }

    public static void column(int[][] matrix, int j) {
        for (int n = 0; n < matrix.length; n++) {
            matrix[n][j] = 0;
        }
    }

    //
    public static void zeroMatrixBook(int[][] matrix) {
        // first book solution
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                row(matrix, i);
            }
        }

        // nullify columns
        for (int j = 0; j < column.length; j++) {
            if (column[j]) {
                column(matrix, j);
            }
        }
    }

    public static void zeroMatrixBook2(int[][] matrix) {
        // 2nd book solution. brings space complexity to O(1) by using the first row and column in matrix instead
        // of making a new array

        boolean rowHasZero = false;
        boolean colHasZero = false;

        // check if first row has a zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // check for column, same as above
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        // now check rest of matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // nullify columns on first row
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                column(matrix, j);
            }
        }

        // nullify rows on first column
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                row(matrix, i);
            }
        }

        // nullify first rows and columns
        if (rowHasZero) {
            row(matrix, 0);
        }

        if (colHasZero) {
            column(matrix, 0);
        }
    }


    // 1.9 String Rotation
    public static boolean stringRotation(String s1, String s2) {
        // my solution...
        // and book solution since I have to use isSubstring

        if (s1.length() == s2.length() && !s1.isEmpty()) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }
}
