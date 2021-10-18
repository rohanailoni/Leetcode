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
    int xdepth=-1;
    int ydepth=-1;
    TreeNode xparent,yparent;
    int x;
    int y;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x=x;
        this.y=y;
        
        measure(0,root,null);
        return xdepth==ydepth && xparent!=yparent;
        
        
    }
    private void measure(int depth,TreeNode root,TreeNode parent){
        
        if(root==null){
            return;
            
        }
        if(root.val==this.x){
            xparent=parent;
            xdepth=depth;
        }else if(root.val==this.y){
            yparent=parent;
            ydepth=depth;
        }
        measure(depth+1,root.left,root);
        measure(depth+1,root.right,root);
        return;
        
        
        
    }
}