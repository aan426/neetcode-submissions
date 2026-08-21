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
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        traverse(root);
        return diameter;
    }

    public int traverse(TreeNode root){
        if(root == null){
            return 0; //height of null is 0
        }

        System.out.println(root.val + " before");
        int right = traverse(root.right);
        int left = traverse(root.left);
        System.out.println(root.val);
        System.out.println(right + " " + left);

        diameter = Math.max((right + left), diameter); //calculate the diameter

        return Math.max(right, left) + 1; //return the height of the current root
    }
}
