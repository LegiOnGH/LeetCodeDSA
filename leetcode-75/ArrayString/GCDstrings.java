package ArrayString;
import java.util.Scanner;

public class GCDstrings{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1: ");
        String str1 = sc.nextLine();
        System.out.println("Enter String 2: ");
        String str2 = sc.nextLine();
        sc.close();

        Sol2 sol = new Sol2();
        System.out.println("GCD of two strings: "+ sol.gcdOfStrings(str1, str2));
    }
}
/*
https://leetcode.com/problems/greatest-common-divisor-of-strings

For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Mathematical Pattern / Euclidean Algorithm / String Pattern

Approach:
• First check whether the strings can form a valid repeating pattern.
• If (str1 + str2) is not equal to (str2 + str1), then no common divisor string exists because the
  strings are not composed of the same repeating base pattern.
• If they match, it means both strings are built from the same repeating substring.
• The length of the greatest common divisor string must be the GCD of the lengths of str1 and str2.
• Compute the GCD of the two string lengths using the Euclidean algorithm.
• Return the substring of str1 from index 0 to gcdLen, which represents the largest repeating unit
  that can divide both strings.

Time Complexity:
• O(n + m)
• n = length of str1, m = length of str2.
• Concatenation and comparison of the strings take O(n + m) time.
• The Euclidean GCD calculation takes O(log(min(n, m))) which is negligible compared to string operations.

Space Complexity:
• O(n + m)
• Temporary space is used when creating the concatenated strings (str1 + str2) and (str2 + str1).
*/

class Sol2{
    public String gcdOfStrings(String str1, String str2){
        if(!(str1+str2).equals(str2+str1)){
            return "Not exists";
        }
        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }
    public int gcd(int s1, int s2){
        if(s2 == 0)
            return s1;
        return gcd(s2, s1 % s2);
    }
}