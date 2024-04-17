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
    private StringBuilder findMin(TreeNode root,StringBuilder path){
        path.append((char)(root.val + 'a'));
        if(root.left == null && root.right == null){
            return new StringBuilder(Character.toString('a' + root.val));
        }else if(root.left == null){
            StringBuilder sb = findMin(root.right,new StringBuilder(path));
            sb.append((char)('a' + root.val));
            return sb;
        }else if(root.right == null){
            StringBuilder sb = findMin(root.left,new StringBuilder(path));
            sb.append((char)('a' + root.val));
            return sb;
        }else{
            StringBuilder left = findMin(root.left,new StringBuilder(path));
            StringBuilder right = findMin(root.right,new StringBuilder(path));
            StringBuilder leftPath = new StringBuilder(left);
            StringBuilder rightPath = new StringBuilder(right);
            leftPath.append(path);
            rightPath.append(path);
            left.append((char)('a' + root.val));
            right.append((char)('a' + root.val));
            if(leftPath.compareTo(rightPath) < 0){
                return left;
            }else{
                return right;
            }
        }
    }
    public String smallestFromLeaf(TreeNode root) {
        return findMin(root , new StringBuilder()).toString();
    }
}