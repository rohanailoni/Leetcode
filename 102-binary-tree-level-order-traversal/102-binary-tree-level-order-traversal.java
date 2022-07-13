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
    class pair{
        TreeNode n;
        int depth;
        pair(TreeNode obj,int depth){
            this.n=obj;
            this.depth=depth;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<pair> q=new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)return ans;
        q.add(new pair(root,0));
        List<Integer>ans1=new ArrayList<>();
        List<pair>cache=new ArrayList<>();
        //cache.add(new pair(root,0));
        while(q.isEmpty()==false){
            ans1=new ArrayList<>();
            pair x=q.poll();
            cache.add(x);
            //System.out.println(x.n);
            if(x.n.left!=null){
                q.add(new pair(x.n.left,x.depth+1));
            }
            if(x.n.right!=null){
                q.add(new pair(x.n.right,x.depth+1));
            }
            
        }
        int n=cache.size();
        int current=0;
        ans1=new ArrayList<>();
        for(int i=0;i<n;i++){
            //System.out.println(current+" "+cache.get(i).depth+" "+cache.get(i).n.val+" "+n);
            if(current==cache.get(i).depth){
                ans1.add(cache.get(i).n.val);
            }else if(current+1==cache.get(i).depth){
                current+=1;
                ans.add(ans1);
                ans1=new ArrayList<>();
                ans1.add(cache.get(i).n.val);
            }
        }
        ans.add(ans1);
        return ans;
        
    }
}