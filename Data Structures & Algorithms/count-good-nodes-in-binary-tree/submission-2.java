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
    public int goodNodes(TreeNode root) {
        //bfs --> for each level check each child, add to stack
        if(root == null){
            return 0;
        }
        return dfs(root, root.val);       

    }

    public int dfs(TreeNode root, int maxOnPath){
        if(root == null){
            return 0;
        }

        int count = 0;

        if(root.val >= maxOnPath){
            maxOnPath = root.val;
            count++;
        }

        count += dfs(root.right, maxOnPath);
        count += dfs(root.left, maxOnPath);

        return count;
    }
}
