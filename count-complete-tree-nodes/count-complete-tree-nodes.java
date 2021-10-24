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
    int sum=1;
    private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            sum++;
            dfs(root.left);
        }
        if(root.right!=null){
            sum++;
            dfs(root.right);
        }
        return;
    }
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return sum;
    }
}