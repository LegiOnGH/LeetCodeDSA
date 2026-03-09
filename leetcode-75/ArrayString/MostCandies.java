package ArrayString;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MostCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of kids: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter candies for each kid: ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Sol3 sol = new Sol3();
        System.out.println("Enter no. of extra candies: ");
        int extra = sc.nextInt();
        sc.close();

        System.out.println(sol.kidsWithCandies(arr, extra));
    }
}
/*
https://leetcode.com/problems/kids-with-the-greatest-number-of-candies

There are n kids with candies. You are given an integer array candies, 
where each candies[i] represents the number of candies the ith kid has,
and an integer extraCandies, denoting the number of extra candies that you have.
Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, 
they will have the greatest number of candies among all the kids, or false otherwise.
Note that multiple kids can have the greatest number of candies.

Array Traversal / Simulation

Approach:
• First find the maximum number of candies any kid currently has.
• Traverse the candies array and update the maximum value.
• Then iterate through the array again.
• For each kid, check if candies[i] + extraCandies is greater than or equal to the maximum value found.
• If it is, add true to the result list because that kid can have the greatest number of candies.
• Otherwise, add false.
• Return the list of boolean values.

Time Complexity:
• O(n)
• The array is traversed twice: once to find the maximum candies and once to compute the result.
• Each traversal takes linear time.

Space Complexity:
• O(n)
• A list of size n is used to store the boolean results.
*/
class Sol3{
    public List<Boolean> kidsWithCandies(int []candies, int extraCandies){
        List<Boolean> result = new ArrayList<>();
        int max = candies[0];
        for(int candy : candies){
            if(candy > max){
                max = candy;
            }
        }
        for(int candy : candies){
            result.add(candy + extraCandies >= max);
        }
        return result;
    }
}
