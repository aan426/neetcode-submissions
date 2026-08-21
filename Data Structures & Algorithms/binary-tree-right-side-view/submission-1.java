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
    public List<Integer> rightSideView(TreeNode root) {
        //use bfs and only show the right most node
        List<Integer> rtList = new ArrayList<>();

        if(root == null){
            return rtList;
        }
        Deque<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while(!bfs.isEmpty()){
            int rowSize = bfs.size();
            int first = 0;
            for(int i = 0; i < rowSize; i++){
                TreeNode curr = bfs.pollFirst();
                if(curr != null && first < 1){
                    //add curr to list
                    rtList.add(curr.val);
                    bfs.offer(curr.right);
                    bfs.offer(curr.left);
                    first++;
                }
                else if(curr != null){
                    bfs.offer(curr.right);
                    bfs.offer(curr.left);
                }
            }
        }
        return rtList;
    }
}
