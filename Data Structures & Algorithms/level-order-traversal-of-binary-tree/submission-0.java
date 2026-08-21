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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }

        Deque<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);

        while(!bfs.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int levelLen = bfs.size(); //cause bfs.size() changes 
            for(int i = 0; i < levelLen; i++){ //loop for the level
                TreeNode curr = bfs.pollFirst();
                if(curr != null){
                    row.add(curr.val);  //add node to sublist
                    bfs.offer(curr.left); //add children to queue
                    bfs.offer(curr.right);
                }
            }
            if(!row.isEmpty()){ //in the case of adding a null row like leaf nodes
                ret.add(row);
            }
        }

        return ret;
    }
}
