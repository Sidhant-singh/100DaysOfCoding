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
    static Map<TreeNode,Integer> dp;
    public int height(TreeNode root){
        if(root==null) return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int left = height(root.left);
        int right = height(root.right);
        dp.put(root,1+Math.max(left,right));
        return dp.get(root);
    }
    public int diameter(TreeNode root) {
        if(root==null) return 0;
        
        int leftAns = diameter(root.left);
        int rightAns = diameter(root.right);
        int mid = height(root.left) + height(root.right);
        
        return Math.max(leftAns,Math.max(rightAns,mid));
        

    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        dp = new HashMap<>();
        return diameter(root);
    }
}