package ArrayString;

import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter characters without space (eg. aabbccc) : ");
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        sc.close();
        
        Sol9 sol = new Sol9();
        int length = sol.compressedString(chars);
        System.out.println("Length of Compressed String: "+ length);
        System.out.print("Compressed String: ");
        for(int i = 0; i<length; i++){
            System.out.print(chars[i]);
        }
    }
}
/*
https://leetcode.com/problems/string-compression

Given an array of characters chars, compress it using the following algorithm:
Begin with an empty string s. For each group of consecutive repeating characters in chars:
- If the group's length is 1, append the character to s.
- Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
Note that group lengths that are 10 or longer will be split into multiple characters in chars.
After you are done modifying the input array, return the new length of the array.
You must write an algorithm that uses only constant extra space.
Note: The characters in the array beyond the returned length do not matter and should be ignored.

Two Pointers / In-place Array Manipulation / Run-Length Encoding

Approach:
• Use two pointers: read and write.
• The read pointer scans the array to identify groups of consecutive repeating characters.
• For each group:
  - Store the current character.
  - Count how many times it appears consecutively.
• Write the character at the write pointer position in the same array.
• If the count is greater than 1, convert the count into characters and write each digit into the array.
• Move the write pointer forward as characters are written.
• Continue this process until the entire array is processed.
• Return the final position of the write pointer, which represents the new compressed length.

Time Complexity:
• O(n)
• Each character is read once by the read pointer, and each compressed character is written once.

Space Complexity:
• O(1)
• The compression is done in-place using only a few variables (read, write, count).
• No extra data structures proportional to input size are used.
*/
class Sol9{
    public int compressedString(char[] chars){
        int read = 0;
        int write = 0;

        while(read < chars.length){
            char current = chars[read];
            int count = 0;

            while(read < chars.length && chars[read] == current){
                read++;
                count++;
            }

            chars[write++] = current;

            if(count > 1){
                char[] digits = String.valueOf(count).toCharArray();
                for(char c : digits){
                    chars[write++] = c;
                }
            }
        }
        return write;
    }
}