package ArrayString;
import java.util.Scanner;

public class IncTripletSubsequence{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int length = sc.nextInt();
        System.out.println("Enter values: ");
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        Sol8 sol = new Sol8();
        System.out.println(sol.incTripletSubsequence(arr));

    }
}
/*
https://leetcode.com/problems/increasing-triplet-subsequence
Given an integer array nums, return true,
if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. 
If no such indices exists, return false.

Greedy Algorithm / Array Traversal

Approach:
Traverse the array once while maintaining two variables:
first  → smallest number seen so far
second → smallest number greater than first

For each number:
1. If num <= first, update first
2. Else if num <= second, update second
3. Else num > first and num > second → increasing triplet found

Time Complexity: O(n)
We traverse the array only once.

Space Complexity: O(1)
Only two extra variables are used.
*/
class Sol8{
    public boolean incTripletSubsequence(int[] nums){
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int num: nums){
            if(num <= first){
                first = num;
            } else if(num <= second){
                second = num;
            } else return true;
        }
        return false;
    }
}