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
    void traverse(ListNode head,Stack<ListNode> stack){
        if(head!=null){
            traverse(head.next,stack);
            if(stack.isEmpty()){
                stack.push(head);
            }
            else{
                if(stack.isEmpty()==false && stack.peek().val<=head.val) stack.push(head);
            }
        }
    }
    void insert(ListNode node,ListNode nodes[]){
        if(nodes[0]!=null){
            nodes[1].next=node;
            nodes[1]=nodes[1].next;
            nodes[1].next=null;
        }
        else{
            nodes[0]=nodes[1]=node;
            node.next=null;
        }
    }
    public ListNode removeNodes(ListNode head) {
        ListNode nodes[]=new ListNode[2];
        if(head.next==null){
            return head;
        }
        ListNode curr=head; 
        Stack<ListNode> stack = new Stack<>();
        traverse(head,stack);
        while(!stack.isEmpty()){
            insert(stack.pop(),nodes);
        }
        return nodes[0];
    }
}