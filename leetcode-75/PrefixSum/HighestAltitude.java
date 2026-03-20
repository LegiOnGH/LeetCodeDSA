package PrefixSum;

import java.util.Scanner;

public class HighestAltitude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int n = sc.nextInt();
        int[] gain = new int[n];
        System.out.println("Enter gain values: ");
        for(int i = 0; i < n; i++){
            gain[i] = sc.nextInt();
        }
        sc.close();

        Sol18 sol =  new Sol18();
        System.out.println("Highest Altitude: "+sol.highestAltitude(gain));
    }
}
/*
https://leetcode.com/problems/find-the-highest-altitude

There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. 
The biker starts his trip on point 0 with altitude equal 0.
You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). 
Return the highest altitude of a point.

Prefix Sum / Array Traversal

Approach:
• The problem represents altitude changes, where each element in gain
  indicates the net gain/loss from the previous point.
• Start with an initial altitude of 0.
• Traverse the gain array and maintain a running sum (current altitude).
• At each step:
  - Add the current gain to the running sum.
  - Update maxHeight if the current altitude is greater.
• The maximum value reached during traversal is the highest altitude.

Time Complexity:
• O(n)
• The array is traversed once.

Space Complexity:
• O(1)
• Only a few variables are used; no extra data structures are required.
*/
class Sol18{
    public int highestAltitude(int[] gain){
        int altitude = 0, maxHeight = 0;
        for(int i = 0; i < gain.length; i++){
            altitude += gain[i];
            maxHeight = Math.max(maxHeight, altitude);
        }
        return maxHeight;
    }
}
