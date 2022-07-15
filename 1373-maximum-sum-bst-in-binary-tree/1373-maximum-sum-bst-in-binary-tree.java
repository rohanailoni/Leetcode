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

class Node{
    TreeNode pp;
    int left;
    int right;
    public int min;
    public int max;
    boolean bst=false;
    Node(TreeNode pp){
        this.pp=pp;
    }
    void set_left(int x){
        this.left=x;
    }
    void set_right(int x){
        this.right=x;
    }
    void set_bst(boolean b){
        this.bst=b;
    }
}
class Solution {
    HashMap<TreeNode,Node>map;
    int max;
    public int maxSumBST(TreeNode root) {
        map=new HashMap<>();
        dfs(root);
        // System.out.println(map);
        // for(Map.Entry<TreeNode,Node>m:map.entrySet()){
        //     System.out.println(m.getKey().val+" "+m.getValue().left+" "+m.getValue().right);
        // }
        max=Integer.MIN_VALUE;
        search(root);
        return max<0?0:max;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        Node n=new Node(root);
        n.set_left(left);
        n.set_right(right);
        if(root.left==null && root.right==null){
            n.min=root.val;
            n.max=root.val;
            n.set_bst(true);
        }else if(root.left==null && root.right!=null){
            if(root.right.val>root.val && map.get(root.right).bst && map.get(root.right).min>root.val && map.get(root.right).max>root.val){
                n.min=root.val;
                n.max=map.get(root.right).max;
                n.set_bst(true);
            }
        }else if(root.left!=null && root.right==null){
            if(root.left.val<=root.val && map.get(root.left).bst && map.get(root.left).min<=root.val && map.get(root.left).max<=root.val){
                n.min=map.get(root.left).min;
                n.max=root.val;
                n.set_bst(true);
            }
        }else if(root.left!=null && root.right!=null){
            if(root.left.val<=root.val && root.right.val>root.val && map.get(root.left).bst && map.get(root.left).min<=root.val && map.get(root.left).max<=root.val && map.get(root.right).bst && map.get(root.right).min>root.val && map.get(root.right).max>root.val){
                n.min=map.get(root.left).min;
                n.max=map.get(root.right).max;
                n.set_bst(true);
            }
        }
        map.put(root,n);
        return left+right+root.val;
    }
    private void search(TreeNode root){
        if(root==null){
            return;
        }
        Node x=map.get(root);
        if(x.bst){
            //System.out.println(root.val+" "+x.left+" "+x.right);
            max=Math.max(max,root.val+x.left+x.right);
        }
        search(root.left);
        search(root.right);
        return;
    }
}