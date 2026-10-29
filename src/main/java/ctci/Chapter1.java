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
}
