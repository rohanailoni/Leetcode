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
    public int maxDepth(TreeNode root) {
        
        
        return dfs(root,0);
        
        
        
    }
    private int dfs(TreeNode node,int s){
        if(node==null){
            return s;
        }
        
        
        int left=dfs(node.left,s+1);
        int right=dfs(node.right,s+1);
        
        
        return Math.max(left,right);
        
        
    }
}