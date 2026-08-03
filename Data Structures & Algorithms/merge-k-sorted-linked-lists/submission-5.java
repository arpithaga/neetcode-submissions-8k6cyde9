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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null || lists.length==0) return null;

        for(int i=1;i<lists.length;i++){
            lists[i]=mergeTwoLists(lists[i],lists[i-1]);
        }

        return lists[lists.length-1];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(0);
        ListNode res=dummy;

        ListNode curr=list1,curr2=list2;
        while(curr!=null && curr2!=null){
            if(curr.val<=curr2.val){
                res.next=curr;
                curr=curr.next;
            }else {
                res.next=curr2;
                curr2=curr2.next;
            }

            res=res.next;
        }
        res.next = (curr!=null) ? curr : curr2;
        return dummy.next;
    }
    
}
