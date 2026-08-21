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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        System.out.println(root.val);
        System.out.println(p.val + " " + q.val);
        if(p.val <= root.val && q.val >= root.val){
            System.out.println("here");
            return root;
        }
        else if(p.val < root.val && q.val < root.val){ //left subtree
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val){ //right subtree
            return lowestCommonAncestor(root.right, p, q);
        }

        return null;
    }

    // public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
    //     //return the parent 
    // }
}
