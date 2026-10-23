package ctci;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
}
