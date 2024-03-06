public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast,slow=fast=head;
        while(fast!=null){
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}