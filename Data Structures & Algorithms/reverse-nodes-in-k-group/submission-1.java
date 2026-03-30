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

        public int len(ListNode head){

            int count=0;

            while(head!=null){

                head=head.next;
                count++;
            }

            return count;

        }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head==null|| k==0) return head;

        

        int N=len(head);

        int groups=N/k;


        ListNode currHead=head;
        ListNode prevHead=null;
        ListNode ans=null;



        for(int i=0;i<groups;i++){

            ListNode curr=currHead;
            ListNode prev=null;

            for(int j=0;j<k;j++){

                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;

            }

            if(prevHead==null){
                ans=prev;
            }else{
                prevHead.next=prev;
            }

           prevHead=currHead;
           currHead=curr;

        }

        prevHead.next=currHead;

        return ans;
        
    }
}
