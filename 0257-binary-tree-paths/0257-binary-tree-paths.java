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
    public static void path(TreeNode root, String res,List<String> ans){
        if(root==null) return;
        if(root.left==null && root.right==null){
            res += root.val;
            ans.add(res);
            return;
        }
        
        if(root.left!=null) path(root.left,res+root.val+"->",ans);
        if(root.right!=null) path(root.right,res+root.val+"->",ans);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        path(root,"",ans);
        return ans;
    }
}