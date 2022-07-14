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
    private int index_finder(int[] in,int num){
        
        for(int i=0;i<in.length;i++){
            if(in[i]==num){
                return i;
            }
        }
        return -1;
    }
    private TreeNode root;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Queue<Integer> q= new LinkedList<>();
        for(int i:preorder)q.add(i);
        return Tree(preorder,inorder,0,q);
    }
    public TreeNode Tree(int[] pre,int[] in,int index,Queue q){
        
        if (in.length>0){
            int root_index=index_finder(in,(int)q.remove());
            TreeNode root=new TreeNode(in[root_index],null,null);
            //System.out.println(index+" "+pre[index]);
            
            
            int[] left_tree=Arrays.copyOfRange(in,0, root_index);
            int[] right_tree=Arrays.copyOfRange(in, root_index+1,in.length);
            root.left=Tree(pre,left_tree,index++,q);
            root.right=Tree(pre,right_tree,index++,q);
            return root;
        }
        return null;
    }
}