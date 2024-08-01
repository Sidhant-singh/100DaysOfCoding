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
//     OPTIMIZED CODE 
    static boolean ans;
    public int levels(TreeNode root){
        if(root==null) return 0;
        int leftLvl = levels(root.left);
        int rightLvl = levels(root.right);
        int diff = Math.abs(leftLvl - rightLvl);
        if(diff>1) ans = false;
        return 1 + Math.max(leftLvl,rightLvl);
    }
    public boolean isBalanced(TreeNode root) {
        ans = true;
        levels(root);
        return ans;
    }
}