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
    boolean is=false;
    int target;
    private int dfs(int sum,TreeNode node){
        if(node==null){
            return 0;
        }
        sum=sum+node.val;
        
        int left,right;
        left=dfs(sum,node.left);
        right=dfs(sum,node.right);
        
        if(left==0 && right==0){
            if(sum==this.target){
                this.is=true;
            }
        }
        return sum;
        
        
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.target=targetSum;
        dfs(0,root);
        
        return this.is;
    }
}