package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dota2Senate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string of Radiants and Dires in order: ");
        String senate = sc.nextLine();
        sc.close();

        Sol28 sol = new Sol28();
        System.out.println("Winning Party: "+ sol.predictWinningParty(senate));
    }
}
/*
https://leetcode.com/problems/dota2-senate

In the world of Dota2, there are two parties: the Radiant and the Dire.
The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. 
The voting for this change is a round-based procedure. 
In each round, each senator can exercise one of the two rights:
Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. 
Then if there are n senators, the size of the given string will be n.
The round-based procedure starts from the first senator to the last senator in the given order. 
This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
Suppose every senator is smart enough and will play the best strategy for his own party. 
Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".

Queue / Simulation / Greedy

Approach:
• Use two queues to store indices of senators:
  - radIndices → positions of 'R'
  - dirIndices → positions of 'D'
• Traverse the string and enqueue indices into respective queues.
• While both queues are non-empty:
  - Compare the front indices of both queues.
  - The senator with the smaller index gets to act first.
  - That senator bans the opponent and survives to the next round.
  - Add the surviving senator back to its queue with index + n
    (simulating the next round cycle).
• Continue until one queue becomes empty.
• The party with remaining senators is the winner.

Time Complexity:
• O(n)
• Each senator is enqueued and dequeued at most once per round,
  but total operations remain linear due to elimination.

Space Complexity:
• O(n)
• Two queues store indices of senators.
*/
class Sol28{
    public String predictWinningParty(String senate){
        Queue<Integer> radIndices = new LinkedList<>();
        Queue<Integer> dirIndices = new LinkedList<>();
        int n = senate.length();
        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R'){
                radIndices.offer(i);
            }else{
                dirIndices.offer(i);
            }
        }
        while(!radIndices.isEmpty() && !dirIndices.isEmpty()){
            int radIndex = radIndices.poll();
            int dirIndex = dirIndices.poll();
            if(radIndex < dirIndex){
                radIndices.offer(n + radIndex);
            }else{
                dirIndices.offer(n + dirIndex);
            }
        }

        return (radIndices.isEmpty()) ? "Dire" : "Radiant";
    }
}