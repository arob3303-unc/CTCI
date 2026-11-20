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

    // Clone Graph Leetcode
    // Uses Node Class
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null; // null check, helps with speed
        Node curr = new Node(node.val);
        map.put(node, curr);
        for (Node n : node.neighbors) {
            if (!map.containsKey(n)) {
                cloneGraph(n);
            }
            curr.neighbors.add(map.get(n));
        }
        return curr;
    }

    // palindromic substrings
    int result = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);
            count(s, i, i + 1);
        }
        return result;
    }

    private void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            result++;
            start--;
            end++;
        }
    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, height[left] * (right - left));
                left++;
            }
            else {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }
        return max;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words =  new HashSet<>(wordDict);
         boolean[] dp = new boolean[s.length()+1];
         dp[0] = true;

         for (int i = 1; i <= s.length(); i++) {
             for (int y = 0; y < i; y++) {
                 if (dp[y] && words.contains(s.substring(y, i))) {
                     dp[i] = true;
                     break;
                 }
             }
         }
         System.out.println(Arrays.toString(dp));
         return dp[s.length()];
    }

    // my solution
//    public boolean hasCycle(Node head) {
//        if (head == null || head.next == null) return false;
//        Node cur = head;
//        Node future = head.next;
//
//        while (future.next != null) {
//            if (future == cur) {
//                return true;
//            }
//            future = future.next.next;
//            cur = cur.next;
//        }
//        return false;
//    }

    // better solution
    public boolean hasCycle(Node head) {
        Node slow =  head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public int missingNumber(int[] nums) {
        int[] tracker = new int [nums.length+1];

        for (int num : nums) {
            tracker[num] = 1;
        }
        for (int i = 0; i < tracker.length; i++) {
            if (tracker[i] == 0) return i;
        }
        return -1;
    }

    // linked list question
    // 143 reorder list
    public void reorderList(Node head) {
        if (head == null || head.next == null) return;

        // head of first half
        Node l1 = head;
        // head of second half
        Node slow = head;

        // tail of second half
        Node fast = head;
        // tail of first half
        Node prev = null;

        // process to split the linked list in half
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        Node l2 = reverse(slow);

        merge(l1, l2);
    }

    private Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void merge(Node l1, Node l2) {
        while (l1 != null && l2 != null) {
            Node l1_next =  l1.next;
            Node l2_next =  l2.next;

            l1.next = l2;

            if (l1_next == null) break;
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }
}
