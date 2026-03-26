package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RemovingStarFromString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string with stars(*): ");
        String s = sc.nextLine();
        sc.close();
        Sol24 sol = new Sol24();
        System.out.println("String after star removal: "+ sol.removeStars(s));
    }
}
/*
https://leetcode.com/problems/removing-stars-from-a-string

You are given a string s, which contains stars *.
In one operation, you can:
Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.
Note:
The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.

Stack / String Processing

Approach 1: Using Stack (Deque)
• Traverse the string character by character.
• Use a stack (Deque) to keep track of valid characters.
• For each character:
  - If it is '*', remove the top element from the stack (closest left character).
  - Otherwise, push the character onto the stack.
• After processing all characters, the stack contains the final result in reverse order.
• Build the result string by removing elements from the bottom of the stack.

Time Complexity:
• O(n)
• Each character is pushed and popped at most once.

Space Complexity:
• O(n)
• Stack stores characters in the worst case.
*/
class Sol24{
    public String removeStars(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '*'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}
/*
Why use Approach 2 over Stack?
• StringBuilder is faster in practice (less object overhead).
• Directly builds the final string (no need to reverse or reconstruct).
• Cleaner and simpler implementation.

StringBuilder / Simulation (Stack-like behavior)

Approach 2: Using StringBuilder
• Traverse the string character by character.
• Use StringBuilder to simulate stack behavior.
• For each character:
  - If it is '*', remove the last character from StringBuilder.
  - Otherwise, append the character.
• Since StringBuilder supports efficient append and delete from end,
  it behaves like a stack but with less overhead.

Time Complexity:
• O(n)
• Each character is processed once.

Space Complexity:
• O(n)
• StringBuilder stores the resulting characters.

class Sol24{
    public String removeStars(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '*'){
                if(!sb.isEmpty()){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
 */

