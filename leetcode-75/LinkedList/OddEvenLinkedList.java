package LinkedList;

import java.util.*;

public class OddEvenLinkedList {
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

        Sol30 sol = new Sol30();
        head = sol.oddEvenList(head);
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
https://leetcode.com/problems/odd-even-linked-list

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Linked List / Two Pointers / In-place Reordering

Approach:
• Separate the linked list into two parts:
  - Odd indexed nodes
  - Even indexed nodes
• Use three pointers:
  - odd → tracks the last node in the odd list
  - even → tracks the last node in the even list
  - evenHead → stores the head of the even list (to attach later)
• Traverse the list:
  - Link odd nodes together by skipping even nodes.
  - Link even nodes together by skipping odd nodes.
• Continue until the end of the list.
• Finally, connect the end of the odd list to the head of the even list.

Time Complexity:
• O(n)
• The list is traversed once.

Space Complexity:
• O(1)
• Reordering is done in-place using only pointers.
*/

class Sol30{
    public ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = odd.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

