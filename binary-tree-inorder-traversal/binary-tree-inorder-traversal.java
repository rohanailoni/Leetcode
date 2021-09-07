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
    List<Integer>ans;
    private void dfs(TreeNode node){
        if(node==null){
            return;
        }
        
        dfs(node.left);
        ans.add(node.val);
        //ans.add(node.val);
        dfs(node.right);
        //ans.add(node.right.val);
        
        return;
        
        
        
        
    }
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        
        ans=new ArrayList<Integer>();
        
        dfs(root);
        return ans;
        
    }
}