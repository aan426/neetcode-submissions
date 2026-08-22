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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]); //build root
        int rootInOrderPos = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                rootInOrderPos = i; //get it's pos in inorder
            }
        }
        //preorder: range [1 to rootInOrderPos + 1) --> # of nodes in the left tree
        //inorder: range [0 to rootInOrderPos) --> all the nodes to the left of root
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootInOrderPos + 1), Arrays.copyOfRange(inorder, 0, rootInOrderPos));

        root.right = buildTree(Arrays.copyOfRange(preorder, rootInOrderPos + 1, preorder.length), Arrays.copyOfRange(inorder, rootInOrderPos + 1, inorder.length));

        return root;                    
    }
}
