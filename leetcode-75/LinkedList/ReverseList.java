package LinkedList;

import java.util.Scanner;

public class ReverseList{
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

        Sol31 sol = new Sol31();
        head = sol.reverseList(head);
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
https://leetcode.com/problems/reverse-linked-list

Given the head of a singly linked list, reverse the list, and return the reversed list.

Linked List / Iterative / Two Pointers

Approach:
• Use three pointers:
  - prev → initially null (will become new head)
  - curr → starts from head
  - next → temporarily stores next node
• Traverse the list:
  - Store next node (next = curr.next)
  - Reverse the link (curr.next = prev)
  - Move prev forward (prev = curr)
  - Move curr forward (curr = next)
• Continue until curr becomes null.
• At the end, prev will be the new head of the reversed list.

Time Complexity:
• O(n)
• Each node is visited exactly once.

Space Complexity:
• O(1)
• Reversal is done in-place using constant extra space.
*/
class Sol31{
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next =  curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}