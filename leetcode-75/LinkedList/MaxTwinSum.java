package LinkedList;

import java.util.Scanner;

public class MaxTwinSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter list length: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("List is empty");
            sc.close();
            return;
        }
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }
        sc.close();

        Sol32 sol = new Sol32();
        int result = sol.maxTwinSum(head);
        System.out.printf("Max Twin Sum for given Linked List: %d",result);;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
/*
https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list

In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. 
These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.
Given the head of a linked list with even length, return the maximum twin sum of the linked list

Linked List / Two Pointers + Reversal

Approach:
• Step 1: Find the middle of the linked list
  - Use slow and fast pointers.
  - When fast reaches the end, slow will be at the middle.

• Step 2: Reverse the second half of the list
  - Reverse the list starting from slow.
  - This allows pairing from both ends in O(1) space.

• Step 3: Calculate twin sums
  - Use two pointers:
      • first → starts from head
      • second → starts from reversed second half
  - Traverse both together:
      • Compute sum = first.val + second.val
      • Track the maximum sum

• Return the maximum twin sum.

Time Complexity:
• O(n)
• One pass to find middle, one to reverse, one to compute sum.

Space Complexity:
• O(1)
• Done in-place using pointer manipulation.
*/
class Sol32{
    public int maxTwinSum(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        ListNode first = head;
        ListNode second = prev;
        int maxSum = 0;
        while(second != null){
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return maxSum;
    }
}