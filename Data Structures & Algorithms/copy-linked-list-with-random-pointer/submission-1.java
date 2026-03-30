/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head==null) return head;

        Node curr=head;

        while(curr!=null){

            Node clone=new Node(curr.val);
            clone.next=curr.next;
            curr.next=clone;
            curr=clone.next;
        }

        curr=head;

        while(curr!=null){

            if(curr.random!=null){

                curr.next.random=curr.random.next;
            }

            curr=curr.next.next;
        }


        curr=head;

        Node dummy=new Node(0);

        Node copyCurr=dummy;

        while(curr!=null){
            copyCurr.next=curr.next;
            curr.next=curr.next.next;

            curr=curr.next;
            copyCurr=copyCurr.next;
        }


        return dummy.next;
        
    }
}
