package HashMapSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DiffOfTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array1 length: ");
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter array1 values: ");
        for(int i = 0; i < n1; i++){
            nums1[i] = sc.nextInt();
        }
        System.out.println("Enter array2 length: ");
        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter array2 values: ");
        for(int i = 0; i < n2; i++){
            nums2[i] = sc.nextInt();
        } 
        sc.close();

        Sol20 sol = new Sol20();
        System.out.println("Difference of two arrays: " + sol.diffOfTwoArrays(nums1, nums2));
    }
}
/*
https://leetcode.com/problems/find-the-difference-of-two-arrays

Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
  - answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
  - answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

HashSet / Set Operations

Approach:
• Use two HashSets to store distinct elements of nums1 and nums2.
• Insert all elements of nums1 into set s1 and all elements of nums2 into set s2.
• This automatically removes duplicates.
• Create two lists:
  - l1 → elements present in s1 but not in s2
  - l2 → elements present in s2 but not in s1
• Traverse s1:
  - If an element is not present in s2, add it to l1.
• Traverse s2:
  - If an element is not present in s1, add it to l2.
• Return both lists as the final answer.

Time Complexity:
• O(n + m)
• n = size of nums1, m = size of nums2.
• Building sets and checking membership both take linear time on average.

Space Complexity:
• O(n + m)
• Two HashSets are used to store unique elements from both arrays.
*/
class Sol20{
    public List<List<Integer>> diffOfTwoArrays(int[] nums1, int[] nums2){
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for(int num : nums1) s1.add(num);
        for(int num : nums2) s2.add(num);

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for(int num : s1){
            if(!s2.contains(num)){
                l1.add(num);
            }
        }
        for(int num : s2){
            if(!s1.contains(num)){
                l2.add(num);
            }
        }
        return Arrays.asList(l1, l2);
    }
}