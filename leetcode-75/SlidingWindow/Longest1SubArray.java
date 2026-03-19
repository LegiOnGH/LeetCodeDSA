package SlidingWindow;

import java.util.Scanner;

public class Longest1SubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array values: ");  
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();

        Sol17 sol = new Sol17();
        System.out.println("Longest SubArray of 1's after deleting one element: " + sol.longestSubArray(nums));
    }
}
/*
https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element

Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's in the resulting array. 
Return 0 if there is no such subarray.

Sliding Window (Variable Size) / Two Pointers

Approach:
• Use a sliding window with two pointers (left and right).
• The goal is to maintain a window with at most one zero (since we can delete one element).
• Traverse the array using the right pointer.
• If nums[right] is 0, increment zeroCount.
• If zeroCount becomes greater than 1:
  - Shrink the window from the left until zeroCount ≤ 1.
  - If nums[left] is 0, decrement zeroCount.
• At each step, update maxLength using (right - left).
  - We use (right - left) instead of (right - left + 1)
    because one element (the zero) must be deleted.
• The window always represents a valid subarray where at most one zero exists.

Time Complexity:
• O(n)
• Each element is visited at most twice (once by right pointer and once by left pointer).

Space Complexity:
• O(1)
• Only a few variables are used; no extra data structures are required.
*/
class Sol17{
    public int longestSubArray(int[] nums){
        int zeroCount = 0;
        int left = 0;
        int maxLength = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zeroCount++;
            }
            while(zeroCount > 1){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
