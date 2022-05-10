class Solution {
    List<List<Integer>>ans;
    int k,n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans=new ArrayList<>();
        this.k=k;
        this.n=n;
        dfs(0,0,new ArrayList<>(),0);
        return ans;
    }
    public void dfs(int i,int sum,List<Integer>cache,int size){
        //System.out.println(ans);
        if(cache.size()==this.k && sum==this.n){
            ans.add(new ArrayList<>(cache));
            return;
        }
        if(cache.size()>=this.k){
            return;
        }
        
        for(int j=i+1;j<10;j++){
            cache.add(j);
            dfs(j,sum+j,cache,size+1);
            cache.remove(size);
        }
        return;
    }
}