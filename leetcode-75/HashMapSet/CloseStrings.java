package HashMapSet;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CloseStrings{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1: ");
        String word1 = sc.nextLine();
        System.out.println("Enter String 2: ");
        String word2 = sc.nextLine();
        sc.close();
        Sol22 sol = new Sol22();
        System.out.println("Are two strings close: " + (sol.closeStrings(word1, word2)?"Yes" :"No"));
    }
}
/*
https://leetcode.com/problems/determine-if-two-strings-are-close

Two strings are considered close if you can attain one from the other using the following operations:
Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.
Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

HashMap / Frequency Counting / Sorting

Approach 1:
• First check if both strings have the same length.
  - If not, they cannot be close.
• Count the frequency of each character in both strings using two HashMaps.
• Check if both strings contain the same set of characters:
  - Compare map1.keySet() with map2.keySet().
  - If they differ, return false (Operation 2 requires same characters).
• Extract frequency values from both maps into lists.
• Sort both frequency lists.
• If the sorted frequency lists are equal, return true.
  - This works because frequencies can be rearranged using allowed operations.

Time Complexity:
• O(n log n)
• Counting frequencies takes O(n), sorting frequency lists takes O(k log k)
  where k ≤ 26 (number of distinct characters).

Space Complexity:
• O(n)
• HashMaps and lists store frequencies of characters.
 */
class Sol22{
    public boolean closeStrings(String word1, String word2){
        if(word1.length() != word2.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c : word1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0)+ 1);
        }
        for(char c : word2.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0)+ 1);
        }
        if(!map1.keySet().equals(map2.keySet())) return false;
        ArrayList<Integer> l1 = new ArrayList<>(map1.values());
        ArrayList<Integer> l2 = new ArrayList<>(map2.values());
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }
}

/*

Array / Frequency Counting / Sorting

Approach 2 (Optimized for lowercase letters):
• First check if both strings have the same length.
• Use two arrays of size 26 to store frequencies of characters.
• Traverse both strings and fill freq1 and freq2.
• Ensure both strings have the same set of characters:
  - For each index i (0 to 25), check:
    • If one frequency is zero and the other is not → return false.
• Sort both frequency arrays.
• If sorted arrays are equal, return true.

Time Complexity:
• O(n)
• Counting takes O(n), sorting fixed-size arrays (26) is O(1).

Space Complexity:
• O(1)
• Fixed-size arrays (26) are used regardless of input size.

class Sol22{
    public boolean closeStrings(String word1, String word2){
        if(word1.length() != word2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char c : word1.toCharArray()){
            freq1[c - 'a']++;
        }
        for(char c : word2.toCharArray()){
            freq2[c - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) return false;
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }
}
*/