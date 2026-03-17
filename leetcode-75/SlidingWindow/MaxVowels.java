package SlidingWindow;

import java.util.Scanner;

public class MaxVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        System.out.println("Enter subarray length: ");
        int k = sc.nextInt();
        sc.close();
        Sol15 sol = new Sol15();
        System.out.println(sol.maxVowels(s, k));
    }
}
/*
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Sliding Window (Fixed Size)

Approach:
• Use a sliding window of size k to track the number of vowels in the current substring.
• First, count the number of vowels in the initial window of size k.
• Store this count as both currentVowels and maxVowels.
• Then slide the window across the string:
  - For each new character entering the window (index i), check if it is a vowel and increment currentVowels if true.
  - For the character leaving the window (index i - k), check if it is a vowel and decrement currentVowels if true.
• After updating, compare currentVowels with maxVowels and update maxVowels if needed.
• If maxVowels reaches k, return k early since this is the maximum possible number of vowels in a window of size k.
• Continue until the end of the string.

Time Complexity:
• O(n)
• Each character is processed once while sliding the window.

Space Complexity:
• O(1)
• Only a few variables are used; no extra data structures are required.
*/
class Sol15 {
    public int maxVowels(String s, int k) {
        int currentVowels = 0;
        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))){
                currentVowels++;
            }
        }
        int maxVowels = currentVowels;
        for(int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                currentVowels++;
            }
            if(isVowel(s.charAt(i - k))){
                currentVowels--;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
            if(maxVowels == k) return k;
        }
        return maxVowels;
    }
    private boolean isVowel(char c){
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
           c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
}
}