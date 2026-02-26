import java.util.Scanner;

public class AddTwoNum {

    public static int[] convertToArray(String input) {
        String[] parts = input.split(" ");
        int[] arr = new int[parts.length];

        for(int i = 0; i < parts.length; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }

        return arr;
    }
    public static void main(String []args){
        Solution2 obj = new Solution2();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of first list (space separated):");
        String input1 = sc.nextLine();

        System.out.println("Enter elements of second list (space separated):");
        String input2 = sc.nextLine();

        sc.close();

        int[] arr1 = convertToArray(input1);
        int[] arr2 = convertToArray(input2);

        ListNode l1 = ListNode.createList(arr1);
        ListNode l2 = ListNode.createList(arr2);
        ListNode result = obj.addNum(l1, l2);
        while(result!=null){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static ListNode createList(int[] arr){

    ListNode head = new ListNode(arr[0]);
    ListNode current = head;

    for(int i=1;i<arr.length;i++){
        current.next = new ListNode(arr[i]);
        current = current.next;
    }

    return head;
}
}

class Solution2{
    public ListNode addNum(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int sum = carry;
            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }            
            carry = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;

        }
        return dummy.next;
    }
}
