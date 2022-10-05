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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode root_new=new TreeNode(val);
            root_new.left=root;
            root_new.right=null;
            return root_new;
        }
        Queue<Node>qu=new LinkedList<>();
        qu.add(new Node(root,1));
        while(qu.size()!=0){
            if(qu.peek().depth==depth-1){
                List<Node>arr=new ArrayList<>();
                while(qu.size()!=0 && qu.peek().depth==depth-1){
                    arr.add(qu.remove());
                }
                for(int i=0;i<arr.size();i++){
                    TreeNode left=arr.get(i).n.left;
                    TreeNode right=arr.get(i).n.right;
                    TreeNode nnll=new TreeNode(val);
                    TreeNode nnrr=new TreeNode(val);
                    arr.get(i).n.left=nnll;
                    arr.get(i).n.right=nnrr;
                    nnll.left=left;
                    nnrr.right=right;
                }
                break;
            }
            Node nn=qu.remove();
            if(nn.n.left!=null)qu.add(new Node(nn.n.left,nn.depth+1));
            if(nn.n.right!=null)qu.add(new Node(nn.n.right,nn.depth+1));
            
        }
        return root;
    }
}
class Node{
    TreeNode n;
    int depth;
    Node(TreeNode n,int depth){
        this.n=n;
        this.depth=depth;
    }
}