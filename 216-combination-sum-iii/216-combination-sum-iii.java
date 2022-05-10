class Solution {
    List<List<Integer>>ans;
    int k,n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans=new ArrayList<>();
        this.k=k;
        this.n=n;
        dfs(0,0,new ArrayList<>());
        return ans;
    }
    public void dfs(int i,int sum,List<Integer>cache){
        //System.out.println(cache);
        if(cache.size()==this.k && sum==this.n){
            ans.add(new ArrayList<>(cache));
            return;
        }
        if(cache.size()>=this.k){
            return;
        }
        
        for(int j=i+1;j<10;j++){
            cache.add(j);
            dfs(j,sum+j,cache);
            cache.remove(cache.size()-1);
        }
        return;
    }
}