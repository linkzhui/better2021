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
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0; 
        }
        int res = 0; 
        TreeNode curr; 
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root); 
        res++; 
        while(!queue.isEmpty()){
            int levelSize = queue.size(); 
            while(levelSize-- > 0){
                curr = queue.poll(); 
                if(curr.left != null){
                    if(curr.val <= curr.left.val){
                        res++; 
                    } else {
                        curr.left.val = curr.val; 
                    }
                    queue.add(curr.left); 
                }
                if(curr.right != null){
                    if(curr.val <= curr.right.val){
                        res++;
                    } else {
                        curr.right.val = curr.val;
                    }
                    queue.add(curr.right); 
                }
            }
        }
        return res; 
    }
}