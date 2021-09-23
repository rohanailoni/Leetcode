class Solution {
    private int[]num;
    private int[] dp;
    private boolean dfs(int index){
        
        if(num.length-1==index){
            return true;
        }
        if(num[index]==0){
            return false;
        }
        if(dp[index]!=-1){
            if(dp[index]==1){
                return true;
            }else{
                return false;
            }
        }
        for(int i=1;i<=num[index];i++){
            boolean s=dfs(index+i);
            if(s){
                dp[index]=1;
                return true;
            }
        }
        dp[index]=0;
        return false;
        
    }
    
    
    
    public boolean canJump(int[] nums) {
        num=nums;
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        
        return dfs(0);
    }
}