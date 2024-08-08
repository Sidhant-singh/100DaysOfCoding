/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         we will go to right as both the nodes will be in right subtree.
        if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
//         we will go to right as both the nodes will be in right subtree.
        else if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
//         both the nodes are in different subtrees
        else return root;
    }
}