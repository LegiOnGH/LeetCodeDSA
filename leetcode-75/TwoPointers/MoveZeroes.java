package TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroes{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int length = sc.nextInt();
        System.out.println("Enter array values: ");
        int[] nums = new int[length];
        for(int i=0; i<length; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();

        Sol10 sol = new Sol10();
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
/*
https://leetcode.com/problems/move-zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Two Pointers / In-place Array Manipulation

Approach 1: Two Pointer Swapping
• Use two pointers:
  - right → scans the array
  - left → indicates the position where the next non-zero element should go.
• Traverse the array using the right pointer.
• Whenever nums[right] is non-zero:
  - Swap nums[left] and nums[right].
  - Increment left.
• This moves every non-zero element to the front while pushing zeroes toward the end.
• Since elements are swapped only when a non-zero is found, the relative order of non-zero elements is preserved.

Time Complexity:
• O(n)
• The array is traversed once.

Space Complexity:
• O(1)
• Only a few variables are used and the operation is done in-place.

*/
class Sol10{
    public void moveZeroes(int[] nums){
        int left = 0;
        int temp = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] != 0){
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
            }
        }
    }
}

/*
Two Pointers / Array Compaction

Approach 2: Non-zero Compaction
• First pass:
  - Traverse the array and copy every non-zero element to the front.
  - Maintain an index (nonZeroes) that tracks where the next non-zero should be placed.
• Second pass:
  - Fill the remaining positions of the array with zeroes.
• This effectively compacts all non-zero elements to the beginning and moves all zeroes to the end.

Time Complexity:
• O(n)
• The array is traversed twice, but both passes are linear.

Space Complexity:
• O(1)
• No extra data structures are used; the array is modified in-place.

***Approach 2 often performs fewer swaps, which can be slightly faster in practice when many zeros exist. 
But both are optimal O(n) / O(1) solutions.***

class Sol10{
    public void moveZeroes(int[] nums){
        int nonZeroes = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[nonZeroes++] = nums[i];
            }
        }
        for(int i = nonZeroes; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
*/
