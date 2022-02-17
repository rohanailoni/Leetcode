class Solution {
    private List<List<Integer>>ans;
    private int[] can;
    private int t;
    private void dfs(int sum,List<Integer>cache,int s){
        if(sum==t){
            //System.out.println(ans);
            
            ans.add(new ArrayList<Integer>(cache));
            return ;
        }
        if(sum>t){
            return;
        }
        
        
        for(int i=s;i<can.length;i++){
            cache.add(can[i]);
            dfs(sum+can[i],cache,i);
            cache.remove(cache.size()-1);
            
            
            
        }
        
        
        
        
    }
    
    
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        t=target;
        can=candidates;
        Arrays.sort(candidates);
        List<Integer>cache=new ArrayList<>();
        ans=new ArrayList<List<Integer>>();
        dfs(0,new ArrayList<>(),0);
        return ans;
        
        
    }
}