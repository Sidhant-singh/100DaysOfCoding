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
    public int helper(TreeNode root,long sum){
        if(root==null) return 0;
        int count = 0;
//         it is not neccesary that the path considered should be end on leafNodes it can end in between if  
        if(root.val==sum) count++;
        
        count += helper(root.left,sum-root.val) + helper(root.right,sum-root.val);
        return count;
    }
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
//         the same thing we are applying on different nodes of a subtree considering it as a root node.
        return helper(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
}