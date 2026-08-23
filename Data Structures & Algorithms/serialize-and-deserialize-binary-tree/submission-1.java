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

public class Codec {
    String ret = "";
    int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //preorder traversal
        dfsString(root);
        System.out.println(ret);
        return ret;
    }
    private void dfsString(TreeNode root){
        if (root == null){
            ret = ret + "N" + ",";
            return;
        }
        ret = ret + root.val + ",";
        dfsString(root.left);
        dfsString(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return dfsTree(nodes);
    }
    private TreeNode dfsTree(String[] data){
        String rootVal = data[i]; //i needs to be a global variable bc each index needs to be accessed across all recursive calls --> this basically replaces the use of the for loop needed to access each index
        if(rootVal.equals("N")){
            i++;
            return null;
        }
        // System.out.println(rootVal + " " + i);
        int rootInt = Integer.parseInt(rootVal);
        TreeNode root = new TreeNode(rootInt);
        i++;
        root.left = dfsTree(data);
        root.right = dfsTree(data);

        return root;
    }
}
