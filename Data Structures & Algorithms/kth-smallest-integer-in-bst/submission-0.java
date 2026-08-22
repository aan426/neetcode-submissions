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
    public int kthSmallest(TreeNode root, int k) {
        //add values to a FIFO and pollFirst until the kth element
        //use a stack and iteravely go through the tree

        Stack<TreeNode> arr = new Stack<>();
        int counter = 0;
        TreeNode rootPt = root;

        while(rootPt != null || !arr.isEmpty()){
            while(rootPt != null){ //process all left nodes first
                arr.push(rootPt);
                rootPt = rootPt.left;
            }
            rootPt = arr.pop();
            counter ++;
            if(counter == k){
                return rootPt.val;
            }
            rootPt = rootPt.right;
        }
        return -1;
    }
}
