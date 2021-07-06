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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // right first; then left first; ... 
        List<List<Integer>> res = new ArrayList<>(); 
        if(root == null){
            return res; 
        }
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root);
        res.add(Arrays.asList(root.val)); 
        int level = 0; 
        // level odd: right to left; 
        // level even: left to right. 
        while(!queue.isEmpty()){
            level++; 
            int levelSize = queue.size();  
            List<Integer> currLevel = new ArrayList<>(); 
            Stack<Integer> stack = new Stack<>(); 
            while(levelSize-- > 0){
                TreeNode curr = queue.poll(); 
                
                if(curr.left != null){
                    queue.add(curr.left); 
                    if(level % 2 == 1){
                        stack.push(curr.left.val); 
                    } else {
                        currLevel.add(curr.left.val); 
                    }
                } 
                if(curr.right != null){
                    queue.add(curr.right); 
                    if(level % 2 == 1){
                        stack.push(curr.right.val); 
                    } else {
                        currLevel.add(curr.right.val); 
                    }
                }
            }// level end

            if(level % 2 == 1){
                while(!stack.isEmpty()){
                    currLevel.add(stack.pop()); 
                }
            }
//                 关键，不空才加入res
            if(currLevel.size() > 0)
                res.add(currLevel); 
        }
        return res; 
    }
}