impl Solution {
    fn solve(nums:&Vec<i32>,dp:&mut Vec<i32>,i:usize)-> bool{
        let n=nums.len();
        if(i>=n){
            return true;
        }
        if(dp[i]!=-1){
            if dp[i]==1{
                return true;
            }else{
                return false;
            }
        }
        let mut res:bool=false;
        if(i+1<n && nums[i]==nums[i+1]){
            res=res | Self::solve(&nums,dp,i+2);
            if(i+2<n && nums[i]==nums[i+2]){
                res=res | Self::solve(&nums,dp,i+3);
            }
            
        }
        if(i+2<n && nums[i]+1==nums[i+1] && nums[i]+2==nums[i+2]){
            res=res | Self::solve(&nums,dp,i+3);
        }
       if(res==true){
            dp[i]=1;
        }else{
            dp[i]=0;
        }
        res
        
        
    }
    pub fn valid_partition(nums: Vec<i32>) -> bool {
        let n:usize=nums.len();
        let mut dp:Vec<bool>=vec![false;n+1];
        if n==2{
            return nums[0]==nums[1];
        }
        dp[0]=true;
        for i in 1..=n-1{
            let mut j=i+1;
            
            if i>0 && nums[i]==nums[i-1]{
                dp[j]=dp[j] | dp[j-2];
            }
            if i>1 && nums[i]==nums[i-1] && nums[i]==nums[i-2]{
                dp[j]=dp[j] | dp[j-3];
            }
            if i>1 && nums[i]==nums[i-1]+1 && nums[i]==nums[i-2]+2{
                dp[j]=dp[j] | dp[j-3];
            }
        }
        return dp[n]
        //return Self::solve(&nums,&mut dp,0);
    }
}