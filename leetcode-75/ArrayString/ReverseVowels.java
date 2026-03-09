package ArrayString;
import java.util.Scanner;

public class ReverseVowels{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word:  ");
        String s = sc.nextLine();
        sc.close();
        Sol5 sol =  new Sol5();
        System.out.println(sol.reverseVowels(s));
    }
}
/*
https://leetcode.com/problems/reverse-vowels-of-a-string

Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Two Pointers

Approach:
• Convert the string into a character array to allow in-place modification.
• Use the two-pointer technique with one pointer starting from the beginning (left)
  and the other from the end (right).
• Move the left pointer forward until a vowel is found.
• Move the right pointer backward until a vowel is found.
• When both pointers point to vowels, swap the characters.
• Move both pointers inward and repeat the process.
• Continue until the two pointers meet or cross.
• Finally convert the modified character array back into a string and return it.

Time Complexity:
• O(n)
• Each character is visited at most once by the two pointers.

Space Complexity:
• O(n)
• A character array of size n is created to modify the string.
*/
class Sol5{
    public String reverseVowels(String s){
        char arr[] = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left<right){
            while(left<right && !isVowel(arr[left])){
                left++;
            }
            while(left<right && !isVowel(arr[right])){
                right--;
            }
            //swap
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return new String(arr);
    }
    public boolean isVowel(char c){
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}