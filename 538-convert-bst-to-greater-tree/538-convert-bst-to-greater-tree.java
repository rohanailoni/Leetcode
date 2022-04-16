// class Solution {
//     public TreeNode convertBST(TreeNode root) {
//         dfs(root);
//         return root;
//     }
//     public void dfs(TreeNode root){
//         if(root==null){
//             return ;
//         }
//         else{
//             int n=summer(root.right,root.val,root.val);
//             //System.out.println(n);
//             root.val=n;
//             dfs(root.left);
//             dfs(root.right);
//             return;
            
//         }
//     }
//     public int summer(TreeNode root,int n,int sum){
//         if(root==null){
//             return 0;
//         }
//         else{
//             sum+=root.val;
//             return summer(root.left,n,sum)+summer(root.right,n,sum)+root.val;
//         }
        
//     }
// }
public class Solution {

    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    
    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
    
}