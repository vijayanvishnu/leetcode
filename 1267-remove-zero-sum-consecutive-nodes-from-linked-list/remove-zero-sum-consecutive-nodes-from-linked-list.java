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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode h = head;
        Map<Integer,ListNode> prefHash = new HashMap<>();
        prefHash.put(0,null);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        while(h != null){
            int prev = list.getLast();
            int sum = prev + h.val;
            boolean found = true;
            while(prefHash.containsKey(sum)){
                int val = 0;
                if((val = list.removeLast()) == sum){
                    list.add(val);
                    found = false;
                    break;
                }
                prefHash.remove(val);
            }
            if(found){
                prefHash.put(sum,h);
                list.add(sum);
            }
            h = h.next;
        }
        // System.out.println(list);
        list.pollFirst();
        ListNode t = null;
        for(int i : list){
            ListNode iNode = prefHash.get(i);
            if(h == null){
                h = t = iNode;
                t.next = null;
            }else{
                t.next = iNode;
                t = t.next;
                t.next = null;
            }
        }
        return h;
    }
}