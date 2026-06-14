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
    public void reorderList(ListNode head) {

        ListNode dummy=new ListNode(0);
        ListNode res=dummy;

        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;   
        }

        ListNode curr=head;
        ListNode curr2=null;
        ListNode curr3=slow.next;

        while(curr3!=null){
            ListNode temp=curr3.next;
            curr3.next=curr2;
            curr2=curr3;
            curr3=temp;
        }
        slow.next=null;

        while(curr!=null && curr2!=null){
            ListNode next1 = curr.next;
            ListNode next2 = curr2.next;

            curr.next = curr2;
            curr2.next = next1;

            curr = next1;
            curr2 = next2;
        }        
    }
}
