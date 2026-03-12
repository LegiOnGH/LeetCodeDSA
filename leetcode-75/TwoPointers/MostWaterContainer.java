package TwoPointers;

import java.util.Scanner;

public class MostWaterContainer{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of lines: ");
        int n = sc.nextInt();
        System.out.println("Enter height of each line: ");
        int[] height = new int[n];
        for(int i = 0; i < n; i++){
            height[i] = sc.nextInt();
        }
        sc.close();
        Sol12 sol = new Sol12();
        System.out.println("Maximum amount of water: "+ sol.maxArea(height));
    }
}
/*
https://leetcode.com/problems/container-with-most-water

You are given an integer array height of length n. There are n vertical lines drawn such that - 
the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Two Pointers / Greedy

Approach:
• Use two pointers:
  - l starting from the left end of the array.
  - r starting from the right end.
• At each step, the container area depends on:
  - height = min(height[l], height[r])
  - width  = r - l
• Compute the area using the current pair of lines and update maxArea if needed.
• Move the pointer pointing to the shorter line inward:
  - If height[l] < height[r], increment l.
  - Otherwise, decrement r.
• This works because the shorter line limits the container height.
  Moving the taller line cannot increase the area since the width would decrease
  while the limiting height remains unchanged.
• Continue until the two pointers meet.

Time Complexity:
• O(n)
• Each pointer moves inward at most n times.

Space Complexity:
• O(1)
• Only a few variables are used; no extra data structures are required.
*/

class Sol12{
    public int maxArea(int[] height){
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        

        while(l < r){
            int h = Math.min(height[l], height[r]);
            int width = r - l;
            int area = h * width; 

            if(area > maxArea) maxArea = area;

            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }

        return maxArea;
    }
}


/*
Alternative Approach:

• The same two-pointer greedy idea is used, but the order of operations differs.
• First determine which side has the smaller height.
• Move that pointer inward immediately.
• Store the limiting height before moving the pointer.
• Since the pointer was moved before calculating the area,
  the width is adjusted using (r - l + 1) to represent the previous width.
• Compute the area using that height and width, then update maxArea.

Note:
• Both approaches produce the same result and have the same complexity.
• The first implementation is usually preferred because it directly follows the formula: 
   area = min(height[l], height[r]) × (r − l).

class Sol12{
    public int maxArea(int[] height){
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        

        while(l < r){
            int h;

            if(height[l] < height[r]){
                h = height[l];
                l++;
            }else{
                h = height[r];
                r--;
            }

            int area = h * (r - l + 1);

            if(area > maxArea) maxArea = area;
        }

        return maxArea;
    }
}
*/
