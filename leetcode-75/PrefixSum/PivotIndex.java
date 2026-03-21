package PrefixSum;

import java.util.Scanner;

public class PivotIndex{
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

        Sol19 sol = new Sol19();
        System.out.println("Leftmost pivot point: " + sol.leftmostPivot(nums));
    }
}
/*
https://leetcode.com/problems/find-pivot-index

Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. 
This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.

Prefix Sum / Array Traversal

Approach:
• First compute the total sum of the array.
• Initialize leftSum = 0.
• Traverse the array:
  - For each index i, the right sum can be calculated as:
        rightSum = totalSum - leftSum - nums[i]
  - If leftSum == rightSum, then i is the pivot index.
  - Otherwise, add nums[i] to leftSum and continue.
• Return the first (leftmost) index where the condition is satisfied.
• If no such index exists, return -1.

Time Complexity:
• O(n)
• One pass to compute totalSum and one pass to find the pivot index.

Space Complexity:
• O(1)
• Only constant extra variables are used.
*/
class Sol19{
    public int leftmostPivot(int[] nums){
        int totalSum = 0;
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            if(leftSum == totalSum - leftSum - nums[i]){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}