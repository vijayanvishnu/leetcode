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
    private void inorder(TreeNode root , List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left , list);
        list.add(root.val);
        inorder(root.right , list);
    }
    private TreeNode insert(List<Integer> nums , int left , int right)
    {
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode curr = new TreeNode();
        curr.val = nums.get(mid);
        curr.left = insert(nums,left,mid - 1);
        curr.right = insert(nums,mid + 1 , right);
        return curr;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        System.out.println(list);
        return insert(list , 0 , list.size() - 1);
    }
}