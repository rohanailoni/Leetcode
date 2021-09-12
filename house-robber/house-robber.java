class Solution {
    int dp[];
    private int dfs(int[]nums,int index){
        
        if(index==nums.length-1 || index+1==nums.length-1 ){
            return nums[index];
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        
        
        int min=-(int)1e9;
        for(int i=index+2;i<nums.length;i++){
            min=Math.max(min,dfs(nums,i));
        }
        
        return dp[index]=min+nums[index];
        
        
    }
    
    
    
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int max=-(int)1e9;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,dfs(nums,i));
        }
        
        
        
        
        return max;
    }
}