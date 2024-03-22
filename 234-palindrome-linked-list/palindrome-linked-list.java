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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode i=head;
        while(i!=null){
            stack.push(i.val);
            i=i.next;
        }
        while(!stack.isEmpty()){
            if(stack.pop().intValue()!=head.val){
                return false;
            }
            head=head.next;
        }
        return true;
    }
}