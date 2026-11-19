package ctci;

import java.util.*;

// Help with syntax when submitting leetcode problems
public class LeetCode {


    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int missing_value = target - nums[i];
            if (myMap.containsKey(missing_value)) {
                return new int[]{myMap.get(missing_value), i};
            }
            myMap.put(nums[i], i);
        }
        return new int[]{0,0};
    }



    public static int lengthOfLongestSubstring(String s) {
        Set<Character> mySet = new HashSet<>();
        int left = 0;
        int longest = 0;

        for (int right = 0; right < s.length(); right++) {
            while (mySet.contains(s.charAt(right))) {
                mySet.remove(s.charAt(left));
                left++;
            }
            mySet.add(s.charAt(right));
            longest = Integer.max(longest, right - left + 1);
        }
        return longest;
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> UniqueNumbers =  new HashSet<>();
        for (int num : nums) {
            UniqueNumbers.add(num);
        }

        int curr = 1;
        int longest = 0;

        for (int num : UniqueNumbers) {
            if (!UniqueNumbers.contains(num - 1)) {
                curr = 1;
                while (UniqueNumbers.contains(num + 1)) {
                    num++;
                    curr++;
                }
                longest = Math.max(longest, curr);
            }
        }
        return longest;
    }

//    public static String longestPalindrome(String s) {
//        int max_length = 0;
//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                if (isPalindrome(s.substring(i, j+1))) {
//                    int len = j - i + 1;
//                    if (len > max_length) {
//                        max_length = len;
//                        result.setLength(0);
//                        result.append(s, i, j + 1);
//                    }
//                }
//            }
//        }
//        return result.toString();
//    }
//
//    public static Boolean isPalindrome(String s) {
//        if (s == null || s.isEmpty()) return true;
//        if (s.length() == 1) return true;
//        int left = 0;
//        int right = s.length() - 1;
//
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) return false;
//            left++;
//            right--;
//        }
//        return true;
//    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0, maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            int odd  = expand(s, i, i);       // center on char i      ("aba")
            int even = expand(s, i, i + 1);   // center between i, i+1 ("abba")
            int len = Math.max(odd, even);

            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;    // works for both odd and even lengths
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;              // length of the palindrome found
    }
}
