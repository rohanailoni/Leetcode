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
    private int dfs(TreeNode node,String str){
        if(node==null){
            return -1;
        }
        str=str+Integer.toString(node.val);
        int s1=dfs(node.left,str);
        int s2=dfs(node.right,str);
        //System.out.println(s1+" "+s2+" "+str);
        if(s1==-1 && s2==-1){
            return Integer.parseInt(str);
            
        }
        if(s1==-1 ){
            return s2;
        }
        if(s2==-1){
            return s1;
        }
        return s1+s2;
    }
    public int sumNumbers(TreeNode root) {
        int s=dfs(root,"");
        return s;
    }
}