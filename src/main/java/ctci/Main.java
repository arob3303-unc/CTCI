package ctci;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(Chapter1.isUnique("abc")); // true
        System.out.println(Arrays.toString(LeetCode.twoSum(new int[]{1, 2, 3, 4, 5}, 3))); // 2 and 3
        System.out.println(LeetCode.lengthOfLongestSubstring("qwertyuiopasdfghjklzxcvbnm"));
    }
}