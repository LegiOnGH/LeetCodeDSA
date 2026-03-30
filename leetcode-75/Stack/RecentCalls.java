package Stack;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class RecentCalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RecentCounter recentCounter = new RecentCounter();

        System.out.println("Enter number of calls:");
        int n = sc.nextInt();

        System.out.println("Enter ping values:");
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int result = recentCounter.ping(t);
            System.out.print(result + " ");
        }

        sc.close();
    }
}
/*
https://leetcode.com/problems/number-of-recent-calls

You have a RecentCounter class which counts the number of recent requests within a certain time frame.
Implement the RecentCounter class:
RecentCounter() Initializes the counter with zero recent requests.
int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). 
Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

Queue / Sliding Window

Approach:
• Use a queue to store timestamps of recent requests.
• For each ping(t):
  - Add the current timestamp t to the queue.
  - Remove all timestamps from the front of the queue that are older than (t - 3000).
    • These are no longer in the valid time window.
• After removal, the queue contains only timestamps in the range [t - 3000, t].
• Return the size of the queue as the number of recent requests.

Time Complexity:
• O(1) amortized per ping
• Each timestamp is added once and removed at most once.

Space Complexity:
• O(n)
• In the worst case, all requests within a 3000ms window are stored in the queue.
*/
class RecentCounter{
    private Queue<Integer> queue;

    public RecentCounter(){
        queue = new LinkedList<>();
    }

    public int ping(int t){
        queue.add(t);

        while(!queue.isEmpty() && queue.peek() < t - 3000){
            queue.poll();
        }

        return queue.size();
    }
}
