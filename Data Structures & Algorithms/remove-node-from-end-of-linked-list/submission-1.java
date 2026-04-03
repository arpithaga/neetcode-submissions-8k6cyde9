/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr=head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int l=0;
        while(curr!=null){
            l++;
            curr=curr.next;
        }

        int r=l-n;
        if(r==0){
            return head.next;
        }

        curr=head;
        for(int i=0;i<r-1;i++){
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return dummy.next;

    }
}
