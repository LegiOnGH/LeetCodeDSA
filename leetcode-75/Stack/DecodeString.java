package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecodeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter encoded string: ");
        String s = sc.nextLine();
        sc.close();

        Sol26 sol = new Sol26();
        System.out.println("Decoded String: "+sol.decodeString(s));
    }
}
/*
https://leetcode.com/problems/decode-string

Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. 
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
For example, there will not be input like 3a or 2[4].

Stack / String Processing / Nested Structure Parsing

Approach:
• Use two stacks:
  - countStack → stores repetition counts (k values)
  - stringStack → stores previous string states
• Traverse the string character by character:
  - If the character is a digit:
      • Build the number k (handle multi-digit numbers).
  - If '[' is encountered:
      • Push the current k into countStack.
      • Push the current string into stringStack.
      • Reset current string and k.
  - If ']' is encountered:
      • Pop the repeat count from countStack.
      • Pop the previous string from stringStack.
      • Append the current string 'repeat' times to the previous string.
      • Update current string.
  - If it is a letter:
      • Append it to the current string.
• After traversal, current contains the fully decoded string.

Time Complexity:
• O(n * k)
• n = length of input string.
• In worst case, characters may be repeated k times (due to decoding).

Space Complexity:
• O(n)
• Stacks and StringBuilder store intermediate results.
*/
class Sol26{
    public String decodeString(String s){
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int k = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            }else if(c == '['){
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            }else if(c == ']'){
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();
                for(int i = 0; i < repeat; i++){
                    prev.append(current);
                }
                current =  prev;
            }else{
                current.append(c);
            }
        }
        return current.toString();
    }
}