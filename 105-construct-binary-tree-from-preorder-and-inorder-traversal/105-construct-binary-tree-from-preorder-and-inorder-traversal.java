
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
        return Tree(preorder,inorder,q);
    }
    public TreeNode Tree(int[] pre,int[] in,Queue q){
        
        if (in.length>0){
            int root_index=index_finder(in,(int)q.remove());
            TreeNode root=new TreeNode(in[root_index],null,null);
           
            
            
            
            
            root.left=Tree(pre,Arrays.copyOfRange(in,0, root_index),q);
            root.right=Tree(pre,Arrays.copyOfRange(in, root_index+1,in.length),q);
            return root;
        }
        return null;
    }
}