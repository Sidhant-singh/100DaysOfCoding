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
 **/
class Solution {
    static boolean flag;
    public long maxi(TreeNode root){
        if(root==null) return Long.MIN_VALUE;
        long leftMax= maxi(root.left);
        if(leftMax>=root.val) flag = false;
        long rightMax = maxi(root.right);
        return Math.max(root.val,Math.max(leftMax,rightMax));
    }
    public long mini(TreeNode root){
        if(root==null) return Long.MAX_VALUE;
        long leftMin = mini(root.left);
        long rightMin = mini(root.right);
        if(rightMin<=root.val) flag = false;
        return Math.min(root.val,Math.min(leftMin,rightMin));
    }
    public boolean isValidBST(TreeNode root) {
        flag = true;
        maxi(root);
        mini(root);
        return flag;
    }
}