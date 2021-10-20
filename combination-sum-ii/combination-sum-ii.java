class Solution {
    private List<List<Integer>>ans;
    private int[] can;
    private int t;
    private void dfs(int sum,List<Integer>cache,int index){
        if(sum==t){
            //System.out.println(ans);
            if(!ans.contains(cache)){
                ans.add(new ArrayList<Integer>(cache));
            }
            
            return ;
        }
        if(sum>t){
            return;
        }
        
        
        for(int i=index;i<can.length;i++){
            if(i>index && can[i]==can[i-1])continue;
            cache.add(can[i]);
            
            dfs(sum+can[i],cache,i+1);
            cache.remove(cache.size()-1);
            
            
            
        }
        
        
        
        
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        t=target;
        can=candidates;
        Arrays.sort(candidates);
        ans=new ArrayList<List<Integer>>();
        dfs(0,new ArrayList<>(),0);
        return ans;
        
    }
}