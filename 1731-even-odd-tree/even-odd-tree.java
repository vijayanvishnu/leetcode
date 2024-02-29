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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        LinkedList<Double> list = new LinkedList<>();
        int level=1;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int prev=-1;
            while(size>0){
                TreeNode temp=queue.remove();
                if(temp.val%2==level){
                    if(level==0){
                        if(prev==-1){
                        prev=temp.val;
                    }
                    else{
                        if(prev<=temp.val){
                            return false;
                        }
                        else{
                            prev=temp.val;
                        }
                    }
                    }
                    else{
                        if(prev==-1){
                        prev=temp.val;
                    }
                    else{
                        if(prev>=temp.val){
                            return false;
                        }
                        else{
                            prev=temp.val;
                        }
                    }

                    }
                }
                else{
                    return false;
                }
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
                size--;
            }
            level=level^1;
        }
        return true;
    }
}