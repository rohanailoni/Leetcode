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
    private int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        dfs(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        
        return ans;
        
        
        
        
        
        
    }
    private void dfs(TreeNode root,int sum){
        if(root==null){
            return;
            
        }
        
        if(sum==root.val){
            ans+=1;
        }
        sum=sum-root.val;
        dfs(root.left,sum);
        dfs(root.right,sum);
        return;
        
        
    }
}