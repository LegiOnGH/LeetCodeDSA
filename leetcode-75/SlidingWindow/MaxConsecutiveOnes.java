package SlidingWindow;

import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array values: ");
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter value of k: ");
        int k = sc.nextInt();

        Sol16 sol = new Sol16();
        System.out.println("Maximum consecutive ones after flipping k 0's: " + sol.longestOnes(nums, k));
    }
}
/*
https://leetcode.com/problems/max-consecutive-ones-iii

Given a binary array nums and an integer k, 
return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Sliding Window (Variable Size) / Two Pointers

Approach:
• Use a sliding window with two pointers (left and right).
• Expand the window by moving the right pointer.
• Keep track of the number of zeroes in the current window (zeroCount).
• If nums[right] is 0, increment zeroCount.
• If zeroCount exceeds k:
  - Shrink the window from the left until zeroCount ≤ k.
  - If nums[left] is 0, decrement zeroCount before moving left.
• At every step, calculate the window size (right - left + 1) and update maxOne.
• The window always represents a valid subarray where at most k zeroes are flipped.

Time Complexity:
• O(n)
• Each element is visited at most twice (once by right pointer and once by left pointer).

Space Complexity:
• O(1)
• Only a few variables are used; no extra data structures are required.
*/
class Sol16 {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int left = 0;
        int maxOne = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            maxOne = Math.max(maxOne, right - left + 1);
        }
        return maxOne;
    }
}