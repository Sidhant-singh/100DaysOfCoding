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
//     OPTIMIZED CODE - O(N)
    static int maxDia;
    public int levels(TreeNode root){
        if(root==null) return 0;
        int leftLvl = levels(root.left);
        int rightLvl = levels(root.right);
        int dia = leftLvl + rightLvl;
        maxDia = Math.max(maxDia,dia);
        return 1+Math.max(leftLvl,rightLvl);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDia = 0;
        levels(root);
        return maxDia;
    }
}