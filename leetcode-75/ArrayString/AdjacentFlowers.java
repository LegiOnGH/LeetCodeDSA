package ArrayString;
import java.util.Scanner;

public class AdjacentFlowers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of plots: ");
        int plot = sc.nextInt();
        int flowerbed[] = new int[plot];
        System.out.println("Enter if plot is planted: "); //1 for planted, 0 for not
        for(int i = 0; i < plot; i++){
            flowerbed[i] = sc.nextInt();
        }
        System.out.println("Enter no. of flowers to be planted: ");
        int  n = sc.nextInt();
        sc.close();
        
        Sol4 sol = new Sol4();
        System.out.println(sol.canPlaceFlowers(flowerbed, n));
    }
}
/*
https://leetcode.com/problems/can-place-flowers

You have a long flowerbed in which some of the plots are planted, and some are not. 
However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, 
return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

Greedy Algorithm / Array Traversal

Approach:
• Traverse the flowerbed array from left to right.
• For each plot, check if it is empty (value = 0).
• If the plot is empty, check its adjacent plots:
  - The left plot is considered 0 if the current plot is the first index.
  - The right plot is considered 0 if the current plot is the last index.
• If both adjacent plots are empty (left == 0 and right == 0), a flower can be planted.
• Plant the flower by setting flowerbed[i] = 1 and increase the count.
• If the number of planted flowers becomes greater than or equal to n, return true immediately.
• After traversing the entire array, return whether the count of newly planted flowers is at least n.

Time Complexity:
• O(n)
• The flowerbed array is traversed once, and each plot is checked only once.

Space Complexity:
• O(1)
• No additional data structures are used; the algorithm modifies the input array directly.
*/
class Sol4{
    public boolean canPlaceFlowers(int []flowerbed, int n){
        int count = 0;
        for(int i = 0; i < flowerbed.length ; i++){
            if(flowerbed[i] == 0){
                int left = (i == 0)? 0 : flowerbed[i-1];
                int right = (i == flowerbed.length - 1)? 0 : flowerbed[i+1];
                if(left == 0 && right == 0){
                    flowerbed[i] = 1;
                    count++;
                    if(count>=n) return true;
                }
            }
        }
        return count>=n;
    }
}