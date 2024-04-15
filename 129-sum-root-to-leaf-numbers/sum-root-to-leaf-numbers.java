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
    static int sum=0;
    void traverse(TreeNode root,int s){
        if(root!=null){
            if(root.left==null && root.right==null){
                sum+=s*10+root.val;
            }
            traverse(root.left,s*10+root.val);
            traverse(root.right,s*10+root.val);
        }
    }
    public int sumNumbers(TreeNode root) {
        sum=0;
        traverse(root,0);
        return sum;
    }
}