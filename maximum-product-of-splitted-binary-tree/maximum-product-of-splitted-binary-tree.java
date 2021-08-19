
class Solution {
    long total=0;
    long max=0;
    private void dfs(TreeNode root){
        if(root==null){
            return ;
        }
        dfs(root.left);
        dfs(root.right);
        
        this.total+=(long)root.val;
        
    }
    private long subarray(TreeNode root){
        if(root==null){
            return 0;
        }
        long l=subarray(root.left);
        long r=subarray(root.right);
        long sum=(l+r+(long)root.val);
        long n=(this.total-sum)*sum;
        if (n>this.max){
            this.max=(long)(n);
        }
        return sum;
    }
    public int maxProduct(TreeNode root) {
        
        
        dfs(root);
        subarray(root);
        return (int)(this.max%((int)Math.pow(10,9)+7));
    }
}