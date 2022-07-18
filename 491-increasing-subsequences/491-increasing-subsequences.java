class Solution {
    HashSet<List<Integer>>set;
    int n;
    int[] nums;
    public List<List<Integer>> findSubsequences(int[] nums) {
        set=new HashSet<>();
        n=nums.length;
        this.nums=nums;
        dfs(new ArrayList<>(),0);
        List<List<Integer>> ans=new ArrayList<>();
        if(set.size()>0){
            ans.addAll(set);
        }
       
        return ans;
    }
    public void dfs(List<Integer>cache,int i){
        if(i>=n){
            //System.out.println(cache);
            //if(!ans.contains(cache) && cache.size()>=2)ans.add(new ArrayList<>(cache));
            return;
        }
        //include if greater
        for(int j=i;j<n;j++){
            if(cache.size()==0 || nums[j]>=cache.get(cache.size()-1)){
                    cache.add(nums[j]);
                    if(cache.size()>=2)set.add(new ArrayList<>(cache));
                    dfs(cache,j+1);
                    cache.remove(cache.size()-1);
            }
        }
        
        //exculde
        //dfs(cache,i+1);
        return;
    }
}