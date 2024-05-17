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
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         if (root == null) {
//             return new ArrayList<>();
//         }

//         Queue<TreeNode> q = new LinkedList<>();
// //         pushing the root node to the queue
//         q.offer(root);
// //         marking flag to true
//         boolean leftToRight = true;
//         List<List<Integer>> ans = new ArrayList<>();

//         while (!q.isEmpty()) {
//             int size = q.size();
//             List<Integer> res = new ArrayList<>(size);
//             for (int i = 0; i < size; i++) {
//                 TreeNode node = q.poll();
// //                 condition for altering the direction on the basis of boolean values.
//                 int index = leftToRight ? i : (size - 1 - i);
//                 res.add(index, node.val);

//                 if (node.left != null) {
//                     q.offer(node.left);
//                 }
//                 if (node.right != null) {
//                     q.offer(node.right);
//                 }
//             }
// //             changing the boolean value
//             leftToRight = !leftToRight;
//             ans.add(res);
//         }

//         return ans;
 //   }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        List<List<Integer>> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> res = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Insert the node value in the appropriate position based on the direction
                if (leftToRight) {
                    res.addLast(node.val);
                } else {
                    res.addFirst(node.val);
                }

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            // Change the direction
            leftToRight = !leftToRight;
            ans.add(res);
        }

        return ans;
    }
}