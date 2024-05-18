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
    int moves = 0;
    
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        // Total excess coins at this node
        int excess = node.val + left + right - 1;
        
        // The number of moves is increased by the absolute value of excess coins
        moves += Math.abs(excess);
        
        // Return the excess coins for this node to the parent
        return excess;
    }
}