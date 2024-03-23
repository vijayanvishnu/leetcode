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
    public void insert(ListNode node , ListNode nodes[]){
        if(nodes[1]!=null){
            nodes[1].next=node;
            nodes[1]=nodes[1].next;
            nodes[1].next=null;
        }
        else{
            nodes[0]=nodes[1]=node;
            node.next=null;
        }
    }
    public void reorderList(ListNode head) {
        ListNode fast,slow=fast=head;
        while(fast!=null){
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }
        ListNode revHead=null;
        ListNode currNode=null;
        while(slow!=null){
            if(revHead==null){
                revHead=slow;
                slow=slow.next;
                revHead.next=null;
            }
            else{
                currNode=slow;
                slow=slow.next;
                currNode.next=revHead;
                revHead=currNode;
            }
        }
        ListNode nodes[]=new ListNode[2];
        while(revHead!=null || head!=null){
            if(head!=null){
                currNode=head;
                head=head.next;
                insert(currNode,nodes);
            }
            if(revHead!=null){
                currNode=revHead;
                revHead=revHead.next;
                insert(currNode,nodes);
            }
        }
    }
}