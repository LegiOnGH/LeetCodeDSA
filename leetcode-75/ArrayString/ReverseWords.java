package ArrayString;
import java.util.Scanner;

public class ReverseWords{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String s = sc.nextLine();
        sc.close();
        
        Sol6 sol = new Sol6();
        System.out.println(sol.reverseWords(s));
    }
}
/*
https://leetcode.com/problems/reverse-words-in-a-string

Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.

String Manipulation / Parsing

Approach:
• Remove leading and trailing spaces using trim().
• Split the string into words using the regex "\\s+", which splits on one or more spaces.
• This ensures multiple spaces between words are treated as a single separator.
• Traverse the array of words from the last index to the first.
• Append each word to a StringBuilder.
• Add a single space between words while appending (except after the last word).
• Convert the StringBuilder to a string and return it.

Time Complexity:
• O(n)
• n is the length of the string.
• Trimming, splitting, and building the result together process each character roughly once.

Space Complexity:
• O(n)
• The split operation creates an array of words and the StringBuilder stores the final reversed string.
*/
class Sol6{
    public String reverseWords(String s){
        String[] word = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for(int i = word.length - 1; i >= 0 ; i--){
            result.append(word[i]);

            if(i != 0) result.append(" ");
        }
        return result.toString();
    }
}