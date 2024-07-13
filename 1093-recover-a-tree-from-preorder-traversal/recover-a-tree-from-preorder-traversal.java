/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        char str[] = traversal.toCharArray();
        int idx = 0;
        int num = 0;
        while(idx < str.length && str[idx] != '-'){
            num = num * 10 + (str[idx] - '0');
            idx++;
        }
        stack.push(new TreeNode(num));
        while(idx < str.length){
            int bars = 0;
            while(idx < str.length && str[idx] == '-'){
                bars++;
                idx++;
            }
            num = 0;
            while(idx < str.length && str[idx] != '-'){
                num = num * 10 + (str[idx] - '0');
                idx++;
            }
            while(stack.size() > bars){
                stack.pop();
            }
            TreeNode node = stack.peek();
            TreeNode newNode = new TreeNode(num);
            if(node.left == null){
                node.left = newNode;
                stack.push(newNode);
            }else{
                node.right = newNode;
                stack.push(newNode);
            }
        }
        while(stack.size() > 1){
            stack.pop();
        }
        return stack.pop();
    }
}