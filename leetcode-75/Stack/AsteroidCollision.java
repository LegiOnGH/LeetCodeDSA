package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class AsteroidCollision{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int n = sc.nextInt();
        int[] asteroids =  new int[n];
        System.out.println("Enter asteroids: ");
        for(int i = 0; i < n; i++){
            asteroids[i] = sc.nextInt();
        }
        sc.close();
        Sol25 sol = new Sol25();
        System.out.println("Remaining Asteroids: "+ Arrays.toString(sol.asteroidCollision(asteroids)));
    }
}
/*
https://leetcode.com/problems/asteroid-collision

We are given an array asteroids of integers representing asteroids in a row. 
The indices of the asteroid in the array represent their relative position in space.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). 
Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. 
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Stack / Simulation

Approach:
• Use a stack to simulate asteroid collisions.
• Traverse each asteroid one by one.
• Push asteroids moving to the right (positive) directly onto the stack.
• For asteroids moving to the left (negative):
  - A collision can occur only if the top of the stack is moving right.
  - While collision is possible:
      • If the top asteroid is smaller → it explodes (pop from stack).
      • If both are equal → both explode (pop and mark current as destroyed).
      • If the top is larger → current asteroid is destroyed.
• Use a flag (destroyed) to track whether the current asteroid survives.
• If it survives all collisions, push it onto the stack.
• After processing all asteroids, the stack contains the final state.
• Convert the stack into an array in correct order.

Time Complexity:
• O(n)
• Each asteroid is pushed and popped at most once.

Space Complexity:
• O(n)
• Stack stores surviving asteroids.
*/
class Sol25{
    public int[] asteroidCollision(int[] asteroids){
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int a : asteroids){
            boolean destroyed = false;
            while(!stack.isEmpty() && a < 0 && stack.peek() > 0){
                if(stack.peek() < -a){
                    stack.pop();
                } else if(stack.peek() == -a){
                    stack.pop();
                    destroyed = true;
                    break;
                } else{
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                stack.push(a);
            }
        }
        int[] output = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            output[i] = stack.pop();
        }
        return output;
    }
}