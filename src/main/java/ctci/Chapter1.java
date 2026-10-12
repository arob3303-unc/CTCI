package ctci;

import java.util.Arrays;
import java.util.HashSet;

public class Chapter1 {

    // my solution
    public static boolean isUnique(String arr) {
        HashSet<Character> mySet = new HashSet<Character>();

        for (int i = 0; i < arr.length(); i++) {
            if (mySet.contains(arr.charAt(i))) {
                return false;
            }
            mySet.add(arr.charAt(i));
        }
        return true;
    }

    // optimal solution
    public static boolean optimalIsUnique(String arr) {
        if (arr.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < arr.length(); i++) {
            int val = arr.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    // my solution
    public static boolean permutation(String arr1, String arr2) {
        if (arr1.length() != arr2.length()) {
            return false;
        }

        int[] charSet1 = new int[128];
        int[] charSet2 = new int[128];

        for (int i = 0; i < arr1.length(); i++) {
            int val = arr1.charAt(i);
            charSet1[val] += 1;
        }
        for (int i = 0; i < arr2.length(); i++) {
            int val = arr2.charAt(i);
            charSet2[val] += 1;
        }

        return Arrays.equals(charSet1, charSet2);
    }
}
