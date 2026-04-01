package LinkedList;

import java.util.*;

public class DeleteMiddleNode {
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

        Sol29 sol = new Sol29();
        head = sol.deleteMiddle(head);
        printList(head);
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
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
https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list

You are given the head of a linked list. 
Delete the middle node, and return the head of the modified linked list.
The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, 
where ⌊x⌋ denotes the largest integer less than or equal to x.
For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

Linked List / Two Pointers (Slow & Fast)

Approach:
• Use two pointers:
  - slow → moves one step at a time
  - fast → moves two steps at a time
• Also maintain a prev pointer to track the node before slow.
• Traverse the list:
  - When fast reaches the end, slow will be at the middle node.
• Once the middle node is found:
  - Delete it by setting prev.next = slow.next.
• Edge case:
  - If the list has only one node, return null.

Time Complexity:
• O(n)
• The list is traversed once.

Space Complexity:
• O(1)
• No extra space is used; only pointers are maintained.
 */


class Sol29 {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;

        return head;
    }
}
