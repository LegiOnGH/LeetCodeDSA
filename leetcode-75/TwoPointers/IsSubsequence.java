package TwoPointers;

import java.util.Scanner;

public class IsSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string s: ");
        String s = sc.nextLine();
        System.out.println("Enter string t: ");
        String t = sc.nextLine();
        sc.close();
        Sol11 sol = new Sol11();
        System.out.println(sol.isSubsequence(s, t));
    }
}
/*
https://leetcode.com/problems/is-subsequence

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Two Pointers / String Traversal

Approach 1: Two Pointer Scan
• Use two pointers:
  - i → traverses string s
  - j → traverses string t
• Iterate while both pointers are within bounds.
• If characters match (s[i] == t[j]):
  - Move pointer i forward.
• Always move pointer j forward.
• If pointer i reaches the end of s, it means every character of s
  was found in order inside t, so s is a subsequence of t.

Time Complexity:
• O(n + m)
• n = length of s, m = length of t.
• Each character of both strings is visited at most once.

Space Complexity:
• O(1)
• Only two pointer variables are used.
*/
class Sol11{
    public boolean isSubsequence(String s, String t){
        int i=0;
        int j=0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
/*
String Traversal / Nested Search

Approach 2: Nested Search
• Traverse string s character by character.
• For each character in s, search for the same character in t
  starting from the last matched position.
• Maintain a variable (l) to remember the position in t where the
  previous match occurred.
• Once a match is found:
  - Increment the match count.
  - Update l to search from the next position in t.
• After processing all characters in s, check if the number of matches
  equals the length of s.

Time Complexity:
• O(n × m) in the worst case
• For each character in s, the algorithm may scan a large portion of t.

Space Complexity:
• O(1)
• Only a few variables are used.

****
• In many practical cases where matches occur early, the inner loop terminates quickly due to the break statement.
• The pointer `l` ensures that already scanned parts of string `t` are not revisited after a match.
• This can reduce the number of comparisons in typical inputs, making the approach faster in practice 
  despite having a worse theoretical worst-case complexity.
****

class Sol11{
    public boolean isSubsequence(String s, String t){
        int same = 0;
        int l = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = l; j < t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    same++;
                    l = j + 1;
                    break;
                }
            }
        }
        return same == s.length();
    }
}
*/