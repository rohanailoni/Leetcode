class Solution {
    private int[] dp;
    private int division(int n){
        int sum=0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i+j==n){
                    //System.out.println(i+" "+j);
                    sum+=dp[i]*dp[j];
                }
            }
        }
        return dp[n+1]=sum;
    }
    public int numTrees(int n) {
        if(n==1){
            return 1;
        }if(n==2){
            return 2;
        }
        dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
       
        for(int i=3;i<=n;i++){
            division(i-1);
        }
        
        return dp[n];
    }
}