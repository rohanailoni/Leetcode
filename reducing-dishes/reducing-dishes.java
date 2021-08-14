class Solution {
    Integer[][] dp=new Integer[501][501];
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return solve(1,0,satisfaction);
    }
    public int solve(int time,int index,int[] satisfaction){
        if(index==satisfaction.length){
            return 0;
            
        }
        if(dp[time][index]!=null)return dp[time][index];
        int with=solve(time+1,index+1,satisfaction)+time*satisfaction[index];
        int without=solve(time,index+1,satisfaction);
        
        return dp[time][index]=Math.max(with,without);
    }
}