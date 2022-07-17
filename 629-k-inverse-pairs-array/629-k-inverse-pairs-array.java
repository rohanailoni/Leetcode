class Solution {
    public int kInversePairs(int n, int k) {
        int dp[][]=new int[n+1][k+1],i,j,t,M=1000000007;
        for(i=1;i<=n;i++){
            for(j=0;j<=k;j++){
                if(j==0) dp[i][0]=1;
                else{
                    //for(t=0;t<=Math.min(j,i-1);t++)
                        //dp[i][j]=(dp[i][j]+dp[i-1][j-t])%1000000007;
                    dp[i][j]=(int)((((long)dp[i][j-1] + (long)dp[i-1][j] + M - ((j-i)>=0?dp[i-1][j-i]:0)))%M);
                }
            }
        }
        if(k>0)
            dp[n][k]=(dp[n][k]+M-dp[n][k-1])%M;
        return dp[n][k];
    }
}