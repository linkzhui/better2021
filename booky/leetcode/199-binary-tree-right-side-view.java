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
        List<Integer> res = new ArrayList<>(); 
        if(root == null){
            return res; 
        }
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root); 
        while(!queue.isEmpty()){
            int levelSize = queue.size(); 
            while(levelSize-- > 0){
                TreeNode curr = queue.poll(); 
                if(levelSize == 0){
                    res.add(curr.val); 
                }
                if(curr.left != null){
                    queue.add(curr.left); 
                }
                if(curr.right != null){
                    queue.add(curr.right); 
                }
            }
        }
        return res; 
    }
}

// 易错点：只考虑一条path上的nodes；事实上答案可以存在不同path，不同branch。

// 所以必须bfs，每一层每个点都需要进入队列被记录。