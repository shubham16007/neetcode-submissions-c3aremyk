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

        if(head==null || head.next==null)return;

        ListNode slow=head;
        ListNode fast=head;

        //find middle
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //reverse the second half
        ListNode second=reverse(slow.next);
        slow.next=null;


        ListNode first=head;
        
        //merge the first and second half 
        while(second!=null){
            ListNode temp1=first.next;
            ListNode temp2=second.next;

            first.next=second;
            second.next=temp1;

            first=temp1;
            second=temp2;
        }
        
    }

    public ListNode reverse(ListNode head){

        ListNode prev=null;

        while(head!=null){
            ListNode newNode=head.next;
            head.next=prev;
            prev=head;
            head=newNode;
        }

        return prev;

    }
}
