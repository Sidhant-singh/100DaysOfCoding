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
    public boolean isExist(TreeNode root,TreeNode node){
        if(root==node) return true;
//         end tk pahoch gye but node ni mila
        if(root==null) return false;
        return isExist(root.left,node) || isExist(root.right,node);
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root) return root;
//         if p is equals to root then it will be its LCA;
//         check that plies in LST
        boolean pliesLST = isExist(root.left,p);
//         check that plies in RST
        boolean qliesLST = isExist(root.left,q);
        
//         if both lies in LST then call the function with the root.left node
        if(pliesLST && qliesLST) return lowestCommonAncestor(root.left,p,q);
        //         if both lies in RST then call the function with the root.right node
        if(!pliesLST && !qliesLST) return lowestCommonAncestor(root.right,p,q);
//         if both lies in different subtrees then its LCA will be root.
        else return root;
     }
}