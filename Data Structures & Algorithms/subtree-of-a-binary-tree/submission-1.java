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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        else if(root == null || subRoot == null){
            return false;
        }

        if(dfs(root, subRoot)){ //will find the start of the recursion
            return true;
        }
        return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        else if(root == null || subRoot == null){
            return false;
        }

        // System.out.println(root.val + " " + subRoot.val);
        if(root.val == subRoot.val){
            boolean left = dfs(root.left, subRoot.left);
            boolean right = dfs(root.right, subRoot.right);
            // System.out.println(left + " " + right);


            return left && right;
        }
        return false;
    }
}
