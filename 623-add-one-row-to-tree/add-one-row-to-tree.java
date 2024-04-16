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
    int delDp;
    int delVal;
    private TreeNode insert(TreeNode root,int depth,boolean left){
        if(depth == delDp){
            TreeNode node = new TreeNode(delVal);
            if(left){
                node.left = root;
            }else{
                node.right = root;
            }
            if(root != null){
                root.left = insert(root.left,depth + 1 , true);
                root.right = insert(root.right,depth + 1 , false);
            }
            return node;
        }
        if(root == null){
            return root;
        }
        root.left = insert(root.left,depth + 1 , true);
        root.right = insert(root.right,depth + 1 , false);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        delDp = depth;
        delVal = val;
        return insert(root,1,true);
    }
}