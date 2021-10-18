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
    class obj{
        TreeNode node;
        int depth;
        obj(TreeNode n,int d){
            node=n;
            this.depth=d;
        }
        
        
    }
    // private void reverse(List<Integer>arr){
    //     int s=0;
    //     int e=arr.size()-1;
    //     int a,b;
    //     while(s<=e){
    //         a=arr.get(s);
    //         b=arr.get(e);
    //         arr.set(s,b);
    //         arr.set(e,a);
    //         s++;
    //         e--;
    //     }
    // }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>>ans=new ArrayList<>();
        
        if(root==null)return ans;
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        Queue<obj>q=new LinkedList<>();
        q.add(new obj(root,0));
        
        boolean s=true;
        while(!q.isEmpty()){
            
            obj n=q.poll();
            
            List<Integer>x=map.getOrDefault(n.depth,new ArrayList<>());
            x.add(n.node.val);
            map.put(n.depth,x);
            if(n.node.left!=null){q.add(new obj(n.node.left,n.depth+1));}
            if(n.node.right!=null){q.add(new obj(n.node.right,n.depth+1));}
                
            
            
        }
        
        for(Map.Entry<Integer,List<Integer>> e:map.entrySet()){
            if(s){
                ans.add(new ArrayList<>(e.getValue()));
                s=false;
            }else{
                
                Collections.reverse(e.getValue());
                ans.add(new ArrayList<>(e.getValue()));
                s=true;
            }
        }
        
        
        return ans;
        
    }
}