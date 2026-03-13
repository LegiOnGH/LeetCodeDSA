package TwoPointers;

import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Scanner;

public class MaxKsum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int n = sc.nextInt();
        System.out.println("Enter array values: ");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter value of k: ");
        int k = sc.nextInt();
        sc.close();

        Sol13 sol = new Sol13();
        System.out.println("Max number of K-Sum Pairs: "+sol.maxKsumPairs(nums, k));
    }
}
/*
https://leetcode.com/problems/max-number-of-k-sum-pairs

You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.

Two Pointers / Sorting

Approach 1: Two Pointer after Sorting
• First sort the array.
• Use two pointers:
  - left starting at the beginning.
  - right starting at the end.
• While left < right:
  - If nums[left] + nums[right] == k:
      • A valid pair is found.
      • Increment the count and move both pointers inward.
  - If the sum is less than k:
      • Increase the sum by moving the left pointer right.
  - If the sum is greater than k:
      • Decrease the sum by moving the right pointer left.
• Continue until the two pointers meet.

Time Complexity:
• O(n log n)
• Sorting takes O(n log n) and the two-pointer traversal takes O(n).

Space Complexity:
• O(1)
• Only a few variables are used besides the input array.
*/
class Sol13{
    public int maxKsumPairs(int[] nums, int k){
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            if(nums[left] + nums[right] == k){
                count++;
                left++;
                right--;
            } else if(nums[left] + nums[right] < k){
                left++;
            } else{
                right--;
            }
        }

        return count;
    }
}

/*
Hash Map / Frequency Counting

Approach 2: HashMap Complement Method
• Traverse the array once.
• For each number, compute its complement:
      complement = k - num
• Check if the complement already exists in the HashMap with frequency > 0.
  - If it exists:
      • A pair can be formed.
      • Increase the operation count.
      • Decrease the frequency of the complement in the map.
  - Otherwise:
      • Store the current number in the map with its frequency.
• The HashMap keeps track of numbers that are waiting to form a valid pair.

Time Complexity:
• O(n)
• Each element is processed once.

Space Complexity:
• O(n)
• The HashMap may store up to n elements in the worst case.

****
HashMap version is faster asymptotically, but the two-pointer version is more space-efficient.
****

class Sol13{
    public int maxKsumPairs(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int num: nums){
            int complement = k - num;

            if(num > k) continue;

            if(map.getOrDefault(complement, 0)>0){
                count++;
                map.put(complement, map.get(complement) - 1);
            }else{
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}
*/