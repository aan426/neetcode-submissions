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
    public int maxDepth(TreeNode root) {
        int maxLen = traversePath(root, 0);

        return maxLen;
    }

    public int traversePath(TreeNode root, int count){
        if(root == null){
            return count;
        }
        count++;
        int len1 = traversePath(root.right, count);
        int len2 = traversePath(root.left, count);

        return Math.max(len1, len2);
    }
}
