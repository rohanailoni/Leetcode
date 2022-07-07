
class Solution {
    int max=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) { 
        //System.out.println(dfs(root.right.left.left,0)+" "+dfs(root.right.left.right,0));
        depth(root);
        return this.max;
    }
    public void depth(TreeNode root){
        if(root==null){
            return;
        }
        int n=dfs(root.left,0);
        int m=dfs(root.right,0);
        //System.out.println(n+" "+m);
        max=Math.max(n,max);
        max=Math.max(m,max);
        max=Math.max(n+m,max);
        depth(root.left);
        depth(root.right);
        return;
    }
    public int dfs(TreeNode root,int height){
        if(root==null){
            return height;
        }
        int n=dfs(root.left,height+1);
        int m=dfs(root.right,height+1);
        //System.out.println(n+" "+m);
        
        return Math.max(n,m);
    }
}