package SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class MaxAvgSubArray1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int n = sc.nextInt();
        System.out.println("Enter array values: ");
        int[] nums = new int[n];
        for( int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter subarray length: ");
        int k = sc.nextInt();
        sc.close();
        Sol14 sol = new Sol14();
        System.out.println(sol.maxAvg(nums, k));
    }
}
/*
https://leetcode.com/problems/maximum-average-subarray-i

You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. 
Any answer with a calculation error less than 10^-5 will be accepted.

Sliding Window (Fixed Size)

Approach:
• Since we need a contiguous subarray of fixed length k, use the sliding window technique.
• First compute the sum of the first k elements to form the initial window.
• Store this sum as maxSum.
• Then slide the window one element at a time:
  - Add the next element entering the window.
  - Subtract the element leaving the window (nums[i - k]).
• After updating the window sum, compare it with maxSum and update maxSum if necessary.
• Continue sliding the window until the end of the array.
• The maximum average is obtained by dividing maxSum by k.

Time Complexity:
• O(n)
• The array is traversed once after computing the initial window.

Space Complexity:
• O(1)
• Only a few variables are used and no extra data structures are required.
*/
class Sol14{
    public double maxAvg(int[] nums, int k){
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        int maxSum = sum;
        for(int i = k; i < nums.length; i++){
            sum += nums[i];
            sum -= nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum/k;
    }
}