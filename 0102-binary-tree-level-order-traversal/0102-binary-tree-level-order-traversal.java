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
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(level(root.left),level(root.right));
    }
    public void NodeAtNThLvl(TreeNode root,int l,int n,List<Integer> ans){
        if(root==null) return;
        if(l==n){
            ans.add(root.val);
        }
        NodeAtNThLvl(root.left,l+1,n,ans);
        NodeAtNThLvl(root.right,l+1,n,ans);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int lvl = level(root);
        for(int i=0;i<lvl;i++){
            List<Integer> ans = new ArrayList<>();
            NodeAtNThLvl(root,0,i,ans);
            res.add(ans);
        }
        
        return res;
    }
}