class Solution {
    int max = 0;
    private int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        int sum = left + right;
        max = Math.max(sum,max);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        diameter(root);
        return max;
    }
}