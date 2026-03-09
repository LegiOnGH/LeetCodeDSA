package ArrayString;
import java.util.Scanner;

public class MergeStringsAlternatively {
    public static void main( String []args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first word");
        String word1 = sc.nextLine();
        System.out.println("Enter second word");
        String word2 = sc.nextLine();
        sc.close();

        Sol1 sol = new Sol1();
        String result = sol.mergeAlternate(word1, word2);
        System.out.println("Merged String: "+result);
    }
}
/*
https://leetcode.com/problems/merge-strings-alternately

You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. 
If a string is longer than the other, append the additional letters onto the end of the merged string.
Return the merged string.

Two Pointers / String Traversal

Approach:
• Create a StringBuilder with capacity equal to the sum of lengths of both strings to avoid resizing.
• Find the maximum length between the two strings.
• Iterate from index 0 to max length.
• At each index:
  - If the index exists in word1, append its character.
  - If the index exists in word2, append its character.
• This alternates characters from both strings starting with word1.
• If one string is longer, the remaining characters are appended automatically when the other string runs out.

Time Complexity:
• O(n + m)
• n = length of word1, m = length of word2.
• Each character from both strings is visited and appended exactly once.

Space Complexity:
• O(n + m)
• StringBuilder stores the merged result which can contain up to n + m characters.
*/
class Sol1{
    public String mergeAlternate(String s1, String s2){
        StringBuilder sb = new StringBuilder(s1.length()+s2.length());
        int max = Math.max(s1.length(), s2.length());
        for(int i = 0; i < max; i++){
            if(i<s1.length()){
                sb.append(s1.charAt(i));
            }
            if(i<s2.length()){
                sb.append(s2.charAt(i));
            }
        }
        return sb.toString();
    }
}
