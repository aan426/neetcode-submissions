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
    public boolean isValidBST(TreeNode root) {
        //BST --> left.val < parent.val < right.val
        //maybe keep track of min and max on path
        //root = 4 --> max val: 4
            //left child: 2 --> 2 < 4
                //left child: 1 --> 1 < 2
                //right child: 3 --> 2 > 3
            //right child: 6 --> 6 > 4  
                //left child: 5 --> 5 < 6
                //right child: 7 --> 7 > 6

        if(root == null){
            return true;
        }

        return bst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
          
    }

    public boolean bst(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }

        boolean bstR = true;
        boolean bstL = true;
        // System.out.println(root.val + " " + root.right.val + " " + root.left.val);
        if(root.val > min && root.val < max){
            bstR = bst(root.right, root.val, max);
            bstL = bst(root.left, min, root.val);
        }
        else{
            return false;
        }

        // System.out.println(bstR + " " + bstL);
        return bstR && bstL;
    }
}
