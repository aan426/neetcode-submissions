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
    boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        isBalanced = true;
        // int right = maxHeight(root.right);
        // int left = maxHeight(root.left);
        // // System.out.println(right + " " + left);

        // if(right != left && right + 1 != left && right - 1 != left){
        //     isBalanced = false;
        // }
        maxHeight(root);
        return isBalanced;
    }

    public int maxHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int right = maxHeight(root.right);
        int left = maxHeight(root.left);
        System.out.println(root.val);
        System.out.println(right + " " + left);

        if(right != left && right + 1 != left && right - 1 != left){
            isBalanced = false;
        }

        return Math.max(right, left) + 1;
    }
}
