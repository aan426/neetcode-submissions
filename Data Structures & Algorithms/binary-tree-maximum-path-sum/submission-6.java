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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //dfs diameter of tree
        path(root);
        return maxPath;
    }

    public int path(TreeNode root){
        if(root == null){
            return 0;
        }

        // pathSum += root.val;
        int leftPathLen = path(root.left);
        int rightPathLen = path(root.right);
        // pathSum += root.val;
        maxPath = Math.max(leftPathLen + rightPathLen + root.val, maxPath);
        maxPath = Math.max(root.val, maxPath);
        maxPath = Math.max(root.val + rightPathLen, maxPath);
        maxPath = Math.max(root.val + leftPathLen, maxPath);
        //curent max length at any given root, but it's not what the parent can consider because the parent can only form a path with either the left or right branch of their child

        // System.out.println(root.val + " " + maxPath);
        // System.out.println(leftPathLen + " " + rightPathLen);
        // System.out.println();

        int whichPath = Math.max(leftPathLen, rightPathLen);
        int whichOrNoPath = Math.max(0, whichPath);

        return root.val + whichOrNoPath; //what do I want to return to my parent node? --> my current value plus whichever left or right path length is longest
        //can't just return that the best possible value is always root + left or right because what if the root itself is the best option, so either add 0 to the root or add a value greater than zero

    }
}
