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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)return new ArrayList<>();
        ans=new ArrayList<>();
        Queue<TreeNode>n=new LinkedList<>();
        n.add(root);
        int global=1;
        while(!n.isEmpty()){
            int count=0;
            for(int cc=0;cc<global;cc++){
                TreeNode temp=n.remove();
                
                if(cc==0)ans.add(temp.val);
                if(temp!=null && temp.right!=null){count++;n.add(temp.right);}
                if(temp!=null && temp.left!=null){count++;n.add(temp.left);}
                //System.out.println(temp.val+" "+count);
            }
            global=count;
            
        }
        return ans;
    }
    
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        ans.add(root.val);
        if(root.right==null){
            dfs(root.left);
            return;
        }
        dfs(root.right);
    }
}