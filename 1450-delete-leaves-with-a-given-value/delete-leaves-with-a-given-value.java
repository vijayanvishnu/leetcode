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
    private TreeNode traverse(TreeNode root,int del){
        if(root == null){
            return null;
        }
        root.left = traverse(root.left, del);
        if(root.val == del && root.left == null && root.right == null){
            return null;
        }
        root.right = traverse(root.right, del);
        if(root.val == del && root.left == null && root.right == null){
            return null;
        }
        return root;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return traverse(root, target);
    }
}