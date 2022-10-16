class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length<d)
            return -1;
        int n=jobDifficulty.length;
        int dp[][]=new int[n+1][d+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,d,n,jobDifficulty,dp);
    }
    private static int solve(int index,int d,int n,int jobDiff[],int dp[][]){
        if(index==n && d==0)
            return 0;
        if(index==n || d==0)
            return Integer.MAX_VALUE;   
        if(dp[index][d]!=-1)
            return dp[index][d];
        int max=0,res=Integer.MAX_VALUE,restMax;
        for(int i=index;i<n;i++){
            max=Math.max(max,jobDiff[i]);
            restMax=solve(i+1,d-1,n,jobDiff,dp);
            if(restMax!=Integer.MAX_VALUE)
                res=Math.min(res,max+restMax);
        }
        return dp[index][d]=res;
    }
}