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
        int len=0;
        ListNode i=head;
        while(i!=null){
            len++;
            i=i.next;
        }
        if(len==n){
            return head.next;
        }
        else{
            int k=len-n;
            i=head;
            while(k>1){
                i=i.next;
                k--;
            }
            if(i.next!=null)
            i.next=i.next.next;
            return head;
        }
    }
}