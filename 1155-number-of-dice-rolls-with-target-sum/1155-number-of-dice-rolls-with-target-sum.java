class Solution {
    int[][]dp;
    int MOD = 1000000000 + 7;
    public int numRollsToTarget(int n, int k, int target) {
        dp=new int[n+1][target+1];
        
        for(int[] r:dp)Arrays.fill(r,-1);
        
        return dfs(n,target,k);
    }
    public int dfs(int level,int target,int k){
        if(level==0){
            //System.out.println(cache+" "+target+" "+k);
            if(target==0){
                
                return 1;
            }
            return 0;
        }
        if(target<0){
            return 0;
        }
        if(dp[level][target]!=-1){
            return dp[level][target];
        }
        int sum=0;
        for(int i=1;i<=k;i++){
            sum=(sum+dfs(level-1,target-i,k))%MOD;
        }
        return dp[level][target]=sum;
    }
}