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
    public void invert(TreeNode root){
        if(root==null) return;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invert(root.left);
        invert(root.right);
    }
    
    public boolean isSame(TreeNode p , TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        
        return (isSame(p.left,q.left) && isSame(p.right,q.right));
    }
    
    public boolean isSymmetric(TreeNode root) {
        invert(root.right);
        if(isSame(root.left,root.right)) return true;
        else return false;
    }
}