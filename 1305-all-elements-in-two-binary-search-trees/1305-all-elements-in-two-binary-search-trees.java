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
    public List<Integer>ans;
    private void dfs(TreeNode r1){
        if(r1==null){
            return;
        }
        this.ans.add(r1.val);
        dfs(r1.left);
        dfs(r1.right);
        return;
        
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ans=new ArrayList<Integer>();
        dfs(root1);
        dfs(root2);
        Collections.sort(ans);
        return ans;
        
    }
}