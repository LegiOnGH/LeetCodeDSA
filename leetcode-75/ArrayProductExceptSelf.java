import java.util.Arrays;
import java.util.Scanner;

public class ArrayProductExceptSelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n  = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        Sol7 sol = new Sol7();
        System.out.println(Arrays.toString(sol.productExceptSelf(arr)));
    }
}
/*
https://leetcode.com/problems/product-of-array-except-self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Approach: Prefix and Suffix Product
1. First pass computes prefix products.
   answer[i] contains product of all elements before i.
2. Second pass traverses from right while maintaining
   a running suffix product and multiplies it with prefix.

Time Complexity: O(n)
Two linear passes through the array.
Space Complexity: O(1)
No extra data structures used except the output array.
*/

class Sol7{
    public int[] productExceptSelf(int[] nums){
        int[] answer = new int[nums.length];

        answer[0] = 1;
        for(int i = 1; i < nums.length; i++){
            answer[i] = answer[i-1] * nums[i-1];
        }

        int right = 1;
        for(int i  = nums.length - 1; i >= 0; i--){
            answer[i] *= right;
            right *= nums[i]; 
        }

        return answer;
    }
}
