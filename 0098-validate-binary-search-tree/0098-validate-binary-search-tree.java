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
    public long maxi(TreeNode root){
        if(root==null) return Long.MIN_VALUE;
        return Math.max(root.val,Math.max(maxi(root.left),maxi(root.right)));
    }
    public long mini(TreeNode root){
        if(root==null) return Long.MAX_VALUE;
        return Math.min(root.val,Math.min(mini(root.left),mini(root.right)));
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.val<=maxi(root.left)) return false;
        if(root.val>=mini(root.right)) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
}