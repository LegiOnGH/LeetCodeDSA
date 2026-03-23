package HashMapSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class UniqueNoOfOccur {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array values: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        
        Sol21 sol = new Sol21();
        System.out.println("Unique number of  occurrences: " + sol.uniqueOccur(arr));
    }
}
/*
https://leetcode.com/problems/unique-number-of-occurrences

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

HashMap + HashSet / Frequency Counting

Approach:
• First count the frequency of each number using a HashMap:
  - Key → number
  - Value → its occurrence count
• Traverse the array and update the frequency using map.getOrDefault().
• Then use a HashSet to store the frequencies.
• Iterate through the values (frequencies) of the map:
  - Try adding each frequency to the set.
  - If set.add(freq) returns false, it means the frequency already exists,
    so occurrences are not unique → return false.
• If all frequencies are added successfully, return true.

Time Complexity:
• O(n)
• Building the frequency map takes O(n), and checking uniqueness also takes O(n).

Space Complexity:
• O(n)
• HashMap stores frequencies and HashSet stores unique frequency values.
 */
class Sol21{
    public boolean uniqueOccur(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);

        HashSet<Integer> set = new HashSet<>();
        for(int freq : map.values()){
            if(!set.add(freq)) return false; // alternatively, if(set.contains(freq)){return false;} set.add(freq);
        }
        return true;
    }
}
