class Solution {
    class pair{
        TreeNode n;
        int depth;
        pair(TreeNode obj,int depth){
            this.n=obj;
            this.depth=depth;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<pair> q=new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)return ans;
        q.add(new pair(root,0));
        List<Integer>ans1=new ArrayList<>();
        List<pair>cache=new ArrayList<>();
        
        int depth_max=Integer.MIN_VALUE;
        while(q.isEmpty()==false){
            ans1=new ArrayList<>();
            pair x=q.poll();
            depth_max=Math.max(depth_max,x.depth);
            cache.add(x);
            
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
        int index=n-1;
        int top=n-1;
        int size;
        while(index>0){
            size=index;
            while(depth_max-1!=cache.get(index).depth && index>0){
                index--;
            }
            //System.out.println(index+" "+size);
            for(int i=index+1;i<=size;i++){
                ans1.add(cache.get(i).n.val);
            }
            ans.add(ans1);
            ans1=new ArrayList<>();
            depth_max--;
        }
        ans1.add(root.val);
        ans.add(ans1);
        return ans;
        
    }
}