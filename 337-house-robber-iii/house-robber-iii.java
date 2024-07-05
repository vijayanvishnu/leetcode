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
    HashMap<TreeNode,Integer> dp;
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        if(dp.containsKey(root)){
            return dp.get(root);
        }
        int pick = root.val;
        if(root.left != null){
            pick = pick + helper(root.left.left) + helper(root.left.right);
        }
        if(root.right != null){
            pick = pick + helper(root.right.left) + helper(root.right.right);
        }
        int dont = helper(root.left) + helper(root.right);
        int ans = Math.max(pick , dont);
        dp.put(root,ans);
        return ans;
    }
    public int rob(TreeNode root) {
        dp = new HashMap<>();
        return helper(root);
    }
}