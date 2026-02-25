public class AddTwoNum {
    public static void main(String []args){
        Solution2 obj = new Solution2();
        ListNode l1 = ListNode.createList(new int[]{2,4,3});
        ListNode l2 = ListNode.createList(new int[]{5,6,4});
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
