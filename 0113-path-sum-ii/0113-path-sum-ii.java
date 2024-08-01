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
    public List<Integer> deepCopy(List<Integer> arr){
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            list.add(i);
        }
        return list;
    }
    public void helper(TreeNode root,int target,List<Integer> arr,List<List<Integer>> ans){
        if(root==null) return;
        if(root.left==null && root.right==null){
            if(target==root.val){
                arr.add(root.val);
                ans.add(arr);
            }
            return;
        }
        arr.add(root.val);
        
//         we have to create deep copies of the passed array
        List<Integer> arr1 = deepCopy(arr);
        List<Integer> arr2 = deepCopy(arr);
        helper(root.left,target-root.val,arr1,ans);
        helper(root.right,target-root.val,arr2,ans);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(root,targetSum,arr,ans);
        return ans;
    }
}